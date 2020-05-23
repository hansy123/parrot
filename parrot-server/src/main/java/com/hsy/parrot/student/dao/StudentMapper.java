package com.hsy.parrot.student.dao;

import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.student.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    List<Student> getAllStudentList();

    List<Student> getStudentListByClazzId(@Param("clazzId") long id);

    void insertStudentList(@Param("studentList") List<Student> studentList, @Param("clazzId") long clazzId);

}
