package com.ruoyi.patproposal.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patproposal.mapper.RyProposalCodeMapper;
import com.ruoyi.patproposal.domain.RyProposalCode;
import com.ruoyi.patproposal.service.IRyProposalCodeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专利相关编码配置Service业务层处理
 * 
 * @author zhangzhenmin
 * @date 2020-08-13
 */
@Service
public class RyProposalCodeServiceImpl implements IRyProposalCodeService 
{
    @Autowired
    private RyProposalCodeMapper ryProposalCodeMapper;

    /**
     * 查询专利相关编码配置
     * 
     * @param pcId 专利相关编码配置ID
     * @return 专利相关编码配置
     */
    @Override
    public RyProposalCode selectRyProposalCodeById(Long pcId)
    {
        return ryProposalCodeMapper.selectRyProposalCodeById(pcId);
    }

    /**
     * 查询专利相关编码配置列表
     * 
     * @param ryProposalCode 专利相关编码配置
     * @return 专利相关编码配置
     */
    @Override
    public List<RyProposalCode> selectRyProposalCodeList(RyProposalCode ryProposalCode)
    {
        return ryProposalCodeMapper.selectRyProposalCodeList(ryProposalCode);
    }

    /**
     * 新增专利相关编码配置
     * 
     * @param ryProposalCode 专利相关编码配置
     * @return 结果
     */
    @Override
    public int insertRyProposalCode(RyProposalCode ryProposalCode)
    {
        return ryProposalCodeMapper.insertRyProposalCode(ryProposalCode);
    }

    /**
     * 修改专利相关编码配置
     * 
     * @param ryProposalCode 专利相关编码配置
     * @return 结果
     */
    @Override
    public int updateRyProposalCode(RyProposalCode ryProposalCode)
    {
        return ryProposalCodeMapper.updateRyProposalCode(ryProposalCode);
    }

    /**
     * 删除专利相关编码配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalCodeByIds(String ids)
    {
        return ryProposalCodeMapper.deleteRyProposalCodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利相关编码配置信息
     * 
     * @param pcId 专利相关编码配置ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalCodeById(Long pcId)
    {
        return ryProposalCodeMapper.deleteRyProposalCodeById(pcId);
    }
}
