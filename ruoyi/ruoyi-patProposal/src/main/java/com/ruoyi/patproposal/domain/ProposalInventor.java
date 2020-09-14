package com.ruoyi.patproposal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 发明人对象 ry_proposal_inventor
 *
 * @author 神州数码
 * @date 2020-08-13
 */
public class ProposalInventor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String inventorId;

    /** 专利编号 */
    @Excel(name = "专利编号")
    private String proposalId;

    /** 发明人工号 */
    @Excel(name = "发明人工号")
    private String userId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 部门 */
    @Excel(name = "部门")
    private String dept;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** null */
    @Excel(name = "null")
    private String idcard;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 贡献度 */
    @Excel(name = "贡献度")
    private Double contribution;

    /** 是否第一发明人 */
    @Excel(name = "是否第一发明人")
    private String isFirstInventor;

    public void setInventorId(String inventorId)
    {
        this.inventorId = inventorId;
    }

    public String getInventorId()
    {
        return inventorId;
    }
    public void setProposalId(String proposalId)
    {
        this.proposalId = proposalId;
    }

    public String getProposalId()
    {
        return proposalId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getDept()
    {
        return dept;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setIdcard(String idcard)
    {
        this.idcard = idcard;
    }

    public String getIdcard()
    {
        return idcard;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setContribution(Double contribution)
    {
        this.contribution = contribution;
    }

    public Double getContribution()
    {
        return contribution;
    }
    public void setIsFirstInventor(String isFirstInventor)
    {
        this.isFirstInventor = isFirstInventor;
    }

    public String getIsFirstInventor()
    {
        return isFirstInventor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("inventorId", getInventorId())
                .append("proposalId", getProposalId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("dept", getDept())
                .append("phone", getPhone())
                .append("idcard", getIdcard())
                .append("email", getEmail())
                .append("contribution", getContribution())
                .append("isFirstInventor", getIsFirstInventor())
                .toString();
    }
}