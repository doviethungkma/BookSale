
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
import model.Category;
import util.Constant;

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
                book.setStatus(rs.getInt("Status"));
                lstAllBook.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAllBook;
    }

    public Book getBookByID(int ID) {
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
                book.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }

    public boolean addBook(String name, String author, String company,
            String description, String image, double price, int saleOff, int bookTypeID, int status) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        String sql = "INSERT INTO tblBooK "
                + "(Name, Author, Company, Description, Image, Price, Saleff, BookTypeID) "
                + "VALUE (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, author);
            ps.setString(3, company);
            ps.setString(4, description);
            ps.setString(5, image);
            ps.setDouble(6, price);
            ps.setInt(7, saleOff);
            ps.setInt(8, bookTypeID);
            ps.setInt(9, status);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    public boolean addBookType(String name, int categoryID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        String sql = "INSERT INTO tblBookType "
                + "(Name, CategoryID) "
                + "VALUE (?, ?)";

        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, categoryID);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
//        System.out.println(bookDAO.addCategory("Test"));
        System.out.println(bookDAO.addBookType("Test", 12));

    }
}

