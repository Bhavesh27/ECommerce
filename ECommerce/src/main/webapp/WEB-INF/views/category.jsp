<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" 
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Category</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/stylesheet.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
     <script type="text/javascript" src="static/js/table_filter.js"></script>
     
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
          </div>
          <div class="col-md-9">
            <!-- Website Overview -->
            <div class="panel panel-default">
              <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Add Category</h3>
              </div>
              <div class="panel-body">
                <form:form action="addCategory" method="post" commandName="newCategory">
                  <div class="form-group">
                    <label>Category Name</label>
                    <input type="text" class="form-control" name="category_name" placeholder="Enter Category Name" value="">
                  </div>
                  <div class="form-group">
                    <label>Category Description</label>
                    <input type="text" class="form-control" name="category_desc" placeholder="Enter Category Description" value="">
                  </div>
                  <input type="submit" class="btn btn-default" value="Submit">
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
                          <input class="search form-control" type="text" placeholder="Filter Categories...">
                      </div>
                </div>
                <br>
                <table class="table table-striped table-hover table-responsive results">
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
	                        <td><a class="btn btn-default" href="<c:url value="/categoryEdit-${category.category_id }"/>">Edit</a> <a class="btn btn-danger" href="<c:url value="/delete-category-${category.category_id}" />">Delete</a></td>
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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>