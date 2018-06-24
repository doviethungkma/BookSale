/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author shadyside
 */
public class UserInfor {

    private int ID;
    private int loginID;
    private String fullName;
    private String DoB;
    private String address;
    private int sex;
    private String phone;
    private String avatar;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String DoB) {
        this.DoB = DoB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UserInfor() {
    }

    public UserInfor(int ID, int loginID, String fullName, String DoB, String address, int sex, String phone, String avatar) {
        this.ID = ID;
        this.loginID = loginID;
        this.fullName = fullName;
        this.DoB = DoB;
        this.address = address;
        this.sex = sex;
        this.phone = phone;
        this.avatar = avatar;
    }

}
