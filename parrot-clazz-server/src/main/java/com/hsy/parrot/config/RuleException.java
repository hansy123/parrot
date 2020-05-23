package com.hsy.parrot.config;

import java.util.Arrays;

public class RuleException extends RuntimeException{
    private final String code;
    private final transient Object body;
    private final String[] parameterArr;

    public RuleException(Object body, ErrCode code, String... parameterArr) {
        super(getText(code.toString(), parameterArr));
        this.code = code.toString();
        this.body = body;
        this.parameterArr = parameterArr;
    }

    public RuleException(Object body, ErrCode code) {
        this(body, code, "");
    }

    public RuleException(ErrCode code, String... parameterArr) {
        this((Object)null, code, parameterArr);
    }

    public RuleException(String codeStr, String parameter) {
        super(getText(codeStr, parameter));
        this.code = codeStr;
        this.body = null;
        this.parameterArr = new String[]{parameter};
    }

    private static String getText(String codeStr, String... parameterArr) {
        return codeStr + " = " + Arrays.toString(parameterArr);
    }

    public String getCode() {
        return this.code;
    }

    public Object getBody() {
        return this.body;
    }

    public String[] getParameterArr() {
        return this.parameterArr;
    }
}
