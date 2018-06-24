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
public class Book {
    private int ID;
    private String name;
    private String author;
    private String company;
    private String image;
    private double price;
    private int saleOff;
    private int bookTypeID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(int saleOff) {
        this.saleOff = saleOff;
    }

    public int getBookTypeID() {
        return bookTypeID;
    }

    public void setBookTypeID(int bookTypeID) {
        this.bookTypeID = bookTypeID;
    }

    public Book() {
    }

    public Book(int ID, String name, String author, String company, String image, double price, int saleOff, int bookTypeID) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.company = company;
        this.image = image;
        this.price = price;
        this.saleOff = saleOff;
        this.bookTypeID = bookTypeID;
    }
    
    
}
