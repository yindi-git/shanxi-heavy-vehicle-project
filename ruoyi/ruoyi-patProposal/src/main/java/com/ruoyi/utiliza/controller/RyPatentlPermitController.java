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
import com.ruoyi.utiliza.domain.RyPatentlPermit;
import com.ruoyi.utiliza.service.IRyPatentlPermitService;

/**
 * 专利运用许可Controller
 * 
 * @author ruoyi
 * @date 2020-09-02
 */
@Controller
@RequestMapping("/permit/permits")
public class RyPatentlPermitController extends BaseController {
    private String prefix = "permit/permits";

    @Autowired
    private IRyPatentlPermitService ryPatentlPermitService;
    @Autowired
    private PatCommonService patCommonService;

    @RequiresPermissions("permit:permits:view")
    @GetMapping()
    public String permits() {
        return prefix + "/permits";
    }

    /**
     * 查询专利运用许可列表
     */
    @RequiresPermissions("permit:permits:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyPatentlPermit ryPatentlPermit) {
        startPage();
        List<RyPatentlPermit> list = ryPatentlPermitService.selectRyPatentlPermitList(ryPatentlPermit);
        return getDataTable(list);
    }

    /**
     * 导出专利运用许可列表
     */
    @RequiresPermissions("permit:permits:export")
    @Log(title = "专利运用许可", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyPatentlPermit ryPatentlPermit) {
        List<RyPatentlPermit> list = ryPatentlPermitService.selectRyPatentlPermitList(ryPatentlPermit);
        ExcelUtil<RyPatentlPermit> util = new ExcelUtil<RyPatentlPermit>(RyPatentlPermit.class);
        return util.exportExcel(list, "permits");
    }

    /**
     * 新增专利运用许可
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存专利运用许可
     */
    @RequiresPermissions("permit:permits:add")
    @Log(title = "专利运用许可", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyPatentlPermit ryPatentlPermit) {

        String sb = ryPatentlPermit.getProposalId();
        String[] as = sb.split(",");

        ryPatentlPermit.setProposalId(as[0]);
        ryPatentlPermit.setProposalName(as[1]);

        ryPatentlPermitService.insertRyPatentlPermit(ryPatentlPermit);
        // int perIds = ryPatentlPermitService.getNewIdPermit();
        String tableName = "ry_patentl_permit";
        int perIds = patCommonService.getNewIdPermit(tableName);
        return toAjaxs(perIds);
    }

    /**
     * 修改专利运用许可
     */
    @GetMapping("/edit/{permitId}")
    public String edit(@PathVariable("permitId") Long permitId, ModelMap mmap) {
        RyPatentlPermit ryPatentlPermit = ryPatentlPermitService.selectRyPatentlPermitById(permitId);
        mmap.put("ryPatentlPermit", ryPatentlPermit);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利运用许可
     */
    @RequiresPermissions("permit:permits:edit")
    @Log(title = "专利运用许可", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyPatentlPermit ryPatentlPermit) {
        return toAjax(ryPatentlPermitService.updateRyPatentlPermit(ryPatentlPermit));
    }

    /**
     * 删除专利运用许可
     */
    @RequiresPermissions("permit:permits:remove")
    @Log(title = "专利运用许可", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ryPatentlPermitService.deleteRyPatentlPermitByIds(ids));
    }
}
