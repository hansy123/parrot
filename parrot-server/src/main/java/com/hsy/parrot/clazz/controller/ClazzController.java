package com.hsy.parrot.clazz.controller;

import com.hsy.parrot.bean.response.GeneConstant;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.clazz.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/27 16:03
 */
@Slf4j
@RestController
@RequestMapping(value = "/clazz", produces = "application/json")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @RequestMapping(value = "getClazzList",method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity getClazzList() {

        log.info("enter getClazzList method ");
        ResponseEntity result;
        try {
            result = clazzService.getClazzList();
        } catch (Exception e) {
            result = new ResponseEntity(GeneConstant.ERROR);
            log.error("getClazzList method fail,exception is {}", e);
        }
        log.info("getClazzList method end");
        return result;
    }
}
