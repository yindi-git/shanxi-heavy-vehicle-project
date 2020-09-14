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
import com.ruoyi.co.domain.RyCoAgencyUser;
import com.ruoyi.co.service.IRyCoAgencyUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 代理人信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Controller
@RequestMapping("/co/agencyUser")
public class RyCoAgencyUserController extends BaseController
{
    private String prefix = "/co/agencyUser";

    @Autowired
    private IRyCoAgencyUserService ryCoAgencyUserService;

    @RequiresPermissions("co:agencyUser:view")
    @GetMapping()
    public String agencyUser()
    {
        return prefix + "/agencyUser";
    }

    /**
     * 查询代理人信息列表
     */
    @RequiresPermissions("co:agencyUser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RyCoAgencyUser ryCoAgencyUser)
    {
        startPage();
        List<RyCoAgencyUser> list = ryCoAgencyUserService.selectRyCoAgencyUserList(ryCoAgencyUser);
        return getDataTable(list);
    }

    /**
     * 导出代理人信息列表
     */
    @RequiresPermissions("co:agencyUser:export")
    @Log(title = "代理人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RyCoAgencyUser ryCoAgencyUser)
    {
        List<RyCoAgencyUser> list = ryCoAgencyUserService.selectRyCoAgencyUserList(ryCoAgencyUser);
        ExcelUtil<RyCoAgencyUser> util = new ExcelUtil<RyCoAgencyUser>(RyCoAgencyUser.class);
        return util.exportExcel(list, "agencyUser");
    }

    /**
     * 新增代理人信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存代理人信息
     */
    @RequiresPermissions("co:agencyUser:add")
    @Log(title = "代理人信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RyCoAgencyUser ryCoAgencyUser)
    {
        return toAjax(ryCoAgencyUserService.insertRyCoAgencyUser(ryCoAgencyUser));
    }

    /**
     * 修改代理人信息
     */
    @GetMapping("/edit/{agencyUserId}")
    public String edit(@PathVariable("agencyUserId") Integer agencyUserId, ModelMap mmap)
    {
        RyCoAgencyUser ryCoAgencyUser = ryCoAgencyUserService.selectRyCoAgencyUserById(agencyUserId);
        mmap.put("ryCoAgencyUser", ryCoAgencyUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存代理人信息
     */
    @RequiresPermissions("co:agencyUser:edit")
    @Log(title = "代理人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RyCoAgencyUser ryCoAgencyUser)
    {
        return toAjax(ryCoAgencyUserService.updateRyCoAgencyUser(ryCoAgencyUser));
    }

    /**
     * 删除代理人信息
     */
    @RequiresPermissions("co:agencyUser:remove")
    @Log(title = "代理人信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ryCoAgencyUserService.deleteRyCoAgencyUserByIds(ids));
    }

    @PostMapping( "/selectListByAgencyId")
    @ResponseBody
    public  List<RyCoAgencyUser>  selectListByAgencyId(String agencyid){
        return  ryCoAgencyUserService.selectListByAgencyId(agencyid);
    }
}
