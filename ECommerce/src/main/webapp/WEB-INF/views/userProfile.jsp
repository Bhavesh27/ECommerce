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
    <link href="light-bootstrap-dashboard.css" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    
</head>
<body>
<c:import url="header.jsp"></c:import>
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
                    <!-- <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-globe"></i>
                                    <b class="caret"></b>
                                    <span class="notification">5</span>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                              </ul>
                        </li>
                    </ul> -->

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="">
                               ${username}
                            </a>
                        </li>
                        <%-- <li>
                            <a href='<c:url value='/logout' ></c:url>' >Log out
                            </a>
                        </li> --%>
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
                            <div class="content">
                                
                                    
									<form:form  action="updatingAccount-${updateUser.id}" enctype="multipart/form-data" commandName="updateUser" method="POST">
										<div class="row">
										
											<input type="hidden" name="password" value="${updateUser.password }">
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
	                                                <label>First Name</label>
	                                                <input type="text" name="name" class="form-control" placeholder="Enter Name" value="${updateUser.name}" required>
	                                            </div>
	                                        </div>
	                                        <!-- <div class="col-md-6">
	                                            <div class="form-group">
	                                                <label>Last Name</label> 
	                                                <input type="text" name="lastName" class="form-control" placeholder="Enter Last Name" value="" required>
	                                            </div>
	                                        </div> -->
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
	                                        <!-- <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>City</label>
	                                                <input type="text" name="city" class="form-control" placeholder="Enter City" value="" required>
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Country</label>
	                                                <input type="text" name="country" class="form-control" placeholder="Enter Country" value="" required>
	                                            </div>
	                                        </div> -->
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Mobile No</label>
	                                                <input type="tel" name="mobileno" class="form-control" placeholder="Enter Mobile No" value="${updateUser.mobileno}" required>
	                                            </div>
	                                        </div>
	                                    </div>
	
	                                    <button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
	                                    <div class="clearfix"></div>
                            
					                    <div class="col-md-4">
					                        <div class="card card-user">
					                            <div class="image">
					                                <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400" alt="Upload Profile Picture"/>
					                            </div>
					                            <div class="content">
					                                <div class="author">
					                                     <a href="#">
					                                     <img class="avatar border-gray" src="#" alt="Upload Profile Picture" />
					                                      ${updateUser.username}<br><small>${updateUser.email}</small>
					                                     </a>
					                                </div>
					                                <input type="file"  value="Upload Photo" name="image" />
					                            </div>
					                            <hr>
					                        </div>
					                    </div>
				  					</form:form>
				  				</div>
                 			</div>
               			</div>
             		</div>
            	</div>
        </div>
    </div>
<c:import url="footer.jsp"></c:import>

</body>
</html>
