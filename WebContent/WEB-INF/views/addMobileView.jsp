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
		<h3>Add Mobile</h3>
		
		<p style="color: red;">${errorString}</p>
		<form action="${pageContext.request.contextPath}/addmobile"
			method="post">
			<table border="1">
				<tr>
					<th>Make</th>
					<th>Model</th>
					<th>IMEI</th>
					<th>Mobile S/N</th>
					<th>Provider</th>
					<th>SIM S/N</th>
					<th>Mobile number</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Department</th>
					<th>Add</th>
					

				</tr>

				

					<tr>
						<td><input type="text" name="make" ></td>
						<td><input type="text" name="model"></td>
						<td><input type="text" name="imei"></td>
						<td><input type="text" name="serial_number"></td>
						<td><input type="text" name="provider"></td>
						<td><input type="text" name="sim_serial_number"></td>
						<td><input type="text" name="mobile_number"></td>
						<td><input type="text" name="first_name"></td>
						<td><input type="text" name="last_name"></td>
						<td><input type="text" name="department"></td>
						<td><button type="submit" name="addMobile"
							value="add_mobile">Add mobile</button></td>

					</tr>

				

			</table>
		</form>
	</div>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>