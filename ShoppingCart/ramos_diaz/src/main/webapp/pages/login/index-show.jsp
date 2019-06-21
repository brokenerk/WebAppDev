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

	<s:actionerror/>
	<s:form id="frmLogin"
		action="%{#pageContext.request.contextPath}/login"
		method="post" theme="simple" class="login100-form validate-form">
		
		<div class="wrap-input100 m-b-10">
			<!--<input class="input100" type="text" name="username" placeholder="Username"/>-->
			<s:textfield cssClass="input100" cssErrorClass="is-invalid" id="txUsername" name="username" placeholder="Email"/>
			<s:fielderror fieldName="username" style="color: white; font-weight: bold;"/>
		</div>

		<div class="wrap-input100 m-b-10">
			<!--<input class="input100" type="password" name="pass" placeholder="Password"/>-->
			<s:password id="txPassword" name="password" cssClass="input100" cssErrorClass="is-invalid" placeholder="Password"/>
			<s:fielderror fieldName="password" style="color: white; font-weight: bold;"/>
			
		</div>

		<s:hidden id="IdSel" name="idSel"/>


		<div class="container-login100-form-btn p-t-10">
			<s:submit class="login100-form-btn" value="Sign In"/>
		</div>
		

	</s:form>

</body>
</html>
</jsp:root>