package com.productDao;

import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
	
	static Connection connect;
	
	public static Connection create_connection() throws ClassNotFoundException{
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.Connection
			String url = "jdbc:mysql://127.0.0.1:3306/product_management_system";
			String user ="root";
			String password ="123456";
			
			connect = DriverManager.getConnection(url,user,password);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return connect;
	}
}
