<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
  xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
  xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
  xmlns:sj="/struts-jquery-tags">
  <jsp:directive.page language="java"
    contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
  <jsp:text>
    <![CDATA[<!DOCTYPE html>]]>
  </jsp:text>

<html lang="es-MX">
<head>
	<title>Login</title>
	<meta charset="UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
<!--==============================================================================================================================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/components/login/vendor/bootstrap/css/bootstrap.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/components/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/components/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/components/login/vendor/animate/animate.css"/>
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/components/login/vendor/css-hamburgers/hamburgers.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/components/login/vendor/select2/select2.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/components/login/css/util.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/components/login/css/main.css"/>
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('${pageContext.request.contextPath}/resources/components/login/images/img-01.jpg');">
			<div class="wrap-login100 p-t-50 p-b-30">
				
			<div class="login100-form-avatar">
				<img src="${pageContext.request.contextPath}/resources/components/login/images/avatar-02.jpg" alt="AVATAR"/>
			</div>

			<span class="login100-form-title p-t-20 p-b-45">
				Login
			</span>
				<decorator:body/>
			<div class="text-center w-full">
				<a class="txt1" href="${pageContext.request.contextPath}/register">
					Create new account						
				</a>
			</div>
			<div class="text-center w-full">
				<a class="txt1" href="${pageContext.request.contextPath}/products">
					Go back to products					
				</a>
			</div>
			</div>
		</div>
	</div>
	
<jsp:text>
  <![CDATA[
	    <!--===============================================================================================-->	
		<script src="${pageContext.request.contextPath}/resources/components/login/vendor/jquery/jquery-3.2.1.min.js"></script>
		<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resources/components/login/vendor/bootstrap/js/popper.js"></script>
		<script src="${pageContext.request.contextPath}/resources/components/login/vendor/bootstrap/js/bootstrap.min.js"></script>
		<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resources/components/login/vendor/select2/select2.min.js"></script>
		<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resources/components/login/js/main.js"></script>
        ]]>
</jsp:text>
</body>
</html>
</jsp:root>