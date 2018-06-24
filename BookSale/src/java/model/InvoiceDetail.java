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
public class InvoiceDetail {
    private int ID;
    private String dateCreated;
    private String lastChangeDate;
    private int status;
    private String customerName;
    private String phone;
    private String email;
    private String address;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(String lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public InvoiceDetail() {
    }

    public InvoiceDetail(int ID, String dateCreated, String lastChangeDate, int status, String customerName, String phone, String email, String address) {
        this.ID = ID;
        this.dateCreated = dateCreated;
        this.lastChangeDate = lastChangeDate;
        this.status = status;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    
    
}
