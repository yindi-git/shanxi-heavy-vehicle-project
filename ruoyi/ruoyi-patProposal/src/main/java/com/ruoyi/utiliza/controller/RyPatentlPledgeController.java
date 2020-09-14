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
import com.ruoyi.utiliza.domain.RyPatentlPledge;
import com.ruoyi.utiliza.service.IRyPatentlPledgeService;

/**
 * 专利运用质押Controller
 * 
 * @author wxb
 * @date 2020-09-04
 */
@Controller
@RequestMapping("/pledge/pledges")
public class RyPatentlPledgeController extends BaseController {
    private String prefix = "pledge/pledges";

    @Autowired
    private IRyPatentlPledgeService ryPatentlPledgeService;
    @Autowired
    private PatCommonService patCommonService;

    @RequiresPermissions("pledge:pledges:view")
    @GetMapping()
    public String pledges() {
        return prefix + "/pledges";
    }

    /**
     * 查询专利运用质押列表
     */
    @RequiresPermissions("pledge:pledges:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyPatentlPledge ryPatentlPledge) {
        startPage();
        List<RyPatentlPledge> list = ryPatentlPledgeService.selectRyPatentlPledgeList(ryPatentlPledge);
        return getDataTable(list);
    }

    /**
     * 导出专利运用质押列表
     */
    @RequiresPermissions("pledge:pledges:export")
    @Log(title = "专利运用质押", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyPatentlPledge ryPatentlPledge) {
        List<RyPatentlPledge> list = ryPatentlPledgeService.selectRyPatentlPledgeList(ryPatentlPledge);
        ExcelUtil<RyPatentlPledge> util = new ExcelUtil<RyPatentlPledge>(RyPatentlPledge.class);
        return util.exportExcel(list, "pledges");
    }

    /**
     * 新增专利运用质押
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存专利运用质押
     */
    @RequiresPermissions("pledge:pledges:add")
    @Log(title = "专利运用质押", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyPatentlPledge ryPatentlPledge) {
        String sb = ryPatentlPledge.getProposalId();
        String[] as = sb.split(",");

        ryPatentlPledge.setProposalId(as[0]);
        ryPatentlPledge.setProposalName(as[1]);

        ryPatentlPledgeService.insertRyPatentlPledge(ryPatentlPledge);
        String tableName = "ry_patentl_pledge";
        int perIds = patCommonService.getNewIdPermit(tableName);
        return toAjaxs(perIds);
    }

    /**
     * 修改专利运用质押
     */
    @GetMapping("/edit/{permitId}")
    public String edit(@PathVariable("permitId") Long permitId, ModelMap mmap) {
        RyPatentlPledge ryPatentlPledge = ryPatentlPledgeService.selectRyPatentlPledgeById(permitId);
        mmap.put("ryPatentlPledge", ryPatentlPledge);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利运用质押
     */
    @RequiresPermissions("pledge:pledges:edit")
    @Log(title = "专利运用质押", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyPatentlPledge ryPatentlPledge) {
        return toAjax(ryPatentlPledgeService.updateRyPatentlPledge(ryPatentlPledge));
    }

    /**
     * 删除专利运用质押
     */
    @RequiresPermissions("pledge:pledges:remove")
    @Log(title = "专利运用质押", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ryPatentlPledgeService.deleteRyPatentlPledgeByIds(ids));
    }
}
