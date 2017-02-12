<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Register</title>


<link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"   rel="stylesheet"  />
	<link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"   rel="stylesheet"   /> 
<link href="static/css/style.css" rel="stylesheet"  />	


</head>
<body>
 <%-- <%@ include file="header.jsp" %> --%>
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
         <form:form action="register" commandName="adduser" enctype="multipart/form-data" method="POST" > 
				 <div class="col-md-6 register-top-grid">
					<h3>Personal Information</h3>
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
						 <input type="tel" name="mobileno" maxlength="10" min="10"> 
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
							   <div>
								<span>Image</span>
								<input type="file" name="image">
							 </div>      
							 <br />
							 <input type="submit" value="submit">
							
					 </div>
					 <div class="clearfix"> </div>
				</form:form>
			</div>
</div>
 <%-- <%@ include file="footer.jsp" %> --%>
</body>
</html>
			