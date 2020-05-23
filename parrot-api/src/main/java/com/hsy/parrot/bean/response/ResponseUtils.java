package com.hsy.parrot.bean.response;

/**
 * 封装结果
 * 简述功能
 * ClassName: ResponseUtils    
 * date: 2018年1月26日 下午4:03:45 
 * @author hsy
 * @since JDK 1.8
 */
public class ResponseUtils {

    /**
     * 请求成功，无参数
     * @author 82702
     * @return
     * @since JDK 1.8
     */
    public static <T> ResponseEntity packegeResult() {
        return new ResponseEntity(GeneConstant.SUCCESS);
    }

    /**
     * 请求成功，有参数
     * @author 82702
     * @param c
     * @return
     * @since JDK 1.8
     */
    public static <T> ResponseEntity packegeResult(T c) {
        return new ResponseEntity(GeneConstant.SUCCESS).setValue(c);
    }

    /**
     * 请求成功与否，由message决定，当message为“error”时，请求失败；其余值均为成功；
     * 有参数
     * @author 82702
     * @param c
     * @param message
     * @return
     * @since JDK 1.8
     */
    public static <T> ResponseEntity packegeResult(T c, String message) {
        return new ResponseEntity(message).setValue(c);
    }

    /**
     * 请求成功与否，由message决定，当message为“error”时，请求失败；其余值均为成功；
     * @author 82702
     * @param message
     * @return
     * @since JDK 1.8
     */
    public static <T> ResponseEntity packegeResult(String message) {
        return new ResponseEntity(message);
    }

    /**
     * 请求成功与否
     * @author whz
     * @param result
     * @param message
     * @return
     * @since JDK 1.8
     */
    public static ResponseEntity packegeResult(int result, String message) {
        return new ResponseEntity(result, message);
    }

    /**
     * 请求成功与否
     * @author whz
     * @param result
     * @return
     * @since JDK 1.8
     */
    public static ResponseEntity packegeResult(int result) {
        return new ResponseEntity(result);
    }

    /**
     * 请求成功与否
     * @author whz
     * @param result
     * @param message
     * @return
     * @since JDK 1.8
     */
    public static <T> ResponseEntity packegeResult(int result, String message, T t) {
        return new ResponseEntity(result, message, t);
    }

}
