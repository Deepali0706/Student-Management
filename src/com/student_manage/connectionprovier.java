package com.student_manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionprovier {
	
	static Connection con;
	
	public static Connection createConnection() {
		
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//create the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","root");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	return con;
		
	}

}
