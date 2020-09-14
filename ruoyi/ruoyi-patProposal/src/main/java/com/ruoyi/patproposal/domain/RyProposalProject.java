package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 项目名称对象 ry_proposal_project
 * 
 * @author ZhenMinZhang
 * @date 2020-09-09
 */
public class RyProposalProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id主键 */
    private String projectId;

    /** 项目名 */
    @Excel(name = "项目名")
    private String projectName;

    /** 项目描述 */
    @Excel(name = "项目描述")
    private String projectDesc;

    /** 责任单位ID */
    @Excel(name = "责任单位ID")
    private String responsibleUnitId;

    /** 责任单位 */
    @Excel(name = "责任单位")
    private String responsibleUnit;

    /** 责任人ID */
    @Excel(name = "责任人ID")
    private String responsibleUserId;

    /** 责任人 */
    @Excel(name = "责任人")
    private String responsibleUser;

    /** 创新点 */
    @Excel(name = "创新点")
    private String innovativePoints;

    /** 项目周期 */
    @Excel(name = "项目周期")
    private String projectCycle;

    /** 保密级别 */
    @Excel(name = "保密级别")
    private String securityLevel;

    /** 计划专利数量 */
    @Excel(name = "计划专利数量")
    private Long planProposalNumber;

    /** 计划发明专利数量 */
    @Excel(name = "计划发明专利数量")
    private Long planInventorPropNumber;

    /** 项目文献 */
    @Excel(name = "项目文献")
    private String projectLiterature;

    /** 维护人ID */
    @Excel(name = "维护人ID")
    private String repairsUserId;

    /** 维护人 */
    @Excel(name = "维护人")
    private String repairsUser;

    /** 维护时间 */
    @Excel(name = "维护时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date repairsTime;

    /** 项目备注 */
    @Excel(name = "项目备注")
    private String projectComments;

    public void setProjectId(String projectId) 
    {
        this.projectId = projectId;
    }

    public String getProjectId() 
    {
        return projectId;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectDesc(String projectDesc) 
    {
        this.projectDesc = projectDesc;
    }

    public String getProjectDesc() 
    {
        return projectDesc;
    }
    public void setResponsibleUnitId(String responsibleUnitId) 
    {
        this.responsibleUnitId = responsibleUnitId;
    }

    public String getResponsibleUnitId() 
    {
        return responsibleUnitId;
    }
    public void setResponsibleUnit(String responsibleUnit) 
    {
        this.responsibleUnit = responsibleUnit;
    }

    public String getResponsibleUnit() 
    {
        return responsibleUnit;
    }
    public void setResponsibleUserId(String responsibleUserId) 
    {
        this.responsibleUserId = responsibleUserId;
    }

    public String getResponsibleUserId() 
    {
        return responsibleUserId;
    }
    public void setResponsibleUser(String responsibleUser) 
    {
        this.responsibleUser = responsibleUser;
    }

    public String getResponsibleUser() 
    {
        return responsibleUser;
    }
    public void setInnovativePoints(String innovativePoints) 
    {
        this.innovativePoints = innovativePoints;
    }

    public String getInnovativePoints() 
    {
        return innovativePoints;
    }
    public void setProjectCycle(String projectCycle) 
    {
        this.projectCycle = projectCycle;
    }

    public String getProjectCycle() 
    {
        return projectCycle;
    }
    public void setSecurityLevel(String securityLevel) 
    {
        this.securityLevel = securityLevel;
    }

    public String getSecurityLevel() 
    {
        return securityLevel;
    }
    public void setPlanProposalNumber(Long planProposalNumber) 
    {
        this.planProposalNumber = planProposalNumber;
    }

    public Long getPlanProposalNumber() 
    {
        return planProposalNumber;
    }
    public void setPlanInventorPropNumber(Long planInventorPropNumber) 
    {
        this.planInventorPropNumber = planInventorPropNumber;
    }

    public Long getPlanInventorPropNumber() 
    {
        return planInventorPropNumber;
    }
    public void setProjectLiterature(String projectLiterature) 
    {
        this.projectLiterature = projectLiterature;
    }

    public String getProjectLiterature() 
    {
        return projectLiterature;
    }
    public void setRepairsUserId(String repairsUserId) 
    {
        this.repairsUserId = repairsUserId;
    }

    public String getRepairsUserId() 
    {
        return repairsUserId;
    }
    public void setRepairsUser(String repairsUser) 
    {
        this.repairsUser = repairsUser;
    }

    public String getRepairsUser() 
    {
        return repairsUser;
    }
    public void setRepairsTime(Date repairsTime) 
    {
        this.repairsTime = repairsTime;
    }

    public Date getRepairsTime() 
    {
        return repairsTime;
    }
    public void setProjectComments(String projectComments) 
    {
        this.projectComments = projectComments;
    }

    public String getProjectComments() 
    {
        return projectComments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("projectDesc", getProjectDesc())
            .append("responsibleUnitId", getResponsibleUnitId())
            .append("responsibleUnit", getResponsibleUnit())
            .append("responsibleUserId", getResponsibleUserId())
            .append("responsibleUser", getResponsibleUser())
            .append("innovativePoints", getInnovativePoints())
            .append("createTime", getCreateTime())
            .append("projectCycle", getProjectCycle())
            .append("securityLevel", getSecurityLevel())
            .append("planProposalNumber", getPlanProposalNumber())
            .append("planInventorPropNumber", getPlanInventorPropNumber())
            .append("projectLiterature", getProjectLiterature())
            .append("repairsUserId", getRepairsUserId())
            .append("repairsUser", getRepairsUser())
            .append("repairsTime", getRepairsTime())
            .append("projectComments", getProjectComments())
            .toString();
    }
}
