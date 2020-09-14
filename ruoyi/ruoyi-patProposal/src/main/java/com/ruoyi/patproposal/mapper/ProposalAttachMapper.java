package com.ruoyi.patproposal.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.patproposal.domain.ProposalAttach;
import org.apache.ibatis.annotations.Param;

/**
 * 专利提案附件 专利提案附件Mapper接口
 * 
 * @author 神州数码
 * @date 2020-08-18
 */
public interface ProposalAttachMapper {
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
     * 删除专利提案附件 专利提案附件
     * 
     * @param attachId 专利提案附件 专利提案附件ID
     * @return 结果
     */
    public int deleteProposalAttachById(Long attachId);

    /**
     * 批量删除专利提案附件 专利提案附件
     * 
     * @param attachIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProposalAttachByIds(String[] attachIds);

    /**
     * 根据ID与附件类型查询附件列表
     * @param proposalId
     * @param uploadType
     * @return
     */
    public List<Map> getProposalAttachList(@Param("proposalId") String proposalId, @Param("uploadType")  String uploadType);
}
