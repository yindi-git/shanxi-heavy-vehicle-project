package com.ruoyi.utiliza.service;

import java.util.List;
import com.ruoyi.utiliza.domain.RyPatentlAssignment;

/**
 * 专利运用受让Service接口
 * 
 * @author wxb
 * @date 2020-09-04
 */
public interface IRyPatentlAssignmentService 
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
     * 批量删除专利运用受让
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyPatentlAssignmentByIds(String ids);

    /**
     * 删除专利运用受让信息
     * 
     * @param permitId 专利运用受让ID
     * @return 结果
     */
    public int deleteRyPatentlAssignmentById(Long permitId);
}
