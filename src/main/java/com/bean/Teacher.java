package com.bean;

import java.time.LocalDateTime;

public class Teacher {
    private Integer id;
    private String name;
    private String zhicheng;
    private String mainpic;
    private LocalDateTime worktime;
    private String detail;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getZhicheng() {
        return zhicheng;
    }
    public void setZhicheng(String zhicheng) {
        this.zhicheng = zhicheng;
    }
    public String getMainpic() {
        return mainpic;
    }
    public void setMainpic(String mainpic) {
        this.mainpic = mainpic;
    }
    public LocalDateTime getWorktime() {
        return worktime;
    }
    public void setWorktime(LocalDateTime worktime) {
        this.worktime = worktime;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
