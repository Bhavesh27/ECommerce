<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
    <link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"   rel="stylesheet" type="text/css"  />
	<link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"  type="text/javascript"  />
	<link href="static/css/style.css"  rel="stylesheet" type="text/css" />
	
</head>
<body>
<!-- <div id="fb-root"></div> -->
<!-- <script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.8&appId=362298237471390";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script> -->
<%-- <c:import url="header.jsp" /> --%>
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
			<form action="${loginUrl}" method="POST" >                      <%--  ${loginUrl} --%>
				<%-- <c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid UserName and Password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if> --%>
			<div> 	
				<span>UserName</span>
				<input type="text" id="username" name="username" placeholder="Enter Username" required> 
			</div>
			<div> 
				<span >Password</span>
				<input type="password" id="password" name="password" placeholder="Enter Password" required>
			</div>				
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			  <div class="form-actions">
				<input type="submit" class="btn btn-block btn-primary btn-default" value="Login"><br />
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid UserName and Password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
			      
			</div>	
			</form>
		
		<div class="col-md-4 left-account">
			<span class=> New User 	<a href='<c:url value="/Registration" />' style="color:#444444;"><span>REGISTER</span></a>	Here </span>
        </div> 
		</div>
	</div>
	</div>
</div>
<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="true" data-auto-logout-link="true"></div>
<%--  <%@ include file="footer.jsp" %> --%>
</body>
</html>
