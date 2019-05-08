package com.zephyr.parser;

import java.util.Map;

import com.zephyr.annotation.BusinessLog;

public interface ContentParser {

	/**
     * @description 获取信息返回查询出的对象
     * @param feildValues 查询条件的参数值
     * @param businessLog 注解
     * @return
     */
    public Object getResult(Map<String, Object> feildValues, BusinessLog businessLog);
}
