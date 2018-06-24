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
public class Invoice {
    private int ID;
    private int productID;
    private int quantity;
    private int invoiceDetail;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(int invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }

    public Invoice() {
    }

    public Invoice(int ID, int productID, int quantity, int invoiceDetail) {
        this.ID = ID;
        this.productID = productID;
        this.quantity = quantity;
        this.invoiceDetail = invoiceDetail;
    }
    
    
}
