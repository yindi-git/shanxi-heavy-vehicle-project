package com.ruoyi.portalintegration.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 密码工具类
 * @author: zhoudongyang
 * @time: 2020/8/6 8:36
 */
public class PasswordUtil {

    public static String Base64ToMd5(String Base64Str){
        return new Md5Hash(Base64Str).toHex();
    }
}
