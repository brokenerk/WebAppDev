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
			
			
			
			<div class="row">
				<div class="col">
					<label for="" class="text-dark">Name</label>
					<s:textfield class="form-control" id="texName" name="model.name"/>
					<s:fielderror fieldName="model.name" class="text-danger"/>
				</div>
				<div class="col">
					<label for="" class="text-dark">Last Name</label>
					<s:textfield class="form-control" id="texLastName" name="model.lastName"/>
					<s:fielderror fieldName="model.lastName" class="text-danger"/>
				</div>
				
				
			</div>
			
			
			<div class="col-md-4">
				<label for="">Second Last Name</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txSecondLastName" name="model.secondLastName"/>
				<s:fielderror fieldName="model.secondLastName" />
			</div>
			
			<div class="col-md-8">
				<h2>Edit Address</h2>
			</div>
			
			<div class="col-md-4">
				<label for="">Street</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txStreet" name="model.street"/>
				<s:fielderror fieldName="model.street" />
			</div>
			
			<div class="col-md-4">
				<label for="">City</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txCity" name="model.city"/>
				<s:fielderror fieldName="model.city" />
			</div>
			
			<div class="col-md-4">
				<label for="">State</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txState" name="model.state"/>
				<s:fielderror fieldName="model.state" />
			</div>
			
			<div class="col-md-4">
				<label for="">ZipCode</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txZipCode" name="model.zipCode"/>
				<s:fielderror fieldName="model.zipCode" />
			</div>
			
			<div class="col-md-4">
				<label for="">Telephone</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txTelephone" name="model.telephone"/>
				<s:fielderror fieldName="model.telephone" />
			</div>
			
			<div class="col-md-8">
				<h2>Edit Account</h2>
			</div>
			
			<div class="col-md-4">
				<label for="">Username</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txLogin" name="model.login"/>
				<s:fielderror fieldName="model.login" />
			</div>
			
			<div class="col-md-4">
				<label for="">Password</label>
			</div>
			<div class="col-md-8">
				<s:password id="txPassword" name="model.password"/>
				<s:fielderror fieldName="model.password" />
			</div>
			
			<div class="col-md-4">
				<label for="">Confirm New Password</label>
			</div>
			<div class="col-md-8">
				<s:password id="txConfirmPassword" name="confirmPassword"/>
				<s:fielderror fieldName="confirmPassword" />
			</div>
			
			
			<s:submit value="Update" />
			<div class="row">
				<a href="${pageContext.request.contextPath}/users">Cancel</a>
			</div>
	</s:form>

</body>
</html>
</jsp:root>