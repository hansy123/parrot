package com.hsy.parrot.student.service;

import com.hsy.parrot.bean.exception.ParrotException;
import com.hsy.parrot.bean.student.Student;

import java.util.List;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/28 18:53
 */
public class StudentServiceError {

    List<Student> getStudentListByClazzId(int id) {
        throw new ParrotException("��ȡѧ���б����");
    }
}
