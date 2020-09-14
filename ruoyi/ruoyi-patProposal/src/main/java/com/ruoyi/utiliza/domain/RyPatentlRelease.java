package com.ruoyi.utiliza.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专利运用解押对象 ry_patentl_release
 * 
 * @author wxb
 * @date 2020-09-08
 */
public class RyPatentlRelease extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专利质押ID */
    private Long permitId;

    /** 专利提案编号 专利提案编号 */
    @Excel(name = "专利提案编号 专利提案编号")
    private String proposalId;

    /** 专利提案名称 申请专利名称 */
    @Excel(name = "专利提案名称 申请专利名称")
    private String proposalName;

    /** 职务发明(0是,1否,默认0) 职务发明(0是,1否,默认0) */
    @Excel(name = "职务发明(0是,1否,默认0) 职务发明(0是,1否,默认0)")
    private String employeeInvention;

    /** 申请人id */
    @Excel(name = "申请人id")
    private String applicantId;

    /** 专利权人 */
    @Excel(name = "专利权人")
    private String patentee;

    /** 解押原因 */
    @Excel(name = "解押原因")
    private String reason;

    /** 0是删除，1是正常 */
    @Excel(name = "0是删除，1是正常")
    private Long isDelete;

    public void setPermitId(Long permitId) 
    {
        this.permitId = permitId;
    }

    public Long getPermitId() 
    {
        return permitId;
    }
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
    public void setPatentee(String patentee) 
    {
        this.patentee = patentee;
    }

    public String getPatentee() 
    {
        return patentee;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("permitId", getPermitId())
            .append("proposalId", getProposalId())
            .append("proposalName", getProposalName())
            .append("employeeInvention", getEmployeeInvention())
            .append("applicantId", getApplicantId())
            .append("patentee", getPatentee())
            .append("reason", getReason())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
