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
<title>Shopping Cart</title>
</head>
<body>
		<h1 class="my-4">Products</h1>
		<div class="row">

		<s:iterator value="listProducts" var="product">
			<s:set var="product.id">${product.id}</s:set>


			<div class="col-lg-4 col-md-4">
		        <div class="card h-400">
		          <img class="card-img-top" src="${pageContext.request.contextPath}/imgs/products/${product.id}.jpg" width="100" alt=""/>
		          <div class="card-body">
		            <h4 class="card-title text-primary">
		              ${product.name}
		            </h4>
		            <div class="row">
		                <div class="col-lg-6 col-md-9 mb-6">
		                	<h8>$ ${product.price}</h8>
		                </div>
		                <div class="col-lg-6 col-md-9 mb-6">
		                	<h8>${product.discount}% OFF</h8>
		                </div>
		            </div>
		            <h5>Price: $ ${product.realPrice}</h5>
		            <p class="card-text">${product.description}</p>
		            <h8>On Stock: ${product.stock} remaining</h8>
		          </div>
		          <div class="card-footer">
		          	<s:if test="%{idUser!=null}">

		          		<s:form id="frmAddProduct"
						action="%{#pageContext.request.contextPath}/cart"
						method="post" theme="simple">
						
						<s:hidden id="IdSel" name="idSel" value="%{#product.id}"/>
						<s:submit class="btn btn-info" value="Add to Cart" />
						</s:form>
		          	</s:if>
		          </div>
		        </div>
		        <br/>
		      </div>
		</s:iterator>
		</div>
</body>
</html>
</jsp:root>