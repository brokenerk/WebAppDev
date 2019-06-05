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
<s:head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
</s:head>
<body>

	<s:actionerror/>
	<s:form id="frmLogin"
		action="%{#pageContext.request.contextPath}/login"
		method="post" theme="simple">
		
		<s:textfield id="txUsername" name="username" placeholder="Email"/>

		<s:fielderror fieldName="username" style="color: red;"/>

		<s:password id="txPassword" name="password" class="lock" placeholder="Password"/>
		<s:fielderror fieldName="password" style="color: red;"/>

		<s:hidden id="IdSel" name="idSel"/>
		<s:submit value="Enter" />

	</s:form>

</body>
</html>
</jsp:root>