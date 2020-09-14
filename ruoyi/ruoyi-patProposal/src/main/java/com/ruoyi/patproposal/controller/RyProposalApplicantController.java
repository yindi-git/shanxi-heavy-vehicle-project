package com.ruoyi.patproposal.controller;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalApplicant;
import com.ruoyi.patproposal.service.IRyProposalApplicantService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-08-28
 */
@Controller
@RequestMapping("/system/applicant")
public class RyProposalApplicantController extends BaseController
{
    private String prefix = "system/applicant";

    @Autowired
    private IRyProposalApplicantService ryProposalApplicantService;

    @RequiresPermissions("system:applicant:view")
    @GetMapping()
    public String applicant()
    {
        return prefix + "/applicant";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:applicant:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposalApplicant ryProposalApplicant)
    {
        startPage();
        List<RyProposalApplicant> list = ryProposalApplicantService.selectRyProposalApplicantList(ryProposalApplicant);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:applicant:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposalApplicant ryProposalApplicant)
    {
        List<RyProposalApplicant> list = ryProposalApplicantService.selectRyProposalApplicantList(ryProposalApplicant);
        ExcelUtil<RyProposalApplicant> util = new ExcelUtil<RyProposalApplicant>(RyProposalApplicant.class);
        return util.exportExcel(list, "applicant");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:applicant:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyProposalApplicant ryProposalApplicant)
    {
        return toAjax(ryProposalApplicantService.insertRyProposalApplicant(ryProposalApplicant));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{applicantId}")
    public String edit(@PathVariable("applicantId") String applicantId, ModelMap mmap)
    {
        RyProposalApplicant ryProposalApplicant = ryProposalApplicantService.selectRyProposalApplicantById(applicantId);
        mmap.put("ryProposalApplicant", ryProposalApplicant);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:applicant:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyProposalApplicant ryProposalApplicant)
    {
        return toAjax(ryProposalApplicantService.updateRyProposalApplicant(ryProposalApplicant));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:applicant:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryProposalApplicantService.deleteRyProposalApplicantByIds(ids));
    }
}
