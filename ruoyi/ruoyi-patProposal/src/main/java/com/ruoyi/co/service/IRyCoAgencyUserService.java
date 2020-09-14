package com.ruoyi.co.service;

import java.util.List;
import com.ruoyi.co.domain.RyCoAgencyUser;

/**
 * 代理人信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public interface IRyCoAgencyUserService 
{
    /**
     * 查询代理人信息
     * 
     * @param agencyUserId 代理人信息ID
     * @return 代理人信息
     */
    public RyCoAgencyUser selectRyCoAgencyUserById(Integer agencyUserId);

    /**
     * 查询代理人信息列表
     * 
     * @param ryCoAgencyUser 代理人信息
     * @return 代理人信息集合
     */
    public List<RyCoAgencyUser> selectRyCoAgencyUserList(RyCoAgencyUser ryCoAgencyUser);

    /**
     * 新增代理人信息
     * 
     * @param ryCoAgencyUser 代理人信息
     * @return 结果
     */
    public int insertRyCoAgencyUser(RyCoAgencyUser ryCoAgencyUser);

    /**
     * 修改代理人信息
     * 
     * @param ryCoAgencyUser 代理人信息
     * @return 结果
     */
    public int updateRyCoAgencyUser(RyCoAgencyUser ryCoAgencyUser);

    /**
     * 批量删除代理人信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyCoAgencyUserByIds(String ids);

    /**
     * 删除代理人信息信息
     * 
     * @param agencyUserId 代理人信息ID
     * @return 结果
     */
    public int deleteRyCoAgencyUserById(Integer agencyUserId);

    public  List<RyCoAgencyUser> selectListByAgencyId(String agencyid);
}
