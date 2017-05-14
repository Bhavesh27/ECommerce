<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nerdsville</title>
</head>
<body>
<%@ include file="header.jsp" %>
	
	<div class="container">
		<div class="row">
			<c:forEach items="${books }" var="book">
				<div class="col-md-2">
					<a href='#'><img src='${pageContext.request.contextPath}/static/images/product/${book.name }.png' width=150px height=200px /></a>
				</div>
			</c:forEach>
		</div>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>