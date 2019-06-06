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

  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>

  <title>Shopping Cart</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/components/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/components/bootstrap/css/shop-homepage.css" rel="stylesheet"/>

  <link href="${pageContext.request.contextPath}/resources/decorators/footer.css" rel="stylesheet"/>
  <decorator:head />
</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="nav-link text-white" href="${pageContext.request.contextPath}/products">
      <span class="navbar-brand mb-0 h1 text-white">Shopping Cart</span>
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link text-white" href="${pageContext.request.contextPath}/products">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>

          <s:if test="%{idUser==null}">
            <li class="nav-item">
              <a class="nav-link text-white" href="${pageContext.request.contextPath}/login/products">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white" href="${pageContext.request.contextPath}/register">Register</a>
            </li>
          </s:if>
          <s:else>
            <li class="nav-item">
              <a class="nav-link text-white" href="${pageContext.request.contextPath}/users">Account</a>
               </li>

            <s:form id="frmRemove"
            action="%{#pageContext.request.contextPath}/login/products"
            method="post" theme="simple">
            
              <s:hidden id="hdnMethod" name="_method" value="delete" />
                <s:submit class="btn btn-link text-white" value="Logout" />
            </s:form>

          </s:else>
          
          <li class="nav-item">
            <a class="nav-link text-white" href="${pageContext.request.contextPath}/cart">Cart</a>
          </li>

        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3 col-md-3">

        <h1 class="my-4">Menu</h1>
        <div class="list-group">
          <a href="${pageContext.request.contextPath}/products" class="list-group-item text-danger">Products</a>
          <a href="${pageContext.request.contextPath}/cart" class="list-group-item text-danger">Cart</a>
          <a href="${pageContext.request.contextPath}/users" class="list-group-item text-danger">Account</a>
          <a href="${pageContext.request.contextPath}/orders" class="list-group-item text-danger">Orders</a>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9 col-md-9">

        <!--<div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide"/>
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide"/>
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide"/>
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>-->

          <decorator:body />
    
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  <p class="text-white">aaa</p>
  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright 2019</p>
    </div>
    <!-- /.container -->
  </footer>



</body>
<jsp:text>
  <![CDATA[
          <!-- Bootstrap core JavaScript -->
          <script src="${pageContext.request.contextPath}/resources/components/bootstrap/vendor/jquery/jquery.min.js"></script>
          <script src="${pageContext.request.contextPath}/resources/components/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        ]]>
</jsp:text>
</html>
</jsp:root>