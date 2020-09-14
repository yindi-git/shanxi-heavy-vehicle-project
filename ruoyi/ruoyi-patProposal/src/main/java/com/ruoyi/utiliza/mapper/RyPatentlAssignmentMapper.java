package com.ruoyi.utiliza.mapper;

import java.util.List;
import com.ruoyi.utiliza.domain.RyPatentlAssignment;

/**
 * 专利运用受让Mapper接口
 * 
 * @author wxb
 * @date 2020-09-04
 */
public interface RyPatentlAssignmentMapper 
{
    /**
     * 查询专利运用受让
     * 
     * @param permitId 专利运用受让ID
     * @return 专利运用受让
     */
    public RyPatentlAssignment selectRyPatentlAssignmentById(Long permitId);

    /**
     * 查询专利运用受让列表
     * 
     * @param ryPatentlAssignment 专利运用受让
     * @return 专利运用受让集合
     */
    public List<RyPatentlAssignment> selectRyPatentlAssignmentList(RyPatentlAssignment ryPatentlAssignment);

    /**
     * 新增专利运用受让
     * 
     * @param ryPatentlAssignment 专利运用受让
     * @return 结果
     */
    public int insertRyPatentlAssignment(RyPatentlAssignment ryPatentlAssignment);

    /**
     * 修改专利运用受让
     * 
     * @param ryPatentlAssignment 专利运用受让
     * @return 结果
     */
    public int updateRyPatentlAssignment(RyPatentlAssignment ryPatentlAssignment);

    /**
     * 删除专利运用受让
     * 
     * @param permitId 专利运用受让ID
     * @return 结果
     */
    public int deleteRyPatentlAssignmentById(Long permitId);

    /**
     * 批量删除专利运用受让
     * 
     * @param permitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyPatentlAssignmentByIds(String[] permitIds);
}
