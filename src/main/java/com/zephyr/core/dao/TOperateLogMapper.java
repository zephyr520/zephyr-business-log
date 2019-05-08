package com.zephyr.core.dao;

import com.zephyr.domain.TOperateLog;

public interface TOperateLogMapper extends BaseMapper<TOperateLog> {
    int deleteByPrimaryKey(Integer id);

    int insert(TOperateLog record);

    int insertSelective(TOperateLog record);

    int updateByPrimaryKeySelective(TOperateLog record);

    int updateByPrimaryKey(TOperateLog record);
}