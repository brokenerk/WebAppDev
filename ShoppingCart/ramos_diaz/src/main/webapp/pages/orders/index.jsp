<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:s="/struts-tags" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Completed Orders</title>
</head>
<body>
	<h1 class="my-4">Completed Orders</h1>

	<div class="row">
		<table class="table table-striped table-hover table-responsive table-fixed">
			<thead class="thead-dark">
				<tr>
					<th>Order ID</th>
					<th>Date</th>
					<th>State</th>
					<th>Total</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="orders" var="order">
					<tr>
						<td>${order.id}</td>
						<td>${order.date}</td>
						<td>Purchased</td>
						<td>$ ${order.total}</td>
						<!-- Metodo PUT -->
						<td><a class="btn btn-info" href="${pageContext.request.contextPath}/orders/${order.id}">View</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>
</jsp:root>