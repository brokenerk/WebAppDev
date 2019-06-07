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
	
	<h1 class="my-4">Proceed to checkout</h1>
	<s:fielderror fieldName="buyError" class="text-danger"/>

	<div row="row">
		<div class="row">
			<table class="table table-striped table-hover table-responsive">
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
					<s:set var="productId">${orderDetail.product.id}</s:set>
					<tr>
						<td style="width:15%"><img src="${pageContext.request.contextPath }/imgs/products/${orderDetail.product.id}.jpg" width="100"/></td>
						<td style="width:20%">${orderDetail.product.name}</td>
						<td style="width:35%">${orderDetail.product.description}</td>
						<td style="width:5%">$ ${orderDetail.product.realPrice}</td>
						<td style="width:10%">${orderDetail.amount}</td>
						<s:fielderror class="text-danger">
							<s:param value="%{#productId}" /> 
						</s:fielderror>
						</tr>
					</s:iterator>
					<tr class="table-info">
						<td scope="col"><b>Total</b></td>
						<td></td>
						<td></td>
						<td style="width:19%"><b>$ ${cart.total}</b></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="row">
			<div class="col-lg-6 col-md-8 mb-6">
				<div class="card h-500">
					<div class="card-body">
						<h5 class="card-title text-primary">Address</h5>
						<p class="card-text">Street: ${model.street}</p>
						<p class="card-text">City: ${model.city}</p>
						<p class="card-text">State: ${model.state}</p>
						<p class="card-text">Zip Code: ${model.zipCode}</p>
						<p class="card-text">Telephone: ${model.telephone}</p>
					</div>
					<div class="card-footer">
						<s:form id="frmEditUser"
						action="%{#pageContext.request.contextPath}/users"
						method="post" theme="simple">
						<s:submit class="btn btn-info" value="Edit Address" />
						</s:form>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-8 mb-6">
				<div class="card h-500">
					<s:form id="card-form"
						action="%{#pageContext.request.contextPath}/buy"
						method="post" theme="simple">
					<div class="card-body">
						<h5 class="card-title text-primary">Payment Method</h5>
						<span class="card-errors text-danger"></span>
						<s:fielderror fieldName="buyError" class="text-danger"/>
						

						<div class="form-group">
							<label for="" class="text-dark">Credit Card</label>
							<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txCreditCard" name="creditCard" data-conekta="card[number]"/>
						</div>

						<div class="form-group">
							<label for="" class="text-dark">Owner</label>
							<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txOwner" name="owner" placeholder="John Doe" data-conekta="card[name]"/>
						</div>

						<div class="form-group row">
							<div class="col-md-4">
								<label for="" class="text-dark">Exp Month</label>
								<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txExpMonth" name="expMonth" placeholder="12" data-conekta="card[exp_month]"/>
							</div>
							<div class="col-md-4">
								<label for="" class="text-dark">Exp Year</label>
								<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txExpYear" name="expYear" placeholder="2022" data-conekta="card[exp_year]"/>
							</div>
							<div class="col-md-4">
								<label for="" class="text-dark">CVC</label>
								<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txCvc" name="cvc" data-conekta="card[cvc]"/>
							</div>
						</div>
						<div class="row" style="padding:10px;">
							<img src="${pageContext.request.contextPath }/imgs/credit-cards.png" height="65"/>
						</div>
					</div>
					<div class="card-footer" id="credit-card-footer">
						<s:submit class="btn btn-success" id = "btnPay" value="Buy Order" />
					</div>
				</s:form>
				</div>
			</div>

			<p class="text-white">aaa</p>
		</div>
	</div>

	
<jsp:text>
  <![CDATA[
	    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdn.conekta.io/js/latest/conekta.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/pages/buy/conekta.js"></script>
    ]]>
</jsp:text>

</body>
	</html>
</jsp:root>