package com.test.one;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public Connection getConnection() throws Exception{		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wartex","root","");
		return con;		
    }
}
