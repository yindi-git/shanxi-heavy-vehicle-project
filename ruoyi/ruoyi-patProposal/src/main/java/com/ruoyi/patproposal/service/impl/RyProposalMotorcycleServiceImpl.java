package com.ruoyi.patproposal.service.impl;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalMotorcycle;
import com.ruoyi.patproposal.mapper.RyProposalMotorcycleMapper;
import com.ruoyi.patproposal.service.IRyProposalMotorcycleService;
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
public class RyProposalMotorcycleServiceImpl implements IRyProposalMotorcycleService
{
    @Autowired
    private RyProposalMotorcycleMapper ryProposalMotorcycleMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param motorcycleId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyProposalMotorcycle selectRyProposalMotorcycleById(String motorcycleId)
    {
        return ryProposalMotorcycleMapper.selectRyProposalMotorcycleById(motorcycleId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalMotorcycle 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyProposalMotorcycle> selectRyProposalMotorcycleList(RyProposalMotorcycle ryProposalMotorcycle)
    {
        return ryProposalMotorcycleMapper.selectRyProposalMotorcycleList(ryProposalMotorcycle);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalMotorcycle 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyProposalMotorcycle(RyProposalMotorcycle ryProposalMotorcycle)
    {
        return ryProposalMotorcycleMapper.insertRyProposalMotorcycle(ryProposalMotorcycle);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalMotorcycle 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyProposalMotorcycle(RyProposalMotorcycle ryProposalMotorcycle)
    {
        return ryProposalMotorcycleMapper.updateRyProposalMotorcycle(ryProposalMotorcycle);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalMotorcycleByIds(String ids)
    {
        return ryProposalMotorcycleMapper.deleteRyProposalMotorcycleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param motorcycleId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalMotorcycleById(String motorcycleId)
    {
        return ryProposalMotorcycleMapper.deleteRyProposalMotorcycleById(motorcycleId);
    }
}
