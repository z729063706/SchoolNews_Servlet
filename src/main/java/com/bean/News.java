package com.bean;

import java.util.Date;
import java.time.LocalDateTime;
public class News {
    private int id;
    private String title;
    private String pic;
    private String content;
    private String shortContent;
    private Integer type;
    private String auther;
    private LocalDateTime creatTime;
    private LocalDateTime updateTime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getShortContent() {
        return shortContent;
    }
    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getAuther() {
        return auther;
    }
    public void setAuther(String auther) {
        this.auther = auther;
    }

    public LocalDateTime getCreatTime() {
        return creatTime;
    }
    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public News() {}
    public News(String title) {
        this.title = title;
    }

}
