package com.ruoyi.patproposal.service;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalApplicant;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-08-28
 */
public interface IRyProposalApplicantService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param applicantId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyProposalApplicant selectRyProposalApplicantById(String applicantId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalApplicant 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyProposalApplicant> selectRyProposalApplicantList(RyProposalApplicant ryProposalApplicant);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalApplicant 【请填写功能名称】
     * @return 结果
     */
    public int insertRyProposalApplicant(RyProposalApplicant ryProposalApplicant);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalApplicant 【请填写功能名称】
     * @return 结果
     */
    public int updateRyProposalApplicant(RyProposalApplicant ryProposalApplicant);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalApplicantByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param applicantId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyProposalApplicantById(Long applicantId);
}
