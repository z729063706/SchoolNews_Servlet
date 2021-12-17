package com.bean;

import java.time.LocalDateTime;

public class Log {
    private String uname;
    private String action;
    private LocalDateTime time;
    public String getAction() {
        return action;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
