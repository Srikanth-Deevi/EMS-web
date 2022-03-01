package ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import module.employee;
import services.employeeServices;


public class UserHome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		HttpSession session = req.getSession();
		
		//getAttrbute(key) is used to get the data.
		String mail=session.getAttribute("employeeMail").toString();
		String password=session.getAttribute("pwd").toString();
		
		employeeServices service=new employeeServices();
		employee emp=service.validate(mail,password);
		out.println("<h2 style=background-color:black;color:white;text-align:right>");
		out.println("Welcome "+emp.getEmployeeName());
		out.println("</h2>");
		out.println("<br>");
		out.println("This is "+emp.getEmployeeName()+" Employee Details :- <br> ");
		out.println(emp.getEmployeeId());
		out.println(emp.getEmployeeName());
		out.println(emp.getEmailId());
		out.println(emp.getGender());
		out.println(emp.getPhone());
		out.println(emp.getSalary());
		
		resp.sendRedirect("index.jsp");
		
		
	}
}
