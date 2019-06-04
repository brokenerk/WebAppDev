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
<title>Info Product</title>
</head>
<body>
	<div class="row">
		<h1 class="title">Info Product</h1>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Name</label>
		</div>
		<div class="col-md-8">${model.name}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Price</label>
		</div>
		<div class="col-md-8">$ ${model.realPrice}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Discount</label>
		</div>
		<div class="col-md-8">${model.discount} %</div>
	</div>
		<div class="form-group">
		<div class="col-md-4">
			<label for="">Image</label>
		</div>
		<div class="col-md-8">
		<img src="${pageContext.request.contextPath }/imgs/products/${model.id}.jpg" width="320"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Description</label>
		</div>
		<div class="col-md-8">${model.description}</div>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<label for="">Stock</label>
		</div>
		<div class="col-md-8">${model.stock}</div>
	</div>

	<div class="row">
		<a href="${pageContext.request.contextPath}/products">Return</a>
	</div>
	
	<s:if test="%{idUser!=null}">
		<div class="row">
			<s:form id="frmAddProduct"
			action="%{#pageContext.request.contextPath}/cart"
			method="post" theme="simple">
			
			<s:hidden id="IdSel" name="idSel"/>
			<s:submit value="Add to Cart" />
			</s:form>
		</div>
	</s:if>
	<s:else>
		<div class="row">
			<a href="${pageContext.request.contextPath}/login/products">Login</a>
		</div>
		<div class="row">
			<a href="${pageContext.request.contextPath}/register">Register</a>
		</div>
	</s:else>
</body>
	</html>
</jsp:root>