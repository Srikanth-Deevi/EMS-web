package ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import module.employee;
import services.employeeServices;

public class GetData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String ename= req.getParameter("ename");
		String email= req.getParameter("email");
		String gender=req.getParameter("gender");
		long phone = Long.parseLong(req.getParameter("phone"));
		int salary = Integer.parseInt(req.getParameter("salary"));
		String password = req.getParameter("password");
		
		employee emp=new employee();
		emp.setEmployeeName(ename);
		emp.setEmailId(email);
		emp.setGender(gender);
		emp.setPhone(phone);
		emp.setSalary(salary);
		emp.setPassword(password);
		
		employeeServices service=new employeeServices();
		boolean result=service.addEmployee(emp);
		if(result) {
			out.println("Employee unable to added");
		}
		else {
			resp.sendRedirect("login.html");
		}		
	}
}
