package com.formssi.third.mapper;

import com.formssi.third.model.BmsBusiness;
import com.formssi.third.model.BmsBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2020/06/12
*/
public interface BmsBusinessMapper {
    long countByExample(BmsBusinessExample example);

    int deleteByExample(BmsBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BmsBusiness record);

    int insertSelective(BmsBusiness record);

    List<BmsBusiness> selectByExample(BmsBusinessExample example);

    BmsBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BmsBusiness record, @Param("example") BmsBusinessExample example);

    int updateByExample(@Param("record") BmsBusiness record, @Param("example") BmsBusinessExample example);

    int updateByPrimaryKeySelective(BmsBusiness record);

    int updateByPrimaryKey(BmsBusiness record);
}