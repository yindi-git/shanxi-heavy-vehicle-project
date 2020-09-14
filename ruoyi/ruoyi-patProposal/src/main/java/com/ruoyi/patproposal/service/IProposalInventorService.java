package com.ruoyi.patproposal.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.patproposal.domain.ProposalInventor;
import com.ruoyi.patproposal.domain.RyProposalInventor;

/**
 * 发明人Service接口
 * 
 * @author 神州数码
 * @date 2020-08-14
 */
public interface IProposalInventorService 
{
    /**
     * 查询发明人
     * 
     * @param inventorId 发明人ID
     * @return 发明人
     */
    public ProposalInventor selectProposalInventorById(String inventorId);

    /**
     * 查询发明人列表
     * 
     * @param proposalInventor 发明人
     * @return 发明人集合
     */
    public List<ProposalInventor> selectProposalInventorList(ProposalInventor proposalInventor);

    /**
     * 新增发明人
     * 
     * @param proposalInventor 发明人
     * @return 结果
     */
    public int insertProposalInventor(ProposalInventor proposalInventor);

    /**
     * 修改发明人
     * 
     * @param proposalInventor 发明人
     * @return 结果
     */
    public int updateProposalInventor(ProposalInventor proposalInventor);

    /**
     * 批量删除发明人
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProposalInventorByIds(String ids);

    /**
     * 删除发明人信息
     * 
     * @param inventorId 发明人ID
     * @return 结果
     */
    public int deleteProposalInventorById(String inventorId);


    public List<ProposalInventor> selectInventorByProposalId(String proposalId);


    /**
     * 根据专利提案编号查询第一发明人信息
     * @actuhor ZhangZhenMin
     * @param proposalId
     * @return
     */
    public ProposalInventor selectFirstInventorByProposalId(String proposalId);
}
