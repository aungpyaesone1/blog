package com.aps.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Account_User")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long syskey;
    private String username;
    private String password;
    private String phone;
    private int recordstatus;
    private String createddate;
    private String modifieddate;
    public User(){

    }

    public User(long id, String username, String password, String phone, int recordstatus, String createddate, String modifieddate) {
        this.syskey = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.recordstatus = recordstatus;
        this.createddate = createddate;
        this.modifieddate = modifieddate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getSyskey() {
        return syskey;
    }

    public void setSyskey(long syskey) {
        this.syskey = syskey;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
