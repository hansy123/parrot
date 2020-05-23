package com.hsy.parrot.student.service;

import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.bean.student.Student;

import java.util.List;

public interface StudentService {
    ResponseEntity getAllStudentList();

    List<Student> getStudentListByClazzId(long id);

    ResponseEntity insertClazzAndStudent(Clazz clazz);

    ResponseEntity getClazzById(long clazzId);
}
