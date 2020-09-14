package com.ruoyi.patproposal.service;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalInventor;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface IRyProposalInventorService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalInventorByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param inventorId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyProposalInventorById(String inventorId);
}
