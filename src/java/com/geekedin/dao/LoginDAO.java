/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.dao;

import com.geekedin.login.Login;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class LoginDAO extends DatabaseConnector
{
    public int addUser(Login login) throws SQLException
    {
        String sql = "INSERT INTO tbllogin(id, username, password) VALUES("+login.getId()+", '"+login.getUsername()+"', '"+login.getPassword()+"')";
        return statement.executeUpdate(sql);
    }
    
    public Login validate(String username, String password) throws SQLException
    {
        Login login = null;
        
        String sql = "SELECT * FROM tbllogin WHERE username = '"+username+"' AND password = '"+password+"'";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            login = new Login(rs.getInt(1), rs.getString(2), rs.getString(3));
        }
        
        return login;
    }
}
