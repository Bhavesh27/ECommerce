<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"   rel="stylesheet" type="text/css"  />
	<link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"  type="text/javascript"  />
	<link href="static/css/carousel.css"  rel="stylesheet" type="text/css" />
	<link href="static/css/style.css"  rel="stylesheet" type="text/css" />
	<title>HOME page</title>
</head>
<body>
	<c:import url="header.jsp" />
	 <!-- Dear <strong>${user}</strong>, Welcome to Home Page. -->  
<!--  <div class="banner">
		<div class="container">
			  <script src="static/js/responsiveslides.min.js"></script>
  <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script> 
			<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider">
			    <li>
					
						<div class="banner-text">
							<h3>Lorem Ipsum is   </h3>
						<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC.</p>
						</div>
				
				</li>
				<li>
					
						<div class="banner-text">
							<h3>There are many  </h3>
						<p>Popular belief Contrary to , Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC.</p>
												

						</div>
					
				</li>
				<li>
						<div class="banner-text">
							<h3>Sed ut perspiciatis</h3>
						<p>Lorem Ipsum is not simply random text. Contrary to popular belief, It has roots in a piece of classical Latin literature from 45 BC.</p>
						</div>
					
				</li>
				<li>
						<div class="banner-text">
							<h3>Sed ut perspiciatis</h3>
						<p>Lorem Ipsum is not simply random text. Contrary to popular belief, It has roots in a piece of classical Latin literature from 45 BC.</p>
						</div>
					
				</li>
			</ul>
		</div>

	</div>
	</div>
 -->

   <!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img class="first-slide" src="static/images/ShowcaseV1.png" alt="First slide">
      <div class="container">
        <div class="carousel-caption">
          <!-- <h1>Example headline.</h1>
          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p> -->
        </div>
      </div>
    </div>
    <div class="item">
      <img class="second-slide" src="static/images/ShowcaseV2.png" alt="Second slide" >
      <div class="container">
        <div class="carousel-caption">
          <!-- <h1>Another example headline.</h1>
          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p> -->
        </div>
      </div>
    </div>
    <div class="item">
      <img class="second-slide" src="static/images/ShowcaseV3.png" alt="Third slide" >
      <div class="container">
        <div class="carousel-caption">
          <!-- <h1>Another example headline.</h1>
          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p> -->
        </div>
      </div>
    </div>
    <div class="item">
      <img class="third-slide" src="static/images/ShowcaseV4.png" alt="Fourth slide" >
      <div class="container">
        <div class="carousel-caption">
          <!-- <h1>One more for good measure.</h1>
          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p> -->
        </div>
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
<!-- /.carousel -->
 
 <!--content-->
<div class="container">
	<div class="cont">
		<div class="content">
			<div class="content-top-bottom">
				<h2>Featured PRODUCTS</h2>
				<div class="col-md-6 men">
					<a href="#" class="b-link-stripe b-animate-go  thickbox" ><img class="img-responsive" src="static/images/image06.jpg" alt="" />
						<div class="b-wrapper">
							<h3 class="b-animate b-from-top top-in   b-delay03 ">
								<span>TRIBECA LIVING</span>	
							</h3>
						</div>
					</a>
				</div>
				<div class="col-md-6">
					<div class="col-md1 ">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox" ><img class="img-responsive" src="static/images/image05.jpg" alt="" />
							<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in1   b-delay03 ">
												<span>CLARISSA</span>	
											</h3>
										</div>
						</a>
						
					</div>
					<div class="col-md2">
						<div class="col-md-6 men1">
							<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="static/images/image04.jpg" alt="" />
									<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in2   b-delay03 ">
												<span>COLORMATE</span>	
											</h3>
										</div>
							</a>
							
						</div>
						<div class="col-md-6 men2">
							<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="static/images/image03.jpg" alt="" />
									<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in2   b-delay03 ">
												<span>HERLEQUIN</span>	
											</h3>
										</div>
							</a>
							
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="content-top">
				<h1>NEW PRODUCTS</h1>
				<div class="grid-in">
					<div class="col-md-3 grid-top simpleCart_shelfItem">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="static/images/image01.jpg" alt="" />
							<div class="b-wrapper">
								<h3 class="b-animate b-from-left    b-delay03 ">
									<span>TRIBECA LIVING</span>
									
								</h3>
							</div>
						</a>
				

					<p><a href="single.html">TRIBECA LIVING</a></p>
					<a href="#" class="item_add"><p class="number item_price"><i>$500.00 </i></p></a>
					</div>
					<div class="col-md-3 grid-top simpleCart_shelfItem">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="static/images/image02.jpg" alt="" >
							<div class="b-wrapper">
											<h3 class="b-animate b-from-left    b-delay03 ">
												<span>ESSENTIAL</span>	
											</h3>
										</div>
						</a>
					<p><a href="single.html">ESSENTIAL</a></p>
					<a href="#" class="item_add"><p class="number item_price"><i>$500.00</i></p></a>
					</div>
					<div class="col-md-3 grid-top simpleCart_shelfItem">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="static/images/image07.jpg" alt="" >
							<div class="b-wrapper">
											<h3 class="b-animate b-from-left    b-delay03 ">
												<span>CLARISSA</span>	
											</h3>
										</div>
						</a>
					<p><a href="single.html">CLARISSA</a></p>
					<a href="#" class="item_add"><p class="number item_price"><i>$500.00</i></p></a>
					</div>
					<div class="col-md-3 grid-top">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="static/images/image08.jpg" alt="" />
							<div class="b-wrapper">
											<h3 class="b-animate b-from-left    b-delay03 ">
												<span>LITTLE HOME</span>	
											</h3>
										</div>
						</a>
					<p><a href="single.html">LITTLE HOME</a></p>
					<a href="#" class="item_add"><p class="number item_price"><i>$500.00</i></p></a>
					</div>
							<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	<!----->
	</div>
	<!---->
</div>
	<a href="<c:url value="/logout" />">Logout</a>
	<c:import url="footer.jsp" />
</body>
</html>