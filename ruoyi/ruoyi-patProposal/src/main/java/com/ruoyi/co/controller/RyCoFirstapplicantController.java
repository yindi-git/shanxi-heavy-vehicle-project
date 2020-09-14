package com.ruoyi.co.controller;

import java.util.List;

import com.ruoyi.co.domain.RyCoFirstapplicant;
import com.ruoyi.co.service.IRyCoFirstapplicantService;
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
 * @date 2020-08-27
 */
@Controller
@RequestMapping("/system/firstapplicant")
public class RyCoFirstapplicantController extends BaseController
{
    private String prefix = "system/firstapplicant";

    @Autowired
    private IRyCoFirstapplicantService ryCoFirstapplicantService;

    @RequiresPermissions("system:firstapplicant:view")
    @GetMapping()
    public String firstapplicant()
    {
        return prefix + "/firstapplicant";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:firstapplicant:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyCoFirstapplicant ryCoFirstapplicant)
    {
        startPage();
        List<RyCoFirstapplicant> list = ryCoFirstapplicantService.selectRyCoFirstapplicantList(ryCoFirstapplicant);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:firstapplicant:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyCoFirstapplicant ryCoFirstapplicant)
    {
        List<RyCoFirstapplicant> list = ryCoFirstapplicantService.selectRyCoFirstapplicantList(ryCoFirstapplicant);
        ExcelUtil<RyCoFirstapplicant> util = new ExcelUtil<RyCoFirstapplicant>(RyCoFirstapplicant.class);
        return util.exportExcel(list, "firstapplicant");
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
    @RequiresPermissions("system:firstapplicant:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyCoFirstapplicant ryCoFirstapplicant)
    {
        return toAjax(ryCoFirstapplicantService.insertRyCoFirstapplicant(ryCoFirstapplicant));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RyCoFirstapplicant ryCoFirstapplicant = ryCoFirstapplicantService.selectRyCoFirstapplicantById(id);
        mmap.put("ryCoFirstapplicant", ryCoFirstapplicant);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:firstapplicant:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyCoFirstapplicant ryCoFirstapplicant)
    {
        return toAjax(ryCoFirstapplicantService.updateRyCoFirstapplicant(ryCoFirstapplicant));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:firstapplicant:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryCoFirstapplicantService.deleteRyCoFirstapplicantByIds(ids));
    }
}
