package com.ruoyi.co.controller;

import com.ruoyi.activiti.service.IProcessService;
import com.ruoyi.co.domain.RyCoAgency;
import com.ruoyi.co.domain.RyCoSynergy;
import com.ruoyi.co.domain.RyCoSynergyVo;
import com.ruoyi.co.service.IRyCoAgencyService;
import com.ruoyi.co.service.IRyCoSynergyService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.patproposal.domain.ProposalInventor;
import com.ruoyi.patproposal.domain.ProposalPat;
import com.ruoyi.patproposal.service.IProposalInventorService;
import com.ruoyi.patproposal.service.IProposalPatService;
import com.ruoyi.patproposal.service.IRyProposalApplicantService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 【协同审查】Controller
 * 
 * @author ruoyi
 * @date 2020-08-27
 */
@Controller
@RequestMapping("/synergy")
public class RyCoSynergyController extends BaseController
{
    private String prefix = "/synergy";

    @Autowired
    private IRyCoSynergyService ryCoSynergyService;

    @Autowired

    private IProposalPatService iProposalPatService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IProcessService processService;

    @Autowired
    private IProposalInventorService proposalInventorService;
    @Autowired
    private IRyProposalApplicantService proposalApplicantService;
    @Autowired
    private IRyCoAgencyService ryCoAgencyService;

    /*  @RequiresPermissions("system:synergy:view")*/
    @GetMapping()
    public String synergy()
    {
        return prefix + "/synergy";
    }

