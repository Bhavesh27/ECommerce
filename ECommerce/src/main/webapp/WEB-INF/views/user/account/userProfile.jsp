<%@page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	
<!-- 	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />-->

	<title>User Profile Page</title>

<!-- 	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" /> -->


    <!-- Bootstrap core CSS     -->
    <link href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />

    <!--  Light Bootstrap Table core CSS    -->
    <link href="${pageContext.request.contextPath}/static/css/light-bootstrap-dashboard.css" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    
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
<c:import url="../../header.jsp"></c:import>
<div class="wrapper">
        <nav class="navbar navbar-default navbar-fixed"> 
            <div class="container-fluid">
                <div class="navbar-header">
                    <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button> -->
                    <a class="navbar-brand" href="#">User Profile</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="">
                               ${username}
                            </a>
                        </li>
                        <li>
                            <a href='<c:url value='/logout' ></c:url>' >Log out
                            </a>
                        </li> 
                    </ul>
                </div>
            </div>
        </nav>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content col-md-12">
                            	<div class="col-md-3"></div>
                            	<div class="col-md-9">
									<%-- <form:form  action="updatingAccount-${updateUser.id}" enctype="multipart/form-data" commandName="updateUser" method="POST">
										<div class="row">
											<div>
											<input type="hidden" name="password" value="${updateUser.password}">
		                                        <div class="col-md-3">
		                                            <div class="form-group">
		                                                <label>Username</label>
		                                                <input type="text" name="username" class="form-control" placeholder="username" value="${updateUser.username}">
		                                            </div>
		                                        </div>
		                                        <div class="col-md-4">
		                                            <div class="form-group">
		                                                <label>Email Id</label>
		                                                <input type="email" name="email" class="form-control" placeholder="email" value="${updateUser.email}" >
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <div class="row">
		                                        <div class="col-md-6">
		                                            <div class="form-group">
		                                                <label>Name</label>
		                                                <input type="text" name="name" class="form-control" placeholder="Enter Name" value="${updateUser.name}" required>
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <div class="">
		                                    	<div class="col-md-4">
						                        <div class="card card-user">
						                            <div class="image">
						                                <img src="http://placehold.it/150x200" id="output" class="img-responsive img product_img" alt="UPLOAD PICTURE" height="200px"  width="150px" />
						                                <input type="file"  value="Upload Photo" name="image" onchange="loadFile(event)"/>
						                            </div>
						               
						                        </div>
						                    </div>
		                                    </div>
		                                    </div>
		                                    <div class="row">
		                                        <div class="col-md-12">
		                                            <div class="form-group">
		                                                <label>Address</label>
		                                                <input type="text" name="address" class="form-control" placeholder="Enter Address" value="${updateUser.address}" required>
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <div class="row">
		                                        <div class="col-md-4">
		                                            <div class="form-group">
		                                                <label>Mobile No</label>
		                                                <input type="tel" name="mobileno" class="form-control" placeholder="Enter Mobile No" value="${updateUser.mobileno}" required>
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
		                                    <div class="clearfix"></div>
					  					</form:form> --%>
					  					<c:choose>
			<c:when test="${edit}">
				<form:form action="updatingAccount/${updateUser.user_id }" method="POST" commandName="updateUser" enctype="multipart/form-data">
					<input type="hidden" name="username" value="${updateUser.username }" readonly>
					<input type="hidden" name="password" value="${updateUser.password }" readonly>
				<div class="row">
	            	<div class="col-md-4">
	                	<div class="form-group">
	                    	<label>Name</label>
	                        	<form:input type="text" path="name" class="form-control" placeholder="Enter Name" value="${updateUser.name}"/>
	                     </div>
	                </div>
	                <div class="col-md-8">
	                	<div class="form-group">
	                                                <label>Email Id</label>
	                                                <form:input type="email" path="email" class="form-control" placeholder="Email" value="${updateUser.email}" />
	                    </div>   
	                 </div>
	              </div>
	              <div class="row">
	                                        <div class="col-md-12">
	                                            <div class="form-group">
	                                                <label>Address</label>
	                                                <form:input type="text" path="address" class="form-control" placeholder="Enter Address" value="${updateUser.address }" />
	                                            </div>
	                                        </div>
	              </div>   
	              <div class="row">
	                                        
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Mobile No</label>
	                                                <form:input type="tel" path="mobile_no" class="form-control" placeholder="Enter Mobile No" value="${updateUser.mobile }" />
	                                            </div>
	                                        </div>
	                                        <div class="col-md-8">
	                                            <div class="form-group">
	                                                <label>Image</label>
	                                                <form:input type="file" path="user_image" class="form-control" onchange="loadFile(event)"/>
	                                            </div>
	                                        </div>
	              </div>
	
	                                    <div class="row">
	                                    	<button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
	                                    </div>                    
			</form:form>
		</c:when>
		<c:otherwise>
			${user.name}
			<a href='<c:url value='/user/${user.username}/account/edit-details/${user.user_id}'></c:url>'>edit details</a>
		</c:otherwise>
		</c:choose>
				  					</div>
				  					<div class="col-md-3"></div>
				  				</div>
                 			</div>
               			</div>
             		</div>
            	</div>
        </div>
    </div>
<c:import url="../../footer.jsp"></c:import>

</body>
</html>
