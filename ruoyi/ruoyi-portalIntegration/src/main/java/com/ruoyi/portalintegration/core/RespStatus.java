package com.ruoyi.portalintegration.core;

public enum RespStatus {
    /** 成功 */
    SUCCESS("0"),

    /** 错误 */
    ERROR("1");

    private final String value;

    RespStatus(String value)
    {
        this.value = value;
    }

    public String value()
    {
        return this.value;
    }
}
