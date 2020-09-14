package com.ruoyi.portalintegration.webservice;

import com.ruoyi.portalintegration.core.RespResult;
import com.ruoyi.portalintegration.model.OriginDept;
import com.ruoyi.portalintegration.model.UserAccount;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/***
 * ESB接组织人员用户
 * @author: zhoudongyang
 * @time: 2020/8/3 14:14
 */
@WebService(name="dataAccessService")
public interface DataAccessService {

    /***
     * 用户(账户)信息
     * @param userAccountList
     * @return
     */
    @WebMethod(operationName="用户账户信息")
    RespResult userAccountData(@WebParam List<UserAccount> userAccountList);

    /***
     * 组织部门信息
     * @param OriginDeptList
     * @return
     */
    @WebMethod(operationName="组织部门信息")
    RespResult originData(@WebParam List<OriginDept> OriginDeptList);
}
