<%@page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../header.jsp"></c:import>
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
	margin : 10px;
}
hr {
 	background-color: #000;
 	border: none;
    height: 1px;
    box-shadow: 2px 2px 2px;
  }		  
</style>
<div class="container">
	<div class="row">Shopping Cart  <p>${msg}</p>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-3"><h4>BOOK</h4></div>
		<div class="col-md-2"><h4>AUTHOR</h4></div>
		<div class="col-md-2"><h4>PRICE</h4></div>
		<div class="col-md-2"><h4>QUANTITY</h4></div>
		<div class="col-md-1"></div>
	</div>
	<c:set var="sub_total" value="0"></c:set>
		<c:forEach items="${products}" var="product">
		<div class="product">
			<div class="row">
				<div class="col-md-2">
					<img src='<c:url value='/static/images/product/${product.getProduct().getProduct_name()}.png'></c:url>' width=100px height=100px/>
				</div>
				<div class="col-md-3">
					<p>${product.getProduct().getProduct_name()}</p>
				</div>
				<div class="col-md-2">
					<p>${product.getProduct().getAuthor_name() }</p>
				</div>
				<div class="col-md-2">
					<p>${product.price }</p>
					<c:set var="sub_total" value="${sub_total + product.total}"></c:set>
					
				</div>
				<div class="col-md-2">
					<p><input type="number" class="form-control" value="${product.quantity}"/></p>
				</div>
				<div class="col-md-1">
					<a href='<c:url value='/user/${user}/cart/remove-cart/${product.cart_id }'></c:url>' title="remove"><i class="fa fa-times" aria-hidden="true" style="font-size:20px; color:#e60000"></i></a>
				</div>
			</div>
		</div>
		</c:forEach>
	<div class="ng-well" style="float:right; margin-right: 100px">
		<pre>Sub Total	: ${sub_total }</pre>
	</div>
	

<hr>
 	<div class="row product">
 		<div class="col-md-offset-3 col-md-2">
 			<a href='<c:url value='#'></c:url>' class="btn btn-lg btn-warning">Proceed to Checkout</a>
 		</div>
 		<div class="col-md-offset-1 col-md-2">
 		<a href='<c:url value='home'></c:url>' class="btn btn-lg btn-warning">Shop More</a>
 		</div>
 	</div>
 </div>
<%@ include file="../../footer.jsp"  %>