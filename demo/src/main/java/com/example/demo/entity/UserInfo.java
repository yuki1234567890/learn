package com.example.demo.entity;

public class UserInfo {

    /** ID */
    private String  id;

    /** 名前 */
    private String name;

    /** 性別 */
    private String sex;

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}