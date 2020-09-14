package com.ruoyi.co.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 货币种类信息对象 ry_co_currency_type
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public class RyCoCurrencyType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 币种编号 */
    private Integer currencyTypeId;

    /** 数字代码 */
    @Excel(name = "数字代码")
    private Integer numberCode;

    /** 币种 */
    @Excel(name = "币种")
    private String currencyType;

    /** 汇率 */
    @Excel(name = "汇率")
    private String exchangeRate;

    /** 货币代码 */
    @Excel(name = "货币代码")
    private String currencyTypeCode;

    /** 国家/地区/组织 */
    @Excel(name = "国家/地区/组织")
    private String organization;

    public void setCurrencyTypeId(Integer currencyTypeId) 
    {
        this.currencyTypeId = currencyTypeId;
    }

    public Integer getCurrencyTypeId() 
    {
        return currencyTypeId;
    }
    public void setNumberCode(Integer numberCode) 
    {
        this.numberCode = numberCode;
    }

    public Integer getNumberCode() 
    {
        return numberCode;
    }
    public void setCurrencyType(String currencyType) 
    {
        this.currencyType = currencyType;
    }

    public String getCurrencyType() 
    {
        return currencyType;
    }
    public void setExchangeRate(String exchangeRate) 
    {
        this.exchangeRate = exchangeRate;
    }

    public String getExchangeRate() 
    {
        return exchangeRate;
    }
    public void setCurrencyTypeCode(String currencyTypeCode) 
    {
        this.currencyTypeCode = currencyTypeCode;
    }

    public String getCurrencyTypeCode() 
    {
        return currencyTypeCode;
    }
    public void setOrganization(String organization) 
    {
        this.organization = organization;
    }

    public String getOrganization() 
    {
        return organization;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("currencyTypeId", getCurrencyTypeId())
            .append("numberCode", getNumberCode())
            .append("currencyType", getCurrencyType())
            .append("exchangeRate", getExchangeRate())
            .append("currencyTypeCode", getCurrencyTypeCode())
            .append("organization", getOrganization())
            .toString();
    }
}
