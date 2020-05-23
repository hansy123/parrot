package com.hsy.parrot.utils;

import com.hsy.parrot.constant.ParameterConstant;

import java.util.Arrays;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 14:51
 */
public class StringUtils {

    public static String concatString(String symbolSeparator, String... str) {
        if (isEmptyArray(str))
            return null;
        String symbolSeparator2 = symbolSeparator == null || symbolSeparator.equals(ParameterConstant.ENPTY_STRING) ? ParameterConstant.ENPTY_STRING : symbolSeparator;
        StringBuilder sb = new StringBuilder();
        Arrays.stream(str).forEach(x -> {
            sb.append(x).append(symbolSeparator2);
        });
        if(symbolSeparator2.equals(ParameterConstant.ENPTY_STRING))
            return sb.toString();
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static boolean isEmptyArray(Object[] array) {
        return (array == null || array.length == 0);
    }

}
