package com.aps.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long syskey;
    private String title;
    private String content;
    private long userid;
    private int recordstatus;
    private String createddate;
    private String modifieddate;

    public Blog(){

    }
    public Blog(long syskey, String title, String content, String createddate, String modifieddate) {
        this.syskey = syskey;
        this.title = title;
        this.content = content;
        this.createddate = createddate;
        this.modifieddate = modifieddate;
    }

    public long getSyskey() {
        return syskey;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setSyskey(long syskey) {
        this.syskey = syskey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRecordstatus() {
        return recordstatus;
    }

    public void setRecordstatus(int recordstatus) {
        this.recordstatus = recordstatus;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(String modifieddate) {
        this.modifieddate = modifieddate;
    }
}
