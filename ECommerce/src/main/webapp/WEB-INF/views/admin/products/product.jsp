<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html >
  <head>
    <title>Admin</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="../../static/css/stylesheet.css" rel="stylesheet"> -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
     <!-- <script type="text/javascript" src="../../static/js/table_filter.js"></script> -->
     
     <style type="text/css">
	
	.results tr[visible='false'],
	
	.no-result{
	  display:none;
	}
	
	.results tr[visible='true']{
	  display:table-row;
	}
	.product_img {
		margin: 15px;
		margin-left: 30px;
		outline: 2px solid #111111;
		height: 200px;
		width: 150px;
	}
	</style>
	<script type="text/javascript">
		var loadFile = function(event) {
		    var reader = new FileReader();
		    reader.onload = function(){
		      var output = document.getElementById('output');
		      output.src = reader.result;
		    };
		    reader.readAsDataURL(event.target.files[0]);
		  };
		
		</script>
  </head>
  <body>
     <c:import url="../adminheader.jsp"></c:import>
    <section id="breadcrumb">
      <div class="container">
        <ol class="breadcrumb">
          <li><a href="<c:url value="/admin/dashboard"/>">Dashboard</a></li>
          <li class="active">Product</li>
        </ol>
      </div>
    </section>

    <section id="main">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <div class="list-group">
              <a href="<c:url value="/admin/dashboard"/>" class="list-group-item active main-color-bg">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Dashboard
              </a>
              <a href="<c:url value="/admin/products/product"/>" class="list-group-item"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Products <span class="badge">${products }</span></a>
              <a href="<c:url value="/admin/suppliers/supplier"/>" class="list-group-item"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Supplier <span class="badge">${suppliers }</span></a>
              <a href="<c:url value="/admin/users/user"/>" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Users <span class="badge">${users }</span></a>
              <a href="<c:url value="/admin/categorys/category"/>" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Categorys <span class="badge">${categories}</span></a>
            </div>
          </div>
          <div class="col-md-9">
            <!-- Website Overview -->
            
            <div class="panel panel-default">
              <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Add Product</h3>
              </div>
              <div class="panel-body">
                <form:form action="add" method="post" modelAttribute="newProduct" enctype="multipart/form-data">
                 <div class="col-md-9">
                  <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" class="form-control" name="product_name" placeholder="Enter Product Name" value="">
                  </div>
                  <div class="form-group">
                    <label>Product Description</label>
                    <input type="text" class="form-control" name="product_desc" placeholder="Enter Product Description" value="" />
                  </div>
                  
                  <div class="form-group col-md-6">
                  	<label>Select Category</label>
				    <form:select class="form-control" path="category.category_id" items="${category}" itemValue="category_id" itemLabel="category_name" />
                  </div>
                  <div class="form-group col-md-6">
                  	<label>Select Supplier</label>
				    <form:select class="form-control" path="supplier.supplier_id" items="${suppliers}" itemValue="supplier_id" itemLabel="supplier_name"/>
                  </div>
                  <div class="form-group">
                    <label>Author Name</label>
                    <input type="text" class="form-control" name="author_name" placeholder="Enter Author Name" value="">
                  </div>
                  </div>
                  <div class="col-md-3">
                  	<img src="http://placehold.it/150x200" id="output" class="img-responsive img product_img" alt="UPLOAD PICTURE" height="200px"  width="150px" />
                  	<input type="file" placeholder = "upload picture" class="button" id="product_image" name="product_image" onchange="loadFile(event)"/>
                  </div>
                  <div class="col-md-12">
                  <div class="form-group col-md-4">
                    <label>Price</label>
                    <input type="number" name="product_price" class="form-control" placeholder="Enter Price" value="" min="0" />
                  </div>
                  <div class="form-group col-md-4">
                    <label>Quantity</label>
                    <input type="number" name="product_quantity" class="form-control" placeholder="Enter Quantity" value="" min="0">
                  </div>
                  <div class="form-group col-md-4">
                    <label>Discount</label>
                    <input type="number" class="form-control" name="product_discount" placeholder="Enter Product Discount" value="" />
                  </div>
                  <input type="submit" class="btn btn-default" value="Submit">
                  </div>
                </form:form>
              </div>
              </div>
            
            <div class="panel panel-default">
              <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Product</h3>
              </div>
              <div class="panel-body">
                <div class="row">
                      <div class="col-md-12">
                          <input class="search form-control" type="text" placeholder="Filter Products..">
                      </div>
                </div>
                <br>
                <table class="table table-striped table-hover results">
                      <thead>
                      	<tr>
	                        <td>Name</td>
	                        <td>Price</td>
	                        <td>Author Name</td>
	                        <td>Quantity</td>
	                        <td></td>
                      	</tr>
                      </thead>
                      <tbody>
                      	<c:forEach items="${products}" var="product">
	                      <tr>
	                        <td><c:out value="${product.product_name}"></c:out></td>
	                        <td><c:out value="${product.product_price}"></c:out></td>
	                        <td><c:out value="${product.author_name}"></c:out></td>
	                        <td><c:out value="${product.product_quantity}"></c:out></td>
	                        <td><a class="btn btn-default" href="<c:url value="/admin/products/edit/${product.product_id}"/>">Edit</a> <a class="btn btn-danger" href="<c:url value="/admin/products/delete/${product.product_id}" />">Delete</a></td>
	                      </tr>
	                     </c:forEach>
                   </tbody>
                   </table>   
              </div>
              </div>

          </div>
        </div>
      </div>
    </section>

    <footer id="footer">
      <p>Copyright NerdsVille, &copy; 2017</p>
    </footer>



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="static/js/table_filter.js"></script>
   
  </body>
</html>
