package com.ruoyi.patproposal.service.impl;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalApplicant;
import com.ruoyi.patproposal.mapper.RyProposalApplicantMapper;
import com.ruoyi.patproposal.service.IRyProposalApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-28
 */
@Service
public class RyProposalApplicantServiceImpl implements IRyProposalApplicantService
{
    @Autowired
    private RyProposalApplicantMapper ryProposalApplicantMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param applicantId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyProposalApplicant selectRyProposalApplicantById(String applicantId)
    {
        return ryProposalApplicantMapper.selectRyProposalApplicantById(applicantId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalApplicant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyProposalApplicant> selectRyProposalApplicantList(RyProposalApplicant ryProposalApplicant)
    {
        return ryProposalApplicantMapper.selectRyProposalApplicantList(ryProposalApplicant);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalApplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyProposalApplicant(RyProposalApplicant ryProposalApplicant)
    {
        return ryProposalApplicantMapper.insertRyProposalApplicant(ryProposalApplicant);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalApplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyProposalApplicant(RyProposalApplicant ryProposalApplicant)
    {
        return ryProposalApplicantMapper.updateRyProposalApplicant(ryProposalApplicant);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalApplicantByIds(String ids)
    {
        return ryProposalApplicantMapper.deleteRyProposalApplicantByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param applicantId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalApplicantById(Long applicantId)
    {
        return ryProposalApplicantMapper.deleteRyProposalApplicantById(applicantId);
    }
}
