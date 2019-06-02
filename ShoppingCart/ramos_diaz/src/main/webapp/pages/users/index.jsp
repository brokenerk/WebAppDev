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
	<div class="row">
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
	
	<!-- Metodo POST -->
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
</body>
</html>
</jsp:root>