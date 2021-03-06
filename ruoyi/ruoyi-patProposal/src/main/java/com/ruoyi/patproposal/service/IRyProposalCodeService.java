package com.ruoyi.patproposal.service;

import java.util.List;
import com.ruoyi.patproposal.domain.RyProposalCode;

/**
 * 专利相关编码配置Service接口
 * 
 * @author zhangzhenmin
 * @date 2020-08-13
 */
public interface IRyProposalCodeService 
{
    /**
     * 查询专利相关编码配置
     * 
     * @param pcId 专利相关编码配置ID
     * @return 专利相关编码配置
     */
    public RyProposalCode selectRyProposalCodeById(Long pcId);

    /**
     * 查询专利相关编码配置列表
     * 
     * @param ryProposalCode 专利相关编码配置
     * @return 专利相关编码配置集合
     */
    public List<RyProposalCode> selectRyProposalCodeList(RyProposalCode ryProposalCode);

    /**
     * 新增专利相关编码配置
     * 
     * @param ryProposalCode 专利相关编码配置
     * @return 结果
     */
    public int insertRyProposalCode(RyProposalCode ryProposalCode);

    /**
     * 修改专利相关编码配置
     * 
     * @param ryProposalCode 专利相关编码配置
     * @return 结果
     */
    public int updateRyProposalCode(RyProposalCode ryProposalCode);

    /**
     * 批量删除专利相关编码配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalCodeByIds(String ids);

    /**
     * 删除专利相关编码配置信息
     * 
     * @param pcId 专利相关编码配置ID
     * @return 结果
     */
    public int deleteRyProposalCodeById(Long pcId);
}
