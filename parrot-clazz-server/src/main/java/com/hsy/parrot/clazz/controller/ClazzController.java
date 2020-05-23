package com.hsy.parrot.clazz.controller;

import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.response.GeneConstant;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.clazz.service.ClazzService;
import com.hsy.parrot.config.FtpConfigDto;
import com.hsy.parrot.config.FtpConfigRule;
import com.hsy.parrot.config.FtpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/27 15:40
 */
@Slf4j
@RestController
@RequestMapping(value = "/clazz", produces = "application/json")
public class ClazzController {

    private static final String DIR_SEPARATOR = "/";
    private static final String FILE_EXTENSION_SEPARATOR = ".";

    @Autowired
    private FtpConfigRule ftpConfigRule;

    @Autowired
    private ClazzService clazzService;

    @PostMapping("/getClazzList")
    public ResponseEntity getClazzList() {

        log.info("enter getClazzList method");
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

    @PostMapping("/insertClazz")
    public ResponseEntity insertClazz(@RequestBody Clazz clazz) {

        log.info("enter insertClazz method");
        ResponseEntity result;
        try {
            result = clazzService.insertClazz(clazz);
        } catch (Exception e) {
            result = new ResponseEntity(GeneConstant.ERROR);
            log.error("insertClazz method fail,exception is {}", e);
        }
        log.info("insertClazz method end");
        return result;
    }

    @PostMapping("/getClazzById")
    public ResponseEntity getClazzById(@RequestParam long clazzId) {

        log.info("enter getClazzById method");
        ResponseEntity result;
        try {
            result = clazzService.getClazzById(clazzId);
        } catch (Exception e) {
            result = new ResponseEntity(GeneConstant.ERROR);
            log.error("getClazzById method fail,exception is {}", e);
        }
        log.info("getClazzById method end");
        return result;
    }

    @GetMapping("/test")
    public void test() {
        try {
            FtpConfigDto ftpConfigDto = ftpConfigRule.getPrivateFtpConfig();
            InputStream in = FtpUtil.readForFTP(ftpConfigDto, getTemplateRemotePath());
            FileOutputStream fos = new FileOutputStream("E:\\a.ftl");
            byte[] by = new byte[1024];
            int len = 0;
            while ((len = in.read(by)) != -1) {
                fos.write(by, 0, len);
            }
            fos.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getTemplateRemotePath() {
        String templatePath = "/credit/template";
        return templatePath + DIR_SEPARATOR + "report-person" + FILE_EXTENSION_SEPARATOR
                + "ftl";
    }
}
