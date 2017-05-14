<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="../../static/css/stylesheet.css" rel="stylesheet">  -->
    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="static/js/table_filter.js"></script> -->
    
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

	<c:import url="../adminheader.jsp"></c:import>
	
    <section id="breadcrumb">
      <div class="container">
        <ol class="breadcrumb">
          <li><a href="<c:url value="/admin"/>">Dashboard</a></li>
          <li class="active">Users</li>
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
                <h3 class="panel-title">Users</h3>
              </div>
              <div class="panel-body">
                <div class="row">
                      <div class="col-md-12">
                          <input class="form-control search" type="text" placeholder="Filter Users...">
                      </div>
                </div>
                <br>
                <table class="table table-striped table-hover results">
                      <thead>
                      <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Username</th>
                        <th>Mobile No</th>
                        <th>Status</th>
                        <th></th>
                      </tr>
                      </thead>
                      <tbody>
                      	<c:forEach items="${users}" var="user">
                      		<tr>
                      			<td><c:out value="${user.name}"></c:out></td>
	                      		<td><c:out value="${user.email}"></c:out></td>
	                      		<td><c:out value="${user.username}"></c:out></td>
	                      		<td><c:out value="${user.mobileno}"></c:out></td>
	                      		<td> 
	                      			<c:choose>
	                      				<c:when test="${user.isActive()}">
	                      					<c:out value="YES"></c:out>
	                      				</c:when>
	                      				<c:otherwise>
	                      					<c:out value="NO"></c:out>
	                      				</c:otherwise>
	                      			</c:choose>
	                      		</td> 
	                      		<td><a class="btn btn-default" href="<c:url value="/admin/users/changeStatus/${user.id}"/>">Change Status</a> <a class="btn btn-danger" href="<c:url value="/admin/users/delete/${user.id}"/>">Delete</a></td>
                      		</tr>
                      	</c:forEach>
                      </tbody>
                      
                      <!-- <tr>
                        <td>Jill Smith</td>
                        <td>jillsmith@gmail.com</td>
                        <td>Dec 12, 2016</td>
                        <td><a class="btn btn-default" href="edit.html">Edit</a> <a class="btn btn-danger" href="#">Delete</a></td>
                      </tr>
                      <tr>
                        <td>Eve Jackson</td>
                        <td>ejackson@yahoo.com</td>
                        <td>Dec 13, 2016</td>
                        <td><a class="btn btn-default" href="edit.html">Edit</a> <a class="btn btn-danger" href="#">Delete</a></td>
                      </tr>
                      <tr>
                       <td>Stephanie Landon</td>
                        <td>landon@yahoo.com</td>
                        <td>Dec 14, 2016</td>
                        <td><a class="btn btn-default" href="edit.html">Edit</a> <a class="btn btn-danger" href="#">Delete</a></td>
                      </tr>
                      <tr>
                        <td>Mike Johnson</td>
                        <td>mjohnson@gmail.com</td>
                        <td>Dec 15, 2016</td>
                        <td><a class="btn btn-default" href="edit.html">Edit</a> <a class="btn btn-danger" href="#">Delete</a></td>
                      </tr>
 -->                   
  </table>
              </div>
              </div>

          </div>
        </div>
      </div>
    </section>

    <footer id="footer">
      <p>Copyright Admin, &copy; 2017</p>
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
