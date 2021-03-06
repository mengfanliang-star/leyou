package com.mengfanliang.mapper;

import com.mengfanliang.entity.Spu;
import com.mengfanliang.entity.SpuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuMapper {
    long countByExample(SpuExample example);

    int deleteByExample(SpuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Spu record);

    int insertSelective(Spu record);

    List<Spu> selectByExample(SpuExample example);

    Spu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Spu record, @Param("example") SpuExample example);

    int updateByExample(@Param("record") Spu record, @Param("example") SpuExample example);

    int updateByPrimaryKeySelective(Spu record);

    int updateByPrimaryKey(Spu record);
}