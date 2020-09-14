package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ry_proposal_applicant
 * 
 * @author ruoyi
 * @date 2020-08-28
 */
public class RyProposalApplicant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long applicantId;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String applicantName;

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String applicantAddr;

    /** 单位编码 */
    @Excel(name = "单位编码")
    private String applicantCode;

    public void setApplicantId(Long applicantId) 
    {
        this.applicantId = applicantId;
    }

    public Long getApplicantId() 
    {
        return applicantId;
    }
    public void setApplicantName(String applicantName) 
    {
        this.applicantName = applicantName;
    }

    public String getApplicantName() 
    {
        return applicantName;
    }
    public void setApplicantAddr(String applicantAddr) 
    {
        this.applicantAddr = applicantAddr;
    }

    public String getApplicantAddr() 
    {
        return applicantAddr;
    }
    public void setApplicantCode(String applicantCode) 
    {
        this.applicantCode = applicantCode;
    }

    public String getApplicantCode() 
    {
        return applicantCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applicantId", getApplicantId())
            .append("applicantName", getApplicantName())
            .append("applicantAddr", getApplicantAddr())
            .append("applicantCode", getApplicantCode())
            .toString();
    }
}
