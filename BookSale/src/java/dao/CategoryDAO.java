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
import model.Category;
import util.Constant;

/**
 *
 * @author shadyside
 */
public class CategoryDAO {

    public boolean addCategory(String name) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        String sql = "INSERT INTO tblCategory (Name, Status) VALUE (?, ?)";

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

    public ArrayList<Category> getAllCategory() throws SQLException {

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Category> lstCategory = new ArrayList<>();
        String sql = "SELECT * FROM tblCategory";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setID(rs.getInt("ID"));
                category.setName(rs.getString("Name"));
                category.setStatus(rs.getInt("Status"));
                lstCategory.add(category);
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstCategory;
    }

    public ArrayList<Category> getActiveCategory() throws SQLException {

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Category> lstCategory = new ArrayList<>();
        String sql = "SELECT * FROM tblCategory WHERE Status = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Constant.CATEGORY_ACTIVE);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setID(rs.getInt("ID"));
                category.setName(rs.getString("Name"));
                category.setStatus(rs.getInt("Status"));
                lstCategory.add(category);
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstCategory;
    }

    public ArrayList<Category> getInActiveCategory() throws SQLException {

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Category> lstCategory = new ArrayList<>();
        String sql = "SELECT * FROM tblCategory WHERE Status = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Constant.CATEGORY_INACTIVE);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setID(rs.getInt("ID"));
                category.setName(rs.getString("Name"));
                category.setStatus(rs.getInt("Status"));
                lstCategory.add(category);
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstCategory;
    }

    public boolean changeCategoryStatus(int categoryID, int status) throws SQLException {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "UPDATE tblCategory SET Status = ? WHERE ID = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, categoryID);
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

    public boolean updateCategory(int categoryID, String name, int status) throws SQLException {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();

        PreparedStatement ps;
        ResultSet re;

        String sql = "UPDATE tblCategory "
                + "SET ID = ?, Name = ?, Status = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ps.setString(2, name);
            ps.setInt(3, status);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public Category getCategoryByID(int categorID) throws SQLException{
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
        Category category = new Category();
        
        String sql = "SELECT * FROM tblCategory WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categorID);
            rs = ps.executeQuery();
            if (rs.next()) {
                category.setID(rs.getInt("ID"));
                category.setName(rs.getString("Name"));
                category.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            conn.close();
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return category;
    }
    
    
//    public static void main(String[] args) {
//       
//        try {
//            CategoryDAO categoryDAO = new CategoryDAO();
//            Category category = categoryDAO.getCategoryByID(13);
//            System.out.println(category.getName());
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
