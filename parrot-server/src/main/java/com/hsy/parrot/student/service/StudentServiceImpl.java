package com.hsy.parrot.student.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.hsy.parrot.annotation.RequireLog;
import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.exception.ParrotException;
import com.hsy.parrot.bean.response.GeneConstant;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.bean.response.ResponseUtils;
import com.hsy.parrot.bean.student.Student;
import com.hsy.parrot.clazz.dao.ClazzMapper;
import com.hsy.parrot.clazz.service.ClazzService;
import com.hsy.parrot.student.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/25 16:03
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClazzService clazzService;

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    @RequireLog
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity getAllStudentList() {
        List<Student> studentList = studentMapper.getAllStudentList();
        return ResponseUtils.packegeResult(studentList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Student> getStudentListByClazzId(long id) {

        return studentMapper.getStudentListByClazzId(id);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @LcnTransaction
    public ResponseEntity insertClazzAndStudent(Clazz clazz) {
        ResponseEntity responseEntity = clazzService.insertClazz(clazz);
        if (responseEntity.getResult() == 1) {
            LinkedHashMap lie = (LinkedHashMap) responseEntity.getValue();
            clazz.setId((int) lie.get("id"));
        } else
            throw new ParrotException("调用远程出错");
        List<Student> studentList = clazz.getStudentList();
        if (studentList == null || studentList.isEmpty())
            throw new ParrotException("无学生数据");
        studentMapper.insertStudentList(studentList, clazz.getId());
//        int a = 10 / 0;
        return new ResponseEntity(GeneConstant.SUCCESS);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity getClazzById(long clazzId) {
        return clazzService.getClazzById(clazzId);
    }
}
