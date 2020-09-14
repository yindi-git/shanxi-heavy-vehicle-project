package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专利提案附件 专利提案附件对象 ry_proposal_attach
 * 
 * @author 神州数码
 * @date 2020-08-18
 */
public class ProposalAttach extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 附件编号 */
    private Long attachId;

    /** 附件名称 附件名称 */
    @Excel(name = "附件名称 附件名称")
    private String accachtName;

    /** 专利提案编号 专利提案编号 */
    @Excel(name = "专利提案编号 专利提案编号")
    private String proposalId;

    /** 附件存储路径 附件存储路径 */
    @Excel(name = "附件存储路径 附件存储路径")
    private String attachPath;

    /** 附件类型 附件类型(1技术交底附件,2附图) */
    @Excel(name = "附件类型 附件类型(1技术交底附件,2附图)")
    private Long attachType;

    /** 附件后缀类型 附件后缀类型 */
    @Excel(name = "附件后缀类型 附件后缀类型")
    private String suffixType;

    public void setAttachId(Long attachId) 
    {
        this.attachId = attachId;
    }

    public Long getAttachId() 
    {
        return attachId;
    }
    public void setAccachtName(String accachtName) 
    {
        this.accachtName = accachtName;
    }

    public String getAccachtName() 
    {
        return accachtName;
    }
    public void setProposalId(String proposalId) 
    {
        this.proposalId = proposalId;
    }

    public String getProposalId() 
    {
        return proposalId;
    }
    public void setAttachPath(String attachPath) 
    {
        this.attachPath = attachPath;
    }

    public String getAttachPath() 
    {
        return attachPath;
    }
    public void setAttachType(Long attachType) 
    {
        this.attachType = attachType;
    }

    public Long getAttachType() 
    {
        return attachType;
    }
    public void setSuffixType(String suffixType) 
    {
        this.suffixType = suffixType;
    }

    public String getSuffixType() 
    {
        return suffixType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attachId", getAttachId())
            .append("accachtName", getAccachtName())
            .append("proposalId", getProposalId())
            .append("attachPath", getAttachPath())
            .append("attachType", getAttachType())
            .append("suffixType", getSuffixType())
            .toString();
    }
}
