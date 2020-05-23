package com.hsy.parrot.utils;

import com.hsy.parrot.constant.ParameterConstant;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 15:15
 */
public class CommonUtils {

    /**
     * ������Ʒredis���key
     *
     * @param code ��Ʒ����
     * @return
     */
    public static String createStockRedisKey(String code) {
        if (code == null || code.equals(ParameterConstant.ENPTY_STRING))
            throw new IllegalArgumentException("redis�д����벻��Ϊ���ַ���");
        return StringUtils.concatString(ParameterConstant.SYMBOL_UNDERLINE, code, ParameterConstant.SYMBOL_STOCK);
    }

    /**
     *
     * @param count ��Ʒ�ܿ��
     * @param lockCount �������
     * @param surplusCount ʣ����
     * @return
     */
    public static String createStockRedisValue(Integer count, Integer lockCount, Integer surplusCount) {

        return StringUtils.concatString(ParameterConstant.SYMBOL_UNDERLINE,String.valueOf(count),String.valueOf(lockCount),String.valueOf(surplusCount));
    }

    public static String createStockRedisValue(String count, String lockCount, String surplusCount) {

        return StringUtils.concatString(ParameterConstant.SYMBOL_UNDERLINE,count,lockCount,surplusCount);
    }
}
