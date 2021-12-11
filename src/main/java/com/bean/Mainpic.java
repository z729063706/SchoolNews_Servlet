package com.bean;

import java.time.LocalDateTime;

public class Mainpic {
    private Integer id;
    private String url;
    private String content;
    private boolean vaild;
    private LocalDateTime insettime;
    public Integer getId() {
        return id;
    }
    public LocalDateTime getInsettime() {
        return insettime;
    }
    public void setInsettime(LocalDateTime insettime) {
        this.insettime = insettime;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isVaild() {
        return vaild;
    }
    public void setVaild(boolean vaild) {
        this.vaild = vaild;
    }
    
}
