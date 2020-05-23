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
     * redis中key
     */
    private String key;
    /**
     * redis中值
     */
    private String value;
    /**
     * 备注
     */
    private String comment;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
