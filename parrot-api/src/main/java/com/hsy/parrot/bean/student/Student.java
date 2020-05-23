package com.hsy.parrot.bean.student;

import com.hsy.parrot.bean.clazz.Clazz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/25 15:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 4682657530287759712L;
    /**
     * student主键
     */
    private long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 1男2女
     */
    private String sex;
    /**
     * 年龄阶段 幼年，同年etc
     */
    private String ageStage;
    /**
     * 班级id
     */
    private int clazzId;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 班级信息
     */
    private Clazz clazzObj;

    /**
     * 版本号
     */
    private double version;
}
