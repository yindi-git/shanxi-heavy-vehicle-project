package com.ruoyi.portalintegration.mapper;

import com.ruoyi.portalintegration.model.OriginDept;
import com.ruoyi.portalintegration.model.UserAccount;

/***
 * ESB接组织人员用户
 * @author: zhoudongyang
 * @time: 2020/8/3 14:14
 */
public interface SysUserAccessMapper {
    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 结果
     */
     int updateUser(UserAccount user);

    /**
     * 新增用户信息
     * @param user 用户信息
     * @return 结果
     */
     int insertUser(UserAccount user);

    /**
     * 校验用户名称是否唯一
     * @param loginName 登录名称
     * @return 结果
     */
     int checkLoginNameUnique(String loginName);

    /**
     * 校验用户角色是否唯一
     * @param userId
     * @return
     */
     int checkUserRoleUnique(String userId);

    /**
     * 插入用户角色
     * @param userId
     */
     void insertUserRole(String userId);

    /**
     * 修改部门信息
     * @param originDept 部门信息
     * @return 结果
     */
     int updateOriginDept(OriginDept originDept);

    /**
     * 调用函数更新部门sys_dept表的ancestors字段
     */
     void updateAncestors();

    /**
     * 新增部门信息
     * @param originDept 部门信息
     * @return 结果
     */
     int insertOriginDept(OriginDept originDept);

    /**
     * 校验该部门是否存在
     * @param orgCode 部门编码
     * @return 结果
     */
     int checkOrgCodeUnique(String orgCode);
}
