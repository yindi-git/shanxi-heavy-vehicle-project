package com.ruoyi.patproposal.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.patproposal.domain.ProposalAttach;
import com.ruoyi.patproposal.service.IProposalAttachService;

/**
 * 专利提案附件 专利提案附件Controller
 * 
 * @author 神州数码
 * @date 2020-08-18
 */
@Controller
@RequestMapping("/patproposal/attach")
public class ProposalAttachController extends BaseController {
    private String prefix = "patproposal/attach";

    @Autowired
    private IProposalAttachService proposalAttachService;

    @RequiresPermissions("patproposal:attach:view")
    @GetMapping()
    public String attach() {
        return prefix + "/attach";
    }

    @Log(title = "附件上传", businessType = BusinessType.INSERT)
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult upload(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) {
        try {
            String proposalId = request.getParameter("proposalId");
            String attachType = request.getParameter("attachType");

            List<MultipartFile> files = multipartRequest.getFiles("filePath");
            List<MultipartFile> files1 = multipartRequest.getFiles("filePath1");
            List<MultipartFile> files2 = multipartRequest.getFiles("filePath2");
            List<MultipartFile> files3 = multipartRequest.getFiles("filePath3");
            List<MultipartFile> files4 = multipartRequest.getFiles("filePath4");
            List<MultipartFile> files5 = multipartRequest.getFiles("filePath5");
           //调用上传文件方法
            saveUpuplodFile(files, proposalId, attachType);
            saveUpuplodFile(files1, proposalId, attachType);
            saveUpuplodFile(files2, proposalId, attachType);
            saveUpuplodFile(files3, proposalId, attachType);
            saveUpuplodFile(files4, proposalId, attachType);
            saveUpuplodFile(files5, proposalId, attachType);

            return null;
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 文件上传提前公共方法
     * @param files
     * @param proposalId
     * @param attachType
     * @throws Exception
     */
    public void saveUpuplodFile(List<MultipartFile> files, String proposalId, String attachType) throws Exception {
        if (files.size() > 0) {
            for (int i = 0; i < files.size(); i++) {
                MultipartFile file = files.get(i);
                if (!file.isEmpty()) {
                    //获取文件后缀
                    String extensionName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.') + 1);
                    String fileName = FileUploadUtils.upload(Global.getProfile() + "/" +attachType+ proposalId + "/pic/", file);
                    ProposalAttach proposalAttach = new ProposalAttach();
                    proposalAttach.setAccachtName(file.getOriginalFilename());
                    proposalAttach.setSuffixType(extensionName);
                    proposalAttach.setProposalId(proposalId);
                    proposalAttach.setAttachType(Long.valueOf(attachType));
                    proposalAttach.setAttachPath(fileName);
                    proposalAttachService.insertProposalAttach(proposalAttach);
                }

            }
        }
    }


    /**
     * 获取所有专利附件列表
     * 
     * @return
     */
    @GetMapping("/getattach")
    @ResponseBody
    public AjaxResult getattach(String proposalId,String  uploadType) {
        if(uploadType==null || uploadType==""){
            uploadType="1";
        }
        List<Map> list = proposalAttachService.getProposalAttachList(proposalId,uploadType);
        return AjaxResult.success("0", list);
    }

    /**
     * 查询专利提案附件 专利提案附件列表
     */
    @RequiresPermissions("patproposal:attach:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProposalAttach proposalAttach) {
        startPage();
        List<ProposalAttach> list = proposalAttachService.selectProposalAttachList(proposalAttach);
        return getDataTable(list);
    }

    /**
     * 导出专利提案附件 专利提案附件列表
     */
    @RequiresPermissions("patproposal:attach:export")
    @Log(title = "专利提案附件 专利提案附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProposalAttach proposalAttach) {
        List<ProposalAttach> list = proposalAttachService.selectProposalAttachList(proposalAttach);
        ExcelUtil<ProposalAttach> util = new ExcelUtil<ProposalAttach>(ProposalAttach.class);
        return util.exportExcel(list, "attach");
    }

    /**
     * 新增专利提案附件 专利提案附件
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存专利提案附件 专利提案附件
     */
    @RequiresPermissions("patproposal:attach:add")
    @Log(title = "专利提案附件 专利提案附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProposalAttach proposalAttach) {
        return toAjax(proposalAttachService.insertProposalAttach(proposalAttach));
    }

    /**
     * 修改专利提案附件 专利提案附件
     */
    @GetMapping("/edit/{attachId}")
    public String edit(@PathVariable("attachId") Long attachId, ModelMap mmap) {
        ProposalAttach proposalAttach = proposalAttachService.selectProposalAttachById(attachId);
        mmap.put("proposalAttach", proposalAttach);
        return prefix + "/edit";
    }

    /**
     * 修改保存专利提案附件 专利提案附件
     */
    @RequiresPermissions("patproposal:attach:edit")
    @Log(title = "专利提案附件 专利提案附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProposalAttach proposalAttach) {
        return toAjax(proposalAttachService.updateProposalAttach(proposalAttach));
    }

    /**
     * 删除专利提案附件 专利提案附件
     */
    @RequiresPermissions("patproposal:attach:remove")
    @Log(title = "专利提案附件 专利提案附件", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(proposalAttachService.deleteProposalAttachByIds(ids));
    }
}
