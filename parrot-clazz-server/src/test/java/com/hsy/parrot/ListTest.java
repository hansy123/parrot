package com.hsy.parrot;

import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.student.Student;
import com.hsy.parrot.config.FtpConfigDto;
import com.hsy.parrot.config.FtpConfigRule;
import com.hsy.parrot.config.FtpUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListTest {


    @Test
    public void test1() throws IllegalAccessException {
        Student student1 = new Student();
        student1.setName("张三");
        student1.setAge(1);
        Student student2 = new Student();
        student2.setName("李四");
        student2.setAge(2);
        Student student3 = new Student();
        student3.setName("王五");
        student3.setAge(3);
        Student student4 = new Student();
        student4.setName("赵六");
        student4.setAge(4);
        Student student5 = new Student();
        student5.setName("王二");
        student5.setAge(5);
        Student student6 = new Student();
        student6.setName("麻子");
        student6.setAge(6);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student6);
        students.add(student5);
        students.add(student4);
        students.add(student3);
        students.add(student2);

        System.out.println("排序前：\n" + students);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student stu1, Student stu2) {
                double age1 = stu1.getAge() == 5 ? 1.5 : stu1.getAge();
                double age2 = stu2.getAge() == 5 ? 1.5 : stu2.getAge();
                if (age1 > age2)
                    return 1;
                else if (age1 < age2)
                    return -1;
                else
                    return 0;
            }
        });
        System.out.println("排序后：\n" + students + "\n -----------------------------");

        Clazz clazz = new Clazz();
        clazz.setStudentList(students);
        clazz.setName("三年级二班");
        Map<String, Object> dataMap = new HashMap<>();
        Map<String, Object> stringObjectMap = convertToMap(dataMap, clazz);
        System.out.println(stringObjectMap);
    }


    public static Map<String, Object> convertToMap(Map<String, Object> dataMap, Object obj) throws IllegalAccessException {
        if (null == obj)
            return dataMap;
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
//            if(field.get(obj) == null)
//                continue;
            field.setAccessible(true);
            dataMap.put(field.getName(), field.get(obj));
        }
        return dataMap;
    }

    @Test
    public void test2() {
        System.out.println(new SimpleDateFormat("yyyy 年 MM 月 dd 日").format(new Date()));
    }

}
