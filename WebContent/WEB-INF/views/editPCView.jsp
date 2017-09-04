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
		<h3>Edit PC</h3>

		<p style="color: red;">${errorString}</p>
		<form action="${pageContext.request.contextPath}/ApplyPCServlet" method="post">
			<table border="1">
				<tr>
					<th>Make</th>
					<th>Model</th>
					<th>Hostname</th>
					<th>IP address</th>
					<th>S/N</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Department</th>
					<th>Update</th>


				</tr>


				<c:forEach items="${pcsList1}" var="pcs">
					<tr>
						<td><input type="text" name="make" value="${pcs.make}"></td>
						<td><input type="text" name="model" value="${pcs.model}"></td>
						<td><input type="text" name="hostname" value="${pcs.hostname}"></td>
						<td><input type="text" name="ip_address" value="${pcs.ip_address}"></td>
						<td><input type="text" name="serial_number" value="${pcs.serial_number}"></td>
						<td><input type="text" name="first_name" value="${pcs.first_name}"></td>
						<td><input type="text" name="last_name" value="${pcs.last_name}"></td>
						<td><input type="text" name="department" value="${pcs.department}"></td>
						<td><button type="submit" name="updatePC" value="${pcs.id}">Update PC</button></td>

					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>