<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" 
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Category</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/stylesheet.css" rel="stylesheet">
</head>
<body>
	<c:import url="adminheader.jsp"></c:import>
	<section id="breadcrumb">
      <div class="container">
        <ol class="breadcrumb">
          <li><a href="<c:url value="/admin"/>">Dashboard</a></li>
          <li class="active">Product</li>
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

            <!-- <div class="well">
              <h4>Disk Space Used</h4>
              <div class="progress">
                  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                      60%
              </div>
            </div>
            <h4>Bandwidth Used </h4>
            <div class="progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
                    40%
            </div>
          </div>
            </div> -->
          </div>
          <div class="col-md-9">
            <!-- Website Overview -->
            <div class="panel panel-default">
              <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Product</h3>
              </div>
              <div class="panel-body">
                <div class="row">
                      <div class="col-md-12">
                          <input class="form-control" type="text" placeholder="Filter Products...">
                      </div>
                </div>
                <br>
                <table class="table table-striped table-hover">
                      <thead>
                      	<tr>
	                        <td>Name</td>
	                        <td>Description</td>
	                        <!-- <td>Author Name</td>
	                        <td>Quantity</td> -->
	                        <td></td>
                      	</tr>
                      </thead>
                      <tbody>
                      	<c:forEach items="${categories}" var="category">
	                      <tr>
	                        <td><c:out value="${category.category_name}"></c:out></td>
	                        <td><c:out value="${category.category_desc}"></c:out></td>
	                        <%-- <td><c:out value="${product.author_name}"></c:out></td>
	                        <td><c:out value="${product.quantity}"></c:out></td> --%>
	                        <td><a class="btn btn-default" href="<c:url value="/categoryEdit"/>">Edit</a> <a class="btn btn-danger" href="<c:url value="/delete-product-{product_id}" />">Delete</a></td>
	                      </tr>
	                     </c:forEach>
                   </tbody>
                   </table>   
                      
                      <!-- 
                      <td>Home</td>
                        <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                        <td>Dec 12, 2016</td>
                        <td><a class="btn btn-default" href="edit.html">Edit</a> <a class="btn btn-danger" href="#">Delete</a></td>
                      <tr>
                        <td>About</td>
                        <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                        <td>Dec 13, 2016</td>
                        <td><a class="btn btn-default" href="edit.html">Edit</a> <a class="btn btn-danger" href="#">Delete</a></td>
                      </tr>
                      <tr>
                        <td>Services</td>
                        <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                        <td>Dec 13, 2016</td>
                        <td><a class="btn btn-default" href="edit.html">Edit</a> <a class="btn btn-danger" href="#">Delete</a></td>
                      </tr>
                      <tr>
                        <td>Contact</td>
                        <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                        <td>Dec 14, 2016</td>
                        <td><a class="btn btn-default" href="edit.html">Edit</a> <a class="btn btn-danger" href="#">Delete</a></td>
                      </tr> -->
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