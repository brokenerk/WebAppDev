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
<title>Cart</title>
</head>
<body>
	<div class="row">
		<h1 class="title">Cart</h1>
	</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Id Order</label>
			</div>
			<div class="col-md-8">${cart.id}</div>
		</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Date</label>
			</div>
			<div class="col-md-8">${cart.date}</div>
		</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Total</label>
			</div>
			<div class="col-md-8">$ ${cart.total}</div>
		</div>
		
		<s:if test="%{cart.id!=null}">
			<div class="form-group">
				<a href="${pageContext.request.contextPath}/buy">Proceed to checkout</a>
			</div>
		</s:if>
		
			
		<div class="row">
		<table>
			<thead>
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>Price</th>
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
						<td>$ ${orderDetail.product.realPrice}</td>
						<td>${orderDetail.amount}</td>
						<td>
							<s:form id="frmAdd"
							action="%{#pageContext.request.contextPath}/cart/%{#productId}"
							method="post" theme="simple">
							
							<s:hidden id="hdnMethod" name="_method" value="put" />
							<s:hidden id="operation" name="operation" value="inc" />
							<s:submit value="+" />
							</s:form>
						</td>
						
						<td>
							<s:form id="frmAdd"
							action="%{#pageContext.request.contextPath}/cart/%{#productId}"
							method="post" theme="simple">
							
							<s:hidden id="hdnMethod" name="_method" value="put" />
							<s:hidden id="operation" name="operation" value="dec" />
							<s:submit value="-" />
							</s:form>
						</td>
						
						<td>
							<s:form id="frmRemove"
							action="%{#pageContext.request.contextPath}/cart/%{#productId}"
							method="post" theme="simple">
							
							<s:hidden id="hdnMethod" name="_method" value="delete" />
							<s:submit value="Remove" />
							</s:form>
						</td>
						
						</tr>
						
				</s:iterator>
			</tbody>
		</table>
	</div>
			
	<div class="row">
		<a href="${pageContext.request.contextPath}/products">Return</a>
	</div>
</body>
	</html>
</jsp:root>