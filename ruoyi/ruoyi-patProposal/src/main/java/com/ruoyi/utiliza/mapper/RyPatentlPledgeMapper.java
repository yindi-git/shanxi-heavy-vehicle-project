package com.ruoyi.utiliza.mapper;

import java.util.List;
import com.ruoyi.utiliza.domain.RyPatentlPledge;

/**
 * 专利运用质押Mapper接口
 * 
 * @author wxb
 * @date 2020-09-04
 */
public interface RyPatentlPledgeMapper 
{
    /**
     * 查询专利运用质押
     * 
     * @param permitId 专利运用质押ID
     * @return 专利运用质押
     */
    public RyPatentlPledge selectRyPatentlPledgeById(Long permitId);

    /**
     * 查询专利运用质押列表
     * 
     * @param ryPatentlPledge 专利运用质押
     * @return 专利运用质押集合
     */
    public List<RyPatentlPledge> selectRyPatentlPledgeList(RyPatentlPledge ryPatentlPledge);

    /**
     * 新增专利运用质押
     * 
     * @param ryPatentlPledge 专利运用质押
     * @return 结果
     */
    public int insertRyPatentlPledge(RyPatentlPledge ryPatentlPledge);

    /**
     * 修改专利运用质押
     * 
     * @param ryPatentlPledge 专利运用质押
     * @return 结果
     */
    public int updateRyPatentlPledge(RyPatentlPledge ryPatentlPledge);

    /**
     * 删除专利运用质押
     * 
     * @param permitId 专利运用质押ID
     * @return 结果
     */
    public int deleteRyPatentlPledgeById(Long permitId);

    /**
     * 批量删除专利运用质押
     * 
     * @param permitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyPatentlPledgeByIds(String[] permitIds);
}
