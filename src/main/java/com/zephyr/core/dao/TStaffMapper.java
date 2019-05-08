package com.zephyr.core.dao;

import com.zephyr.domain.TStaff;

public interface TStaffMapper extends BaseMapper<TStaff> {
    int deleteByPrimaryKey(Integer id);

    int insert(TStaff record);

    int insertSelective(TStaff record);

    int updateByPrimaryKeySelective(TStaff record);

    int updateByPrimaryKey(TStaff record);
}