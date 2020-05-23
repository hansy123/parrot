package com.hsy.parrot.bean.paramter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoParameter {
    private int id;
    /**
     * redis��key
     */
    private String key;
    /**
     * redis��ֵ
     */
    private String value;
    /**
     * ��ע
     */
    private String comment;
    /**
     * ����ʱ��
     */
    private Date createTime;
    /**
     * ����ʱ��
     */
    private Date updateTime;

}
