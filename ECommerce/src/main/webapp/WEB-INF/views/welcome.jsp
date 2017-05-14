<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Griffy" rel="stylesheet">
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/landing.css">
	
	<title>HOME page</title>
</head>
<body>
	<c:import url="header.jsp" />
	<div class="container-fluid">
		<div class="row">
		 <div class="col-md-12">
			<div class="carousel slide" id="myCarousel" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#myCarousel">
					</li>
					<li data-slide-to="1" data-target="#myCarousel" class="active">
					</li>
					<li data-slide-to="2" data-target="#myCarousel">
					</li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="item">
						<img alt="Carousel Bootstrap First" src="http://lorempixel.com/output/sports-q-c-1600-500-1.jpg" />
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item active">
						<img alt="Carousel Bootstrap Second" src="http://lorempixel.com/output/sports-q-c-1600-500-2.jpg" />
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="Carousel Bootstrap Third" src="http://lorempixel.com/output/sports-q-c-1600-500-3.jpg" />
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> 
				<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<h3>Deals of the Day</h3>
	</div>
	<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-md-3 col-sm-4">
				<div class="box">
					<div class="row">
						<div class="col-md-7 col-sm-8 col-xs-6">
							<div class="flip-container" ontouchstart="this.classList.toggle('hover');">
								<div class="flipper">
									<div class="front">
										<img src='<c:url value='/static/images/product/${product.name}.png'></c:url>' height='200px' width='150px'/>
									</div>
									<div class="back">
										<div class="btn-group">
											<a href='<c:url value='/addCart?productName=${product.name}'></c:url>'><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>ADD TO CART</a>
											<a href='<c:url value='/addWishlistItem?book=${product.name }'></c:url>'><span id="icon"><i class="fa fa-heart" aria-hidden="true"></i></span>ADD TO WISHLIST</a>
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>BUY NOW</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5 col-sm-4 col-xs-6">
							<div class="info">
								<h4>${product.name }</h4>
								<p>${product.author_name }</p>
								<c:if test="${product.discount == 0 }">
									<p>&#x20b9 ${product.price }</p>
								</c:if>
								<c:if test="${product.discount > 0 }">
									<p><s>&#x20b9 ${product.price }</s></p>
									<p style="font-family: 'Pacifico', cursive; color: #888899; font-size: 20px">${product.discount}% off</p>
									<p>&#x20b9 ${product.price - product.discount * product.price / 100}</p>
								</c:if>
								<c:if test="${product.quantity  > 0}">
									<p style="color:green">In stock</p>
								</c:if>
								<c:if test="${product.quantity == 0 }">
									<p style="color:red"><del>Out of stock</del></p>	
								</c:if>	
							</div>
						</div>
					</div>
				</div>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<h3>Best Sellers</h3>
		</div>
		<div class="row">
			<h3>Latest Books</h3>
		</div>
		<div class="row">
			<h3>Upto 40% off</h3>
		</div>
	</div>
	<br>
    
    <br>
	<a href="<c:url value="/logout" />">Logout</a>
	<c:import url="footer.jsp" />
</body>
</html>