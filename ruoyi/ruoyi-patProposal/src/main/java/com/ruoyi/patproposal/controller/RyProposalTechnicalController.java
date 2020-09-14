package com.ruoyi.patproposal.controller;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalTechnical;
import com.ruoyi.patproposal.service.IRyProposalTechnicalService;
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
 * @date 2020-08-04
 */
@Controller
@RequestMapping("/system/technical")
public class RyProposalTechnicalController extends BaseController
{
    private String prefix = "system/technical";

    @Autowired
    private IRyProposalTechnicalService ryProposalTechnicalService;

    @RequiresPermissions("system:technical:view")
    @GetMapping()
    public String technical()
    {
        return prefix + "/technical";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:technical:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposalTechnical ryProposalTechnical)
    {
        startPage();
        List<RyProposalTechnical> list = ryProposalTechnicalService.selectRyProposalTechnicalList(ryProposalTechnical);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:technical:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposalTechnical ryProposalTechnical)
    {
        List<RyProposalTechnical> list = ryProposalTechnicalService.selectRyProposalTechnicalList(ryProposalTechnical);
        ExcelUtil<RyProposalTechnical> util = new ExcelUtil<RyProposalTechnical>(RyProposalTechnical.class);
        return util.exportExcel(list, "technical");
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
    @RequiresPermissions("system:technical:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyProposalTechnical ryProposalTechnical)
    {
        return toAjax(ryProposalTechnicalService.insertRyProposalTechnical(ryProposalTechnical));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{technicalId}")
    public String edit(@PathVariable("technicalId") String technicalId, ModelMap mmap)
    {
        RyProposalTechnical ryProposalTechnical = ryProposalTechnicalService.selectRyProposalTechnicalById(technicalId);
        mmap.put("ryProposalTechnical", ryProposalTechnical);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:technical:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyProposalTechnical ryProposalTechnical)
    {
        return toAjax(ryProposalTechnicalService.updateRyProposalTechnical(ryProposalTechnical));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:technical:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryProposalTechnicalService.deleteRyProposalTechnicalByIds(ids));
    }
}
