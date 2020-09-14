package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专利相关编码配置对象 ry_proposal_code
 * 
 * @author zhangzhenmin
 * @date 2020-08-13
 */
public class RyProposalCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专利编号配置ID */
    private Long pcId;

    /** 专利编号配置主体 */
    @Excel(name = "专利编号配置主体")
    private String pcBody;

    /** 专利编号配置年份 */
    @Excel(name = "专利编号配置年份")
    private String pcYear;

    /** 规则类型编号 */
    @Excel(name = "规则类型编号")
    private String pcTypeCode;

    /** 规则类型名称 */
    @Excel(name = "规则类型名称")
    private String pcTypeName;

    /** 下一个编号 */
    @Excel(name = "下一个编号")
    private Integer pcNextCode;

    public void setPcId(Long pcId) 
    {
        this.pcId = pcId;
    }

    public Long getPcId() 
    {
        return pcId;
    }
    public void setPcBody(String pcBody) 
    {
        this.pcBody = pcBody;
    }

    public String getPcBody() 
    {
        return pcBody;
    }
    public void setPcYear(String pcYear) 
    {
        this.pcYear = pcYear;
    }

    public String getPcYear() 
    {
        return pcYear;
    }
    public void setPcTypeCode(String pcTypeCode) 
    {
        this.pcTypeCode = pcTypeCode;
    }

    public String getPcTypeCode() 
    {
        return pcTypeCode;
    }
    public void setPcTypeName(String pcTypeName) 
    {
        this.pcTypeName = pcTypeName;
    }

    public String getPcTypeName() 
    {
        return pcTypeName;
    }
    public void setPcNextCode(Integer pcNextCode) 
    {
        this.pcNextCode = pcNextCode;
    }

    public Integer getPcNextCode() 
    {
        return pcNextCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pcId", getPcId())
            .append("pcBody", getPcBody())
            .append("pcYear", getPcYear())
            .append("pcTypeCode", getPcTypeCode())
            .append("pcTypeName", getPcTypeName())
            .append("pcNextCode", getPcNextCode())
            .toString();
    }
}
