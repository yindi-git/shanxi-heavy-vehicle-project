package com.ruoyi.patproposal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.ruoyi.patproposal.mapper.ProposalPatMapper;
import com.ruoyi.activiti.service.IProcessService;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.patproposal.domain.RyProposaPatVo;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysUserMapper;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patproposal.domain.ProposalPat;
import com.ruoyi.patproposal.service.IProposalPatService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 专利提案相关Service业务层处理
 *
 * @author 神州数码
 * @date 2020-08-13
 */
@Service
public class ProposalPatServiceImpl implements IProposalPatService
{
    @Autowired
    private ProposalPatMapper proposalPatMapper;
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
     * 查询专利提案相关
     *
     * @param proposalId 专利提案相关ID
     * @return 专利提案相关
     */
    @Override
    public RyProposaPatVo selectProposalPatById(String proposalId)
    {
        return proposalPatMapper.selectProposalPatById(proposalId);
    }

    /**
     * 查询专利提案相关列表
     *
     * @param ryProposalPat 专利提案相关
     * @return 专利提案相关
     */
    @Override
    public List<RyProposaPatVo> selectProposalPatList(RyProposaPatVo ryProposalPat)
    {
        return proposalPatMapper.selectProposalPatList(ryProposalPat);
    }
    /**
     * 新增专利提案相关
     *
     * @param proposalPat 专利提案相关
     * @return 结果
     */
    @Override
    public int insertProposalPat(ProposalPat proposalPat)
    {
        return proposalPatMapper.insertProposalPat(proposalPat);
    }

    /**
     * 校验专利名称
     * @param proposalName
     * @return
     */
    @Override
    public int checkProposalName(String proposalName) {
        return proposalPatMapper.checkProposalName(proposalName);
    }

    /**
     * 修改专利提案相关
     *
     * @param proposalPat 专利提案相关
     * @return 结果
     */
    @Override
    public int updateProposalPat(ProposalPat proposalPat)
    {
        return proposalPatMapper.updateProposalPat(proposalPat);
    }

    /**
     * 删除专利提案相关对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProposalPatByIds(String ids)
    {
        return proposalPatMapper.deleteProposalPatByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利提案相关信息
     *
     * @param proposalId 专利提案相关ID
     * @return 结果
     */
    @Override
    public int deleteProposalPatById(String proposalId)
    {
        return proposalPatMapper.deleteProposalPatById(proposalId);
    }

    /**
     * 启动流程
     * @param entity
     * @param applyUserId
     * @return
     */
    @Override

    public ProcessInstance submitApply(RyProposaPatVo entity, String applyUserId, String key, Map<String, Object> variables) {
        //申请人id
        entity.setApplicantId(applyUserId);
        entity.setLaunchTime(DateUtils.getNowDate());
        entity.setUpdateBy(applyUserId);
        proposalPatMapper.updateProposalPat(entity);
        // 实体类 ID，作为流程的业务 key

        String businessKey = entity.getProposalId().toString();

        ProcessInstance processInstance = processService.submitApply(applyUserId, businessKey, entity.getProposalName(), entity.getProposalId(), key, variables);

        String processInstanceId = processInstance.getId();
        // 建立双向关系
        entity.setInstanceId(processInstanceId);
        proposalPatMapper.updateProposalPat(entity);

        return processInstance;

    }

