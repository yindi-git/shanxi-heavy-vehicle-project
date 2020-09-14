package com.ruoyi.co.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理机构信息对象 ry_co_agency
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public class RyCoAgency extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Integer agencyId;

    /** 代理机构名称 */
    @Excel(name = "代理机构名称")
    private String agencyName;

    /** 代理机构编号 */
    @Excel(name = "代理机构编号")
    private String agencyNo;

    /** 代理机构编码 */
    @Excel(name = "代理机构编码")
    private String agencycode;

    /** 负责人ID */
    @Excel(name = "负责人ID")
    private String responsibleUserId;

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String responsibleUser;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String agencyTel;

    /** 办公地址 */
    @Excel(name = "办公地址")
    private String agencyAddress;

    /** 从业人数 */
    @Excel(name = "从业人数")
    private Integer numberOfAgency;

    /** 执业证件  附件 */
    @Excel(name = "执业证件  附件")
    private String businessLicense;

    /** 执业证件 附件 */
    @Excel(name = "执业证件 附件")
    private String practiceCertificate;

    /** 成立时间 */
    @Excel(name = "成立时间")
    private String foundedTime;

    /** 机构评级 */
    @Excel(name = "机构评级")
    private String agencyLevel;

    /** 机构状态  0 正常合作 1  停止合作    2-已撤销 */
    @Excel(name = "机构状态  0 正常合作 1  停止合作    2-已撤销")
    private Integer agencyStatus;

    public void setAgencyId(Integer agencyId) 
    {
        this.agencyId = agencyId;
    }

    public Integer getAgencyId() 
    {
        return agencyId;
    }
    public void setAgencyName(String agencyName) 
    {
        this.agencyName = agencyName;
    }

    public String getAgencyName() 
    {
        return agencyName;
    }
    public void setAgencyNo(String agencyNo) 
    {
        this.agencyNo = agencyNo;
    }

    public String getAgencyNo() 
    {
        return agencyNo;
    }
    public void setAgencycode(String agencycode) 
    {
        this.agencycode = agencycode;
    }

    public String getAgencycode() 
    {
        return agencycode;
    }
    public void setResponsibleUserId(String responsibleUserId) 
    {
        this.responsibleUserId = responsibleUserId;
    }

    public String getResponsibleUserId() 
    {
        return responsibleUserId;
    }
    public void setResponsibleUser(String responsibleUser) 
    {
        this.responsibleUser = responsibleUser;
    }

    public String getResponsibleUser() 
    {
        return responsibleUser;
    }
    public void setAgencyTel(String agencyTel) 
    {
        this.agencyTel = agencyTel;
    }

    public String getAgencyTel() 
    {
        return agencyTel;
    }
    public void setAgencyAddress(String agencyAddress) 
    {
        this.agencyAddress = agencyAddress;
    }

    public String getAgencyAddress() 
    {
        return agencyAddress;
    }
    public void setNumberOfAgency(Integer numberOfAgency) 
    {
        this.numberOfAgency = numberOfAgency;
    }

    public Integer getNumberOfAgency() 
    {
        return numberOfAgency;
    }
    public void setBusinessLicense(String businessLicense) 
    {
        this.businessLicense = businessLicense;
    }

    public String getBusinessLicense() 
    {
        return businessLicense;
    }
    public void setPracticeCertificate(String practiceCertificate) 
    {
        this.practiceCertificate = practiceCertificate;
    }

    public String getPracticeCertificate() 
    {
        return practiceCertificate;
    }
    public void setFoundedTime(String foundedTime) 
    {
        this.foundedTime = foundedTime;
    }

    public String getFoundedTime() 
    {
        return foundedTime;
    }
    public void setAgencyLevel(String agencyLevel) 
    {
        this.agencyLevel = agencyLevel;
    }

    public String getAgencyLevel() 
    {
        return agencyLevel;
    }
    public void setAgencyStatus(Integer agencyStatus) 
    {
        this.agencyStatus = agencyStatus;
    }

    public Integer getAgencyStatus() 
    {
        return agencyStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("agencyId", getAgencyId())
            .append("agencyName", getAgencyName())
            .append("agencyNo", getAgencyNo())
            .append("agencycode", getAgencycode())
            .append("responsibleUserId", getResponsibleUserId())
            .append("responsibleUser", getResponsibleUser())
            .append("agencyTel", getAgencyTel())
            .append("agencyAddress", getAgencyAddress())
            .append("numberOfAgency", getNumberOfAgency())
            .append("businessLicense", getBusinessLicense())
            .append("practiceCertificate", getPracticeCertificate())
            .append("foundedTime", getFoundedTime())
            .append("agencyLevel", getAgencyLevel())
            .append("agencyStatus", getAgencyStatus())
            .toString();
    }
}
