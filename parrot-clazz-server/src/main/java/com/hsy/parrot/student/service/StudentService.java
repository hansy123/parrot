package com.hsy.parrot.student.service;

import com.hsy.parrot.bean.student.Student;
import com.hsy.parrot.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "parrotServer", configuration = FeignConfig.class, fallback = StudentServiceError.class)
public interface StudentService {

    @PostMapping(value = "/student/getStudentListByClazzId")
    List<Student> getStudentListByClazzId(@RequestParam("id") long id);
}
