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
<title>Edit Info</title>
</head>
<body>
	<h1 class="my-4">Edit Personal Info</h1>
	<s:actionerror/>
	<s:form id="frmAddUser"
	action="%{#pageContext.request.contextPath}/users/%{model.id}"
	method="post" theme="simple">
			
		<s:hidden id="hdnMethod" name="_method" value="put" />
		<s:hidden id="IdUser" name="model.id" value="%{model.id}" />
		
		<div class="form-group row">
			<div class="col">
				<label for="" class="text-dark">Name</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txName" name="model.name"/>
				<s:fielderror fieldName="model.name" class="text-danger"/>
			</div>
			<div class="col">
				<label for="" class="text-dark">Last Name</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txLastName" name="model.lastName"/>
				<s:fielderror fieldName="model.lastName" class="text-danger"/>
			</div>
		</div>

		<div class="form-group row">
			<div class="col">
				<label for="" class="text-dark">Second Last Name</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txSecondLastName" name="model.secondLastName"/>
				<s:fielderror fieldName="model.secondLastName" class="text-danger"/>
			</div>
			<div class="col">
				<label for="" class="text-dark">Email</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txLogin" name="model.login"/>
				<s:fielderror fieldName="model.login" class="text-danger"/>
			</div>
		</div>

		<div class="form-group row">
			<div class="col">
				<label for="" class="text-dark">Password</label>
				<s:password cssClass="form-control" cssErrorClass="is-invalid" id="txPassword" name="model.password"/>
				<s:fielderror fieldName="model.password" class="text-danger"/>
			</div>
			<div class="col">
				<label for="" class="text-dark">Confirm Password</label>
				<s:password cssClass="form-control" cssErrorClass="is-invalid" id="txConfirmPassword" name="confirmPassword"/>
				<s:fielderror fieldName="confirmPassword" class="text-danger"/>
			</div>
		</div>
		
		
		<div class="my-4">
			<h2>Edit Address</h2>
		</div>

		<div class="form-group row">
			<div class="col">
				<label for="" class="text-dark">Street</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txStreet" name="model.street"/>
				<s:fielderror fieldName="model.street" class="text-danger"/>
			</div>
			<div class="col">
				<label for="" class="text-dark">City</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txCity" name="model.city"/>
				<s:fielderror fieldName="model.city" class="text-danger"/>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-md-4">
				<label for="" class="text-dark">State</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txState" name="model.state"/>
				<s:fielderror fieldName="model.state" class="text-danger"/>
			</div>
			<div class="col-md-4">
				<label for="" class="text-dark">Zip Code</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txZipCode" name="model.zipCode"/>
				<s:fielderror fieldName="model.zipCode" class="text-danger"/>
			</div>
			<div class="col-md-4">
				<label for="" class="text-dark">Telephone</label>
				<s:textfield cssClass="form-control" cssErrorClass="is-invalid" id="txTelephone" name="model.telephone"/>
				<s:fielderror fieldName="model.telephone" class="text-danger"/>
			</div>
		</div>
		
		<div class="form-group row">
			<div class="col-md-2">
				<s:submit class="btn btn-success" value="Update" />
			</div>
			<div class="col">
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/users">Cancel</a>
			</div>
		</div>

	</s:form>

</body>
</html>
</jsp:root>