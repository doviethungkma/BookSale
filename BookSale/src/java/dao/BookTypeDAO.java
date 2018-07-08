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
import model.BookType;
import util.Constant;

/**
 *
 * @author shadyside
 */
public class BookTypeDAO {
        public boolean addBookType(String name) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        String sql = "INSERT INTO tblBookType (Name, Status) VALUE (?, ?)";

        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, Constant.CATEGORY_ACTIVE);
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

    public ArrayList<BookType> getAllBookType() throws SQLException {

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<BookType> lstBookType = new ArrayList<>();
        String sql = "SELECT * FROM tblBookType";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookType bookType = new BookType();
                bookType.setID(rs.getInt("ID"));
                bookType.setName(rs.getString("Name"));
                bookType.setCategoryID(rs.getInt("CategoryID"));
                bookType.setStatus(rs.getInt("Status"));
                lstBookType.add(bookType);
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstBookType;
    }

    public ArrayList<BookType> getActiveBookType() throws SQLException {

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<BookType> lstBookType = new ArrayList<>();
        String sql = "SELECT * FROM tblBookType WHERE Status = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Constant.CATEGORY_ACTIVE);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookType bookType = new BookType();
                bookType.setID(rs.getInt("ID"));
                bookType.setName(rs.getString("Name"));
                bookType.setCategoryID(rs.getInt("CategoryID"));
                bookType.setStatus(rs.getInt("Status"));
                lstBookType.add(bookType);
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstBookType;
    }

    public ArrayList<BookType> getInActiveBookType() throws SQLException {

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<BookType> lstBookType = new ArrayList<>();
        String sql = "SELECT * FROM tblBookType WHERE Status = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Constant.CATEGORY_INACTIVE);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookType bookType = new BookType();
                bookType.setID(rs.getInt("ID"));
                bookType.setName(rs.getString("Name"));
                bookType.setCategoryID(rs.getInt("CategoryID"));
                bookType.setStatus(rs.getInt("Status"));
                lstBookType.add(bookType);
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstBookType;
    }

    public boolean changeBookTypeStatus(int bookTypeID, int status) throws SQLException {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "UPDATE tblBookType SET Status = ? WHERE ID = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, bookTypeID);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean updateBookType(int bookTypeID, String name, int categoryID, int status) throws SQLException {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet re;

        String sql = "UPDATE tblBookType "
                + "SET ID = ?, Name = ?, CategoryID = ?, Status = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bookTypeID);
            ps.setString(2, name);
            ps.setInt(3, categoryID);
            ps.setInt(4, status);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public BookType getBookTypeByID(int categorID) throws SQLException{
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
        BookType bookType = new BookType();
        
        String sql = "SELECT * FROM tblBookType WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categorID);
            rs = ps.executeQuery();
            if (rs.next()) {
                bookType.setID(rs.getInt("ID"));
                bookType.setName(rs.getString("Name"));
                bookType.setCategoryID(rs.getInt("CategoryID"));
                bookType.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return bookType;
    }
}
