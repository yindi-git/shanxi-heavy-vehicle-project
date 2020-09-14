package com.ruoyi.utiliza.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 专利运用受让对象 ry_patentl_assignment
 * 
 * @author wxb
 * @date 2020-09-04
 */
public class RyPatentlAssignment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专利许可ID */
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

    /** 提报单位id 提报单位id */
    @Excel(name = "提报单位id 提报单位id")
    private String applyDeptId;

    /** 专利类型id 专利类型id */
    @Excel(name = "专利类型id 专利类型id")
    private String typeId;

    /** 签约时间 */
    @Excel(name = "签约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signupTime;

    /** 生效时间 */
    @Excel(name = "生效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date takeTime;

    /** 资产估值 */
    @Excel(name = "资产估值")
    private String assetValuation;

    /** 评估机构 */
    @Excel(name = "评估机构")
    private String evaluationAgency;

    /** 专利权人 */
    @Excel(name = "专利权人")
    private String patentee;

    /** 组织机构 */
    @Excel(name = "组织机构")
    private String organization;

    /** 0是删除，1是正常 */
    @Excel(name = "0是删除，1是正常")
    private Long isDelete;

    /** 专利受让公司 */
    @Excel(name = "专利受让公司")
    private String patentPermitCompany;

    /** 专利受让公司法人 */
    @Excel(name = "专利受让公司法人")
    private String patentPermitLegal;

    /** 专利受让公司介绍 */
    @Excel(name = "专利受让公司介绍")
    private String patentPermitIntroduce;

    /** 专利受让公司备案费用 */
    @Excel(name = "专利受让公司备案费用")
    private Long patentPermitKeeppay;

    /** 专利受让公司代理费用 */
    @Excel(name = "专利受让公司代理费用")
    private Long patentPermitAgentpay;

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
    public void setSignupTime(Date signupTime) 
    {
        this.signupTime = signupTime;
    }

    public Date getSignupTime() 
    {
        return signupTime;
    }
    public void setTakeTime(Date takeTime) 
    {
        this.takeTime = takeTime;
    }

    public Date getTakeTime() 
    {
        return takeTime;
    }
    public void setAssetValuation(String assetValuation) 
    {
        this.assetValuation = assetValuation;
    }

    public String getAssetValuation() 
    {
        return assetValuation;
    }
    public void setEvaluationAgency(String evaluationAgency) 
    {
        this.evaluationAgency = evaluationAgency;
    }

    public String getEvaluationAgency() 
    {
        return evaluationAgency;
    }
    public void setPatentee(String patentee) 
    {
        this.patentee = patentee;
    }

    public String getPatentee() 
    {
        return patentee;
    }
    public void setOrganization(String organization) 
    {
        this.organization = organization;
    }

    public String getOrganization() 
    {
        return organization;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }
    public void setPatentPermitCompany(String patentPermitCompany) 
    {
        this.patentPermitCompany = patentPermitCompany;
    }

    public String getPatentPermitCompany() 
    {
        return patentPermitCompany;
    }
    public void setPatentPermitLegal(String patentPermitLegal) 
    {
        this.patentPermitLegal = patentPermitLegal;
    }

    public String getPatentPermitLegal() 
    {
        return patentPermitLegal;
    }
    public void setPatentPermitIntroduce(String patentPermitIntroduce) 
    {
        this.patentPermitIntroduce = patentPermitIntroduce;
    }

    public String getPatentPermitIntroduce() 
    {
        return patentPermitIntroduce;
    }
    public void setPatentPermitKeeppay(Long patentPermitKeeppay) 
    {
        this.patentPermitKeeppay = patentPermitKeeppay;
    }

    public Long getPatentPermitKeeppay() 
    {
        return patentPermitKeeppay;
    }
    public void setPatentPermitAgentpay(Long patentPermitAgentpay) 
    {
        this.patentPermitAgentpay = patentPermitAgentpay;
    }

    public Long getPatentPermitAgentpay() 
    {
        return patentPermitAgentpay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("permitId", getPermitId())
            .append("proposalId", getProposalId())
            .append("proposalName", getProposalName())
            .append("employeeInvention", getEmployeeInvention())
            .append("applicantId", getApplicantId())
            .append("applyDeptId", getApplyDeptId())
            .append("typeId", getTypeId())
            .append("signupTime", getSignupTime())
            .append("takeTime", getTakeTime())
            .append("assetValuation", getAssetValuation())
            .append("evaluationAgency", getEvaluationAgency())
            .append("patentee", getPatentee())
            .append("organization", getOrganization())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("isDelete", getIsDelete())
            .append("patentPermitCompany", getPatentPermitCompany())
            .append("patentPermitLegal", getPatentPermitLegal())
            .append("patentPermitIntroduce", getPatentPermitIntroduce())
            .append("patentPermitKeeppay", getPatentPermitKeeppay())
            .append("patentPermitAgentpay", getPatentPermitAgentpay())
            .toString();
    }
}
