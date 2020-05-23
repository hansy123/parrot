package com.hsy.parrot.parameter;

import com.hsy.parrot.bean.paramter.CoParameter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ParameterDao {
    List<CoParameter> getParameter();
}
