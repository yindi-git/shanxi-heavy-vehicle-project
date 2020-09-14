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
import com.ruoyi.utiliza.domain.RyPatentlTransfer;
import com.ruoyi.utiliza.service.IRyPatentlTransferService;

/**
 * 专利运用转让Controller
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@Controller
@RequestMapping("/transfer/transfers")
public class RyPatentlTransferController extends BaseController {
    private String prefix = "transfer/transfers";

    @Autowired
    private IRyPatentlTransferService ryPatentlTransferService;
    @Autowired
    private PatCommonService patCommonService;

    @RequiresPermissions("transfer:transfers:view")
    @GetMapping()
    public String transfers() {
        return prefix + "/transfers";
    }

    /**
     * 查询专利运用转让列表
     */
    @RequiresPermissions("transfer:transfers:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyPatentlTransfer ryPatentlTransfer) {
        startPage();
        List<RyPatentlTransfer> list = ryPatentlTransferService.selectRyPatentlTransferList(ryPatentlTransfer);
        return getDataTable(list);
    }

    /**
     * 导出专利运用转让列表
     */
    @RequiresPermissions("transfer:transfers:export")
    @Log(title = "专利运用转让", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyPatentlTransfer ryPatentlTransfer) {
        List<RyPatentlTransfer> list = ryPatentlTransferService.selectRyPatentlTransferList(ryPatentlTransfer);
        ExcelUtil<RyPatentlTransfer> util = new ExcelUtil<RyPatentlTransfer>(RyPatentlTransfer.class);
        return util.exportExcel(list, "transfers");
    }

    /**
     * 新增专利运用转让
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存专利运用转让
     */
    @RequiresPermissions("transfer:transfers:add")
    @Log(title = "专利运用转让", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyPatentlTransfer ryPatentlTransfer) {
        String sb = ryPatentlTransfer.getProposalId();
        String[] as = sb.split(",");

        ryPatentlTransfer.setProposalId(as[0]);
        ryPatentlTransfer.setProposalName(as[1]);

        ryPatentlTransferService.insertRyPatentlTransfer(ryPatentlTransfer);
        String tableName = "ry_patentl_transfer";
        int perIds = patCommonService.getNewIdPermit(tableName);
        return toAjaxs(perIds);
    }

    /**
     * 修改专利运用转让
     */
    @GetMapping("/edit/{permitId}")
    public String edit(@PathVariable("permitId") Long permitId, ModelMap mmap) {
        RyPatentlTransfer ryPatentlTransfer = ryPatentlTransferService.selectRyPatentlTransferById(permitId);
        mmap.put("ryPatentlTransfer", ryPatentlTransfer);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利运用转让
     */
    @RequiresPermissions("transfer:transfers:edit")
    @Log(title = "专利运用转让", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyPatentlTransfer ryPatentlTransfer) {
        return toAjax(ryPatentlTransferService.updateRyPatentlTransfer(ryPatentlTransfer));
    }

    /**
     * 删除专利运用转让
     */
    @RequiresPermissions("transfer:transfers:remove")
    @Log(title = "专利运用转让", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ryPatentlTransferService.deleteRyPatentlTransferByIds(ids));
    }
}
