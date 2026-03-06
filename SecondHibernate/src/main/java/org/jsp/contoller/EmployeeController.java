package org.jsp.contoller;

import org.jsp.dao.EmployeeDao;
import org.jsp.dto.Employee;

public class EmployeeController {
	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setEmpid(102);
		employee.setEname("yashwant");
		employee.setEmail("yash@janu.in");
		employee.setPasswod("Janu@ThanaThayaKya");
		employee.setNumber(9143143143L);
		employee.setAddress("Uppal");
		
		EmployeeDao dao=new EmployeeDao();
//		dao.saveEmployee(employee);
//		dao.findEmployeeByEmail("yash@janu.in");
//		dao.updateNameByEmail("yash@janu.in", "Janu" );
		dao.findAllEmployees();
	}
}
