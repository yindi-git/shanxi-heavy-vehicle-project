package com.ruoyi.portalintegration.model;

/**
 * 组织部门信息
 * @author: zhoudongyang
 * @time: 2020/8/5 15:38
 */
public class OriginDept {
    /**
     *组织编码
     */
    private String OrgCode;
    /**
     *组织名称
     */
    private String OrgName;
    /**
     *上级组织代码
     */
    private String HigherOrgCode;
    /**
     *启用状态
     */
    private String EnabledState;
    /**
     *撤销标记
     */
    private String UndoFlag;

    public String getOrgCode() {
        return OrgCode;
    }

    public void setOrgCode(String orgCode) {
        OrgCode = orgCode;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String orgName) {
        OrgName = orgName;
    }

    public String getHigherOrgCode() {
        return HigherOrgCode;
    }

    public void setHigherOrgCode(String higherOrgCode) {
        HigherOrgCode = higherOrgCode;
    }

    public String getEnabledState() {
        return EnabledState;
    }

    public void setEnabledState(String enabledState) {
        EnabledState = enabledState;
    }

    public String getUndoFlag() {
        return UndoFlag;
    }

    public void setUndoFlag(String undoFlag) {
        UndoFlag = undoFlag;
    }
}
