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
public class Password {
    private int ID;
    private String password;
    private String dateCreated;
    private String Salt;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String Salt) {
        this.Salt = Salt;
    }

    public Password() {
    }

    public Password(int ID, String password, String dateCreated, String Salt) {
        this.ID = ID;
        this.password = password;
        this.dateCreated = dateCreated;
        this.Salt = Salt;
    }
    
    
}
