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
<title>Manage User</title>
</head>
<body>
	<div class="row">
		<h1 class="title">Edit user</h1>
	</div>
	<s:actionerror />
	<s:form id="frmEditUser"
		action="%{#pageContext.request.contextPath}/manage-user"
		method="post" theme="simple">
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Firstname</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txName" name="model.name" cssClass="form-control"
					cssErrorClass="is-invalid" />
				<s:fielderror fieldName="model.name" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Lastname</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txName" name="model.lastName"
					cssClass="form-control" cssErrorClass="is-invalid" />
				<s:fielderror fieldName="model.lastName" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Second lastname</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txName" name="model.secondLastName"
					cssClass="form-control" cssErrorClass="is-invalid" />
				<s:fielderror fieldName="model.secondLastName" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">CURP</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txName" name="model.curp" cssClass="form-control"
					cssErrorClass="is-invalid" />
				<s:fielderror fieldName="model.curp" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Birthday</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txName" name="model.birthDay"
					cssClass="form-control" cssErrorClass="is-invalid" />
				<s:fielderror fieldName="model.birthDay" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Login</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="txName" name="model.login" cssClass="form-control"
					cssErrorClass="is-invalid" />
				<s:fielderror fieldName="model.login" />
			</div>
		</div>
		<div class="row">
			<a href="${pageContext.request.contextPath}/manage-user">Cancel</a>
			<s:submit value="Confirm" />
		</div>
	</s:form>
</body>
	</html>
</jsp:root>