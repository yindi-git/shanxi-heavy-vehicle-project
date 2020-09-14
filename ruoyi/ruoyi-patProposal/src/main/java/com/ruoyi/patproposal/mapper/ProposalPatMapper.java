package com.ruoyi.patproposal.mapper;

import java.util.List;
import com.ruoyi.patproposal.domain.ProposalPat;
import com.ruoyi.patproposal.domain.RyProposaPatVo;

/**
 * 专利提案相关Mapper接口
 *
 * @author 神州数码
 * @date 2020-08-13
 */
public interface ProposalPatMapper
{
    /**
     * 查询专利提案相关
     *
     * @param proposalId 专利提案相关ID
     * @return 专利提案相关
     */
    public RyProposaPatVo selectProposalPatById(String proposalId);

    /**
     * 查询专利提案相关列表
     *
     * @param ryProposalPat,String beginLaunchTime,String endLaunchTime专利提案相关
     * @return 专利提案相关集合
     */
    public List<RyProposaPatVo> selectProposalPatList(RyProposaPatVo ryProposalPat);

    /**
     * 新增专利提案相关
     *
     * @param proposalPat 专利提案相关
     * @return 结果
     */
    public int insertProposalPat(ProposalPat proposalPat);

    /**
     * 修改专利提案相关
     *
     * @param proposalPat 专利提案相关
     * @return 结果
     */
    public int updateProposalPat(ProposalPat proposalPat);

    /**
     * 删除专利提案相关
     *
     * @param proposalId 专利提案相关ID
     * @return 结果
     */
    public int deleteProposalPatById(String proposalId);

    /**
     * 批量删除专利提案相关
     *
     * @param proposalIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProposalPatByIds(String[] proposalIds);

    /**
     * 校验专利名称
     * @param proposalName
     * @return
     */
    public int checkProposalName(String proposalName);


    /**
     * 生成专利申请编码时查询
     * @param proposalId
     * @return
     */
    public  int  selectProposalPatLikeId(String proposalId);
}