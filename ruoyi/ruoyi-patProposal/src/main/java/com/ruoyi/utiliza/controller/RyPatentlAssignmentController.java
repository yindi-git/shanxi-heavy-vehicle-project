package com.ruoyi.utiliza.controller;

import java.util.List;

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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.patproposal.service.PatCommonService;
import com.ruoyi.utiliza.domain.RyPatentlAssignment;
import com.ruoyi.utiliza.service.IRyPatentlAssignmentService;

/**
 * 专利运用受让Controller
 * 
 * @author wxb
 * @date 2020-09-04
 */
@Controller
@RequestMapping("/assignment/assignments")
public class RyPatentlAssignmentController extends BaseController {
    private String prefix = "assignment/assignments";

    @Autowired
    private IRyPatentlAssignmentService ryPatentlAssignmentService;
    @Autowired
    private PatCommonService patCommonService;

    @RequiresPermissions("assignment:assignments:view")
    @GetMapping()
    public String assignments() {
        return prefix + "/assignments";
    }

    /**
     * 查询专利运用受让列表
     */
    @RequiresPermissions("assignment:assignments:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyPatentlAssignment ryPatentlAssignment) {
        startPage();
        List<RyPatentlAssignment> list = ryPatentlAssignmentService.selectRyPatentlAssignmentList(ryPatentlAssignment);
        return getDataTable(list);
    }

    /**
     * 导出专利运用受让列表
     */
    @RequiresPermissions("assignment:assignments:export")
    @Log(title = "专利运用受让", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyPatentlAssignment ryPatentlAssignment) {
        List<RyPatentlAssignment> list = ryPatentlAssignmentService.selectRyPatentlAssignmentList(ryPatentlAssignment);
        ExcelUtil<RyPatentlAssignment> util = new ExcelUtil<RyPatentlAssignment>(RyPatentlAssignment.class);
        return util.exportExcel(list, "assignments");
    }

    /**
     * 新增专利运用受让
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存专利运用受让
     */
    @RequiresPermissions("assignment:assignments:add")
    @Log(title = "专利运用受让", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyPatentlAssignment ryPatentlAssignment) {
        String sb = ryPatentlAssignment.getProposalId();
        String[] as = sb.split(",");

        ryPatentlAssignment.setProposalId(as[0]);
        ryPatentlAssignment.setProposalName(as[1]);

        ryPatentlAssignmentService.insertRyPatentlAssignment(ryPatentlAssignment);
        String tableName = "ry_patentl_assignment";
        int perIds = patCommonService.getNewIdPermit(tableName);
        return toAjaxs(perIds);
    }

    /**
     * 修改专利运用受让
     */
    @GetMapping("/edit/{permitId}")
    public String edit(@PathVariable("permitId") Long permitId, ModelMap mmap) {
        RyPatentlAssignment ryPatentlAssignment = ryPatentlAssignmentService.selectRyPatentlAssignmentById(permitId);
        mmap.put("ryPatentlAssignment", ryPatentlAssignment);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利运用受让
     */
    @RequiresPermissions("assignment:assignments:edit")
    @Log(title = "专利运用受让", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyPatentlAssignment ryPatentlAssignment) {
        return toAjax(ryPatentlAssignmentService.updateRyPatentlAssignment(ryPatentlAssignment));
    }

    /**
     * 删除专利运用受让
     */
    @RequiresPermissions("assignment:assignments:remove")
    @Log(title = "专利运用受让", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ryPatentlAssignmentService.deleteRyPatentlAssignmentByIds(ids));
    }
}
