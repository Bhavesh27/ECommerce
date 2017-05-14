<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../header.jsp"  %>
 <style>
 h4:after {
     content:' ';
     display:block;
     border:2px solid #0040FF;
     border-radius:4px;
     padding-left: 20px;
 	padding-right: 20px;
     -webkit-border-radius:4px;
     -moz-border-radius:4px;
     box-shadow:inset 0 1px 1px rgba(0, 0, 0, .05);
     -webkit-box-shadow:inset 0 1px 1px rgba(0, 0, 0, .05);
     -moz-box-shadow:inset 0 1px 1px rgba(0, 0, 0, .05);
 }
 .product {
 	margin : 5px;
 }
 </style>
 <div class="container">
 	<div class="row">Wishlist  <p>${msg}</p>
 	</div>
 	<div class="row">
 		<div class="col-md-2"></div>
 		<div class="col-md-3"><h4>BOOK</h4></div>
 		<div class="col-md-2"><h4>AUTHOR</h4></div>
 		<div class="col-md-4"><h4>DESCRIPTION</h4></div>
 		<div class="col-md-1"></div>
 	</div>
 	<c:set var="sub_total" value="0"></c:set>
 		<c:forEach items="${products }" var="product">
 		<div class="product">
 			<div class="row">
 				<div class="col-md-2">
 					<img src='<c:url value='/static/images/product/${product.product_name }.png'></c:url>' width=100px height=100px/>
 				</div>
 				<div class="col-md-3">
 					<p>${product.product_name }</p>
 				</div>
 				<div class="col-md-2">
 					<p>${product.author }</p>
 				</div>
 				<div class="col-md-4">
 					<p>${product.description }</p>
 				</div>
 				<div class="col-md-1">
 					<a href='<c:url value='remove-wishlist-${product.wishlist_id }'></c:url>'><i class="fa fa-times" aria-hidden="true" style="font-size:20px; color:#e60000"></i></a>
 				</div>
 			</div>
 		</div>
 		</c:forEach>
 </div>
 <%@ include file="../../footer.jsp"  %> 