package com.ruoyi.patproposal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ruoyi.activiti.service.IProcessService;

import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.patproposal.domain.RyProposaPatVo;
import com.ruoyi.patproposal.service.IRyProposalApplicantService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.BooleanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.patproposal.domain.ProposalPat;
import com.ruoyi.patproposal.service.IProposalPatService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 专利提案相关Controller
 *
 * @author 神州数码
 * @date 2020-08-13
 */
@Controller
@RequestMapping("/patProposal")
public class ProposalPatController extends BaseController
{
    private String prefix = "/patProposal";

    @Autowired
    private IProposalPatService proposalPatService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IProcessService processService;

    @Autowired
    private IRyProposalApplicantService proposalApplicantService;



    /*

        @RequiresPermissions("patproposal:pat:view")*/
    @GetMapping()
    public String pat()
    {
        return prefix + "/pat";
    }

    /**
     * 查询专利提案相关列表
     */
    /*   @RequiresPermissions("patproposal:pat:list")*/
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposaPatVo proposalPat)
    {
        startPage();
        if(!ShiroUtils.getLoginName().equals("admin")){ proposalPat.setCreateBy(ShiroUtils.getLoginName());}
        List<RyProposaPatVo> list = proposalPatService.selectProposalPatList(proposalPat);
        return getDataTable(list);
    }

    /**
     * 导出专利提案相关列表
     */
    /* @RequiresPermissions("patproposal:pat:export")*/
    @Log(title = "专利提案相关", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposaPatVo proposalPat)
    {
        List<RyProposaPatVo> list = proposalPatService.selectProposalPatList(proposalPat);
        ExcelUtil<RyProposaPatVo> util = new ExcelUtil<RyProposaPatVo>(RyProposaPatVo.class);
        return util.exportExcel(list, "pat");
    }

    /**
     * 新增专利提案相关
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专利提案相关
     */
    /*  @RequiresPermissions("patproposal:pat:add")*/
    @Log(title = "专利提案相关", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProposalPat proposalPat)
    {
        //三位公司编码
        String  str =  proposalApplicantService.selectRyProposalApplicantById(proposalPat.getApplicantId()).getApplicantCode();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String tt =sdf.format(date);
        String deptCode = "ZLTA".concat(str).concat(sdf.format(date));
        int sum = proposalPatService.selectProposalPatLikeId(deptCode);
        if(sum == 0){ proposalPat.setProposalId(deptCode+"00001");}
        else{
            int sumLength = String.valueOf(sum+1).length();
            String sun= "00001".substring(0,5-sumLength);
            proposalPat.setProposalId(deptCode+sun+(sum+1));
        }
        proposalPat.setCreateTime(DateUtils.getNowDate());
        proposalPat.setCreateBy(ShiroUtils.getLoginName());
        proposalPatService.insertProposalPat(proposalPat);
        return AjaxResult.success("插入成功",proposalPat.getProposalId());
    }


    @Log(title = "专利提案相关", businessType = BusinessType.OTHER)
    @PostMapping("/checkProposalName")
    @ResponseBody
    public AjaxResult checkProposalName(String proposalName)
    {   int num = proposalPatService.checkProposalName(proposalName);
        return AjaxResult.success("查询成功",num);
    }

    /**
     * 修改专利提案相关
     */
    @GetMapping("/edit/{proposalId}")
    public String edit(@PathVariable("proposalId") String proposalId, ModelMap mmap)
    {
        ProposalPat proposalPat = proposalPatService.selectProposalPatById(proposalId);
        mmap.put("proposalPat", proposalPat);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利提案相关
     */
    /*    @RequiresPermissions("patproposal:pat:edit")*/
    @Log(title = "专利提案相关", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProposalPat proposalPat)
    {
        return toAjax(proposalPatService.updateProposalPat(proposalPat));
    }

    /**
     * 删除专利提案相关
     */
    /*    @RequiresPermissions("patproposal:pat:remove")*/
    @Log(title = "专利提案相关", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proposalPatService.deleteProposalPatByIds(ids));
    }

    /**
     * 提交申请
     */
    @Log(title = "专利申请提交", businessType = BusinessType.UPDATE)
    @PostMapping( "/submitApply")
    @ResponseBody
    public AjaxResult submitApply(String  id) {
        RyProposaPatVo ryProposalPat = proposalPatService.selectProposalPatById(id);
        String applyUserId = ShiroUtils.getLoginName();
        proposalPatService.submitApply(ryProposalPat, applyUserId, "patProposal", new HashMap<>());

        return success();
    }


    @GetMapping("/patTodo")
    public String todoView() {
        return prefix + "/patTodo";
    }
    /**
     * 加载审批弹窗
     * @param taskId
     * @param mmap
     * @returnshowVerifyDialog
     */
    @GetMapping("/showVerifyDialog/{taskId}")
    public String showVerifyDialog(@PathVariable("taskId") String taskId, ModelMap mmap) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        RyProposaPatVo proposalPat = proposalPatService.selectProposalPatById(processInstance.getBusinessKey());
        mmap.put("proposalPat", proposalPat);
        mmap.put("taskId", taskId);
        String verifyName = task.getTaskDefinitionKey().substring(0, 1).toUpperCase() + task.getTaskDefinitionKey().substring(1);
        return prefix + "/task" + verifyName;
    }

    @GetMapping("/showFormDialog/{instanceId}")
    public String showFormDialog(@PathVariable("instanceId") String instanceId, ModelMap mmap) {
        String businessKey = processService.findBusinessKeyByInstanceId(instanceId);
        RyProposaPatVo proposalPat  = proposalPatService.selectProposalPatById(businessKey);
        mmap.put("proposalPat", proposalPat);
        return prefix + "/view";
    }


    /**
     * 完成任务
     *
     * @return
     */
    @RequestMapping(value = "/complete/{taskId}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public AjaxResult complete(@PathVariable("taskId") String taskId, @RequestParam(value = "saveEntity", required = false) String saveEntity,
                               @ModelAttribute("preloadLeave") RyProposaPatVo proposalPat, HttpServletRequest request) {
        boolean saveEntityBoolean = BooleanUtils.toBoolean(saveEntity);
        processService.complete(taskId, proposalPat.getInstanceId(), proposalPat.getProposalName(), proposalPat.getProposalId(), "patProposal", new HashMap<String, Object>(), request);
        if (saveEntityBoolean) {
            proposalPatService.updateProposalPat(proposalPat);
        }
        return success("任务已完成");
    }

    /**
     * 自动绑定页面字段
     */
    @ModelAttribute("preloadLeave")
    public RyProposaPatVo getLeave(@RequestParam(value = "id", required = false) String id, HttpSession session) {
        if (id != null) {
            return proposalPatService.selectProposalPatById(id);
        }
        return new RyProposaPatVo();
    }

}