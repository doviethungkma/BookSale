
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

/**
 *
 * @author shadyside
 */
public class BookDAO {

    public ArrayList<Book> getAllBook() {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        String sql = "SELECT * FROM tblBook";
        ArrayList<Book> lstAllBook = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setID(rs.getInt("ID"));
                book.setName(rs.getString("Name"));
                book.setAuthor(rs.getString("Author"));
                book.setCompany(rs.getString("Company"));
                book.setDescription(rs.getString("Description"));
                book.setImage(rs.getString("Image"));
                book.setPrice(rs.getDouble("Price"));
                book.setSaleOff(rs.getInt("SaleOff"));
                book.setBookTypeID(rs.getInt("BookTypeID"));
                lstAllBook.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAllBook;
    }
    
     public Book getBookByID(int ID){
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        String sql = "SELECT * FROM tblBook WHERE ID = ?";
        Book book = new Book();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                book.setID(rs.getInt("ID"));
                book.setName(rs.getString("Name"));
                book.setAuthor(rs.getString("Author"));
                book.setCompany(rs.getString("Company"));
                book.setDescription(rs.getString("Description"));
                book.setImage(rs.getString("Image"));
                book.setPrice(rs.getDouble("Price"));
                book.setSaleOff(rs.getInt("SaleOff"));
                book.setBookTypeID(rs.getInt("BookTypeID"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }
    
    public static void main(String[] args) {
        ArrayList<Book> lst = new BookDAO().getAllBook();
        System.out.println(lst.size());
    }
}
