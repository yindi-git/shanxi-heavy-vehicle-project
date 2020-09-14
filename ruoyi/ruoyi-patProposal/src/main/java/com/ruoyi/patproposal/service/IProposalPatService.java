package com.ruoyi.patproposal.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.patproposal.domain.ProposalPat;
import com.ruoyi.patproposal.domain.RyProposaPatVo;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 专利提案相关Service接口
 *
 * @author 神州数码
 * @date 2020-08-13
 */
public interface IProposalPatService
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
     * @param proposalPat 专利提案相关
     * @return 专利提案相关集合
     */
    public List<RyProposaPatVo> selectProposalPatList(RyProposaPatVo proposalPat);

    /**
     * 新增专利提案相关
     *
     * @param proposalPat 专利提案相关
     * @return 结果
     */
    public int insertProposalPat(ProposalPat proposalPat);

    /**
     * 校验专利名称
     * @param proposalName
     * @return
     */
    public int checkProposalName(String proposalName);

    /**
     * 修改专利提案相关
     *
     * @param proposalPat 专利提案相关
     * @return 结果
     */
    public int updateProposalPat(ProposalPat proposalPat);

    /**
     * 批量删除专利提案相关
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProposalPatByIds(String ids);

    /**
     * 删除专利提案相关信息
     *
     * @param proposalId 专利提案相关ID
     * @return 结果
     */
    public int deleteProposalPatById(String proposalId);


    /**
     * 启动流程
     * @param entity
     * @param applyUserId
     * @return
     */
    public ProcessInstance submitApply(RyProposaPatVo entity, String applyUserId, String key, Map<String, Object> variables);


    /**
     * 查询我的待办列表
     * @param userId
     * @return
     */
    List<RyProposaPatVo> findTodoTasks(RyProposaPatVo proposaPat, String userId);

    List<RyProposaPatVo> findDoneTasks(RyProposaPatVo proposaPat, String userId);

    /**
     * 生成专利申请编码时查询
     * @param proposalId
     * @return
     */
    public  int selectProposalPatLikeId(String proposalId);

  
}