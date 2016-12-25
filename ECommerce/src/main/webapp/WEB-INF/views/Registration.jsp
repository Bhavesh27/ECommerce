<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link href="<c:url value=' ../static/css/bootstrap.css' />"  rel="stylesheet" type="text/css" media="all" />

<link href="<c:url value=' ../static/css/style.css' />" rel="stylesheet" type="text/css" media="all" />	

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<body>
	<!-- grow -->
	<div class="grow">
		<div class="container">
			<h2>Register</h2>
		</div>
	</div>
	<!-- grow -->
<!--content-->
<div class="container">
<div class="register">
		  	  <form:form action="register" method="post" commandName="adduser"> 
				 <div class="col-md-6 register-top-grid">
					<h3>Personal infomation</h3>
					 <div>
						<span>Name</span>
						<input type="text" name="name"> 
					 </div>
					 <div>
						<span>Email</span>
						<input type="email" name="email"> 
					 </div>
					 <div>
						 <span>Mobile-No</span>
						 <input type="number" maxlength="10" min="10"> 
					 </div>
					  <!--  <a class="news-letter" href="#">
						 <label class="checkbox"><input type="checkbox" checked=""><i> </i>Sign Up for Newsletter</label>
					   </a> -->
					 </div>
				     <div class="col-md-6 register-bottom-grid">
						    <h3>Login information</h3>
							 <div>
								<span>Username</span>
								<input type="text" name="username">
							 </div>
							 <div>
								<span>Password</span>
								<input type="password" name="password">
							 </div>
							 <input type="submit" value="submit">
							
					 </div>
					 <div class="clearfix"> </div>
				</form:form>
			</div>
</div>
</body>
</html>
			