package com.ruoyi.patproposal.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class ActHiomment  extends BaseEntity {

    private static final long serialVersionUID = 1L;

  /*  *//** $column.columnComment *//*
    private String id;

    *//** $column.columnComment *//*
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type;

    *//** $column.columnComment *//*
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date time;
*/
    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userId;

   /* *//** $column.columnComment *//*
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String taskId;

    *//** $column.columnComment *//*
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String procInstId;

    *//** $column.columnComment *//*
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String action;*/

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String message;

    /** $column.columnComment */

    /*public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setTime(Date time)
    {
        this.time = time;
    }

    public Date getTime()
    {
        return time;
    }*/
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
   /* public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskId()
    {
        return taskId;
    }
    public void setProcInstId(String procInstId)
    {
        this.procInstId = procInstId;
    }

    public String getProcInstId()
    {
        return procInstId;
    }
    public void setAction(String action)
    {
        this.action = action;
    }

    public String getAction()
    {
        return action;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
*/
    public String getMessage()
    {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
               /* .append("id", getId())
                .append("type", getType())
                .append("time", getTime())*/
                .append("userId", getUserId())
                /*.append("taskId", getTaskId())
                .append("procInstId", getProcInstId())
                .append("action", getAction())*/
                .append("message", getMessage())
                .toString();
    }
}
