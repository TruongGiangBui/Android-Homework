package com.example.myapplication;

public class Email {
    private String name;
    private String content;
    private String time;
    private String avatar;

    public Email(String name, String content, String time, String avatar) {
        this.name = name;
        this.content = content;
        this.time = time;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Email{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Email() {
    }
}
