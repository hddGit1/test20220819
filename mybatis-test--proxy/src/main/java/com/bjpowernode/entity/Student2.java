package com.bjpowernode.entity;

public class Student2 {
    private Integer num;
    private String user;
    private Integer date;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "num=" + num +
                ", user='" + user + '\'' +
                ", date=" + date +
                '}';
    }
}
