package com.ruoyi.web.controller.system;

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
import com.ruoyi.patproposal.domain.RyProposalProject;
import com.ruoyi.patproposal.service.IRyProposalProjectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目名称Controller
 * 
 * @author ZhenMinZhang
 * @date 2020-09-09
 */
@Controller
@RequestMapping("/system/project")
public class RyProposalProjectController extends BaseController
{
    private String prefix = "system/project";

    @Autowired
    private IRyProposalProjectService ryProposalProjectService;

    @RequiresPermissions("system:project:view")
    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }

    /**
     * 查询项目名称列表
     */
    @RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyProposalProject ryProposalProject)
    {
        startPage();
        List<RyProposalProject> list = ryProposalProjectService.selectRyProposalProjectList(ryProposalProject);
        return getDataTable(list);
    }

    /**
     * 导出项目名称列表
     */
    @RequiresPermissions("system:project:export")
    @Log(title = "项目名称", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyProposalProject ryProposalProject)
    {
        List<RyProposalProject> list = ryProposalProjectService.selectRyProposalProjectList(ryProposalProject);
        ExcelUtil<RyProposalProject> util = new ExcelUtil<RyProposalProject>(RyProposalProject.class);
        return util.exportExcel(list, "project");
    }

    /**
     * 新增项目名称
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目名称
     */
    @RequiresPermissions("system:project:add")
    @Log(title = "项目名称", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyProposalProject ryProposalProject)
    {
        return toAjax(ryProposalProjectService.insertRyProposalProject(ryProposalProject));
    }

    /**
     * 修改项目名称
     */
    @GetMapping("/edit/{projectId}")
    public String edit(@PathVariable("projectId") String projectId, ModelMap mmap)
    {
        RyProposalProject ryProposalProject = ryProposalProjectService.selectRyProposalProjectById(projectId);
        mmap.put("ryProposalProject", ryProposalProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目名称
     */
    @RequiresPermissions("system:project:edit")
    @Log(title = "项目名称", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyProposalProject ryProposalProject)
    {
        return toAjax(ryProposalProjectService.updateRyProposalProject(ryProposalProject));
    }

    /**
     * 删除项目名称
     */
    @RequiresPermissions("system:project:remove")
    @Log(title = "项目名称", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryProposalProjectService.deleteRyProposalProjectByIds(ids));
    }
}
