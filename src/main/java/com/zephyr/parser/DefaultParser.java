package com.zephyr.parser;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zephyr.annotation.BusinessLog;
import com.zephyr.core.dao.BaseMapper;
import com.zephyr.util.SpringUtil;

public class DefaultParser implements ContentParser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultParser.class);

	@Override
	public Object getResult(Map<String, Object> feildValues, BusinessLog businessLog) {
		Object result= feildValues.get("id");
        Integer id=0;
        if(result instanceof String){
            id= Integer.parseInt((String) result);

        }else if(result instanceof Integer){
            id= (Integer) result;
        }
        Class<?> clazz = businessLog.serviceClass();
        BaseMapper<?> mapper = (BaseMapper<?>) SpringUtil.getBean(clazz);
        LOGGER.info("serviceClass : {}", clazz.getName());
		return mapper.selectByPrimaryKey(id);
	}

}
