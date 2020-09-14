package com.ruoyi.utiliza.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.utiliza.mapper.RyPatentlAssignmentMapper;
import com.ruoyi.utiliza.domain.RyPatentlAssignment;
import com.ruoyi.utiliza.service.IRyPatentlAssignmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专利运用受让Service业务层处理
 * 
 * @author wxb
 * @date 2020-09-04
 */
@Service
public class RyPatentlAssignmentServiceImpl implements IRyPatentlAssignmentService 
{
    @Autowired
    private RyPatentlAssignmentMapper ryPatentlAssignmentMapper;

    /**
     * 查询专利运用受让
     * 
     * @param permitId 专利运用受让ID
     * @return 专利运用受让
     */
    @Override
    public RyPatentlAssignment selectRyPatentlAssignmentById(Long permitId)
    {
        return ryPatentlAssignmentMapper.selectRyPatentlAssignmentById(permitId);
    }

    /**
     * 查询专利运用受让列表
     * 
     * @param ryPatentlAssignment 专利运用受让
     * @return 专利运用受让
     */
    @Override
    public List<RyPatentlAssignment> selectRyPatentlAssignmentList(RyPatentlAssignment ryPatentlAssignment)
    {
        return ryPatentlAssignmentMapper.selectRyPatentlAssignmentList(ryPatentlAssignment);
    }

    /**
     * 新增专利运用受让
     * 
     * @param ryPatentlAssignment 专利运用受让
     * @return 结果
     */
    @Override
    public int insertRyPatentlAssignment(RyPatentlAssignment ryPatentlAssignment)
    {
        ryPatentlAssignment.setCreateTime(DateUtils.getNowDate());
        return ryPatentlAssignmentMapper.insertRyPatentlAssignment(ryPatentlAssignment);
    }

    /**
     * 修改专利运用受让
     * 
     * @param ryPatentlAssignment 专利运用受让
     * @return 结果
     */
    @Override
    public int updateRyPatentlAssignment(RyPatentlAssignment ryPatentlAssignment)
    {
        return ryPatentlAssignmentMapper.updateRyPatentlAssignment(ryPatentlAssignment);
    }

    /**
     * 删除专利运用受让对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlAssignmentByIds(String ids)
    {
        return ryPatentlAssignmentMapper.deleteRyPatentlAssignmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利运用受让信息
     * 
     * @param permitId 专利运用受让ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlAssignmentById(Long permitId)
    {
        return ryPatentlAssignmentMapper.deleteRyPatentlAssignmentById(permitId);
    }
}
