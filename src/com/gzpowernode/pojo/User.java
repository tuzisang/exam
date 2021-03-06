package com.gzpowernode.pojo;

/**
 * @author tzsang
 * @create 2022-04-22 9:09
 */
public class User {
    private int id;
    private String username;
    private String name;
    private String pwd;
    private String gender;

    public User() {
    }

    public User(int id, String username, String name, String pwd, String gender) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.pwd = pwd;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
