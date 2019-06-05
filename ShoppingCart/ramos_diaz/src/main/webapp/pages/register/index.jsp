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
<title>Register</title>
</head>
<body>
	<s:actionerror/>
	<s:form id="frmAddUser"
			action="%{#pageContext.request.contextPath}/register"
			method="post" theme="simple">
			
				<h2>Personal Info</h2>
			
				<s:fielderror fieldName="model.name" style="color: red;"/>
				<s:textfield id="txName" name="model.name" placeholder="Name"/>
				
				<s:fielderror fieldName="model.lastName" style="color: red;"/>
				<s:textfield id="txLastName" name="model.lastName" placeholder="Last Name"/>
				
				<s:fielderror fieldName="model.secondLastName" style="color: red;"/>
				<s:textfield id="txSecondLastName" name="model.secondLastName" placeholder="Second Last Name"/>
				

				<h2>Address</h2>

				<s:fielderror fieldName="model.street" style="color: red;"/>
				<s:textfield id="txStreet" name="model.street" placeholder="Street"/>
				
				<s:fielderror fieldName="model.city" style="color: red;"/>
				<s:textfield id="txCity" name="model.city" placeholder="City"/>
				
				<s:fielderror fieldName="model.state" style="color: red;"/>
				<s:textfield id="txState" name="model.state" placeholder="State"/>
				
				<s:fielderror fieldName="model.zipCode" style="color: red;"/>
				<s:textfield id="txZipCode" name="model.zipCode" placeholder="Zip Code"/>
				

				<s:fielderror fieldName="model.telephone" style="color: red;"/>
				<s:textfield id="txTelephone" name="model.telephone" placeholder="Telephone"/>
					

				<h2>Account</h2>
				<s:fielderror fieldName="model.login" style="color: red;"/>
				<s:textfield id="txLogin" name="model.login" placeholder="Email"/>
				
				<s:fielderror fieldName="model.password" style="color: red;"/>
				<s:password id="txPassword" name="model.password" placeholder="Password"/>
				
				<s:fielderror fieldName="confirmPassword" style="color: red;"/>
				<s:password id="txConfirmPassword" name="confirmPassword" placeholder="Confirm Password"/>
				
			
			<s:submit value="Sign up" />
	</s:form>

</body>
</html>
</jsp:root>