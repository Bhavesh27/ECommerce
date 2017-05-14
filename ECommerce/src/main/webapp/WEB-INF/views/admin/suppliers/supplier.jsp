<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
  <head>
   
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="../static/css/stylesheet.css" rel="stylesheet"> -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!--  <script type="text/javascript" src="../static/js/table_filter.js"></script> -->
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
 
 	 <c:import url="../adminheader.jsp" />
 	  <%--  <%@ include file="../adminheader.jsp" %> --%>
 	   <c:url var="supplierUrl" value="/admin/suppliers" />
    <section id="breadcrumb">
      <div class="container">
        <ol class="breadcrumb">
          <li><a href="<c:url value="/admin/dashboard"/>">Dashboard</a></li>
          <li class="active">Supplier</li>
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
              <a href="<c:url value="/admin/products/product"/>" class="list-group-item"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Products <span class="badge">${products}</span></a>
              <a href="<c:url value="/admin/suppliers/supplier"/>" class="list-group-item"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Supplier <span class="badge">${suppliers}</span></a>
              <a href="<c:url value="/admin/users/user"/>" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Users <span class="badge">${users}</span></a>
              <a href="<c:url value="/admin/categorys/category"/>" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Categorys <span class="badge">${categories}</span></a>
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
                <h3 class="panel-title">Add Supplier</h3>
              </div>
              <div class="panel-body">
                <form:form action="add" method="POST" commandName="newSupplier">
                  <div class="form-group">
                    <label>Supplier Name</label>
                    <input type="text" name="supplier_name" class="form-control" placeholder="Enter Supplier Name" value="" required />
                  </div>
                  <div class="form-group">
                    <label>Supplier Address</label>
                    <input name="address" class="form-control" placeholder="Enter Supplier Address" required />
                  </div>
                  <div class="form-group">
                    <label>Supplier Email ID</label>
                    <input type="email" name="emailid" class="form-control" placeholder="Enter Email Id" value="" required />
                  </div>
                  <div class="form-group">
                    <label>Enter Mobile No</label>
                    <input type="number" name="mobileno" class="form-control" placeholder="Enter Mobile No" value="" required />
                  </div>
                  <input type="submit" class="btn btn-default" value="Submit">
                </form:form>
              </div>
              </div>
            
            <div class="panel panel-default">
              <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Supplier</h3>
              </div>
              <div class="panel-body">
                <div class="row">
                      <div class="col-md-12">
                          <input class="search form-control" type="text" placeholder="Filter Suppliers...">
                      </div>
                </div>
                <br>
                <table class="table table-striped table-hover results">
                      <thead>
                      <tr>
                        <td>Name</td>
                        <td>Address</td>
                        <td>Email ID</td>
                        <td>Mobile No</td>
                        <td></td>
                      </tr>
                      </thead>
                      <tbody>
                      
                      	<c:forEach items="${suppliers}" var="supplier">
                      		<tr>
                      			<td>${supplier.supplier_name }</td>
                      			<td>${supplier.address }</td>
                      			<td>${supplier.emailid }</td>
                      			<td>${supplier.mobileno }</td>
                      			<td><a class="btn btn-default" href="<c:url value="/admin/suppliers/edit/${supplier.supplier_id}"/>">Edit</a> <a class="btn btn-danger" href="<c:url value="/admin/suppliers/delete/${supplier.supplier_id}" />">Delete</a></td>
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