    /**
     * 查询待办任务
     */
    @Override
    public Page<RyProposaPatVo> findTodoTasks(RyProposaPatVo proposaPat, String userId) {
        // 手动分页
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        Page<RyProposaPatVo> list = new Page<>();

        List<RyProposaPatVo> results = new ArrayList<>();
        List<Task> tasks = processService.findTodoTasks(userId, proposaPat.getTypeId());
        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            TaskEntityImpl taskImpl = (TaskEntityImpl) task;
            String processInstanceId = taskImpl.getProcessInstanceId();
            // 条件过滤 1
            if (StringUtils.isNotBlank(proposaPat.getInstanceId()) && !proposaPat.getInstanceId().equals(processInstanceId)) {
                continue;
            }
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            String businessKey = processInstance.getBusinessKey();
            RyProposaPatVo proposaPat2 =  proposalPatMapper.selectProposalPatById(businessKey);
            // 条件过滤 2
            if (StringUtils.isNotBlank(proposaPat.getTypeId()) && !proposaPat.getTypeId().equals(proposaPat2.getTypeId())) {
                continue;
            }
            proposaPat2.setTaskId(taskImpl.getId());
            if (taskImpl.getSuspensionState() == 2) {
                proposaPat2.setTaskName("已挂起");
            } else {
                proposaPat2.setTaskName(taskImpl.getName());
            }
            SysUser sysUser = userMapper.selectUserByLoginName(proposaPat2.getApplyUserName());
            proposaPat2.setApplyUserName(sysUser.getUserName());
            results.add(proposaPat2);
        }

        List<RyProposaPatVo> tempList;
        if (pageNum != null && pageSize != null) {
            int maxRow = (pageNum - 1) * pageSize + pageSize > results.size() ? results.size() : (pageNum - 1) * pageSize + pageSize;
            tempList = results.subList((pageNum - 1) * pageSize, maxRow);
            list.setTotal(results.size());
            list.setPageNum(pageNum);
            list.setPageSize(pageSize);
        } else {
            tempList = results;
        }

        list.addAll(tempList);

        return list;
    }

    /**
     * 查询已办列表
     * @param proposaPat
     * @param userId
     * @return
     */
    @Override
    public Page<RyProposaPatVo> findDoneTasks(RyProposaPatVo proposaPat, String userId) {
        // 手动分页
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        Page<RyProposaPatVo> list = new Page<>();

        List<RyProposaPatVo> results = new ArrayList<>();
        List<HistoricTaskInstance> hisList = processService.findDoneTasks(userId, proposaPat.getTaskName());
        // 根据流程的业务ID查询实体并关联
        for (HistoricTaskInstance instance : hisList) {
            String processInstanceId = instance.getProcessInstanceId();
            // 条件过滤 1
            if (StringUtils.isNotBlank(proposaPat.getInstanceId()) && !proposaPat.getInstanceId().equals(processInstanceId)) {
                continue;
            }
            HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            String businessKey = processInstance.getBusinessKey();
            RyProposaPatVo ProposaPat = proposalPatMapper.selectProposalPatById(businessKey);
            RyProposaPatVo newProposaPat = new RyProposaPatVo();
            BeanUtils.copyProperties(ProposaPat, newProposaPat);
            // 条件过滤 2
            if (StringUtils.isNotBlank(proposaPat.getTypeId()) && !proposaPat.getTypeId().equals(ProposaPat.getTypeId())) {
                continue;
            }
            newProposaPat.setTaskId(instance.getId());
            newProposaPat.setTaskName(instance.getName());
            newProposaPat.setDoneTime(instance.getEndTime());
            SysUser sysUser = userMapper.selectUserByLoginName(ProposaPat.getApplyUserName());
            newProposaPat.setApplyUserName(sysUser.getUserName());
            results.add(newProposaPat);
        }

        List<RyProposaPatVo> tempList;
        if (pageNum != null && pageSize != null) {
            int maxRow = (pageNum - 1) * pageSize + pageSize > results.size() ? results.size() : (pageNum - 1) * pageSize + pageSize;
            tempList = results.subList((pageNum - 1) * pageSize, maxRow);
            list.setTotal(results.size());
            list.setPageNum(pageNum);
            list.setPageSize(pageSize);
        } else {
            tempList = results;
        }

        list.addAll(tempList);

        return list;
    }

    @Override
    public int selectProposalPatLikeId(String proposalId1) {
       return proposalPatMapper.selectProposalPatLikeId(proposalId1);
    }
}