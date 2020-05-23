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
     * student����
     */
    private long id;
    /**
     * ����
     */
    private String name;
    /**
     * ����
     */
    private Integer age;
    /**
     * 1��2Ů
     */
    private String sex;
    /**
     * ����׶� ���꣬ͬ��etc
     */
    private String ageStage;
    /**
     * �༶id
     */
    private int clazzId;
    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * �༶��Ϣ
     */
    private Clazz clazzObj;

    /**
     * �汾��
     */
    private double version;
}
