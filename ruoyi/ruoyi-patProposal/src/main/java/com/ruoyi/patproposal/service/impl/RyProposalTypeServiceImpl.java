package com.ruoyi.patproposal.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patproposal.mapper.RyProposalTypeMapper;
import com.ruoyi.patproposal.domain.RyProposalType;
import com.ruoyi.patproposal.service.IRyProposalTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专利类型信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@Service
public class RyProposalTypeServiceImpl implements IRyProposalTypeService 
{
    @Autowired
    private RyProposalTypeMapper ryProposalTypeMapper;

    /**
     * 查询专利类型信息
     * 
     * @param typeId 专利类型信息ID
     * @return 专利类型信息
     */
    @Override
    public RyProposalType selectRyProposalTypeById(String typeId)
    {
        return ryProposalTypeMapper.selectRyProposalTypeById(typeId);
    }

    /**
     * 查询专利类型信息列表
     * 
     * @param ryProposalType 专利类型信息
     * @return 专利类型信息
     */
    @Override
    public List<RyProposalType> selectRyProposalTypeList(RyProposalType ryProposalType)
    {
        return ryProposalTypeMapper.selectRyProposalTypeList(ryProposalType);
    }

    /**
     * 新增专利类型信息
     * 
     * @param ryProposalType 专利类型信息
     * @return 结果
     */
    @Override
    public int insertRyProposalType(RyProposalType ryProposalType)
    {
        return ryProposalTypeMapper.insertRyProposalType(ryProposalType);
    }

    /**
     * 修改专利类型信息
     * 
     * @param ryProposalType 专利类型信息
     * @return 结果
     */
    @Override
    public int updateRyProposalType(RyProposalType ryProposalType)
    {
        return ryProposalTypeMapper.updateRyProposalType(ryProposalType);
    }

    /**
     * 删除专利类型信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalTypeByIds(String ids)
    {
        return ryProposalTypeMapper.deleteRyProposalTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利类型信息信息
     * 
     * @param typeId 专利类型信息ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalTypeById(String typeId)
    {
        return ryProposalTypeMapper.deleteRyProposalTypeById(typeId);
    }
}
