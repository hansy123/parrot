package com.hsy.parrot.bean.clazz;

import com.hsy.parrot.bean.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/25 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz implements Serializable {
    private static final long serialVersionUID = 8296369557942237489L;
    /**
     * 主键
     */
    private long id;
    /**
     * 班级名
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 版本号
     */
    private double version;

    /**
     * 学生列表
     */
    private List<Student> studentList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public double getVersion() {
        return version;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
