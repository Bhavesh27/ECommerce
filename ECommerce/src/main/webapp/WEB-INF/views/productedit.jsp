<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/stylesheet.css" rel="stylesheet">
    <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>
  </head>
  <body>
  	<c:import url="adminheader.jsp"></c:import>
  
    <section id="breadcrumb">
      <div class="container">
        <ol class="breadcrumb">
          <li><a href="<c:url value="/admin"/>">Dashboard</a></li>
          <li><a href="<c:url value="/product"/>">Product</a></li>
          <li class="active">Edit Page</li>
        </ol>
      </div>
    </section>

    <section id="main">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <div class="list-group">
              <a href="<c:url value="/admin"/>" class="list-group-item active main-color-bg">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Dashboard
              </a>
              <a href="<c:url value="/product"/>" class="list-group-item"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Product <span class="badge">12</span></a>
              <a href="<c:url value="/supplier"/>" class="list-group-item"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Supplier <span class="badge">33</span></a>
              <a href="<c:url value="/users"/>" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Users <span class="badge">203</span></a>
            </div>
          </div>
          <div class="col-md-9">
            <!-- Website Overview -->
            <div class="panel panel-default">
              <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Product Edit Page</h3>
              </div>
              <div class="panel-body">
                <form:form action="edit-product-${product_id}" method="post" commandName="updateProduct">
                  <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Enter Product Name" value="${product_name}">
                  </div>
                  <div class="form-group">
                    <label>Product Description</label>
                    <input name="description" class="form-control" placeholder="Enter Product Description" value="${product_description}" />
                  </div>
                  <div class="form-group">
                  	<label>Select Category</label>
				    <form:select class="form-control" path="category.category_id" items="${category}" itemValue="category_id" itemLabel="category_name" />
                  </div>
                  <div class="form-group">
                    <label>Author Name</label>
                    <input type="text" class="form-control" name="author_name" placeholder="Enter Author Name" value="${product_author}">
                  </div>
                  <div class="form-group">
                  	<label>Select Supplier</label>
				    <form:select class="form-control" path="supplier.supplier_id" items="${suppliers}" itemValue="supplier_id" itemLabel="supplier_name"/>
                  </div>
                  <div class="form-group">
                    <label>Price</label>
                    <input type="number" name="price" class="form-control" placeholder="Enter Price" value="${product_price}" >
                  </div>
                  <div class="form-group">
                    <label>Quantity</label>
                    <input type="number" name="quantity" class="form-control" placeholder="Enter Quantity" value="${product_quantity}">
                  </div>
                  <input type="submit" class="btn btn-default" value="Submit">
                </form:form>
              </div>
              </div>

          </div>
        </div>
      </div>
    </section>

    <footer id="footer">
      <p>Copyright NerdsVille, &copy; 2017</p>
    </footer>

  <!-- <script>
     CKEDITOR.replace( 'editor1' );
 </script> -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
