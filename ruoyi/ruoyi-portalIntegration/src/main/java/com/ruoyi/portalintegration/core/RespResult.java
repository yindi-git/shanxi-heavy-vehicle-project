package com.ruoyi.portalintegration.core;

import java.util.HashMap;

/**
 * ESB接组织人员用户响应信息实体
 * @author: zhoudongyang
 * @time: 2020/8/3 14:14
 */
public class RespResult extends HashMap<String, Object> {
    /**
     * 返回状态
     */
    public static String L_RET_STATUS="L_RET_STATUS";

    /**
     * 错误代码
     */
    public static String L_RET_ERROR_CODE="L_RET_ERROR_CODE";

    /**
     * 错误信息
     */
    public static String L_RET_ERROR_MESSAGE="L_RET_ERROR_MESSAGE";

    public RespResult(Status status, String code, String msg) {
        super.put(L_RET_STATUS, status.value);
        super.put(L_RET_ERROR_CODE, code);
        super.put(L_RET_ERROR_MESSAGE, msg);
    }

    /**
     * 状态类型
     */
    public enum Status{
        /** 成功 */
        SUCCESS("0"),

        /** 错误 */
        ERROR("1");

        private final String value;

        Status(String value)
        {
            this.value = value;
        }

        public String value()
        {
            return this.value;
        }
    }

    /**
     * 失败时信息返回
     * @param code
     * @param msg
     * @return
     */
    public static RespResult success(String code,String msg) {
        return new RespResult(Status.SUCCESS,code,msg);
    }


    /**
     * 失败时信息返回
     * @param code
     * @param msg
     * @return
     */
    public static RespResult error(String code,String msg)
    {
        return new RespResult(Status.ERROR,code,msg);
    }

}
