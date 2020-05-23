package com.hsy.parrot.utils;

import com.hsy.parrot.constant.ParameterConstant;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 15:15
 */
public class CommonUtils {

    /**
     * 生成商品redis库存key
     *
     * @param code 商品编码
     * @return
     */
    public static String createStockRedisKey(String code) {
        if (code == null || code.equals(ParameterConstant.ENPTY_STRING))
            throw new IllegalArgumentException("redis中存库编码不能为空字符串");
        return StringUtils.concatString(ParameterConstant.SYMBOL_UNDERLINE, code, ParameterConstant.SYMBOL_STOCK);
    }

    /**
     *
     * @param count 商品总库存
     * @param lockCount 锁定库存
     * @param surplusCount 剩余库存
     * @return
     */
    public static String createStockRedisValue(Integer count, Integer lockCount, Integer surplusCount) {

        return StringUtils.concatString(ParameterConstant.SYMBOL_UNDERLINE,String.valueOf(count),String.valueOf(lockCount),String.valueOf(surplusCount));
    }

    public static String createStockRedisValue(String count, String lockCount, String surplusCount) {

        return StringUtils.concatString(ParameterConstant.SYMBOL_UNDERLINE,count,lockCount,surplusCount);
    }
}
