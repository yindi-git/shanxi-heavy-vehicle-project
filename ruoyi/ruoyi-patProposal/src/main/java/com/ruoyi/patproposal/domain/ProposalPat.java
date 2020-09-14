package com.ruoyi.patproposal.domain;

import com.ruoyi.activiti.domain.BizTodoItem;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.util.List;

/**
 * 专利提案相关对象 ry_proposal_pat
 *
 * @author 神州数码
 * @date 2020-08-13
 */
public class ProposalPat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专利提案编号 */
    @Excel(name = "专利提案编号")
    private String proposalId;

    /** 申请专利名称 */
    @Excel(name = "申请专利名称")
    private String proposalName;

    /** 职务发明(0是,1否,默认0) */
    @Excel(name = "职务发明(0是,1否,默认0)")
    private String employeeInvention;

    /** 申请人id */
    @Excel(name = "申请人id")
    private String applicantId;

    /** 提报单位id */
    @Excel(name = "提报单位id")
    private String applyDeptId;

    /** 专利类型id */
    @Excel(name = "专利类型id")
    private String typeId;

    /** 重要度 */
    @Excel(name = "重要度")
    private String importanceId;

    /** 提案日期 */
    @Excel(name = "提案日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date launchTime;

    /** 所属研发项目id */
    @Excel(name = "所属研发项目id")
    private String projectId;

    /** 车型id */
    @Excel(name = "车型id")
    private String motorcycleId;

    /** 申请国家id */
    @Excel(name = "申请国家id")
    private String countryId;

    /** 技术领域id */
    @Excel(name = "技术领域id")
    private String technicalId;

    /** 提前公开(0是,1否,仅发明类型) */
    @Excel(name = "提前公开(0是,1否,仅发明类型)")
    private String isOpen;

    /** 快速预审是否预审(0是,1否) */
    @Excel(name = "快速预审是否预审(0是,1否)")
    private String isPreliminary;

    /** 背景技术 */
    @Excel(name = "背景技术")
    private String backTech;

    /** 内容概要 */
    @Excel(name = "内容概要")
    private String contentSummary;

    /** 联系人id */
    @Excel(name = "联系人id")
    private String contactsId;

    /** 状态 */
    @Excel(name = "状态")
    private String proposalStatus;

    /** 流程id */
    @Excel(name = "流程id")
    private String instanceId;

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /** 是否删除 */
    @Excel(name = "流程is_delete")
    private  String isDelete;


    public BizTodoItem getBizTodoItem() {
        return bizTodoItem;
    }

    public void setBizTodoItem(BizTodoItem bizTodoItem) {
        this.bizTodoItem = bizTodoItem;
    }

    private BizTodoItem bizTodoItem;
    private ActHiomment actHiomment;

    public ActHiomment getActHiomment() {
        return actHiomment;
    }

    public void setActHiomment(ActHiomment actHiomment) {
        this.actHiomment = actHiomment;
    }




    public ProposalComment getProposalComment() {
        return proposalComment;
    }

    public void setProposalComment(ProposalComment proposalComment) {
        this.proposalComment = proposalComment;
    }

    private  ProposalComment proposalComment;




    public void setProposalId(String proposalId)
    {
        this.proposalId = proposalId;
    }

    public String getProposalId()
    {
        return proposalId;
    }
    public void setProposalName(String proposalName)
    {
        this.proposalName = proposalName;
    }

    public String getProposalName()
    {
        return proposalName;
    }
    public void setEmployeeInvention(String employeeInvention)
    {
        this.employeeInvention = employeeInvention;
    }

    public String getEmployeeInvention()
    {
        return employeeInvention;
    }
    public void setApplicantId(String applicantId)
    {
        this.applicantId = applicantId;
    }

    public String getApplicantId()
    {
        return applicantId;
    }
    public void setApplyDeptId(String applyDeptId)
    {
        this.applyDeptId = applyDeptId;
    }

    public String getApplyDeptId()
    {
        return applyDeptId;
    }
    public void setTypeId(String typeId)
    {
        this.typeId = typeId;
    }

    public String getTypeId()
    {
        return typeId;
    }
    public void setImportanceId(String importanceId)
    {
        this.importanceId = importanceId;
    }

    public String getImportanceId()
    {
        return importanceId;
    }
    public void setLaunchTime(Date launchTime)
    {
        this.launchTime = launchTime;
    }

    public Date getLaunchTime()
    {
        return launchTime;
    }
    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public String getProjectId()
    {
        return projectId;
    }
    public void setMotorcycleId(String motorcycleId)
    {
        this.motorcycleId = motorcycleId;
    }

    public String getMotorcycleId()
    {
        return motorcycleId;
    }
    public void setCountryId(String countryId)
    {
        this.countryId = countryId;
    }

    public String getCountryId()
    {
        return countryId;
    }
    public void setTechnicalId(String technicalId)
    {
        this.technicalId = technicalId;
    }

    public String getTechnicalId()
    {
        return technicalId;
    }
    public void setIsOpen(String isOpen)
    {
        this.isOpen = isOpen;
    }

    public String getIsOpen()
    {
        return isOpen;
    }
    public void setIsPreliminary(String isPreliminary)
    {
        this.isPreliminary = isPreliminary;
    }

    public String getIsPreliminary()
    {
        return isPreliminary;
    }
    public void setBackTech(String backTech)
    {
        this.backTech = backTech;
    }

    public String getBackTech()
    {
        return backTech;
    }
    public void setContentSummary(String contentSummary)
    {
        this.contentSummary = contentSummary;
    }

    public String getContentSummary()
    {
        return contentSummary;
    }
    public void setContactsId(String contactsId)
    {
        this.contactsId = contactsId;
    }

    public String getContactsId()
    {
        return contactsId;
    }
    public void setProposalStatus(String proposalStatus)
    {
        this.proposalStatus = proposalStatus;
    }

    public String getProposalStatus()
    {
        return proposalStatus;
    }
    public void setInstanceId(String instanceId)
    {
        this.instanceId = instanceId;
    }

    public String getInstanceId()
    {
        return instanceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("proposalId", getProposalId())
                .append("proposalName", getProposalName())
                .append("employeeInvention", getEmployeeInvention())
                .append("applicantId", getApplicantId())
                .append("applyDeptId", getApplyDeptId())
                .append("typeId", getTypeId())
                .append("importanceId", getImportanceId())
                .append("launchTime", getLaunchTime())
                .append("projectId", getProjectId())
                .append("motorcycleId", getMotorcycleId())
                .append("countryId", getCountryId())
                .append("technicalId", getTechnicalId())
                .append("isOpen", getIsOpen())
                .append("isPreliminary", getIsPreliminary())
                .append("backTech", getBackTech())
                .append("contentSummary", getContentSummary())
                .append("contactsId", getContactsId())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("proposalStatus", getProposalStatus())
                .append("instanceId", getInstanceId())
                .append("bizTodoItem", getBizTodoItem())
                .append("isDelete", getIsDelete())
                .append("proposalComment", getProposalComment())
                .append("actHiomment", getActHiomment())
                .toString();
    }
}