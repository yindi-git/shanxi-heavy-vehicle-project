package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专利类型信息对象 ry_proposal_type
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public class RyProposalType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String typeId;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 专利号对应编号 */
    @Excel(name = "专利号对应编号")
    private String typeNumForProposal;

    /** 保护对象 */
    @Excel(name = "保护对象")
    private String protectionObject;

    public void setTypeId(String typeId) 
    {
        this.typeId = typeId;
    }

    public String getTypeId() 
    {
        return typeId;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setTypeNumForProposal(String typeNumForProposal) 
    {
        this.typeNumForProposal = typeNumForProposal;
    }

    public String getTypeNumForProposal() 
    {
        return typeNumForProposal;
    }
    public void setProtectionObject(String protectionObject) 
    {
        this.protectionObject = protectionObject;
    }

    public String getProtectionObject() 
    {
        return protectionObject;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeId", getTypeId())
            .append("typeName", getTypeName())
            .append("typeNumForProposal", getTypeNumForProposal())
            .append("protectionObject", getProtectionObject())
            .toString();
    }
}
