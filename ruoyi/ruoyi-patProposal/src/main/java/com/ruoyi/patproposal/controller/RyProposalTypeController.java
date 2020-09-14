package com.ruoyi.patproposal.controller;

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
import com.ruoyi.patproposal.domain.RyProposalType;
import com.ruoyi.patproposal.service.IRyProposalTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专利类型信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@Controller
@RequestMapping("/system/type")
public class RyProposalTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private IRyProposalTypeService ryProposalTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询专利类型信息列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposalType ryProposalType)
    {
        startPage();
        List<RyProposalType> list = ryProposalTypeService.selectRyProposalTypeList(ryProposalType);
        return getDataTable(list);
    }

    /**
     * 导出专利类型信息列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "专利类型信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposalType ryProposalType)
    {
        List<RyProposalType> list = ryProposalTypeService.selectRyProposalTypeList(ryProposalType);
        ExcelUtil<RyProposalType> util = new ExcelUtil<RyProposalType>(RyProposalType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增专利类型信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专利类型信息
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "专利类型信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyProposalType ryProposalType)
    {
        return toAjax(ryProposalTypeService.insertRyProposalType(ryProposalType));
    }

    /**
     * 修改专利类型信息
     */
    @GetMapping("/edit/{typeId}")
    public String edit(@PathVariable("typeId") String typeId, ModelMap mmap)
    {
        RyProposalType ryProposalType = ryProposalTypeService.selectRyProposalTypeById(typeId);
        mmap.put("ryProposalType", ryProposalType);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利类型信息
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "专利类型信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyProposalType ryProposalType)
    {
        return toAjax(ryProposalTypeService.updateRyProposalType(ryProposalType));
    }

    /**
     * 删除专利类型信息
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "专利类型信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryProposalTypeService.deleteRyProposalTypeByIds(ids));
    }
}
