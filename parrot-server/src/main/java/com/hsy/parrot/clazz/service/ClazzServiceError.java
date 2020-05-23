package com.hsy.parrot.clazz.service;

import com.hsy.parrot.bean.exception.ParrotException;
import com.hsy.parrot.bean.response.ResponseEntity;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/25 18:00
 */
public class ClazzServiceError {

    ResponseEntity getClazzList() {
        throw new ParrotException("获取班级列表出错");
    }
}
