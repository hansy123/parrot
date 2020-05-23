package com.hsy.parrot.student.controller;

import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.response.GeneConstant;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.bean.student.Student;
import com.hsy.parrot.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/25 16:01
 */
@Slf4j
@RestController
@RequestMapping(value = "/student", produces = "application/json")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/getAllStudentList")
    public ResponseEntity getAllStudentList() {
        log.info("enter getAllStudentList method");
        ResponseEntity result;
        try {
            result = studentService.getAllStudentList();
        } catch (Exception e) {
            result = new ResponseEntity(GeneConstant.ERROR);
            log.error("getAllStudentList method fail,exception is {}", e);
        }
        log.info("getAllStudentList method end");
        return result;
    }

    @PostMapping(value = "/getStudentListByClazzId")
    public List<Student> getStudentListByClazzId(@RequestParam("id") long id) {
        log.info("enter getStudentListByClazzId method");
        List<Student> result;
        try {
            result = studentService.getStudentListByClazzId(id);
        } catch (Exception e) {
            result = null;
            log.error("getStudentListByClazzId method fail,exception is {}", e);
        }
        log.info("getStudentListByClazzId method end");
        return result;
    }

    @RequestMapping(value = "insertClazzAndStudent", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity insertClazzAndStudent(@RequestBody Clazz clazz) {

        log.info("enter insertClazzAndStudent method ");
        ResponseEntity result;
        try {
            result = studentService.insertClazzAndStudent(clazz);
        } catch (Exception e) {
            result = new ResponseEntity(GeneConstant.ERROR);
            log.error("insertClazzAndStudent method fail,exception is {}", e);
        }
        log.info("insertClazzAndStudent method end");
        return result;
    }

    @RequestMapping(value = "getClazzById", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity getClazzById(long clazzId) {

        log.info("enter getClazzById method ");
        ResponseEntity result;
        try {
            result = studentService.getClazzById(clazzId);
        } catch (Exception e) {
            result = new ResponseEntity(GeneConstant.ERROR);
            log.error("getClazzById method fail,exception is {}", e);
        }
        log.info("getClazzById method end");
        return result;
    }
}
