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
		<h3>Edit Printer</h3>

		<p style="color: red;">${errorString}</p>
		<form action="${pageContext.request.contextPath}/applyprinter" method="post">
			<table border="1">
				<tr>
					<th>Make</th>
					<th>Model</th>
					<th>Hostname</th>
					<th>IP address</th>
					<th>S/N</th>
					<th>Department</th>
					<th>Update</th>


				</tr>


				<c:forEach items="${printersList1}" var="printers">
					<tr>
						<td><input type="text" name="make" value="${printers.make}"></td>
						<td><input type="text" name="model" value="${printers.model}"></td>
						<td><input type="text" name="hostname" value="${printers.hostname}"></td>
						<td><input type="text" name="ip_address" value="${printers.ip_address}"></td>
						<td><input type="text" name="serial_number" value="${printers.serial_number}"></td>
						<td><input type="text" name="department" value="${printers.department}"></td>
						<td><button type="submit" name="updatePrinter" value="${printers.id}">Update Printer</button></td>

					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>