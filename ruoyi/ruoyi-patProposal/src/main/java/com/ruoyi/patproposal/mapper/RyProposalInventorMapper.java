package com.ruoyi.patproposal.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.patproposal.domain.RyProposalInventor;


/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface RyProposalInventorMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param inventorId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyProposalInventor selectRyProposalInventorById(String inventorId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalInventor 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyProposalInventor> selectRyProposalInventorList(RyProposalInventor ryProposalInventor);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalInventor 【请填写功能名称】
     * @return 结果
     */
    public int insertRyProposalInventor(RyProposalInventor ryProposalInventor);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalInventor 【请填写功能名称】
     * @return 结果
     */
    public int updateRyProposalInventor(RyProposalInventor ryProposalInventor);

    /**
     * 删除【请填写功能名称】
     * 
     * @param inventorId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyProposalInventorById(String inventorId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param inventorIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalInventorByIds(String[] inventorIds);

}
