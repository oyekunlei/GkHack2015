/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.dao;

import com.geekedin.category.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author user
 */
public class CategoryDAO extends DatabaseConnector
{
    public Vector<Category> getCategories() throws SQLException
    {
        Vector<Category> categories = new Vector<Category>();
        
        String sql = "SELECT * FROM tblcategory";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            categories.add(new Category(rs.getInt(1), rs.getString(2)));
        }
        
        return categories;
    }
    
    public Category getCategory(int categoryId) throws SQLException
    {
        Category category = null;
        
        String sql = "SELECT * FROM tblcategory WHERE id =" + categoryId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            category = new Category(rs.getInt(1), rs.getString(2));
        }
        
        return category;
    }
}
