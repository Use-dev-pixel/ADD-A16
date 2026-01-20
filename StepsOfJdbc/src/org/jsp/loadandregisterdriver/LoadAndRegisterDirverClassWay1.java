package org.jsp.loadandregisterdriver;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class LoadAndRegisterDirverClassWay1 {
	public static void main(String[] args) {
		try {
			Driver driver =new Driver();//load Driver class
			DriverManager.registerDriver(driver);// register driver class
			
			System.out.println("Driver class loaded");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
