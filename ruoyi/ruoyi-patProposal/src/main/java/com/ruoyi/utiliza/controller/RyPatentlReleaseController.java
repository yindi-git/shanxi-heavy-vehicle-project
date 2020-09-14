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
import com.ruoyi.utiliza.domain.RyPatentlRelease;
import com.ruoyi.utiliza.service.IRyPatentlReleaseService;

/**
 * 专利运用解押Controller
 * 
 * @author wxb
 * @date 2020-09-08
 */
@Controller
@RequestMapping("/release/releases")
public class RyPatentlReleaseController extends BaseController {
    private String prefix = "release/releases";

    @Autowired
    private IRyPatentlReleaseService ryPatentlReleaseService;
    @Autowired
    private PatCommonService patCommonService;

    @RequiresPermissions("release:releases:view")
    @GetMapping()
    public String releases() {
        return prefix + "/releases";
    }

    /**
     * 查询专利运用解押列表
     */
    @RequiresPermissions("release:releases:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyPatentlRelease ryPatentlRelease) {
        startPage();
        List<RyPatentlRelease> list = ryPatentlReleaseService.selectRyPatentlReleaseList(ryPatentlRelease);
        return getDataTable(list);
    }

    /**
     * 导出专利运用解押列表
     */
    @RequiresPermissions("release:releases:export")
    @Log(title = "专利运用解押", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyPatentlRelease ryPatentlRelease) {
        List<RyPatentlRelease> list = ryPatentlReleaseService.selectRyPatentlReleaseList(ryPatentlRelease);
        ExcelUtil<RyPatentlRelease> util = new ExcelUtil<RyPatentlRelease>(RyPatentlRelease.class);
        return util.exportExcel(list, "releases");
    }

    /**
     * 新增专利运用解押
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存专利运用解押
     */
    @RequiresPermissions("release:releases:add")
    @Log(title = "专利运用解押", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyPatentlRelease ryPatentlRelease) {
        String sb = ryPatentlRelease.getProposalId();
        String[] as = sb.split(",");

        ryPatentlRelease.setProposalId(as[0]);
        ryPatentlRelease.setProposalName(as[1]);

        ryPatentlReleaseService.insertRyPatentlRelease(ryPatentlRelease);
        String tableName = "ry_patentl_release";
        int perIds = patCommonService.getNewIdPermit(tableName);
        return toAjaxs(perIds);
    }

    /**
     * 修改专利运用解押
     */
    @GetMapping("/edit/{permitId}")
    public String edit(@PathVariable("permitId") Long permitId, ModelMap mmap) {
        RyPatentlRelease ryPatentlRelease = ryPatentlReleaseService.selectRyPatentlReleaseById(permitId);
        mmap.put("ryPatentlRelease", ryPatentlRelease);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利运用解押
     */
    @RequiresPermissions("release:releases:edit")
    @Log(title = "专利运用解押", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyPatentlRelease ryPatentlRelease) {
        return toAjax(ryPatentlReleaseService.updateRyPatentlRelease(ryPatentlRelease));
    }

    /**
     * 删除专利运用解押
     */
    @RequiresPermissions("release:releases:remove")
    @Log(title = "专利运用解押", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ryPatentlReleaseService.deleteRyPatentlReleaseByIds(ids));
    }
}
