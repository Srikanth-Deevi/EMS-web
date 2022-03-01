package ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import module.employee;

import services.employeeServices;

public class GetEmployees extends HttpServlet {
	employeeServices service= new employeeServices();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		ArrayList<employee> employeesList=service.getEmployees();
		
		out.println("<head>");
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\""+"rel=stylesheet");
		out.println("<script src=\"https://unpkg.com/@popperjs/core@2\"></script>");
		out.println("<script src= \"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>");
		out.println("</head>");
		
		out.println("<body class=\"bg-secodary\">");
		
		out.println("<h3 class=\"text-center text-success mt-3 \">Employees Table </h3>");
		out.println("<div>");
		out.println("<table class=\"table table-dark table-hover table-striped\" >");
		out.println("<tr class=\"fs-4\"><th class=\"text-warning\">Employee_Id</th><th class=\"text-warning\"=>Employee_Name</th><th class=\"text-warning\">Email_Id</th><th class=\"text-warning\">Gender</th><th class=\"text-warning\">Phone</th><th class=\"text-warning\">salary</th><th class=\"text-warning\">Password</th> <th></th></tr>");

		for(employee emp : employeesList) {
			out.println("<tr class=\"bg-dark\">");
			out.println("<td>"+emp.getEmployeeId()+"</td>");
			out.println("<td>"+emp.getEmployeeName()+"</td>");
			out.println("<td>"+emp.getEmailId()+"</td>");
			out.println("<td>"+emp.getGender()+"</td>");
			out.println("<td>"+emp.getPhone()+"</td>");
			out.println("<td>"+emp.getSalary()+"</td>");
			out.println("<td>"+emp.getPassword()+"</td>");
			out.println("<td><button class=\"btn btn-primary\">Edit</button></td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</div>");
		out.println("</body");
		
		
	}
	}
