package com.mengfanliang.mapper;

import com.mengfanliang.entity.SpecParam;
import com.mengfanliang.entity.SpecParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecParamMapper {
    long countByExample(SpecParamExample example);

    int deleteByExample(SpecParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpecParam record);

    int insertSelective(SpecParam record);

    List<SpecParam> selectByExample(SpecParamExample example);

    SpecParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecParam record, @Param("example") SpecParamExample example);

    int updateByExample(@Param("record") SpecParam record, @Param("example") SpecParamExample example);

    int updateByPrimaryKeySelective(SpecParam record);

    int updateByPrimaryKey(SpecParam record);
}