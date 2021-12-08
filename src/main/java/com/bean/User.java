package com.bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private int uid;
    private String uname;
    private String upass;
    private String name;
    private Integer utype;
    private LocalDateTime regtime;
    private Boolean isChild;
    public Boolean getIsChild() {
        return isChild;
    }
    public void setIsChild(Boolean isChild) {
        this.isChild = isChild;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUpass() {
        return upass;
    }
    public void setUpass(String upass) {
        this.upass = upass;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getUtype() {
        return utype;
    }
    public void setUtype(Integer utype) {
        this.utype = utype;
    }
    public LocalDateTime getRegtime() {
        return regtime;
    }
    public void setRegtime(LocalDateTime regtime) {
        this.regtime = regtime;
    }

    
}



