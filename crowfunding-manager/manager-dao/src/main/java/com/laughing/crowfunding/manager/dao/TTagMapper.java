package com.laughing.crowfunding.manager.dao;

import com.laughing.crowfunding.manager.bean.TTag;
import com.laughing.crowfunding.manager.bean.TTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTagMapper {
    long countByExample(TTagExample example);

    int deleteByExample(TTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTag record);

    int insertSelective(TTag record);

    List<TTag> selectByExample(TTagExample example);

    TTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTag record, @Param("example") TTagExample example);

    int updateByExample(@Param("record") TTag record, @Param("example") TTagExample example);

    int updateByPrimaryKeySelective(TTag record);

    int updateByPrimaryKey(TTag record);
}