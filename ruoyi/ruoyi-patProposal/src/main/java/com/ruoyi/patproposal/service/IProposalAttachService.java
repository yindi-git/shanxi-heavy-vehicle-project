package com.ruoyi.patproposal.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.patproposal.domain.ProposalAttach;

/**
 * 专利提案附件 专利提案附件Service接口
 * 
 * @author 神州数码
 * @date 2020-08-18
 */
public interface IProposalAttachService {
    /**
     * 查询专利提案附件 专利提案附件
     * 
     * @param attachId 专利提案附件 专利提案附件ID
     * @return 专利提案附件 专利提案附件
     */
    public ProposalAttach selectProposalAttachById(Long attachId);

    /**
     * 查询专利提案附件 专利提案附件列表
     * 
     * @param proposalAttach 专利提案附件 专利提案附件
     * @return 专利提案附件 专利提案附件集合
     */
    public List<ProposalAttach> selectProposalAttachList(ProposalAttach proposalAttach);

    /**
     * 新增专利提案附件 专利提案附件
     * 
     * @param proposalAttach 专利提案附件 专利提案附件
     * @return 结果
     */
    public int insertProposalAttach(ProposalAttach proposalAttach);

    /**
     * 修改专利提案附件 专利提案附件
     * 
     * @param proposalAttach 专利提案附件 专利提案附件
     * @return 结果
     */
    public int updateProposalAttach(ProposalAttach proposalAttach);

    /**
     * 批量删除专利提案附件 专利提案附件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProposalAttachByIds(String ids);

    /**
     * 删除专利提案附件 专利提案附件信息
     * 
     * @param attachId 专利提案附件 专利提案附件ID
     * @return 结果
     */
    public int deleteProposalAttachById(Long attachId);

    public List<Map> getProposalAttachList(String proposalId,String uploadType);
}
