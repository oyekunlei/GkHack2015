/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class DatabaseConnector 
{
    protected Connection connection;
    protected Statement statement;

    public void open(String usn, String pswd, String url) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, usn, pswd);
        statement = connection.createStatement();
    }
    
    public void close() throws SQLException
    {
        statement.close();
        connection.close();
    }
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    
}
