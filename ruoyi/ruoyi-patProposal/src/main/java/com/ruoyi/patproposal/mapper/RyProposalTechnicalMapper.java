package com.ruoyi.patproposal.mapper;

import com.ruoyi.patproposal.domain.RyProposalTechnical;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface RyProposalTechnicalMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param technicalId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyProposalTechnical selectRyProposalTechnicalById(String technicalId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryProposalTechnical 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyProposalTechnical> selectRyProposalTechnicalList(RyProposalTechnical ryProposalTechnical);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryProposalTechnical 【请填写功能名称】
     * @return 结果
     */
    public int insertRyProposalTechnical(RyProposalTechnical ryProposalTechnical);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryProposalTechnical 【请填写功能名称】
     * @return 结果
     */
    public int updateRyProposalTechnical(RyProposalTechnical ryProposalTechnical);

    /**
     * 删除【请填写功能名称】
     * 
     * @param technicalId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyProposalTechnicalById(String technicalId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param technicalIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalTechnicalByIds(String[] technicalIds);
}
