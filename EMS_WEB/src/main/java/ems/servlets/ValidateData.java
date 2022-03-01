package ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import module.employee;
import services.employeeServices;

public class ValidateData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String employeeMail=req.getParameter("employeeMail");
		String password=req.getParameter("pwd");
		employeeServices service=new employeeServices();
		employee emp=service.validate(employeeMail,password);
		RequestDispatcher dispatch;
		if(emp.getEmployeeId()==0) {
			out.println("<h2><font color=red>Sorry Employee not Found</font></h2>");
			dispatch=req.getRequestDispatcher("login.html");
			dispatch.include(req,resp);
			
		}
		else {
			//creating a new session object.
			HttpSession session=req.getSession();
			
			//Set attribute for the session 
			//setAttribute(key,value);
			session.setAttribute("employeeMail",emp.getEmailId());
			session.setAttribute("pwd",emp.getPassword());
			
			resp.sendRedirect("UserHome");
			
			
	}
}
}
