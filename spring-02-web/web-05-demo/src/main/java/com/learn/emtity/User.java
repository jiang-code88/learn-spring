package com.learn.emtity;

import java.util.Arrays;
import java.util.Date;

public class User {

    private String id;

    private String username;

    private String name;

    private Date birthday;

    private byte[] photo;

    private Department department;

    public User(String id, String username, String name, Date birthday, byte[] photo, Department department) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.birthday = birthday;
        this.photo = photo;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", photo=" + Arrays.toString(photo) +
                ", department=" + department +
                '}';
    }
}