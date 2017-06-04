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
		<h3>Mobiles List</h3>
		<form action="" method="post">
			<button>Add new</button>
			<input type="submit" name="importCSV" value="importCSV"> <input
				type="submit" name="exportCSV" value="exportCSV">
		</form>
		<p style="color: red;">${errorString}</p>
		<form action="${pageContext.request.contextPath}/mobiles"
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
					<th>Edit</th>
					<th>Delete</th>

				</tr>

				<c:forEach items="${mobilesList}" var="mobiles">

					<tr>
						<td>${mobiles.make}</td>
						<td>${mobiles.model}</td>
						<td>${mobiles.imei}</td>
						<td>${mobiles.m_serial_number}</td>
						<td>${mobiles.provider}</td>
						<td>${mobiles.s_serial_number}</td>
						<td>${mobiles.mobile_number}</td>
						<td>${mobiles.first_name}</td>
						<td>${mobiles.last_name}</td>
						<td>${mobiles.department}</td>
						<td><button>Edit</button></td>
						<td><button type="submit" name="delMobileBtn"
							value="${mobiles.id}">Delete</button></td>

					</tr>

				</c:forEach>

			</table>
		</form>
	</div>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>