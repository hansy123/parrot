package com.hsy.parrot.config;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Map;

@Slf4j
public class Validator {

    private static final String YES = "1";

    public Validator() {
    }

    public static void assertNotBlank(String param, ErrCode code, String... parameters) {
        if (param == null || param.trim().length() == 0) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertBlank(String param, ErrCode code, String... parameters) {
        if (param != null && param.trim().length() > 0) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertNotEmpty(Map param, ErrCode code, String... parameters) {
        if (param == null || param.size() == 0) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertNotEmpty(Collection list, ErrCode code, String... parameters) {
        if (list == null || list.size() == 0) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertEmpty(Map<String, Object> param, ErrCode code, String... parameters) {
        if (param != null && param.size() > 0) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertNotNull(Object param, ErrCode code, String... parameters) {
        if (param == null) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertNull(Object param, ErrCode code, String... parameters) {
        if (param != null) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertTrue(Boolean param, ErrCode code, String... parameters) {
        if (!param) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertYes(String str, ErrCode code, String... parameters) {
        assertTrue("1".equals(str), code, parameters);
    }

    public static void assertNo(String str, ErrCode code, String... parameters) {
        assertFalse(!"1".equals(str), code, parameters);
    }

    public static void assertFalse(Boolean param, ErrCode code, String... parameters) {
        if (param) {
            throw new RuleException(code, parameters);
        }
    }

    public static void assertMatch(String param, String pattern, ErrCode code, String... parameters) {
        assertTrue(param.matches(pattern), code, parameters);
    }
}
