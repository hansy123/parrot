package com.hsy.parrot.clazz.dao;

import com.hsy.parrot.bean.clazz.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/25 18:00
 */
@Mapper
@Repository
public interface ClazzMapper {

    Clazz getClazzById(@Param("id") Integer id);
}
