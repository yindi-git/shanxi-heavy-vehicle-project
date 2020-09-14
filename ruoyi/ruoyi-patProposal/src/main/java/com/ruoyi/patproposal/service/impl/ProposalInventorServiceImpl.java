package com.ruoyi.patproposal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patproposal.mapper.ProposalInventorMapper;
import com.ruoyi.patproposal.domain.ProposalInventor;
import com.ruoyi.patproposal.service.IProposalInventorService;
import com.ruoyi.common.core.text.Convert;

/**
 * 发明人Service业务层处理
 * 
 * @author 神州数码
 * @date 2020-08-14
 */
@Service
public class ProposalInventorServiceImpl implements IProposalInventorService 
{
    @Autowired
    private ProposalInventorMapper proposalInventorMapper;


    /**
     * 查询发明人
     * 
     * @param inventorId 发明人ID
     * @return 发明人
     */
    @Override
    public ProposalInventor selectProposalInventorById(String inventorId)
    {
        return proposalInventorMapper.selectProposalInventorById(inventorId);
    }

    /**
     * 查询发明人列表
     * 
     * @param proposalInventor 发明人
     * @return 发明人
     */
    @Override
    public List<ProposalInventor> selectProposalInventorList(ProposalInventor proposalInventor)
    {
        return proposalInventorMapper.selectProposalInventorList(proposalInventor);
    }

    /**
     * 新增发明人
     * 
     * @param proposalInventor 发明人
     * @return 结果
     */
    @Override
    public int insertProposalInventor(ProposalInventor proposalInventor)
    {
        String proposalId=proposalInventor.getProposalId();
        proposalInventorMapper.deleteInventorByProposalId(proposalId);
        return proposalInventorMapper.insertProposalInventor(proposalInventor);
    }

    /**
     * 修改发明人
     * 
     * @param proposalInventor 发明人
     * @return 结果
     */
    @Override
    public int updateProposalInventor(ProposalInventor proposalInventor)
    {
        return proposalInventorMapper.updateProposalInventor(proposalInventor);
    }

    /**
     * 删除发明人对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProposalInventorByIds(String ids)
    {
        return proposalInventorMapper.deleteProposalInventorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除发明人信息
     * 
     * @param inventorId 发明人ID
     * @return 结果
     */
    @Override
    public int deleteProposalInventorById(String inventorId)
    {
        return proposalInventorMapper.deleteProposalInventorById(inventorId);
    }

    @Override
    public List<ProposalInventor> selectInventorByProposalId(String proposalId) {
        return proposalInventorMapper.selectInventorByProposalId(proposalId);
    }

    @Override
    public ProposalInventor selectFirstInventorByProposalId(String proposalId) {
        return proposalInventorMapper.selectFirstInventorByProposalId(proposalId);
    }
}
