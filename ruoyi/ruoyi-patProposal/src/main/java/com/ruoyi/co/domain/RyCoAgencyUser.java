package com.ruoyi.co.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理人信息对象 ry_co_agency_user
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public class RyCoAgencyUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer agencyUserId;

    /** 代理人编号 */
    @Excel(name = "代理人编号")
    private String agencyUserCode;

    /** 代理人姓名 */
    @Excel(name = "代理人姓名")
    private String agencyUserName;

    /** 所属机构 ID */
    @Excel(name = "所属机构 ID")
    private String agencyId;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String agencyUserTel;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String agencyUserEmail;

    /** 擅长领域 */
    @Excel(name = "擅长领域")
    private String skilledAreas;

    /** 工作年限 */
    @Excel(name = "工作年限")
    private Integer yearsOfWork;

    /** 执业证编码 */
    @Excel(name = "执业证编码")
    private String obtainLicenseCode;

    /** 代理人等级 */
    @Excel(name = "代理人等级")
    private String agencyUserLevel;

    /** 代理人状态  0 正常 1  异常  2-已离职 */
    @Excel(name = "代理人状态  0 正常 1  异常  2-已离职")
    private Integer agencyUserStatus;

    public void setAgencyUserId(Integer agencyUserId) 
    {
        this.agencyUserId = agencyUserId;
    }

    public Integer getAgencyUserId() 
    {
        return agencyUserId;
    }
    public void setAgencyUserCode(String agencyUserCode) 
    {
        this.agencyUserCode = agencyUserCode;
    }

    public String getAgencyUserCode() 
    {
        return agencyUserCode;
    }
    public void setAgencyUserName(String agencyUserName) 
    {
        this.agencyUserName = agencyUserName;
    }

    public String getAgencyUserName() 
    {
        return agencyUserName;
    }
    public void setAgencyId(String agencyId) 
    {
        this.agencyId = agencyId;
    }

    public String getAgencyId() 
    {
        return agencyId;
    }
    public void setAgencyUserTel(String agencyUserTel) 
    {
        this.agencyUserTel = agencyUserTel;
    }

    public String getAgencyUserTel() 
    {
        return agencyUserTel;
    }
    public void setAgencyUserEmail(String agencyUserEmail) 
    {
        this.agencyUserEmail = agencyUserEmail;
    }

    public String getAgencyUserEmail() 
    {
        return agencyUserEmail;
    }
    public void setSkilledAreas(String skilledAreas) 
    {
        this.skilledAreas = skilledAreas;
    }

    public String getSkilledAreas() 
    {
        return skilledAreas;
    }
    public void setYearsOfWork(Integer yearsOfWork) 
    {
        this.yearsOfWork = yearsOfWork;
    }

    public Integer getYearsOfWork() 
    {
        return yearsOfWork;
    }
    public void setObtainLicenseCode(String obtainLicenseCode) 
    {
        this.obtainLicenseCode = obtainLicenseCode;
    }

    public String getObtainLicenseCode() 
    {
        return obtainLicenseCode;
    }
    public void setAgencyUserLevel(String agencyUserLevel) 
    {
        this.agencyUserLevel = agencyUserLevel;
    }

    public String getAgencyUserLevel() 
    {
        return agencyUserLevel;
    }
    public void setAgencyUserStatus(Integer agencyUserStatus) 
    {
        this.agencyUserStatus = agencyUserStatus;
    }

    public Integer getAgencyUserStatus() 
    {
        return agencyUserStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("agencyUserId", getAgencyUserId())
            .append("agencyUserCode", getAgencyUserCode())
            .append("agencyUserName", getAgencyUserName())
            .append("agencyId", getAgencyId())
            .append("agencyUserTel", getAgencyUserTel())
            .append("agencyUserEmail", getAgencyUserEmail())
            .append("skilledAreas", getSkilledAreas())
            .append("yearsOfWork", getYearsOfWork())
            .append("obtainLicenseCode", getObtainLicenseCode())
            .append("agencyUserLevel", getAgencyUserLevel())
            .append("agencyUserStatus", getAgencyUserStatus())
            .toString();
    }
}
