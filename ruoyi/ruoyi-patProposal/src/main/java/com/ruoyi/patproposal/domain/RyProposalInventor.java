package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ry_proposal_inventor
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public class RyProposalInventor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String inventorId;

    /** 发明人id */
    @Excel(name = "发明人id")
    private String userId;

    /** 贡献度 */
    @Excel(name = "贡献度")
    private Double contribution;

    public void setInventorId(String inventorId) 
    {
        this.inventorId = inventorId;
    }

    public String getInventorId() 
    {
        return inventorId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setContribution(Double contribution) 
    {
        this.contribution = contribution;
    }

    public Double getContribution() 
    {
        return contribution;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inventorId", getInventorId())
            .append("userId", getUserId())
            .append("contribution", getContribution())
            .toString();
    }
}
