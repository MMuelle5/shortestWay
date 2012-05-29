package com.mima.db.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DriverManagerDAOFactory extends DAOFactory {
    private String url;
    private String username;
    private String password;

    public DriverManagerDAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        Connection con = null;
        
		con = DriverManager.getConnection(url, username, password);
		
        
        return con;
    }
}

