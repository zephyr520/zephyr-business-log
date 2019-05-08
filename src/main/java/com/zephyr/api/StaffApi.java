package com.zephyr.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.zephyr.annotation.BusinessLog;
import com.zephyr.core.dao.TStaffMapper;
import com.zephyr.dto.StaffReqDTO;
import com.zephyr.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffApi {

	@Autowired
	private StaffService staffService;
	
	@PostMapping("/modify")
	@BusinessLog(name = "修改", serviceClass=TStaffMapper.class)
	public void modifyStaff(@RequestBody StaffReqDTO reqDto) {
		staffService.modifyStaff(reqDto);
	}
}