    /**
     * 查询【协同审查】列表
     */
  /*  @RequiresPermissions("co:synergy:list")*/
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyCoSynergy ryCoSynergy)
    {
        startPage();
        List<RyCoSynergy> list = ryCoSynergyService.selectRyCoSynergyList(ryCoSynergy);
        return getDataTable(list);
    }

    /**
     * 导出【协同审查】列表
     */
    @RequiresPermissions("system:synergy:export")
    @Log(title = "【协同审查】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyCoSynergy ryCoSynergy)
    {
        List<RyCoSynergy> list = ryCoSynergyService.selectRyCoSynergyList(ryCoSynergy);
        ExcelUtil<RyCoSynergy> util = new ExcelUtil<RyCoSynergy>(RyCoSynergy.class);
        return util.exportExcel(list, "synergy");
    }



    /**
     * 【编辑或发起协同审查】
     */
    @GetMapping("/edit/{proposalId}")
    public String edit(@PathVariable("proposalId") String proposalId, ModelMap mmap)
    {
        ProposalPat proposalPat =null ;
        //如果是法务部发起协同审查则传递参数以ZLTA开头，否则为协同审查记录编辑
        String maxId=proposalId ;
        if(proposalId.startsWith("ZLTA")){
            //查询专利申请信息
             proposalPat =iProposalPatService.selectProposalPatById(proposalId);
            //初始化协同审查数据
            RyCoSynergy ryCoSynergy1 = new RyCoSynergy();
            ryCoSynergy1.setProposalId(proposalPat.getProposalId());
            ryCoSynergy1.setIsOpen(Integer.parseInt(proposalPat.getIsOpen()));
            ryCoSynergy1.setIsPreliminary(Integer.parseInt(proposalPat.getIsPreliminary()));
            ryCoSynergy1.setCountryid(Integer.parseInt(proposalPat.getCountryId()));
            ryCoSynergyService.insertRyCoSynergy(ryCoSynergy1);
            //获取初始化后的协同审查记录ID
            maxId=ryCoSynergyService.selectCoSyneryMaxIdByProposalId(proposalId) ;
        }

        //获取初始化后的协同审查记录或目标要编辑的协同审查记录
        RyCoSynergy ryCoSynergy = ryCoSynergyService.selectRyCoSynergyById(maxId);
        //如果是法务部发起协同审查则传递参数以ZLTA开头，需要生成专利编号
        if(proposalId.startsWith("ZLTA")){
            String str=proposalApplicantService.selectRyProposalApplicantById(proposalPat.getApplicantId()).getApplicantCode();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            String tt =sdf.format(date);
            String deptCode = "ZLSQ".concat(str).concat(sdf.format(date));
            int sum = ryCoSynergyService.selectProposalPatLikeId(deptCode);
            if(sum == 0){ ryCoSynergy.setPatentcode(deptCode+"00001");}
            else{
                int sumLength = String.valueOf(sum+1).length();
                String sun= "00001".substring(0,5-sumLength);
                ryCoSynergy.setPatentcode(deptCode+sun+(sum+1));
            }
        }else{
            //协同审查记录编辑，需要查询专利提案对象信息
            if(ryCoSynergy !=null){
                proposalId =ryCoSynergy.getProposalId() ;
                proposalPat =iProposalPatService.selectProposalPatById(proposalId);

            }

        }
        ryCoSynergy.setProposalPat(proposalPat);
        //查询第一发明人信息
        ProposalInventor   inventor =   proposalInventorService.selectFirstInventorByProposalId(proposalId) ;
        ryCoSynergy.setProposalInventor(inventor);
        mmap.put("ryCoSynergy", ryCoSynergy);
        return prefix + "/edit";
    }

    /**
     * 修改保存【协同审查】
     */
   /* @RequiresPermissions("system:synergy:edit")*/
    @Log(title = "【协同审查】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyCoSynergyVo ryCoSynergy)
    {

        return toAjax(ryCoSynergyService.updateRyCoSynergy(ryCoSynergy));
    }

    /**
     * 删除【协同审查】
     */
//    @RequiresPermissions("system:synergy:remove")
    @Log(title = "【协同审查】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryCoSynergyService.deleteRyCoSynergyByIds(ids));
    }


    /**
     * 查询第一发明人
     */
    @PostMapping( "/inventor")
    @ResponseBody
    public List<ProposalInventor> selectInventorByProposalId(String proposalId){
     return  proposalInventorService.selectInventorByProposalId(proposalId);
    }
/**
 * 提交申请
 */
    @Log(title = "法务部代理委托提交", businessType = BusinessType.UPDATE)
    @PostMapping( "/submitApply")
    @ResponseBody
    public AjaxResult submitApply(String  id) {
        RyCoSynergyVo ryCoSynergy = ryCoSynergyService.selectRyCoSynergyById(id);
        String applyUserId = ShiroUtils.getLoginName();
        System.out.println(applyUserId);
        ryCoSynergyService.submitApply(ryCoSynergy, applyUserId, "synergy", new HashMap<>());
        return success();
    }


@Log(title = "法务部代理委托提交", businessType = BusinessType.UPDATE)
@PostMapping( "/submitApplys")
@ResponseBody
public AjaxResult submitApply(String  id,HttpServletRequest request, /*@RequestParam("users") */String users) {
    System.out.println(id);
    RyCoSynergyVo ryCoSynergy = ryCoSynergyService.selectRyCoSynergyById(id);
    System.out.println(ryCoSynergy);
    String applyUserId = ShiroUtils.getLoginName();
    Map<String, Object> variables = new HashMap<>();
    try {
        if (users != null /*&& users.length > 0*/) {
            Object value =  Arrays.asList(users);
            variables.put("users", value);
        }
    ryCoSynergyService.submitApply(ryCoSynergy, applyUserId, "synergy", variables);
    return success();}catch (Exception e) {
            logger.error("error on submitApply id {}, variables={}", new Object[]{ryCoSynergy.getId(), variables, e});
            return error("提交申请失败");
        }
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
        RyCoSynergyVo ryCoSynergy =  ryCoSynergyService.selectRyCoSynergyByAgencyId(processInstance.getBusinessKey());
        String proposalId="0";
        if(ryCoSynergy !=null){
            proposalId=ryCoSynergy.getProposalId();
            //查询专利申请信息
            ProposalPat proposalPat =iProposalPatService.selectProposalPatById(proposalId);
            ryCoSynergy.setProposalPat(proposalPat);
            //查询第一发明人信息
            ProposalInventor inventor =   proposalInventorService.selectFirstInventorByProposalId(proposalId) ;
            ryCoSynergy.setProposalInventor(inventor);
        }

        mmap.put("ryCoSynergy", ryCoSynergy);
        mmap.put("taskId", taskId);
        String verifyName = task.getTaskDefinitionKey().substring(0, 1).toUpperCase() + task.getTaskDefinitionKey().substring(1);
        return prefix + "/task" + verifyName;
    }

    @GetMapping("/showFormDialog/{instanceId}")
    public String showFormDialog(@PathVariable("instanceId") String instanceId, ModelMap mmap) {
        String businessKey = processService.findBusinessKeyByInstanceId(instanceId);
        RyCoSynergyVo ryCoSynergy  = ryCoSynergyService.selectRyCoSynergyById(businessKey);
        mmap.put("ryCoSynergy", ryCoSynergy);
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
                               @ModelAttribute("preloadLeave") RyCoSynergyVo ryCoSynergy, HttpServletRequest request) {
        boolean saveEntityBoolean = BooleanUtils.toBoolean(saveEntity);
        processService.complete(taskId, ryCoSynergy.getInstanceId(), ryCoSynergy.getTaskName(), ryCoSynergy.getProposalId(), "synergy", new HashMap<String, Object>(), request);
        if (saveEntityBoolean) {
            ryCoSynergyService.updateRyCoSynergy(ryCoSynergy);
        }
        return success("任务已完成");
    }

    /**
     * 自动绑定页面字段
     */
    @ModelAttribute("preloadLeave")
    public RyCoSynergyVo getLeave(@RequestParam(value = "id", required = false) String id, HttpSession session) {
        if (id != null) {
            return ryCoSynergyService.selectRyCoSynergyById(id);
        }
        return new RyCoSynergyVo();
    }
}
