package com.hsy.parrot.collection;

import com.alibaba.fastjson.JSON;
import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.student.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author:hsy
 * @description:
 * @date 2019/12/24 10:49
 */
@Slf4j
public class ConllectionTest {

    @Test
    public void test1() {
        System.out.println("ArrayList:");
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        l1.add(null);
        l1.add(null);

        l1.stream().forEach(i -> System.out.println(i));

        System.out.println("----------------------\nHashSet:");
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(1);
        s1.add(null);
        s1.add(null);
        s1.stream().forEach(s -> System.out.println(s));

        System.out.println("----------------------\nHashMap:");
        Map<Integer, Integer> m1 = new HashMap<>();
        m1.put(1, 1);
        m1.put(1, 1);
        m1.put(null, 2);
        m1.put(null, 1);
        m1.put(null, 3);
        m1.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

    private static int num2 = 100;

    public static void changeNum(Integer num) {
        num = 1000;
    }

    public static void main(String[] args) {
        Integer num = 200;
        Integer num2 = 300;
        changeNum(num);
        changeNum(num2);
        System.out.println(num);
        System.out.println(num2 + "\n--------------");
        System.out.println(testTry());
    }

    public static int testTry() {
        int a = 7;
        try {
            return a;
        } catch (Exception e) {

        } finally {
            a = 10;
        }
        return a;
    }

    @Test
    public void testJson() {
        Clazz clazz = new Clazz();
        clazz.setId(1L);
        clazz.setName("¶þ°à");
        clazz.setVersion(1.0);
        clazz.setCreateTime(new Date());
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1L);
        student1.setName("hsy");
        student1.setSex("ÄÐ");
        student1.setVersion(1.0);
        students.add(student1);

        Student student2 = new Student();
        student2.setId(1L);
        student2.setName("byf");
        student2.setSex("ÄÐ");
        student2.setVersion(1.0);
        students.add(student2);
        clazz.setStudentList(students);


        String clazzJsonStr = JSON.toJSONString(clazz);
        System.out.println(clazzJsonStr);

    }

    @Test
    public void testStr() {

        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str1 == str3);


        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));
        System.out.println(str1.equals(str3));
    }

}
