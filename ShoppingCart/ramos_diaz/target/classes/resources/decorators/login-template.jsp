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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="${pageContext.request.contextPath}/resources/components/shoppy/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/resources/components/shoppy/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!--js-->

<!--icons-css-->
<link href="${pageContext.request.contextPath}/resources/components/shoppy/css/font-awesome.css" rel="stylesheet"/> 
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'/>
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'/>
<!--static chart-->
</head>
<body>	
<div class="login-page">
    <div class="login-main">  	
    	 <div class="login-head">
				<h1>Login</h1>
			</div>
			<div class="login-block">
				<decorator:body/>
				<!--<form>
					<input type="text" name="email" placeholder="Email" required=""/>
					<input type="password" name="password" class="lock" placeholder="Password"/>

					<input type="submit" name="Sign In" value="Enter"/>	
									
				</form>-->
				<h3>Not a member?<a href="${pageContext.request.contextPath}/register"> Sign up now</a></h3>
				<h5><a href="${pageContext.request.contextPath}/products">Go Back to Products</a></h5>
			</div>
      </div>
</div>
<!--inner block end here-->
<!--copy rights start here-->
<div class="copyrights">
	 <p>©Copyright 2019</p>
</div>	
<!--COPY rights end here-->

<!--scrolling js-->
<jsp:text>
  <![CDATA[
  		<script src="${pageContext.request.contextPath}/resources/components/shoppy/js/jquery-2.1.1.min.js"></script> 
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<script src="${pageContext.request.contextPath}/resources/components/shoppy/js/jquery.nicescroll.js"></script>
		<script src="${pageContext.request.contextPath}/resources/components/shoppy/js/scripts.js"></script>
		<!--//scrolling js-->
<script src="${pageContext.request.contextPath}/resources/components/shoppy/js/bootstrap.js"> </script>
        ]]>
</jsp:text>
<!-- mother grid end here-->
</body>
</html>
</jsp:root>