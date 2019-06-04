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
<title>Order purchased</title>
</head>
<body>
	<div class="row">
		<h2 class="title">Thank you! You have bought the order with ID ${cart.id}</h2>
	</div>
	
	<div class="form-group">
			<div class="col-md-4">
				<label for="">Total: </label>
			</div>
			<div class="col-md-8">$ ${cart.total}</div>
		</div>
		
	<div class="row">
		<h3>Details: </h3>
	</div>
	
	<div class="row">
		<table>
			<thead>
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>Amount</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="orderDetails" var="orderDetail">
					<s:set var="productId">${orderDetail.product.id}</s:set>
					<tr>
						<td><img src="${pageContext.request.contextPath }/imgs/products/${orderDetail.product.id}.jpg" width="100"/></td>
						<td>${orderDetail.product.name}</td>
						<td>${orderDetail.amount}</td>
						</tr>
						
				</s:iterator>
			</tbody>
		</table>
	</div>
	
	<div class="row">
		<a href="${pageContext.request.contextPath}/orders">Completed Orders</a>
	</div>
	<div class="row">
		<a href="${pageContext.request.contextPath}/products">Products</a>
	</div>
	<div class="row">
		<a href="${pageContext.request.contextPath}/users">Account</a>
	</div>
</body>
</html>
</jsp:root>