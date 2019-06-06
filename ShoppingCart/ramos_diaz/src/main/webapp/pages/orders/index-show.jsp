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
<title>Completed Order</title>
</head>
<body>
	<h1 class="my-4">Order ID: ${order.id}</h1>
	<div>
		<label for="">Purchased at: ${order.date}</label>
	</div>

		
	<div class="row">
		<table class="table table-striped table-hover table-responsive table-fixed">
			<thead class="thead-dark">
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="orderDetails" var="orderDetail">
					<tr>
						<td style="width:10%"><img src="${pageContext.request.contextPath }/imgs/products/${orderDetail.product.id}.jpg" width="100"/></td>
						<td style="width:20%">${orderDetail.product.name}</td>
						<td style="width:35%">${orderDetail.product.description}</td>
						<td style="width:20%">$ ${orderDetail.product.realPrice}</td>
						<td style="width:5%">${orderDetail.amount}</td>
						</tr>
				</s:iterator>
				<tr class="table-info">
					<td scope="col"><b>Total</b></td>
					<td></td>
					<td></td>
					<td style="width:20%"><b>$ ${order.total}</b></td>
					<td></td>

				</tr>
			</tbody>
		</table>
	</div>
			
	<div class="row">
		<a class="btn btn-info" href="${pageContext.request.contextPath}/orders">Return to orders</a>
	</div>
</body>
</html>
</jsp:root>