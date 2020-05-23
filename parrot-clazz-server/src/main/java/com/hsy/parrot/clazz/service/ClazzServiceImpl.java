package com.hsy.parrot.clazz.service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.response.GeneConstant;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.bean.response.ResponseUtils;
import com.hsy.parrot.bean.student.Student;
import com.hsy.parrot.clazz.dao.ClazzMapper;
import com.hsy.parrot.student.service.StudentService;
import com.hsy.parrot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/27 15:43
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    public ClazzMapper clazzMapper;

    @Autowired
    public StudentService studentService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity getClazzList() {
        List<Clazz> clazzList = clazzMapper.getClazzList();

        clazzList.forEach(clazz -> {
            packStudentList(clazz);
        });

        return ResponseUtils.packegeResult(clazzList);
    }

    private void packStudentList(Clazz clazz) {

        List<Student> studentList = studentService.getStudentListByClazzId(clazz.getId());
        clazz.setStudentList(studentList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    public ResponseEntity insertClazz(Clazz clazz) {
        RedisUtil.set("author", "hsy");
        clazzMapper.insertClazz(clazz);
        return new ResponseEntity(GeneConstant.SUCCESS, clazz);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity getClazzById(long clazzId) {
        Clazz clazz = clazzMapper.getClazzById(clazzId);
        return ResponseUtils.packegeResult(clazz);
    }
}
