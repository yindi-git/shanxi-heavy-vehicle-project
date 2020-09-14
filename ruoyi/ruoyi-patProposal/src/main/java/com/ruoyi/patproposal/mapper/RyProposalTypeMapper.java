package com.ruoyi.patproposal.mapper;

import java.util.List;
import com.ruoyi.patproposal.domain.RyProposalType;

/**
 * 专利类型信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public interface RyProposalTypeMapper 
{
    /**
     * 查询专利类型信息
     * 
     * @param typeId 专利类型信息ID
     * @return 专利类型信息
     */
    public RyProposalType selectRyProposalTypeById(String typeId);

    /**
     * 查询专利类型信息列表
     * 
     * @param ryProposalType 专利类型信息
     * @return 专利类型信息集合
     */
    public List<RyProposalType> selectRyProposalTypeList(RyProposalType ryProposalType);

    /**
     * 新增专利类型信息
     * 
     * @param ryProposalType 专利类型信息
     * @return 结果
     */
    public int insertRyProposalType(RyProposalType ryProposalType);

    /**
     * 修改专利类型信息
     * 
     * @param ryProposalType 专利类型信息
     * @return 结果
     */
    public int updateRyProposalType(RyProposalType ryProposalType);

    /**
     * 删除专利类型信息
     * 
     * @param typeId 专利类型信息ID
     * @return 结果
     */
    public int deleteRyProposalTypeById(String typeId);

    /**
     * 批量删除专利类型信息
     * 
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalTypeByIds(String[] typeIds);
}
