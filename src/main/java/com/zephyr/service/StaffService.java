package com.zephyr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zephyr.core.dao.TStaffMapper;
import com.zephyr.domain.TStaff;
import com.zephyr.dto.StaffReqDTO;

@Service
public class StaffService {

	@Autowired
	private TStaffMapper staffMapper;
	
	public void modifyStaff(StaffReqDTO reqDto) {
		TStaff oldRecord = staffMapper.selectByPrimaryKey(reqDto.getId());
		if (oldRecord == null) {
			throw new RuntimeException("定损员不存在");
		}
		TStaff record = new TStaff();
		record.setId(reqDto.getId());
		record.setStaffName(reqDto.getStaffName());
		record.setStaffPhone(reqDto.getStaffPhone());
		int updateRow = staffMapper.updateByPrimaryKeySelective(record);
		if(updateRow < 1) {
			throw new RuntimeException("修改定损员信息异常");
		}
	}
}
