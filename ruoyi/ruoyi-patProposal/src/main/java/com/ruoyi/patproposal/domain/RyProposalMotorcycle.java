package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ry_proposal_motorcycle
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public class RyProposalMotorcycle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 汽车表id */
    private String motorcycleId;

    /** 汽车类型 */
    @Excel(name = "汽车类型")
    private String motorcycleType;

    public void setMotorcycleId(String motorcycleId) 
    {
        this.motorcycleId = motorcycleId;
    }

    public String getMotorcycleId() 
    {
        return motorcycleId;
    }
    public void setMotorcycleType(String motorcycleType) 
    {
        this.motorcycleType = motorcycleType;
    }

    public String getMotorcycleType() 
    {
        return motorcycleType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("motorcycleId", getMotorcycleId())
            .append("motorcycleType", getMotorcycleType())
            .toString();
    }
}
