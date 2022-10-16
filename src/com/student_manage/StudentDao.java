package com.student_manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean  insertStudentToDB(Student st)	{
		boolean f=false;
		try {

			//jdbc code		
			Connection con=connectionprovier.createConnection();
			String a="insert into students(sname,sphone,scity) values(?,?,?)";
			
			//prepared Statement
			 PreparedStatement ps=con.prepareStatement(a);
			 
			 //set the value of parameter
			 ps.setString(1, st.getStudentname());
			 ps.setString(2, st.getStudentphone());
			 ps.setString(3, st.getStudentcity());
			 
			 //execute..
			 ps.executeUpdate();
			 f=true;
			 
			 
		}catch(Exception e) {
			//to handle exception
			e.printStackTrace();
		}
		return f;
		
		
	}
public static  boolean deleteStudent(int userId) {
	boolean f=false;
	try {

		//jdbc code		
		Connection con=connectionprovier.createConnection();
		String a="delete from students where sid=?";
		
		//prepared Statement
		 PreparedStatement ps=con.prepareStatement(a);
		 
		 //set the value of parameter
		 ps.setInt(1, userId);
		
		 
		 //execute..
		 ps.executeUpdate();
		 f=true;
		 
		 
	}catch(Exception e) {
		//to handle exception
		e.printStackTrace();
	}
	return f;
	
}
public static boolean showAllStudent() {
	// TODO Auto-generated method stub
	boolean f=false;
	try {

		//jdbc code		
		Connection con=connectionprovier.createConnection();
		String a="select * from students";
		
		//Statement
		 Statement ps=con.createStatement();
		 
		ResultSet set=ps.executeQuery(a);
		
		while(set.next())
		{
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString("scity");
			
			System.out.println("ID : "+id);
			System.out.println("Name : "+name);
			System.out.println("Phone : "+phone);
			System.out.println("City : "+city);
			System.out.println("----------------------------------------------------");
		}
		 
	}catch(Exception e) {
		//to handle exception
		e.printStackTrace();
	}
	return f;
}
}

