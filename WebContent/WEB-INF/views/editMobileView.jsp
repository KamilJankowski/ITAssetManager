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
		<h3>Edit Mobile</h3>

		<p style="color: red;">${errorString}</p>
		<form action="${pageContext.request.contextPath}/editmobile"
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
					<th>Update</th>


				</tr>


				<c:forEach items="${mobilesList}" var="mobiles">
					<tr>
						<td><input type="text" name="make" value="${mobiles.make}"></td>
						<td><input type="text" name="model" value="${mobiles.model}"></td>
						<td><input type="text" name="imei" value="${mobiles.imei}"></td>
						<td><input type="text" name="serial_number" value="${mobiles.m_serial_number}"></td>
						<td><input type="text" name="provider" value="${mobiles.provider}"></td>
						<td><input type="text" name="sim_serial_number" value="${mobiles.s_serial_number}"></td>
						<td><input type="text" name="mobile_number" value="${mobiles.mobile_number}"></td>
						<td><input type="text" name="first_name" value="${mobiles.first_name}"></td>
						<td><input type="text" name="last_name" value="${mobiles.last_name}"></td>
						<td><input type="text" name="department" value="${mobiles.department}"></td>
						<td><button type="submit" name="updateMobile" value="update_Mobile">Update mobile</button></td>

					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>