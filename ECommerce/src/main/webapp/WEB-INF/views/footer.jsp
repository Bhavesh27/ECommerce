<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="static/css/footer.css" rel="stylesheet" />
</head>
<body>
	<script>
	  window.fbAsyncInit = function() {
		FB.init({
		  appId      : '362298237471390',
		  xfbml      : true,
		  version    : 'v2.8'
		});
		FB.AppEvents.logPageView();
	  };

	  (function(d, s, id){
		 var js, fjs = d.getElementsByTagName(s)[0];
		 if (d.getElementById(id)) {return;}
		 js = d.createElement(s); js.id = id;
		 js.src = "//connect.facebook.net/en_US/sdk.js";
		 fjs.parentNode.insertBefore(js, fjs);
	   }(document, 'script', 'facebook-jssdk'));
	</script>
	<footer>
		<section>
			<h3><b>Nerds Villa</b></h3>
			<p><b>011-22474323</b><br /><br />
			1899 WoodWill Street<br />
			Noida Sector-21<br />
			NerdsVille@BooksLovers.com
		</section>
		<section>
			<h3>Connect With Us</h3>
			<ul class="social">
				<li><a href="www.facebook.com"><img src="static/images/fb.png" /></a></li>
				<li><a href="www.googleplus.com"><img src="static/images/googleplus.png" /></a></li>
				<li><a href="www.twitter.com"><img src="static/images/twitter1.png" /></a></li>
				<li><a href="www.youtube.com"><img src="static/images/youtube1.png" /></a></li>
			</ul>
		</section>
		<section>
			<img src="static/images/images.jpg" />
		</section>
	</footer>
	<footer class="second">
		<p> &copy; Copyright-NerdsVille,2010 </p>
	</footer>
</body>
</html>