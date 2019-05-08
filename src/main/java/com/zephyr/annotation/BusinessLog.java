package com.zephyr.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zephyr.core.dao.BaseMapper;
import com.zephyr.parser.DefaultParser;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BusinessLog {
	
	/**
	 *  操作中文说明
	 * @return
	 */
	String name() default "";
	
	/**
	 * 	获取编辑信息的解析类，目前为使用id获取，复杂的解析需要自己实现，默认不填写
     * 	则使用默认解析类
     * @return
     */
	Class<?> parseClass() default DefaultParser.class;
	
	Class<?> serviceClass() default BaseMapper.class;
	
	/**
	 * 	字段名
	 * @return
	 */
	String[] fieldName() default {"id"};
	
	String handleName() default "";
	
}