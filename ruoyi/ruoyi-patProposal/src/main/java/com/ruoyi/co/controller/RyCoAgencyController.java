package com.ruoyi.co.controller;

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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.co.domain.RyCoAgency;
import com.ruoyi.co.service.IRyCoAgencyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 代理机构信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Controller
@RequestMapping("/co/agency")
public class RyCoAgencyController extends BaseController
{
    private String prefix = "co/agency";

    @Autowired
    private IRyCoAgencyService ryCoAgencyService;

    @RequiresPermissions("co:agency:view")
    @GetMapping()
    public String agency()
    {
        return prefix + "/agency";
    }

    /**
     * 查询代理机构信息列表
     */
    @RequiresPermissions("co:agency:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyCoAgency ryCoAgency)
    {
        startPage();
        List<RyCoAgency> list = ryCoAgencyService.selectRyCoAgencyList(ryCoAgency);
        return getDataTable(list);
    }

    /**
     * 导出代理机构信息列表
     */
    @RequiresPermissions("co:agency:export")
    @Log(title = "代理机构信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyCoAgency ryCoAgency)
    {
        List<RyCoAgency> list = ryCoAgencyService.selectRyCoAgencyList(ryCoAgency);
        ExcelUtil<RyCoAgency> util = new ExcelUtil<RyCoAgency>(RyCoAgency.class);
        return util.exportExcel(list, "agency");
    }

    /**
     * 新增代理机构信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存代理机构信息
     */
    @RequiresPermissions("co:agency:add")
    @Log(title = "代理机构信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyCoAgency ryCoAgency)
    {
        return toAjax(ryCoAgencyService.insertRyCoAgency(ryCoAgency));
    }

    /**
     * 修改代理机构信息
     */
    @GetMapping("/edit/{agencyId}")
    public String edit(@PathVariable("agencyId") String agencyId, ModelMap mmap)
    {
        RyCoAgency ryCoAgency = ryCoAgencyService.selectRyCoAgencyById(agencyId);
        mmap.put("ryCoAgency", ryCoAgency);
        return prefix + "/edit";
    }

    /**
     * 修改保存代理机构信息
     */
    @RequiresPermissions("co:agency:edit")
    @Log(title = "代理机构信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyCoAgency ryCoAgency)
    {
        return toAjax(ryCoAgencyService.updateRyCoAgency(ryCoAgency));
    }

    /**
     * 删除代理机构信息
     */
    @RequiresPermissions("co:agency:remove")
    @Log(title = "代理机构信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryCoAgencyService.deleteRyCoAgencyByIds(ids));
    }

   @PostMapping("/selectListByAgencyId")
   @ResponseBody
    public List<RyCoAgency> selectAllRyCoAgencyList(){
        return ryCoAgencyService.selectAllRyCoAgencyList();
    }
}
