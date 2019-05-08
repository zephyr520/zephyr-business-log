package com.zephyr.core.dao;

import java.io.Serializable;

public interface BaseMapper<T> {

	T selectByPrimaryKey(Serializable id);
}
