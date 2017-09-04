<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT Asset Manager</title>
<link rel="stylesheet" href="CSS/style.css" type="text/css">

</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="wrapper">
		<h3>Add Printer</h3>
		
		<p style="color: red;">${errorString}</p>
		<form action="${pageContext.request.contextPath}/addprinter"
			method="post">
			<table border="1">
				<tr>
					<th>Make</th>
					<th>Model</th>
					<th>Hostname</th>
					<th>IP address</th>
					<th>S/N</th>
					<th>Department</th>
					<th>Add</th>
				</tr>

				

					<tr>
						<td><input type="text" name="make" ></td>
						<td><input type="text" name="model"></td>
						<td><input type="text" name="hostname"></td>
						<td><input type="text" name="ip_address"></td>
						<td><input type="text" name="serial_number"></td>
						<td><input type="text" name="department"></td>
						<td><button type="submit" name="addprinter"
							value="addprinter">Add Pinter</button></td>

					</tr>

				

			</table>
		</form>
	</div>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>