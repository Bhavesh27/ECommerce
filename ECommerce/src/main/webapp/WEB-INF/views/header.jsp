<%@page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
  <head>
   
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	
	<link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"   rel="stylesheet" />
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header.css">
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/autocompleter.js"></script>
    <style type="text/css">
    	#icon{
    	height:30px;
    	width:40px;
    	}
    	#logo{
    	height:100px;
    	width:180px;
    	}
 		#search{
 		padding-bottom:10px;
 		}
    	.ui-helper-hidden-accessible { display:none; }
    </style>
  
  </head>
  <body>
    <header>
    <div class="container">
    <div class="row">
      <!-- <div class="col-md-4" >
      	<img src='static/images/Bookstore-logo.png' alt='Bookstore' height="100px" width="280px"/>
        <h3>BOOKS VILLA</h3>
      </div> -->
          <div class="col-md-2 col-xs-12">
            <img id="logo" src='${pageContext.request.contextPath}/static/images/bookpile.jpg' alt='Bookstore' />
          </div>
          <div class="col-md-2 col-xs-12" style="float:left">
            <h2>BOOKSTORE</h2>
          </div>
          <div class="col-md-4 col-xs-8 search-container" style="padding-top: 40px">
          <form:form action="product" method="GET">
            <div class="input-group ui-widget">
              <input type="text" id="search" name="search" class="form-control" placeholder="search"/>
              <span class="input-group-addon">
                <button class="icon" style="color:#4CAF50"><i class="fa fa-search"></i></button>
              </span>
            </div>
           </form:form>
          </div>
      <div class="col-md-2" style="padding-top: 35px; padding-left:40px">
          	<div class="cart-list">
	          	<c:if test="${pageContext.request.userPrincipal.name == null }">
	          		<c:set var="cart_url" value="/login"></c:set>
	          		<c:set var="wishlist_url" value="/login"></c:set>
	          		<c:set var="cart_size" value="0"></c:set>
	          	</c:if>
	          	<c:if test="${pageContext.request.userPrincipal.name != null }">
	          		<c:set var="cart_url" value="/user/${pageContext.request.userPrincipal.name}/cart"></c:set>		
             		<c:set var="wishlist_url" value="/user/${pageContext.request.userPrincipal.name}/wishlist"></c:set>
	          		<c:set var="cart_size" value="${cartSize }"></c:set>
	          		<c:set var="wishlist_size" value="${wishlistSize }"></c:set>
	          	</c:if>
	            <a href='<c:url value='${cart_url }'></c:url>'><span class="fa fa-shopping-cart" style="font-size: 25px; color:#585858"></span>
	            <span class="item"><b>CART    ${cartSize }</b></span></a>
	        </div>
          </div>
          <div class="col-md-2" style="padding-top: 35px">
          	<div class="cart-list">
            	<a href='<c:url value='${wishlist_url }'></c:url>'><img src='<c:url value='static/images/wishlist-pro-icon.jpg'></c:url>' width='30px' height='30px' />
            	<span class="item"><b>WISHLIST   ${wishlistSize }</b></span></a>
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
            <li class="dropdown"><a class="dropbtn" href='<c:url value='/displayProduct/productList'></c:url>'>Genre <span class="caret"></span></a>
              <div class="dropdown-menu">
              	<c:forEach items="${categories}" var="category">
	              		<ul>
	              			<li><a href='<c:url value='/displayProduct/productList/categorywise/${category.category_id}'></c:url>'>${category.category_name}</a></li>
	              		</ul>
	  
              	</c:forEach>
 
            </div>
            </li>
          </ul>
          <%! String name; %>
          <% name=(String)session.getAttribute("role"); %>
          <c:set var="test" value="${name }"></c:set>
          <c:set var="role" value="ROLE_ADMIN"></c:set>
          <ul class="nav navbar-nav navbar-right">
          	<c:if test="${pageContext.request.userPrincipal.name == null }">
	            <li><a href='<c:url value='/login'></c:url>'>Sign In</a></li>
	            <li><a href='<c:url value='/Registration'></c:url>'>Register</a></li>
	            <!-- <li><a href=""><i class="glyphicon glyphicon-shopping-cart" style="font-size:15px"></i><span class="sr-only">(current)</span></a></li> -->
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null }">
            	<li class="${Contactus} dropdown"><a class="dropbtn" href='<c:url value='/home'></c:url>'>${pageContext.request.userPrincipal.name} <span class="caret"></span></a>
			       	<ul class="dropdown-menu" style="width:150px">
			       		<li><a href='<c:url value='/user/${pageContext.request.userPrincipal.name}/account'></c:url>'>your account</a></li>         <%-- /account?username=${user} --%>
			       		<%-- <li><a>your orders</a></li>
			       		<li><a href='<c:url value='/cart?username=${pageContext.request.userPrincipal.name}'></c:url>'>your cart</a></li> --%>
			       		<li><a href='<c:url value='/user/${pageContext.request.userPrincipal.name}/order'></c:url>'>your orders</a></li>
			       		<li><a href='<c:url value='/user/${pageContext.request.userPrincipal.name}/cart'></c:url>'>your cart</a></li>
 	       	        	<li><a href='<c:url value='/user/${pageContext.request.userPrincipal.name}/wishlist'></c:url>'>your wishlist</a></li>
			       	</ul>
			     </li>
            	<li><a href='<c:url value='/account?username=${pageContext.request.userPrincipal.name}'></c:url>' style="padding-bottom: 13px; padding-top: 13px"><img id="icon" src='<c:url value='/static/images/user/${pageContext.request.userPrincipal.name}.png'></c:url>' class="img img-rounded"/></a></li>
            	<li><a href='<c:url value='/logout'></c:url>'>Logout</a></li>
            	<c:if test="${test == role }">
            	
            		<a href='<c:url value='/gotoadminsection'></c:url>' >Admin Section</a>
            	
            	</c:if>
            	<%-- <li><a href='<c:url value='/cart?username=${pageContext.request.userPrincipal.name}'></c:url>'><i class="glyphicon glyphicon-shopping-cart" style="font-size:15px"></i><span class="sr-only">(current)</span></a></li> --%>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>  