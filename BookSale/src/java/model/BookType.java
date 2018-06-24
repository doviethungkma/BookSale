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
public class BookType {
    private int ID;
    private String name;
    private int categoryID;

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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public BookType() {
    }

    public BookType(int ID, String name, int categoryID) {
        this.ID = ID;
        this.name = name;
        this.categoryID = categoryID;
    }
    
    
}
