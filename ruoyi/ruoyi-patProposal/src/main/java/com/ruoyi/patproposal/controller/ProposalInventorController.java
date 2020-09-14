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
import com.ruoyi.patproposal.domain.ProposalInventor;
import com.ruoyi.patproposal.service.IProposalInventorService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 发明人Controller
 * 
 * @author 神州数码
 * @date 2020-08-14
 */
@Controller
@RequestMapping("/patproposal/inventor")
public class ProposalInventorController extends BaseController
{
    private String prefix = "patproposal/inventor";

    @Autowired
    private IProposalInventorService proposalInventorService;

    @RequiresPermissions("patproposal:inventor:view")
    @GetMapping()
    public String inventor()
    {
        return prefix + "/inventor";
    }

    /**
     * 查询发明人列表
     */
    @RequiresPermissions("patproposal:inventor:listAll")
    @PostMapping("/listAll")
    @ResponseBody
    public List<ProposalInventor> list(String proposalId)
    {
        ProposalInventor proposalInventor=new ProposalInventor();
        proposalInventor.setProposalId(proposalId);
        List<ProposalInventor> list = proposalInventorService.selectProposalInventorList(proposalInventor);
        return list;
    }

    /**
     * 查询发明人列表
     */
    @RequiresPermissions("patproposal:inventor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProposalInventor proposalInventor)
    {
        startPage();
        List<ProposalInventor> list = proposalInventorService.selectProposalInventorList(proposalInventor);
        return getDataTable(list);
    }

    /**
     * 导出发明人列表
     */
    @RequiresPermissions("patproposal:inventor:export")
    @Log(title = "发明人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProposalInventor proposalInventor)
    {
        List<ProposalInventor> list = proposalInventorService.selectProposalInventorList(proposalInventor);
        ExcelUtil<ProposalInventor> util = new ExcelUtil<ProposalInventor>(ProposalInventor.class);
        return util.exportExcel(list, "inventor");
    }

    /**
     * 新增发明人
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存发明人
     */
    @RequiresPermissions("patproposal:inventor:add")
    @Log(title = "发明人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProposalInventor proposalInventor)
    {
        proposalInventor.setInventorId(String.valueOf(System.currentTimeMillis()));
        return toAjax(proposalInventorService.insertProposalInventor(proposalInventor));
    }

    /**
     * 修改发明人
     */
    @GetMapping("/edit/{inventorId}")
    public String edit(@PathVariable("inventorId") String inventorId, ModelMap mmap)
    {
        ProposalInventor proposalInventor = proposalInventorService.selectProposalInventorById(inventorId);
        mmap.put("proposalInventor", proposalInventor);
        return prefix + "/edit";
    }

    /**
     * 修改保存发明人
     */
    @RequiresPermissions("patproposal:inventor:edit")
    @Log(title = "发明人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProposalInventor proposalInventor)
    {
        return toAjax(proposalInventorService.updateProposalInventor(proposalInventor));
    }

    /**
     * 删除发明人
     */
    @RequiresPermissions("patproposal:inventor:remove")
    @Log(title = "发明人", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proposalInventorService.deleteProposalInventorByIds(ids));
    }
}
