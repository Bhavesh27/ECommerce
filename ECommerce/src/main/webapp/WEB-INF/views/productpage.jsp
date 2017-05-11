<%@ include file = "header.jsp"  %>		
   <div class="row">		
  		
  	<div class="col-md-6">		
  		<img src='<c:url value='static/images/product/${book.product_name }.png'></c:url>' width=300px height=400px />		
  		<a href='<c:url value='addCartItem?book=${book.product_name }'></c:url>' class="btn btn-warning">Add To Cart</a>		
  		<a href='<c:url value='addWishlistItem?book=${book.product_name }'></c:url>' class="btn btn-danger">Add To Wishlist</a>		
  	</div>		
  	<div class="col-md-6">		
  		<h3>${book.product_name }</h3>		
  		<h6>${book.description }</h6>		
  		${book.price }		
  	</div>		
   </div>		
 <%@ include file = "footer.jsp"  %>