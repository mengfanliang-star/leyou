package com.mengfanliang.mapper;

import com.mengfanliang.entity.SpecGroup;
import com.mengfanliang.entity.SpecGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecGroupMapper {
    long countByExample(SpecGroupExample example);

    int deleteByExample(SpecGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpecGroup record);

    int insertSelective(SpecGroup record);

    List<SpecGroup> selectByExample(SpecGroupExample example);

    SpecGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecGroup record, @Param("example") SpecGroupExample example);

    int updateByExample(@Param("record") SpecGroup record, @Param("example") SpecGroupExample example);

    int updateByPrimaryKeySelective(SpecGroup record);

    int updateByPrimaryKey(SpecGroup record);
}