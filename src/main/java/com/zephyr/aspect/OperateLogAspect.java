package com.zephyr.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.zephyr.annotation.BusinessLog;
import com.zephyr.core.dao.TOperateLogMapper;
import com.zephyr.domain.TOperateLog;
import com.zephyr.parser.ContentParser;
import com.zephyr.util.ReflectionUtils;

@Aspect
@Component
public class OperateLogAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OperateLogAspect.class);
	
	private TOperateLog operateLog = new TOperateLog();
	
	private Object oldObject;

	private Object newObject;

	private Map<String, Object> fieldValues;

	@Autowired
	private TOperateLogMapper operateLogMapper;

	@Before("@annotation(businessLog)")
	public void doBefore(JoinPoint joinPoint, BusinessLog businessLog) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		Object args = joinPoint.getArgs()[0];
		String[] fields = businessLog.fieldName();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		operateLog.setUserName("zhangsan");
		operateLog.setModifyIp("127.0.0.1");
		operateLog.setModifyDate(sdf.format(new Date()));
		String handelName = businessLog.handleName();
		if ("".equals(handelName)) {
			operateLog.setModifyObject(request.getRequestURL().toString());
		} else {
			operateLog.setModifyObject(handelName);
		}
		operateLog.setModifyName(businessLog.name());
		operateLog.setModifyContent("");
		if ("修改".equals(businessLog.name())) {
			for (String field : fields) {
				fieldValues = new HashMap<>();
				Object result = ReflectionUtils.getFieldValue(args, field);
				fieldValues.put(field, result);
			}
			try {
				ContentParser contentParser = (ContentParser) businessLog.parseClass().newInstance();
				oldObject = contentParser.getResult(fieldValues, businessLog);
			} catch (Exception e) {
				LOGGER.error("service加载失败:", e);
			}
		} else {
			if ("修改".equals(businessLog.name())) {
				LOGGER.error("id查询失败，无法记录日志");
			}
		}
		LOGGER.info("doBefore Operate Log : {}", JSON.toJSONString(operateLog));
	}
	
	@AfterReturning(pointcut = "@annotation(businessLog)",returning = "object")
    public void doAfterReturing(Object object, BusinessLog businessLog){
        if("修改".equals(businessLog.name())){
            ContentParser contentParser= null;
            try {
                contentParser = (ContentParser) businessLog.parseClass().newInstance();
                newObject=contentParser.getResult(fieldValues,businessLog);
            } catch (Exception e) {
                LOGGER.error("service加载失败:",e);
            }

            try {
                List<Map<String ,Object>> changelist= ReflectionUtils.compareTwoClass(oldObject,newObject);
                StringBuilder str=new StringBuilder();
                for(Map<String,Object> map:changelist){
                    str.append("【"+map.get("name")+"】从【"+map.get("old")+"】改为了【"+map.get("new")+"】;\n");
                }
                operateLog.setModifyContent(str.toString());

            } catch (Exception e) {
                LOGGER.error("比较异常",e);
            }
        }
        LOGGER.info("doAfterReturing Operate Log : {}", JSON.toJSONString(operateLog));
        operateLogMapper.insertSelective(operateLog);
    }
}
