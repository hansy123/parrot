package com.hsy.parrot.clazz.service;

import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "parrotClazzServer", configuration = FeignConfig.class, fallback = ClazzServiceError.class)
public interface ClazzService {

    @PostMapping(value = "/clazz/getClazzList")
    ResponseEntity getClazzList();

    @PostMapping(value = "/kafka/updateMessageStatus")
    ResponseEntity updateStatus(@RequestParam("content") String content);

    @PostMapping(value = "/clazz/insertClazz")
    ResponseEntity insertClazz(@RequestBody Clazz clazz);

    @PostMapping(value = "/clazz/getClazzById")
    ResponseEntity getClazzById(long clazzId);
}
