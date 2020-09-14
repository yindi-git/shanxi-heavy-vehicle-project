package com.ruoyi.patproposal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.patproposal.domain.ProposalAttach;
import com.ruoyi.patproposal.mapper.ProposalAttachMapper;
import com.ruoyi.patproposal.service.IProposalAttachService;

/**
 * 专利提案附件 专利提案附件Service业务层处理
 * 
 * @author 神州数码
 * @date 2020-08-18
 */
@Service
public class ProposalAttachServiceImpl implements IProposalAttachService {
    @Autowired
    private ProposalAttachMapper proposalAttachMapper;

    /**
     * 查询专利提案附件 专利提案附件
     * 
     * @param attachId 专利提案附件 专利提案附件ID
     * @return 专利提案附件 专利提案附件
     */
    @Override
    public ProposalAttach selectProposalAttachById(Long attachId) {
        return proposalAttachMapper.selectProposalAttachById(attachId);
    }

    /**
     * 查询专利提案附件 专利提案附件列表
     * 
     * @param proposalAttach 专利提案附件 专利提案附件
     * @return 专利提案附件 专利提案附件
     */
    @Override
    public List<ProposalAttach> selectProposalAttachList(ProposalAttach proposalAttach) {
        return proposalAttachMapper.selectProposalAttachList(proposalAttach);
    }

    /**
     * 新增专利提案附件 专利提案附件
     * 
     * @param proposalAttach 专利提案附件 专利提案附件
     * @return 结果
     */
    @Override
    public int insertProposalAttach(ProposalAttach proposalAttach) {
        return proposalAttachMapper.insertProposalAttach(proposalAttach);
    }

    /**
     * 修改专利提案附件 专利提案附件
     * 
     * @param proposalAttach 专利提案附件 专利提案附件
     * @return 结果
     */
    @Override
    public int updateProposalAttach(ProposalAttach proposalAttach) {
        return proposalAttachMapper.updateProposalAttach(proposalAttach);
    }

    /**
     * 删除专利提案附件 专利提案附件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProposalAttachByIds(String ids) {
        return proposalAttachMapper.deleteProposalAttachByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利提案附件 专利提案附件信息
     * 
     * @param attachId 专利提案附件 专利提案附件ID
     * @return 结果
     */
    @Override
    public int deleteProposalAttachById(Long attachId) {
        return proposalAttachMapper.deleteProposalAttachById(attachId);
    }

    @Override
    public List<Map> getProposalAttachList(String proposalId,String uploadType) {
        return proposalAttachMapper.getProposalAttachList(proposalId,uploadType);
    }
}
