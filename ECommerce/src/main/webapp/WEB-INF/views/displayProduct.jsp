<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nerdsville</title>
<style>
.product-list {
	margin: 20px;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
	
	<div class="container">
		<div class="row">
			<c:forEach items="${books }" var="book">
				<%-- <div class="col-md-2">
					<a href='#'><img src='<c:url value='static/images/product/${book.name }.png'></c:url>' width=150px height=200px /></a>
				</div> --%>
				<div class="product-list">
					<div class="col-md-2">
						<a href='<c:url value='/descriptionPage?book=${book.product_name }'></c:url>'><img src='<c:url value='static/images/product/${book.product_name }.png'></c:url>' width=150px height=200px /></a>
						<h4>${book.product_name }</h4> by ${book.author }
					</div>
			</c:forEach>
		</div>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>