package com.ruoyi.co.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.co.domain.RyCoSynergy;
import com.ruoyi.co.domain.RyCoSynergyVo;
import org.activiti.engine.runtime.ProcessInstance;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-08-27
 */
public interface IRyCoSynergyService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyCoSynergyVo selectRyCoSynergyById(String  id);

    public RyCoSynergyVo selectRyCoSynergyByProposalId(String  proposalId);

    public RyCoSynergyVo selectRyCoSynergyByAgencyId(String  agencyId);
    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryCoSynergy 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyCoSynergy> selectRyCoSynergyList(RyCoSynergy ryCoSynergy);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryCoSynergy 【请填写功能名称】
     * @return 结果
     */
    public int insertRyCoSynergy(RyCoSynergy ryCoSynergy);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryCoSynergy 【请填写功能名称】
     * @return 结果
     */
    public int updateRyCoSynergy(RyCoSynergyVo ryCoSynergy);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyCoSynergyByIds(String ids);


    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyCoSynergyById(String id);

    /**
     * 启动流程
     * @param entity
     * @param applyUserId
     * @return
     */
    public ProcessInstance submitApply(RyCoSynergyVo entity, String applyUserId, String key, Map<String, Object> variables);

    public int selectProposalPatLikeId(String patentCode);


    /**
     * 根据proposalId获取最大记录ID
     * @param proposalId
     * @return
     */
    public String selectCoSyneryMaxIdByProposalId(String proposalId);

}
