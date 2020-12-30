package com.formssi.third.mapper;

import com.formssi.third.model.DfypParams;
import com.formssi.third.model.DfypParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2020/08/21
*/
public interface DfypParamsMapper {
    long countByExample(DfypParamsExample example);

    int deleteByExample(DfypParamsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DfypParams record);

    int insertSelective(DfypParams record);

    List<DfypParams> selectByExample(DfypParamsExample example);

    DfypParams selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DfypParams record, @Param("example") DfypParamsExample example);

    int updateByExample(@Param("record") DfypParams record, @Param("example") DfypParamsExample example);

    int updateByPrimaryKeySelective(DfypParams record);

    int updateByPrimaryKey(DfypParams record);
}