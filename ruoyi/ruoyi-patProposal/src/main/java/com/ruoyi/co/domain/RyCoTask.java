package com.ruoyi.co.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 【请填写功能名称】对象 ry_co_task
 * 
 * @author ruoyi
 * @date 2020-08-27
 */
public class RyCoTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer taskid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String taskname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date timenodes;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String usertime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String agencyname;

    public void setTaskid(Integer taskid) 
    {
        this.taskid = taskid;
    }

    public Integer getTaskid() 
    {
        return taskid;
    }
    public void setTaskname(String taskname) 
    {
        this.taskname = taskname;
    }

    public String getTaskname() 
    {
        return taskname;
    }
    public void setTimenodes(Date timenodes) 
    {
        this.timenodes = timenodes;
    }

    public Date getTimenodes() 
    {
        return timenodes;
    }
    public void setUsertime(String usertime) 
    {
        this.usertime = usertime;
    }

    public String getUsertime() 
    {
        return usertime;
    }
    public void setAgencyname(String agencyname) 
    {
        this.agencyname = agencyname;
    }

    public String getAgencyname() 
    {
        return agencyname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskid", getTaskid())
            .append("taskname", getTaskname())
            .append("timenodes", getTimenodes())
            .append("usertime", getUsertime())
            .append("agencyname", getAgencyname())
            .toString();
    }
}
