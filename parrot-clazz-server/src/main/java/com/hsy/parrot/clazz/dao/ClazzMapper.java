package com.hsy.parrot.clazz.dao;

import com.hsy.parrot.bean.clazz.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClazzMapper {
    List<Clazz> getClazzList();

    void insertClazz(@Param("clazz") Clazz clazz);

    Clazz getClazzById(@Param("clazzId") long clazzId);
}
