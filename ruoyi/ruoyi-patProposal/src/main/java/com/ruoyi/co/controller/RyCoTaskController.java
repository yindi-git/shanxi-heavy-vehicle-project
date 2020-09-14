package com.ruoyi.co.controller;

import java.util.List;

import com.ruoyi.co.domain.RyCoTask;
import com.ruoyi.co.service.IRyCoTaskService;
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
@RequestMapping("/system/task")
public class RyCoTaskController extends BaseController
{
    private String prefix = "system/task";

    @Autowired
    private IRyCoTaskService ryCoTaskService;

    @RequiresPermissions("system:task:view")
    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:task:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyCoTask ryCoTask)
    {
        startPage();
        List<RyCoTask> list = ryCoTaskService.selectRyCoTaskList(ryCoTask);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:task:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyCoTask ryCoTask)
    {
        List<RyCoTask> list = ryCoTaskService.selectRyCoTaskList(ryCoTask);
        ExcelUtil<RyCoTask> util = new ExcelUtil<RyCoTask>(RyCoTask.class);
        return util.exportExcel(list, "task");
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
    @RequiresPermissions("system:task:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyCoTask ryCoTask)
    {
        return toAjax(ryCoTaskService.insertRyCoTask(ryCoTask));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{taskid}")
    public String edit(@PathVariable("taskid") Integer taskid, ModelMap mmap)
    {
        RyCoTask ryCoTask = ryCoTaskService.selectRyCoTaskById(taskid);
        mmap.put("ryCoTask", ryCoTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:task:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyCoTask ryCoTask)
    {
        return toAjax(ryCoTaskService.updateRyCoTask(ryCoTask));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:task:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryCoTaskService.deleteRyCoTaskByIds(ids));
    }
}
