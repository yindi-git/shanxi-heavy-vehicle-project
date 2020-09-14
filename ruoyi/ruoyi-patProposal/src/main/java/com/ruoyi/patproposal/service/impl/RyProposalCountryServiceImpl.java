package com.ruoyi.patproposal.service.impl;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalCountry;
import com.ruoyi.patproposal.mapper.RyProposalCountryMapper;
import com.ruoyi.patproposal.service.IRyProposalCountryService;
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
public class RyProposalCountryServiceImpl implements IRyProposalCountryService
{
    @Autowired
    private RyProposalCountryMapper ryProposalCountryMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param countryId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyProposalCountry selectRyProposalCountryById(String countryId)
    {
        return ryProposalCountryMapper.selectRyProposalCountryById(countryId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalCountry 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyProposalCountry> selectRyProposalCountryList(RyProposalCountry ryProposalCountry)
    {
        return ryProposalCountryMapper.selectRyProposalCountryList(ryProposalCountry);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalCountry 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyProposalCountry(RyProposalCountry ryProposalCountry)
    {
        return ryProposalCountryMapper.insertRyProposalCountry(ryProposalCountry);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalCountry 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyProposalCountry(RyProposalCountry ryProposalCountry)
    {
        return ryProposalCountryMapper.updateRyProposalCountry(ryProposalCountry);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalCountryByIds(String ids)
    {
        return ryProposalCountryMapper.deleteRyProposalCountryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param countryId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalCountryById(String countryId)
    {
        return ryProposalCountryMapper.deleteRyProposalCountryById(countryId);
    }
}
