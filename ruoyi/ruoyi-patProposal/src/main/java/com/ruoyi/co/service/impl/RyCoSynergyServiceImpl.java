package com.ruoyi.co.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.activiti.service.IProcessService;
import com.ruoyi.co.domain.RyCoSynergy;
import com.ruoyi.co.domain.RyCoSynergyVo;
import com.ruoyi.co.mapper.RyCoSynergyMapper;
import com.ruoyi.co.service.IRyCoSynergyService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.SysUserMapper;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-27
 */
@Service
public class RyCoSynergyServiceImpl implements IRyCoSynergyService
{
    @Autowired
    private RyCoSynergyMapper ryCoSynergyMapper;

    @Autowired
    private IProcessService processService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyCoSynergyVo selectRyCoSynergyById(String id)
    {
        return ryCoSynergyMapper.selectRyCoSynergyById(id);
    }

    @Override
    public RyCoSynergyVo selectRyCoSynergyByProposalId(String proposalId) {
        return ryCoSynergyMapper.selectRyCoSynergyByProposalId(proposalId);
    }

    @Override
    public RyCoSynergyVo selectRyCoSynergyByAgencyId(String agencyId) {
        return ryCoSynergyMapper.selectRyCoSynergyByAgencyId(agencyId);
    }

    @Override
    public int selectProposalPatLikeId(String patentCode){
        return  ryCoSynergyMapper.selectProposalPatLikeId(patentCode);
    }

    @Override
    public String selectCoSyneryMaxIdByProposalId(String proposalId) {
        return ryCoSynergyMapper.selectCoSyneryMaxIdByProposalId( proposalId);
    }

    ;


    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryCoSynergy 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyCoSynergy> selectRyCoSynergyList(RyCoSynergy ryCoSynergy)
    {
        return ryCoSynergyMapper.selectRyCoSynergyList(ryCoSynergy);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryCoSynergy 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyCoSynergy(RyCoSynergy ryCoSynergy)
    {
        return ryCoSynergyMapper.insertRyCoSynergy(ryCoSynergy);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryCoSynergy 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyCoSynergy(RyCoSynergyVo ryCoSynergy)
    {
        return ryCoSynergyMapper.updateRyCoSynergy(ryCoSynergy);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyCoSynergyByIds(String ids)
    {
        return ryCoSynergyMapper.deleteRyCoSynergyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyCoSynergyById(String id)
    {
        return ryCoSynergyMapper.deleteRyCoSynergyById(id);
    }

    /**
     * 启动流程
     * @param entity
     * @param applyUserId
     * @return
     */
    @Override
    public ProcessInstance submitApply(RyCoSynergyVo entity, String applyUserId, String key, Map<String, Object> variables) {
        //申请人id
        entity.setApplyUserName("applyUserId");
        entity.setDoneTime(DateUtils.getNowDate());
        entity.setUpdateBy(applyUserId);
        ryCoSynergyMapper.updateRyCoSynergy(entity);
        // 实体类 ID，作为流程的业务 key

        String businessKey = entity.getAgencyid().toString();

        ProcessInstance processInstance = processService.submitApply(applyUserId, businessKey, entity.getAgencycode(), entity.getProposalId(), key, variables);

        String processInstanceId = processInstance.getId();
        // 建立双向关系
        entity.setInstanceId(processInstanceId);
        ryCoSynergyMapper.updateRyCoSynergy(entity);

        return processInstance;

    }
}
