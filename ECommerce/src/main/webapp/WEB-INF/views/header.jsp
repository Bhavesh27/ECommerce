<%@page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="en">
  <head>
   
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	
	<link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"   rel="stylesheet" />
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="static/css/header.css">
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="static/js/autocompleter.js"></script>
  
  </head>
  <body>
    <header>
    <div class="container">
    <div class="row">
      <div class="col-md-4" >
      	<!-- <img src='static/images/Bookstore-logo.png' alt='Bookstore' height="100px" width="280px"/> -->
        <h3>BOOKS VILLA</h3>
      </div>
      <div class="col-md-6 search-container" style="float: left; padding-bottom: 1px">
        <div class="input-group ui-widget" style="padding-top: 12px" >
          <input type="text" class="form-control" name="search" id="search" placeholder="search"  />
          <span class="input-group-addon">
            <a href="#"><i class="fa fa-search"></i></a>
          </span>
        </div>
      </div>
    </div>
  </div>
</header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-default" >
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href='<c:url value='/home'></c:url>'>BOOKS VILLA</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href='<c:url value='/home'></c:url>'>Home</a></li>
            <li><a href='<c:url value='/aboutUs'></c:url>'>About</a></li>
            <li><a href='<c:url value='/contactUs'></c:url>'>Contact</a></li>
            <li class="dropdown"><a class="dropbtn" href='<c:url value='/allProduct'></c:url>'>Genre <span class="caret"></span></a>
              <div class="dropdown-menu">
              	<c:forEach items="${categories}" var="category">
	              		<ul>
	              			<li><a href='<c:url value='displayProduct-${category.category_id}'></c:url>'>${category.category_name}</a></li>
	              		</ul>
	  
              	</c:forEach>
 
            </div>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<c:if test="${pageContext.request.userPrincipal.name == null }">
	            <li><a href='<c:url value='/login'></c:url>'>Sign In</a></li>
	            <li><a href='<c:url value='/Registration'></c:url>'>Register</a></li>
	            <li><a href=""><i class="glyphicon glyphicon-shopping-cart" style="font-size:15px"></i><span class="sr-only">(current)</span></a></li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null }">
            	<li class="${Contactus} dropdown"><a class="dropbtn" href='<c:url value='/home'></c:url>'>${pageContext.request.userPrincipal.name} <span class="caret"></span></a>
			       	<ul class="dropdown-menu" style="width:150px">
			       		<li><a href='<c:url value='/account?username=${pageContext.request.userPrincipal.name}'></c:url>'>your account</a></li>         <%-- /account?username=${user} --%>
			       		<li><a>your orders</a></li>
			       		<li><a href='<c:url value='/cart?username=${pageContext.request.userPrincipal.name}'></c:url>'>your cart</a></li>
			       	</ul>
			     </li>
            	<li><a href='<c:url value='/home'></c:url>' style="padding-bottom: 13px; padding-top: 13px"><img src='<c:url value='/static/images/user/${pageContext.request.userPrincipal.name}.png'></c:url>' height='25' width='25' class="img img-rounded"/></a></li>
            	<li><a href='<c:url value='/logout'></c:url>'>Logout</a></li>
            	<li><a href=""><i class="glyphicon glyphicon-shopping-cart" style="font-size:15px"></i><span class="sr-only">(current)</span></a></li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>  