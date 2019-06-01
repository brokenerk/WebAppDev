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
<title>Shopping Cart</title>
</head>
<body>
	<div class="row">
		<a href="${pageContext.request.contextPath}/users">Account</a>
	</div>
	<div class="row">
		<a href="${pageContext.request.contextPath}/cart">Cart</a>
	</div>
	<div class="row">
		<h1 class="title">Products</h1>
	</div>
	<div class="row">
		<table>
			<thead>
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>Price</th>
					<th>Discount</th>
					<th>Total</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listProducts" var="product">
					<s:set var="product.id">${product.id}</s:set>
					<tr>
						<td><img src="${pageContext.request.contextPath }/imgs/products/${product.id}.jpg" width="100"/></td>
						<td>${product.name}</td>
						<td>$ ${product.price}</td>
						<td>${product.discount} %</td>
						<td>$ ${product.realPrice}</td>
						<td><a href="${pageContext.request.contextPath}/products/${product.id}">View</a></td>
						<td>
							<s:form id="frmAddProduct"
							action="%{#pageContext.request.contextPath}/cart"
							method="post" theme="simple">
							
							<s:hidden id="IdSel" name="idSel" value="%{#product.id}"/>
							<s:submit value="Add to Cart" />
							</s:form>
							
						</td>
						
						</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>
</jsp:root>