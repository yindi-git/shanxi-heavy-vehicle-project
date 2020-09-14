package com.ruoyi.co.domain;

import com.ruoyi.patproposal.domain.ProposalInventor;
import com.ruoyi.patproposal.domain.ProposalPat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.xmlbeans.impl.jam.JField;

import java.util.Date;

/**
 * 协同审查对象 ry_co_synergy
 * 
 * @author ruoyi
 * @date 2020-08-27
 */
public class RyCoSynergy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private int id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String proposalId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String patentcode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer samedayapply;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer typeid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer countryid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isOpen;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isPreliminary;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer agencyid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String agencycode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String budgecode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date creattime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String moreinfo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String attachId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String conductor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date timenodes;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /** 流程id */
    @Excel(name = "流程id")
    private String instanceId;


    public ProposalPat getProposalPat() {
        return proposalPat;
    }

    public void setProposalPat(ProposalPat proposalPat) {
        this.proposalPat = proposalPat;
    }


    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    private Date updatetime;



    private ProposalPat proposalPat;

    private ProposalInventor proposalInventor;
    public ProposalInventor getProposalInventor() {
        return proposalInventor;
    }

    public void setProposalInventor(ProposalInventor proposalInventor) {
        this.proposalInventor = proposalInventor;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setProposalId(String proposalId) 
    {
        this.proposalId = proposalId;
    }

    public String getProposalId() 
    {
        return proposalId;
    }
    public void setPatentcode(String patentcode) 
    {
        this.patentcode = patentcode;
    }

    public String getPatentcode() 
    {
        return patentcode;
    }
    public void setSamedayapply(Integer samedayapply) 
    {
        this.samedayapply = samedayapply;
    }

    public Integer getSamedayapply() 
    {
        return samedayapply;
    }
    public void setTypeid(Integer typeid) 
    {
        this.typeid = typeid;
    }

    public Integer getTypeid() 
    {
        return typeid;
    }
    public void setCountryid(Integer countryid) 
    {
        this.countryid = countryid;
    }

    public Integer getCountryid() 
    {
        return countryid;
    }
    public void setIsOpen(Integer isOpen) 
    {
        this.isOpen = isOpen;
    }

    public Integer getIsOpen() 
    {
        return isOpen;
    }
    public void setIsPreliminary(Integer isPreliminary) 
    {
        this.isPreliminary = isPreliminary;
    }

    public Integer getIsPreliminary() 
    {
        return isPreliminary;
    }
    public void setAgencyid(Integer agencyid) 
    {
        this.agencyid = agencyid;
    }

    public Integer getAgencyid() 
    {
        return agencyid;
    }
    public void setAgencycode(String agencycode) 
    {
        this.agencycode = agencycode;
    }

    public String getAgencycode() 
    {
        return agencycode;
    }
    public void setBudgecode(String budgecode) 
    {
        this.budgecode = budgecode;
    }

    public String getBudgecode() 
    {
        return budgecode;
    }
    public void setCreattime(Date creattime) 
    {
        this.creattime = creattime;
    }

    public Date getCreattime() 
    {
        return creattime;
    }
    public void setMoreinfo(String moreinfo) 
    {
        this.moreinfo = moreinfo;
    }

    public String getMoreinfo() 
    {
        return moreinfo;
    }
    public void setAttachId(String attachId) 
    {
        this.attachId = attachId;
    }

    public String getAttachId() 
    {
        return attachId;
    }
    public void setConductor(String conductor) 
    {
        this.conductor = conductor;
    }

    public String getConductor() 
    {
        return conductor;
    }
    public void setTimenodes(Date timenodes) 
    {
        this.timenodes = timenodes;
    }

    public Date getTimenodes() 
    {
        return timenodes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("proposalId", getProposalId())
            .append("patentcode", getPatentcode())
            .append("samedayapply", getSamedayapply())
            .append("typeid", getTypeid())
            .append("countryid", getCountryid())
            .append("isOpen", getIsOpen())
            .append("isPreliminary", getIsPreliminary())
            .append("agencyid", getAgencyid())
            .append("agencycode", getAgencycode())
            .append("budgecode", getBudgecode())
            .append("creattime", getCreattime())
            .append("moreinfo", getMoreinfo())
            .append("attachId", getAttachId())
            .append("conductor", getConductor())
            .append("proposalPat", getProposalPat())
            .append("timenodes", getTimenodes())
             .append("updatetime", getUpdatetime())
            .toString();
    }
}
