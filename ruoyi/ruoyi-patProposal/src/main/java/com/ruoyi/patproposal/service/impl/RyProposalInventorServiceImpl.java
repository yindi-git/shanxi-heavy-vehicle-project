package com.ruoyi.patproposal.service.impl;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalInventor;
import com.ruoyi.patproposal.mapper.RyProposalInventorMapper;
import com.ruoyi.patproposal.service.IRyProposalInventorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Service
public class RyProposalInventorServiceImpl implements IRyProposalInventorService
{
    @Autowired
    private RyProposalInventorMapper ryProposalInventorMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param inventorId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyProposalInventor selectRyProposalInventorById(String inventorId)
    {
        return ryProposalInventorMapper.selectRyProposalInventorById(inventorId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalInventor 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyProposalInventor> selectRyProposalInventorList(RyProposalInventor ryProposalInventor)
    {
        return ryProposalInventorMapper.selectRyProposalInventorList(ryProposalInventor);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalInventor 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyProposalInventor(RyProposalInventor ryProposalInventor)
    {
        return ryProposalInventorMapper.insertRyProposalInventor(ryProposalInventor);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalInventor 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyProposalInventor(RyProposalInventor ryProposalInventor)
    {
        return ryProposalInventorMapper.updateRyProposalInventor(ryProposalInventor);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalInventorByIds(String ids)
    {
        return ryProposalInventorMapper.deleteRyProposalInventorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param inventorId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalInventorById(String inventorId)
    {
        return ryProposalInventorMapper.deleteRyProposalInventorById(inventorId);
    }
}
