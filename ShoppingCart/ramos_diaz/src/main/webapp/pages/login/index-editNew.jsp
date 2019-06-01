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
<title>Login</title>
</head>
<body>
	<s:actionerror />
	<s:form id="frmLogin"
		action="%{#pageContext.request.contextPath}/login"
		method="post" theme="simple">
		
		<div class="col-md-4">
				<label for="">Username</label>
		</div>
		<div class="col-md-8">
			<s:textfield id="txUsername" name="username"/>
			<s:fielderror fieldName="username" />
		</div>
		
		<div class="col-md-4">
				<label for="">Password</label>
		</div>
		<div class="col-md-8">
			<s:password id="txPassword" name="password"/>
			<s:fielderror fieldName="password" />
		</div>
		
		<div class="col-md-8">
			<s:hidden id="IdSel" name="idSel"/>
		</div>


		<s:submit value="Confirm" />
		<div class="row">
			<a href="${pageContext.request.contextPath}/products">Return</a>
		</div>
	</s:form>

</body>
</html>
</jsp:root>