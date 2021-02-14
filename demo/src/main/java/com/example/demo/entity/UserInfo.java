package com.example.demo.entity;

public class UserInfo {

    /** ID */
    private String  id;

    /** 名前 */
    private String name;

    /** 性別 */
    private String sex;

    /** 生年月日 */
    private String dob;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}