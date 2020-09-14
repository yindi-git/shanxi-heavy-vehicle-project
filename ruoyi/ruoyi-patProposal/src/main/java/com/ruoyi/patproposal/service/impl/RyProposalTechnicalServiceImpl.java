package com.ruoyi.patproposal.service.impl;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalTechnical;
import com.ruoyi.patproposal.mapper.RyProposalTechnicalMapper;
import com.ruoyi.patproposal.service.IRyProposalTechnicalService;
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
public class RyProposalTechnicalServiceImpl implements IRyProposalTechnicalService
{
    @Autowired
    private RyProposalTechnicalMapper ryProposalTechnicalMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param technicalId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyProposalTechnical selectRyProposalTechnicalById(String technicalId)
    {
        return ryProposalTechnicalMapper.selectRyProposalTechnicalById(technicalId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalTechnical 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyProposalTechnical> selectRyProposalTechnicalList(RyProposalTechnical ryProposalTechnical)
    {
        return ryProposalTechnicalMapper.selectRyProposalTechnicalList(ryProposalTechnical);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalTechnical 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyProposalTechnical(RyProposalTechnical ryProposalTechnical)
    {
        return ryProposalTechnicalMapper.insertRyProposalTechnical(ryProposalTechnical);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalTechnical 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyProposalTechnical(RyProposalTechnical ryProposalTechnical)
    {
        return ryProposalTechnicalMapper.updateRyProposalTechnical(ryProposalTechnical);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalTechnicalByIds(String ids)
    {
        return ryProposalTechnicalMapper.deleteRyProposalTechnicalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param technicalId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalTechnicalById(String technicalId)
    {
        return ryProposalTechnicalMapper.deleteRyProposalTechnicalById(technicalId);
    }
}
