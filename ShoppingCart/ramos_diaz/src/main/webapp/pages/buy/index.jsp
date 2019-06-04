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
<title>Proceed to checkout</title>
</head>
<body>
	<s:fielderror fieldName="buyError" />
	<div class="row">
		<h2 class="title">Order Info</h2>
	</div>

		<div class="form-group">
			<div class="col-md-4">
				<label for="">Total</label>
			</div>
			<div class="col-md-8">$ ${cart.total}</div>
		</div>
		
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
						</tr>
						
				</s:iterator>
			</tbody>
		</table>
		
		<div class="row">
			<h2 class="title">Address</h2>
		</div>
	
		<div class="col-md-4">
			<label for="">Street</label>
		</div>
		<div class="col-md-8">${model.street}</div>


		<div class="col-md-4">
			<label for="">City</label>
		</div>
		<div class="col-md-8">${model.city}</div>


		<div class="col-md-4">
			<label for="">State</label>
		</div>
		<div class="col-md-8">${model.state}</div>


		<div class="col-md-4">
			<label for="">Zip Code</label>
		</div>
		<div class="col-md-8">${model.zipCode}</div>


			<div class="row">
				<s:form id="frmEditUser"
					action="%{#pageContext.request.contextPath}/users"
					method="post" theme="simple">
					<s:submit value="Edit Address Info" />
				</s:form>
			</div>
		
		<s:form id="frmCreditCard"
			action="%{#pageContext.request.contextPath}/buy"
			method="post" theme="simple">
			
			<div class="col-md-8">
				<h2>Payment Source</h2>
			</div>
			
			
			<div class="col-md-4">
				<label for="">Credit Card Number</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txCreditCard" name="creditCard"/>
				<s:fielderror fieldName="creditCard" />
			</div>
			
						<div class="col-md-4">
				<label for="">Owner</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txOwner" name="owner"/>
				<s:fielderror fieldName="owner" />
			</div>
			

				<div class="col-md-4">
					<label for="">Expiration Month - MM</label>
				</div>
					<div class="col-md-8">
					<s:textfield id="txExpMonth" name="expMonth"/>
					<s:fielderror fieldName="expMonth" />
				</div>
				
				<div class="col-md-4">
					<label for="">Expiration Year - YYYY</label>
				</div>
				<div class="col-md-8">
					<s:textfield id="txExpYear" name="expYear"/>
					<s:fielderror fieldName="expYear" />
				</div>
				
			
			<div class="col-md-4">
				<label for="">CVC</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txCVC" name="cvc"/>
				<s:fielderror fieldName="cvc" />
			</div>
			
			<s:submit value="Buy Order" />
			<div class="row">
				<a href="${pageContext.request.contextPath}/cart">Cancel</a>
			</div>
		</s:form>
		
		
	</div>
</body>
	</html>
</jsp:root>