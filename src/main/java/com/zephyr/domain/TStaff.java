package com.zephyr.domain;

import java.io.Serializable;

import com.zephyr.annotation.Column;

public class TStaff implements Serializable {
	@Column(name = "定损员ID")
    private Integer id;
    @Column(name = "定损员手机号")
    private String staffPhone;
    @Column(name = "定损员姓名")
    private String staffName;
    @Column(name = "定损员备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}