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
<title>Profile</title>
</head>
<body>

	<h1 class="my-4">Account Info</h1>
	<div class="row">
		<div class="col-lg-6 col-md-8 mb-6">

			<div class="card h-500">
				<div class="card-body">
					<h5 class="card-title text-primary">Personal Info</h5>
					<p class="card-text">User ID: ${model.id}</p>
					<p class="card-text">Name: ${model.name}</p>
					<p class="card-text">Last Name: ${model.lastName}</p>
					<p class="card-text">Second Last Name: ${model.secondLastName}</p>
					<p class="card-text">Email: ${model.login}</p>
				</div>
				<div class="card-footer">
					<a href="${pageContext.request.contextPath}/orders" class="btn btn-info">Completed Orders</a>
				</div>
			</div>
		</div>
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
					<s:submit class="btn btn-info" value="Edit Info" />
					</s:form>
				</div>
			</div>
		</div>



	<!--<div class="row">
		<h1 class="title">User ID: ${model.id}</h1>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Name</label>
		</div>
		<div class="col-md-8">${model.name}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Last Name</label>
		</div>
		<div class="col-md-8">${model.lastName}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Second last Name</label>
		</div>
		<div class="col-md-8">${model.secondLastName}</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Username</label>
		</div>
		<div class="col-md-8">${model.login}</div>
	</div>
	
	<div class="row">
		<h2 class="title">Address</h2>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Street</label>
		</div>
		<div class="col-md-8">${model.street}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">City</label>
		</div>
		<div class="col-md-8">${model.city}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">State</label>
		</div>
		<div class="col-md-8">${model.state}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">ZIPCODE</label>
		</div>
		<div class="col-md-8">${model.zipCode}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Telephone</label>
		</div>
		<div class="col-md-8">${model.telephone}</div>
	</div>
	

	<div class="row">
	
		<s:form id="frmEditUser"
			action="%{#pageContext.request.contextPath}/users"
			method="post" theme="simple">
			<s:submit value="Edit" />
		</s:form>

	</div>

	<div class="row">
		<a href="${pageContext.request.contextPath}/orders">Completed Orders</a>
	</div>
	<div class="row">
		<a href="${pageContext.request.contextPath}/products">Return</a>
	</div>	
	-->
</div>
</body>
</html>
</jsp:root>