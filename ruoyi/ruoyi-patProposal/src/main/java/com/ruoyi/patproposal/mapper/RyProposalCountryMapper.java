package com.ruoyi.patproposal.mapper;

import com.ruoyi.patproposal.domain.RyProposalCountry;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface RyProposalCountryMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param countryId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyProposalCountryById(String countryId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param countryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalCountryByIds(String[] countryIds);
}
