package org.jsp.loadandregisterdriver;

public class LoadAndRegisterDirverClassWay2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Load and register driver class");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
