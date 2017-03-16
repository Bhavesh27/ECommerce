<%@page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
         <form:form action="register" commandName="adduser" method="POST" > 
				 <div class="col-md-6 register-top-grid">
					<h3>Personal Information</h3>
					 <div>
						<span>Name</span>
						<input type="text" name="name" placeholder="Enter Name" required> 
					 </div>
					 <div>
						<span>Email</span>
						<input type="email" name="email" placeholder="Enter Email" required> 
					 </div>
					 <div>
						 <span>Mobile-No</span>
						 <input type="tel" name="mobileno" maxlength="10" min="10" placeholder="Enter Mobile No" required> 
					 </div>
					  <!--  <a class="news-letter" href="#">
						 <label class="checkbox"><input type="checkbox" checked=""><i> </i>Sign Up for Newsletter</label>
					   </a> -->
					 </div>
				     <div class="col-md-6 register-bottom-grid">
						    <h3>Login information</h3>
							 <div>
								<span>Username</span>
								<input type="text" name="username" placeholder="Enter Username" required>
							 </div>
							 <div>
								<span>Password</span>
								<input type="password" name="password" placeholder="Enter Password" required>
							 </div>
							  <!--  <div>
								<span>Image</span>
								<input type="file" name="image">
							 </div> -->      
							 <br />
							 <input type="submit" value="submit">
							
					 </div>
					 <div class="clearfix"> </div><br />
					 <br/>
					  <c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>${Msg}</p>
					</div>
				</c:if>
				<%--
				<c:if test="${param.username != null}">
					<div class="alert alert-success">
						<p>${usernameMsg}</p>
					</div>
				</c:if>
				<c:if test="${param.mobileno != null}">
					<div class="alert alert-success">
						<p>${mobilenoMsg}</p>
					</div>
				</c:if> --%>
				
					 
				</form:form>
			</div>
</div>
 <%-- <%@ include file="footer.jsp" %> --%>
</body>
</html>
			