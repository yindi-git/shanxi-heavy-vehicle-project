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
import com.ruoyi.co.domain.RyCoCurrencyType;
import com.ruoyi.co.service.IRyCoCurrencyTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货币种类信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Controller
@RequestMapping("/co/currencyType")
public class RyCoCurrencyTypeController extends BaseController
{
    private String prefix = "/co/currencyType";

    @Autowired
    private IRyCoCurrencyTypeService ryCoCurrencyTypeService;

   // @RequiresPermissions("co:currencyType:view")
    @GetMapping()
    public String currencyType()
    {
        return prefix + "/currencyType";
    }

    /**
     * 查询货币种类信息列表
     */
    // @RequiresPermissions("co:currencyType:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyCoCurrencyType ryCoCurrencyType)
    {
        startPage();
        List<RyCoCurrencyType> list = ryCoCurrencyTypeService.selectRyCoCurrencyTypeList(ryCoCurrencyType);
        return getDataTable(list);
    }

    /**
     * 导出货币种类信息列表
     */
    @RequiresPermissions("co:currencyType:export")
    @Log(title = "货币种类信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyCoCurrencyType ryCoCurrencyType)
    {
        List<RyCoCurrencyType> list = ryCoCurrencyTypeService.selectRyCoCurrencyTypeList(ryCoCurrencyType);
        ExcelUtil<RyCoCurrencyType> util = new ExcelUtil<RyCoCurrencyType>(RyCoCurrencyType.class);
        return util.exportExcel(list, "currencyType");
    }

    /**
     * 新增货币种类信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存货币种类信息
     */
    @RequiresPermissions("co:currencyType:add")
    @Log(title = "货币种类信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyCoCurrencyType ryCoCurrencyType)
    {
        return toAjax(ryCoCurrencyTypeService.insertRyCoCurrencyType(ryCoCurrencyType));
    }

    /**
     * 修改货币种类信息
     */
    @GetMapping("/edit/{currencyTypeId}")
    public String edit(@PathVariable("currencyTypeId") Integer currencyTypeId, ModelMap mmap)
    {
        RyCoCurrencyType ryCoCurrencyType = ryCoCurrencyTypeService.selectRyCoCurrencyTypeById(currencyTypeId);
        mmap.put("ryCoCurrencyType", ryCoCurrencyType);
        return prefix + "/edit";
    }

    /**
     * 修改保存货币种类信息
     */
    @RequiresPermissions("co:currencyType:edit")
    @Log(title = "货币种类信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyCoCurrencyType ryCoCurrencyType)
    {
        return toAjax(ryCoCurrencyTypeService.updateRyCoCurrencyType(ryCoCurrencyType));
    }

    /**
     * 删除货币种类信息
     */
    @RequiresPermissions("co:currencyType:remove")
    @Log(title = "货币种类信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryCoCurrencyTypeService.deleteRyCoCurrencyTypeByIds(ids));
    }
}
