<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ page import="java.util.ArrayList,module.employee,Dao.employeeDao " %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/@popperjs/core@2">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
        
        function changeTheme(themestyle){
            var d=document.getElementById("theme");
            switch(themestyle){
                case "Black" : d.style="background-color:black";break;
                case "grey"  : d.style="background-color:grey";break;
                case "teal"  : d.style="background-color:teal";break;
            }
        }
    </script>

</head>
<body class="" id="theme">
<%@ include file="Service.jsp" %>
	<select class="m float-end col-2" onchange="changeTheme(this.value)">
      <option value="">select Theme</option>
      <option value="Black">Dark Theme</option>
      <option value="teal">Teal Theme</option>
      <option value="grey">Grey Theme</option>
    </select>
<div class="float-end col-2">
	<%
	
	
	%>
</div>
	



	<%

		ArrayList<employee> employeesList=service.getEmployees();
	%>
	
<div>


	
	<h2><a class="text-warning text-decoration-none" href="index.html">Employee Management</a></h2>
	<hr/>
	<h3 class="text-center text-secondary">Employee List</h3>
	<button class="float-end container w-25 btn btn-primary"><a href="registration.html" class="text-white">Add Employee</a></button><br><br>
		
	
	
<table class="table table-hover table-warning table-bordered border-dark table-sm container w-75">
	<tr>
		<th>EmployeeId</th>
		<th>EmployeeName</th>
		<th>EmployeeEmailId</th>
		<th>Gender</th>
		<th>Phone</th>
		<th>Salary</th>
		<th colspan="3">Actions</th>
		
	</tr>


	<%
		for(employee emp : employeesList){
	%>
<tr>
	<td><%=emp.getEmployeeId()%></td>
	<td><%=emp.getEmployeeName() %></td>
	<td><%=emp.getEmailId() %></td>
	<td><%=emp.getGender() %></td>
	<td><%=emp.getPhone() %></td>
	<td><%=emp.getSalary() %></td>
	<td><button class="btn btn-sm btn-primary">Edit</button></td>
	
	
</tr>

<%
}
%>
</table>
</div>


</body>
</html>