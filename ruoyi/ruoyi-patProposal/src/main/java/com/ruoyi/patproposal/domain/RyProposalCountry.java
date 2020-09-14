package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 国家名称对象 ry_proposal_country
 *
 * @author ruoyi
 * @date 2020-08-19
 */
public class RyProposalCountry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 国家编号 */
    private String countryId;

    /** 国家代码 */
    @Excel(name = "国家代码")
    private String countryCode;

    /** 申请国家  */
    @Excel(name = "申请国家 ")
    private String countryName;

    public void setCountryId(String countryId)
    {
        this.countryId = countryId;
    }

    public String getCountryId()
    {
        return countryId;
    }
    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getCountryCode()
    {
        return countryCode;
    }
    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    public String getCountryName()
    {
        return countryName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("countryId", getCountryId())
                .append("countryCode", getCountryCode())
                .append("countryName", getCountryName())
                .toString();
    }
}