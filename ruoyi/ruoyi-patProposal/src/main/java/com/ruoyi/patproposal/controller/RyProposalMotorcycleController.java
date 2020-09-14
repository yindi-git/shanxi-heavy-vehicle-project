package com.ruoyi.patproposal.controller;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalMotorcycle;
import com.ruoyi.patproposal.service.IRyProposalMotorcycleService;
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
@RequestMapping("/system/motorcycle")
public class RyProposalMotorcycleController extends BaseController
{
    private String prefix = "system/motorcycle";

    @Autowired
    private IRyProposalMotorcycleService ryProposalMotorcycleService;

    @RequiresPermissions("system:motorcycle:view")
    @GetMapping()
    public String motorcycle()
    {
        return prefix + "/motorcycle";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:motorcycle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposalMotorcycle ryProposalMotorcycle)
    {
        startPage();
        List<RyProposalMotorcycle> list = ryProposalMotorcycleService.selectRyProposalMotorcycleList(ryProposalMotorcycle);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:motorcycle:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposalMotorcycle ryProposalMotorcycle)
    {
        List<RyProposalMotorcycle> list = ryProposalMotorcycleService.selectRyProposalMotorcycleList(ryProposalMotorcycle);
        ExcelUtil<RyProposalMotorcycle> util = new ExcelUtil<RyProposalMotorcycle>(RyProposalMotorcycle.class);
        return util.exportExcel(list, "motorcycle");
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
    @RequiresPermissions("system:motorcycle:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyProposalMotorcycle ryProposalMotorcycle)
    {
        return toAjax(ryProposalMotorcycleService.insertRyProposalMotorcycle(ryProposalMotorcycle));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{motorcycleId}")
    public String edit(@PathVariable("motorcycleId") String motorcycleId, ModelMap mmap)
    {
        RyProposalMotorcycle ryProposalMotorcycle = ryProposalMotorcycleService.selectRyProposalMotorcycleById(motorcycleId);
        mmap.put("ryProposalMotorcycle", ryProposalMotorcycle);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:motorcycle:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyProposalMotorcycle ryProposalMotorcycle)
    {
        return toAjax(ryProposalMotorcycleService.updateRyProposalMotorcycle(ryProposalMotorcycle));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:motorcycle:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryProposalMotorcycleService.deleteRyProposalMotorcycleByIds(ids));
    }
}
