package com.ruoyi.web.controller.patproposal;

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
import com.ruoyi.patproposal.domain.RyProposalCode;
import com.ruoyi.patproposal.service.IRyProposalCodeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专利相关编码配置Controller
 * 
 * @author zhangzhenmin
 * @date 2020-08-13
 */
@Controller
@RequestMapping("/patproposal/code")
public class RyProposalCodeController extends BaseController
{
    private String prefix = "patproposal/code";

    @Autowired
    private IRyProposalCodeService ryProposalCodeService;

    @RequiresPermissions("patproposal:code:view")
    @GetMapping()
    public String code()
    {
        return prefix + "/code";
    }

    /**
     * 查询专利相关编码配置列表
     */
    @RequiresPermissions("patproposal:code:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposalCode ryProposalCode)
    {
        startPage();
        List<RyProposalCode> list = ryProposalCodeService.selectRyProposalCodeList(ryProposalCode);
        return getDataTable(list);
    }

    /**
     * 导出专利相关编码配置列表
     */
    @RequiresPermissions("patproposal:code:export")
    @Log(title = "专利相关编码配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposalCode ryProposalCode)
    {
        List<RyProposalCode> list = ryProposalCodeService.selectRyProposalCodeList(ryProposalCode);
        ExcelUtil<RyProposalCode> util = new ExcelUtil<RyProposalCode>(RyProposalCode.class);
        return util.exportExcel(list, "code");
    }

    /**
     * 新增专利相关编码配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专利相关编码配置
     */
    @RequiresPermissions("patproposal:code:add")
    @Log(title = "专利相关编码配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyProposalCode ryProposalCode)
    {
        return toAjax(ryProposalCodeService.insertRyProposalCode(ryProposalCode));
    }

    /**
     * 修改专利相关编码配置
     */
    @GetMapping("/edit/{pcId}")
    public String edit(@PathVariable("pcId") Long pcId, ModelMap mmap)
    {
        RyProposalCode ryProposalCode = ryProposalCodeService.selectRyProposalCodeById(pcId);
        mmap.put("ryProposalCode", ryProposalCode);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利相关编码配置
     */
    @RequiresPermissions("patproposal:code:edit")
    @Log(title = "专利相关编码配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyProposalCode ryProposalCode)
    {
        return toAjax(ryProposalCodeService.updateRyProposalCode(ryProposalCode));
    }

    /**
     * 删除专利相关编码配置
     */
    @RequiresPermissions("patproposal:code:remove")
    @Log(title = "专利相关编码配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryProposalCodeService.deleteRyProposalCodeByIds(ids));
    }
}
