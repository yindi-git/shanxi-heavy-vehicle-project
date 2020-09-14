package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ry_proposal_technical
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public class RyProposalTechnical extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String technicalId;

    /** 技术领域描述 */
    @Excel(name = "技术领域描述")
    private String technicalDesc;

    public void setTechnicalId(String technicalId) 
    {
        this.technicalId = technicalId;
    }

    public String getTechnicalId() 
    {
        return technicalId;
    }
    public void setTechnicalDesc(String technicalDesc) 
    {
        this.technicalDesc = technicalDesc;
    }

    public String getTechnicalDesc() 
    {
        return technicalDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("technicalId", getTechnicalId())
            .append("technicalDesc", getTechnicalDesc())
            .toString();
    }
}
