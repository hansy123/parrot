package com.hsy.parrot.clazz.service;

import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.response.ResponseEntity;

public interface ClazzService {
    ResponseEntity getClazzList();

    ResponseEntity insertClazz(Clazz clazz);

    ResponseEntity getClazzById(long clazzId);
}
