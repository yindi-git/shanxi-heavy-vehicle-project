package com.ruoyi.patproposal.controller;

import java.util.List;

import com.ruoyi.patproposal.domain.RyProposalCountry;
import com.ruoyi.patproposal.service.IRyProposalCountryService;
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
 * 国家名称Controller
 *
 * @author ruoyi
 * @date 2020-08-19
 */
@Controller
@RequestMapping("/system/country")
public class  ProposalCountryController extends BaseController {
    private String prefix = "system/country";

    @Autowired
    private IRyProposalCountryService ryProposalCountryService;

    @RequiresPermissions("system:country:view")
    @GetMapping()
    public String country() {
        return prefix + "/country";
    }

    /**
     * 查询国家名称列表
     */
    @RequiresPermissions("system:country:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposalCountry ryProposalCountry) {
        startPage();
        List<RyProposalCountry> list = ryProposalCountryService.selectRyProposalCountryList(ryProposalCountry);
        return getDataTable(list);
    }

    /**
     * 导出国家名称列表
     */
    @RequiresPermissions("system:country:export")
    @Log(title = "国家名称", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposalCountry ryProposalCountry) {
        List<RyProposalCountry> list = ryProposalCountryService.selectRyProposalCountryList(ryProposalCountry);
        ExcelUtil<RyProposalCountry> util = new ExcelUtil<RyProposalCountry>(RyProposalCountry.class);
        return util.exportExcel(list, "country");
    }

    /**
     * 新增国家名称
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存国家名称
     */
    @RequiresPermissions("system:country:add")
    @Log(title = "国家名称", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyProposalCountry ryProposalCountry) {
        return toAjax(ryProposalCountryService.insertRyProposalCountry(ryProposalCountry));
    }

    /**
     * 修改国家名称
     */
    @GetMapping("/edit/{countryId}")
    public String edit(@PathVariable("countryId") String countryId, ModelMap mmap) {
        RyProposalCountry ryProposalCountry = ryProposalCountryService.selectRyProposalCountryById(countryId);
        mmap.put("ryProposalCountry", ryProposalCountry);
        return prefix + "/edit";
    }

    /**
     * 修改保存国家名称
     */
    @RequiresPermissions("system:country:edit")
    @Log(title = "国家名称", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyProposalCountry ryProposalCountry) {
        return toAjax(ryProposalCountryService.updateRyProposalCountry(ryProposalCountry));
    }

    /**
     * 删除国家名称
     */
    @RequiresPermissions("system:country:remove")
    @Log(title = "国家名称", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ryProposalCountryService.deleteRyProposalCountryByIds(ids));
    }

    @PostMapping("/selectRyProposalCountryById")
    @ResponseBody
    public RyProposalCountry selectRyProposalCountryById(String countryId){
        return  ryProposalCountryService.selectRyProposalCountryById(countryId); }



}