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
		<h3>Printers List</h3>
		<form action="${pageContext.request.contextPath}/addprinter"
			method="post">
			<button type="submit" name="addprinter">Add new</button>
		</form>
		<form action="" method="post">

			<input type="submit" name="importCSV" value="importCSV"> 
			<input type="submit" name="exportCSV" value="exportCSV">
		</form>

		<p style="color: red;">${errorString}</p>

		<table border="1">
			<tr>
				<th>Make</th>
				<th>Model</th>
				<th>Hostname</th>
				<th>IP address</th>
				<th>S/N</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>

			</tr>
			<c:forEach items="${printersList}" var="printers">
				<tr>
					<td>${printers.make}</td>
					<td>${printers.model}</td>
					<td>${printers.hostname}</td>
					<td>${printers.ip_address}</td>
					<td>${printers.serial_number}</td>
					<td>${printers.department}</td>
					<td>
						<form 	method="post">
							<button type="submit" name="editPrinterBtn" value="${printers.id}">Edit</button>
						</form>
					</td>

					<td>
						<form action="${pageContext.request.contextPath}/printers"
							method="post">
							<button type="submit" name="delPrinterBtn" value="${printers.id}">Delete</button>
						</form>
					</td>

				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>