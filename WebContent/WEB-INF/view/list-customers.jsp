<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List Customers</title>
		<link type="text/css" rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	<body>
		
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Management</h2>
			</div>
		</div>
		
		<div id="container">
			
			<div id="content">
			
			<!-- create a button: add customer -->
			<button 
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button">
				Add Customer
			</button>
			
			<!-- Add HTML table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- We need to loop here to get all customer info -->
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- construct update link with customer id  -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			</div>
			
		</div>
	</body>
</html>