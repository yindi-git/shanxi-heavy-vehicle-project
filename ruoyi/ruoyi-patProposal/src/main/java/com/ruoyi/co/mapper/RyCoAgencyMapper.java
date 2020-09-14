package com.ruoyi.co.mapper;

import java.util.List;
import com.ruoyi.co.domain.RyCoAgency;

/**
 * 代理机构信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public interface RyCoAgencyMapper 
{
    /**
     * 查询代理机构信息
     * 
     * @param agencyId 代理机构信息ID
     * @return 代理机构信息
     */
    public RyCoAgency selectRyCoAgencyById(String agencyId);

    /**
     * 查询代理机构信息列表
     * 
     * @param ryCoAgency 代理机构信息
     * @return 代理机构信息集合
     */
    public List<RyCoAgency> selectRyCoAgencyList(RyCoAgency ryCoAgency);

    /**
     * 新增代理机构信息
     * 
     * @param ryCoAgency 代理机构信息
     * @return 结果
     */
    public int insertRyCoAgency(RyCoAgency ryCoAgency);

    /**
     * 修改代理机构信息
     * 
     * @param ryCoAgency 代理机构信息
     * @return 结果
     */
    public int updateRyCoAgency(RyCoAgency ryCoAgency);

    /**
     * 删除代理机构信息
     * 
     * @param agencyId 代理机构信息ID
     * @return 结果
     */
    public int deleteRyCoAgencyById(Integer agencyId);

    /**
     * 批量删除代理机构信息
     * 
     * @param agencyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyCoAgencyByIds(String[] agencyIds);

    public List<RyCoAgency> selectAllRyCoAgencyList();
}
