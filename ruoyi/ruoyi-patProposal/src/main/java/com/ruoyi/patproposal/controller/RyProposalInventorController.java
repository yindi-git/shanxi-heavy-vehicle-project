package com.ruoyi.patproposal.controller;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalInventor;
import com.ruoyi.patproposal.service.IRyProposalInventorService;
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
@RequestMapping("/system/inventor")
public class RyProposalInventorController extends BaseController
{
    private String prefix = "system/inventor";

    @Autowired
    private IRyProposalInventorService ryProposalInventorService;

    @RequiresPermissions("system:inventor:view")
    @GetMapping()
    public String inventor()
    {
        return prefix + "/inventor";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:inventor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposalInventor ryProposalInventor)
    {
        startPage();
        List<RyProposalInventor> list = ryProposalInventorService.selectRyProposalInventorList(ryProposalInventor);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:inventor:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposalInventor ryProposalInventor)
    {
        List<RyProposalInventor> list = ryProposalInventorService.selectRyProposalInventorList(ryProposalInventor);
        ExcelUtil<RyProposalInventor> util = new ExcelUtil<RyProposalInventor>(RyProposalInventor.class);
        return util.exportExcel(list, "inventor");
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
    @RequiresPermissions("system:inventor:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyProposalInventor ryProposalInventor)
    {
        return toAjax(ryProposalInventorService.insertRyProposalInventor(ryProposalInventor));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{inventorId}")
    public String edit(@PathVariable("inventorId") String inventorId, ModelMap mmap)
    {
        RyProposalInventor ryProposalInventor = ryProposalInventorService.selectRyProposalInventorById(inventorId);
        mmap.put("ryProposalInventor", ryProposalInventor);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:inventor:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyProposalInventor ryProposalInventor)
    {
        return toAjax(ryProposalInventorService.updateRyProposalInventor(ryProposalInventor));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:inventor:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryProposalInventorService.deleteRyProposalInventorByIds(ids));
    }
}
