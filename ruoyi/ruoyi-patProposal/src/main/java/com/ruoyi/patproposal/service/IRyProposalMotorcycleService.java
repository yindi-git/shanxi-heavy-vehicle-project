package com.ruoyi.patproposal.service;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalMotorcycle;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface IRyProposalMotorcycleService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param motorcycleId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyProposalMotorcycle selectRyProposalMotorcycleById(String motorcycleId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalMotorcycle 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyProposalMotorcycle> selectRyProposalMotorcycleList(RyProposalMotorcycle ryProposalMotorcycle);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalMotorcycle 【请填写功能名称】
     * @return 结果
     */
    public int insertRyProposalMotorcycle(RyProposalMotorcycle ryProposalMotorcycle);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalMotorcycle 【请填写功能名称】
     * @return 结果
     */
    public int updateRyProposalMotorcycle(RyProposalMotorcycle ryProposalMotorcycle);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalMotorcycleByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param motorcycleId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyProposalMotorcycleById(String motorcycleId);
}
