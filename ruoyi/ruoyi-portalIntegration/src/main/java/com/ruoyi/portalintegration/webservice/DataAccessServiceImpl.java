package com.ruoyi.portalintegration.webservice;


import com.ruoyi.portalintegration.core.RespResult;
import com.ruoyi.portalintegration.mapper.SysUserAccessMapper;
import com.ruoyi.portalintegration.model.OriginDept;
import com.ruoyi.portalintegration.model.UserAccount;
import com.ruoyi.portalintegration.util.PasswordUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.List;

/**
 * ESB接组织人员用户实现类
 *
 * @author: zhoudongyang
 * @time: 2020/8/3 14:14
 */
@Component
@WebService(serviceName = "dataAccessService",
        targetNamespace = "http://webservice.portalIntegration.ruoyi.com",
        endpointInterface = "com.ruoyi.portalintegration.webservice.DataAccessService"
)
public class DataAccessServiceImpl implements DataAccessService {

    @Resource
    private SysUserAccessMapper sysUserAccessMapper;

    /**
     * 用户账户信息同步
     *
     * @param userAccountList
     * @return
     */
    @Override
    public RespResult userAccountData(List<UserAccount> userAccountList) {
        /**
         * 同步用户信息(数据库没有则新增，有则更新)
         */
        try {
            if (userAccountList.size() > 0) {
                for (UserAccount userAccount : userAccountList) {
                    String loginName = userAccount.getLoginName();
                    //密码转换
                    String passwordESB = userAccount.getPassword();
                    String passwordMd5 = PasswordUtil.Base64ToMd5(passwordESB);
                    userAccount.setPassword(passwordMd5);
                    //检查登录名是否存在
                    int num = sysUserAccessMapper.checkLoginNameUnique(loginName);
                    if (num > 0) {
                        sysUserAccessMapper.updateUser(userAccount);
                    } else {
                        sysUserAccessMapper.insertUser(userAccount);
                        /***
                         * 分配角色
                         */
                        int count= sysUserAccessMapper.checkUserRoleUnique(loginName);
                        if(count == 0){
                            sysUserAccessMapper.insertUserRole(loginName);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespResult.error("101","同步失败");
        }
        return RespResult.success();
    }

    /**
     * 组织部门信息同步
     *
     * @param OriginDeptList
     * @return
     */
    @Override
    public RespResult originData(List<OriginDept> OriginDeptList) {
        /**
         * 1、更新组织部门信息
         * 2、调用函数更新部门sys_dept表的ancestors字段
         */
        try {
            if (OriginDeptList.size() > 0) {
                for (OriginDept originDept : OriginDeptList) {
                    String orgCode = originDept.getOrgCode();
                    int num = sysUserAccessMapper.checkOrgCodeUnique(orgCode);
                    if (num > 0) {
                        sysUserAccessMapper.updateOriginDept(originDept);
                    } else {
                        sysUserAccessMapper.insertOriginDept(originDept);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespResult.error("101","同步失败");
        }
        /***
         * （推送结束后插入）
         * 调用函数更新部门sys_dept表的ancestors字段
         */
        sysUserAccessMapper.updateAncestors();
        return RespResult.success();
    }
}
