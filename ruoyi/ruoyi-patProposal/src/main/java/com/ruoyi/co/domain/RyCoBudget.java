package com.ruoyi.co.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 【请填写功能名称】对象 ry_co_budget
 *
 * @author ruoyi
 * @date 2020-09-01
 */
public class RyCoBudget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 费用表id */
    private Integer budgetid;

    /** 公司主体 */
    @Excel(name = "公司主体")
    private String applicantMain;

    /** 公司编码 */
    @Excel(name = "公司编码")
    private String applicantCode;

    /** 预算年度 */
    @Excel(name = "预算年度")
    private String budgetYear;

    /** 业务名称 */
    @Excel(name = "业务名称")
    private String businessName;

    /** 预算编号 */
    @Excel(name = "预算编号")
    private String budgetCode;

    /** 预算额度 */
    @Excel(name = "预算额度")
    private Integer budgetLimit;

    /** 业务描述 */
    @Excel(name = "业务描述")
    private String businessDescribe;

    /** 费用编码 */
    @Excel(name = "费用编码")
    private String costCode;

    /** 费用项目 */
    @Excel(name = "费用项目")
    private String costProject;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 执行情况 */
    @Excel(name = "执行情况")
    private String budgetExecute;

    /** 执行率 */
    @Excel(name = "执行率")
    private Integer executeRate;

    /** 操作时间 */
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operatTime;

    public void setBudgetid(Integer budgetid)
    {
        this.budgetid = budgetid;
    }

    public Integer getBudgetid()
    {
        return budgetid;
    }
    public void setApplicantMain(String applicantMain)
    {
        this.applicantMain = applicantMain;
    }

    public String getApplicantMain()
    {
        return applicantMain;
    }
    public void setApplicantCode(String applicantCode)
    {
        this.applicantCode = applicantCode;
    }

    public String getApplicantCode()
    {
        return applicantCode;
    }
    public void setBudgetYear(String budgetYear)
    {
        this.budgetYear = budgetYear;
    }

    public String getBudgetYear()
    {
        return budgetYear;
    }
    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    public String getBusinessName()
    {
        return businessName;
    }
    public void setBudgetCode(String budgetCode)
    {
        this.budgetCode = budgetCode;
    }

    public String getBudgetCode()
    {
        return budgetCode;
    }
    public void setBudgetLimit(Integer budgetLimit)
    {
        this.budgetLimit = budgetLimit;
    }

    public Integer getBudgetLimit()
    {
        return budgetLimit;
    }
    public void setBusinessDescribe(String businessDescribe)
    {
        this.businessDescribe = businessDescribe;
    }

    public String getBusinessDescribe()
    {
        return businessDescribe;
    }
    public void setCostCode(String costCode)
    {
        this.costCode = costCode;
    }

    public String getCostCode()
    {
        return costCode;
    }
    public void setCostProject(String costProject)
    {
        this.costProject = costProject;
    }

    public String getCostProject()
    {
        return costProject;
    }
    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }
    public void setBudgetExecute(String budgetExecute)
    {
        this.budgetExecute = budgetExecute;
    }

    public String getBudgetExecute()
    {
        return budgetExecute;
    }
    public void setExecuteRate(Integer executeRate)
    {
        this.executeRate = executeRate;
    }

    public Integer getExecuteRate()
    {
        return executeRate;
    }
    public void setOperatTime(Date operatTime)
    {
        this.operatTime = operatTime;
    }

    public Date getOperatTime()
    {
        return operatTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("budgetid", getBudgetid())
                .append("applicantMain", getApplicantMain())
                .append("applicantCode", getApplicantCode())
                .append("budgetYear", getBudgetYear())
                .append("businessName", getBusinessName())
                .append("budgetCode", getBudgetCode())
                .append("budgetLimit", getBudgetLimit())
                .append("businessDescribe", getBusinessDescribe())
                .append("costCode", getCostCode())
                .append("costProject", getCostProject())
                .append("remark", getRemark())
                .append("operator", getOperator())
                .append("budgetExecute", getBudgetExecute())
                .append("executeRate", getExecuteRate())
                .append("operatTime", getOperatTime())
                .toString();
    }
}