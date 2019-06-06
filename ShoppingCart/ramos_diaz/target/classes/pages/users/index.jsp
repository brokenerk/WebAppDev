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
		<p class="text-white">aaa</p>
	</div>

</body>
</html>
</jsp:root>