<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
    <link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"   rel="stylesheet" type="text/css"  />
	<link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"   rel="stylesheet"  type="text/css"  />
	<link href="static/css/style.css"  rel="stylesheet" type="text/css" />
</head>
<body>
<c:import url="header.jsp" />
	<!-- grow -->
	<div class="grow">
		<div class="container">
			<h2>Login</h2>
		</div>
	</div>
<div class="container">
		<div class="account">
		<div class="account-pass">
		<div class="col-md-8 account-top">
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="POST">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
			<div> 	
				<span>Username</span>
				<input type="text" id="username" name="username" placeholder="Enter Username" required> 
			</div>
			<div> 
				<span >Password</span>
				<input type="password" id="password" name="password" placeholder="Enter Password" required>
			</div>				
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			  <div class="form-actions">
				<input type="submit" class="btn btn-block btn-primary btn-default" value="Login"><br />
			       New User 	<a href='<c:url value="/Registration" />' style="background:#444444;">REGISTER</a>	Here 
			</div>	
			</form>
		
		<!-- <div class="col-md-4 left-account">
			New User <a href="register.jsp">Register</a> Here
        </div> -->
		</div>
	</div>
	</div>

</div>
 <%@ include file="footer.jsp" %>
</body>
</html>