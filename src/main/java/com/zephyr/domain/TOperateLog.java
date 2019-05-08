package com.zephyr.domain;

import java.io.Serializable;

import com.zephyr.annotation.Column;

public class TOperateLog implements Serializable {
    private Integer id;
    @Column(name = "操作人")
    private String userName;
    @Column(name = "操作日期")
    private String modifyDate;
    @Column(name = "操作名词")
    private String modifyName;
    @Column(name = "操作对象")
    private String modifyObject;
    @Column(name = "操作内容")
    private String modifyContent;
    @Column(name = "操作IP")
    private String modifyIp;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyName() {
        return modifyName;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public String getModifyObject() {
        return modifyObject;
    }

    public void setModifyObject(String modifyObject) {
        this.modifyObject = modifyObject;
    }

    public String getModifyContent() {
        return modifyContent;
    }

    public void setModifyContent(String modifyContent) {
        this.modifyContent = modifyContent;
    }

    public String getModifyIp() {
        return modifyIp;
    }

    public void setModifyIp(String modifyIp) {
        this.modifyIp = modifyIp;
    }
}