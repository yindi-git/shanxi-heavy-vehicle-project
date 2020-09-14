package com.ruoyi.patproposal.service;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalCountry;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface IRyProposalCountryService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param countryId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyProposalCountry selectRyProposalCountryById(String countryId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalCountry 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyProposalCountry> selectRyProposalCountryList(RyProposalCountry ryProposalCountry);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalCountry 【请填写功能名称】
     * @return 结果
     */
    public int insertRyProposalCountry(RyProposalCountry ryProposalCountry);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalCountry 【请填写功能名称】
     * @return 结果
     */
    public int updateRyProposalCountry(RyProposalCountry ryProposalCountry);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalCountryByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param countryId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyProposalCountryById(String countryId);
}
