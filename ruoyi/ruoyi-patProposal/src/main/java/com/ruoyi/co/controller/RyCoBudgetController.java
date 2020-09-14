package com.ruoyi.co.controller;

import java.util.List;

import com.ruoyi.co.domain.RyCoBudget;
import com.ruoyi.co.service.IRyCoBudgetService;
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
 * @date 2020-09-01
 */
@Controller
@RequestMapping("/co/budget")
public class RyCoBudgetController extends BaseController
{
    private String prefix = "co/budget";

    @Autowired
    private IRyCoBudgetService ryCoBudgetService;

    @RequiresPermissions("system:budget:view")
    @GetMapping()
    public String budget()
    {
        return prefix + "/budget";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:budget:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyCoBudget ryCoBudget)
    {
        startPage();
        List<RyCoBudget> list = ryCoBudgetService.selectRyCoBudgetList(ryCoBudget);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:budget:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyCoBudget ryCoBudget)
    {
        List<RyCoBudget> list = ryCoBudgetService.selectRyCoBudgetList(ryCoBudget);
        ExcelUtil<RyCoBudget> util = new ExcelUtil<RyCoBudget>(RyCoBudget.class);
        return util.exportExcel(list, "budget");
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
    @RequiresPermissions("system:budget:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyCoBudget ryCoBudget)
    {
        return toAjax(ryCoBudgetService.insertRyCoBudget(ryCoBudget));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{budgetid}")
    public String edit(@PathVariable("budgetid") Integer budgetid, ModelMap mmap)
    {
        RyCoBudget ryCoBudget = ryCoBudgetService.selectRyCoBudgetById(budgetid);
        mmap.put("ryCoBudget", ryCoBudget);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:budget:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyCoBudget ryCoBudget)
    {
        return toAjax(ryCoBudgetService.updateRyCoBudget(ryCoBudget));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:budget:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryCoBudgetService.deleteRyCoBudgetByIds(ids));
    }

    @PostMapping("selectAllBudgetList")
    @ResponseBody
    public List<RyCoBudget> selectAllBudgetList(){
        return ryCoBudgetService.selectAllBudgetList();}

}
