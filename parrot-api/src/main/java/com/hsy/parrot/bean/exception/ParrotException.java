package com.hsy.parrot.bean.exception;

/**
 * @author:hsy
 * @description:
 * @date 2019/12/30 14:42
 */
public class ParrotException extends RuntimeException {

    private static final long serialVersionUID = 1195447011677831601L;

    public ParrotException() {
        super();
    }

    public ParrotException(String message) {
        super(message);
    }

    public ParrotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParrotException(Throwable cause) {
        super(cause);
    }

    public ParrotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
