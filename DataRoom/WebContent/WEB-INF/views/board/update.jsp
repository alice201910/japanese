<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Data Room - list</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by FreeHTML5.co" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="FreeHTML5.co" />

<!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FreeHTML5.co
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	-->

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="../../css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="../../css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="../../css/bootstrap.css">
<!-- Flexslider  -->
<link rel="stylesheet" href="../../css/flexslider.css">
<!-- Theme style  -->
<link rel="stylesheet" href="../../css/style.css">

<!-- Modernizr JS -->
<script src="../../js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
html {
	margin: 0px;
}

div>h1 {
	margin-left: 60px;
}

#cancel {
	float: right;
	margin-right: 60px;
}

.form-horizontal {
	float: left;
}

.col-sm-2 control-label {
	padding: 0px;
	background-color: black;
}

.form-control {
	background-color: white;
}

#ri {
	margin-left: 480px;
}

.form-control {
	background-color: white;
}
</style>
</head>
<body>
	<!-- #228896 -->
	<div id="fh5co-page">
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
		<aside id="fh5co-aside" role="complementary"
			class="border js-fullheight">

			<h1 id="fh5co-logo">
				<a href="/main">Marble</a>
			</h1>
			<nav id="fh5co-main-menu" role="navigation">
				<ul>
					<li><a href="/main">Home</a></li>
					<li class="fh5co-active"><a href="/board/list">DataRoom</a></li>
				</ul>
			</nav>
			<div class="fh5co-footer">
				<p>
					<small><span>&copy; 2016 Blend Free HTML5. All
							Rights Reserved.</span> <span>Designed by <a
							href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a>
					</span> <span>Demo Images: <a href="https://unsplash.com/"
							target="_blank">Unsplash</a></span></small>
				</p>
				<ul>
					<li><a href="#"><i class="icon-facebook2"></i></a></li>
					<li><a href="#"><i class="icon-twitter2"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
					<li><a href="#"><i class="icon-linkedin2"></i></a></li>
				</ul>
			</div>
		</aside>
		<div id="fh5co-main">
			<div class="fh5co-narrow-content">
				<h2 class="fh5co-heading animate-box"
					data-animate-effect="fadeInLeft">Data Room</h2>
				<div class="row row-bottom-padded-md">
					<div class="forms">
						<form id="form1" class="form-horizontal" method="post" action="/board/update" enctype="multipart/form-data">
						<input type="hidden" value="${param.page}" name="page">
						<input type="hidden" value="${param.amount}" name="amount">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-1 control-label">title</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="mem_title"
										value="${board.title}" placeholder="title">
								</div>
							</div>
							<div class="form-group">
								<label for="contents" class="col-sm-1 control-label">content</label>
								<div class="col-sm-10">
									<textarea rows="10" cols="100" class="form-control"
										name="mem_content">${board.content}</textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-1  control-label">writer</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="mem_writer" readonly="readonly"
										value="${board.writer}" placeholder="wirter">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputFile" class="col-sm-1  control-label">file</label>
								<div class="col-sm-10">
									<input type="file" id="exampleInputFile" name="fs"
										class="form-control" multiple="multiple">
								</div>
							</div>
							<input type="hidden" value="${board.bno}" name="bno">
							<div>
								<c:forEach var="file" items="${board.fnames}">
									<div class="form-group">
										<div class="col-sm-1">
											<div class="container show-grid board-table" id="tb">
												<div class="row board-head">
													<div class="col-md-2" class="fn" id="fn">${file}
														<i class="fa fa-times" style="font-size: 20px; color: red" id="btn" data-file='${file}'></i>
														
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>

							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-8">
									<button type="submit" class="btn btn-default">UPDATE</button>
								</div> 
							<div class="col-sm-offset-1 col-sm-2"> <a
									href="/board/list"><button class="btn btn-default">취소</button></a>
							</div>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="../../js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="../../js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="../../js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="../../js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="../../js/jquery.flexslider-min.js"></script>
	<!-- MAIN JS -->
	<script src="../../js/main.js"></script>
	<script>
		function cancel() {
			location.href = "/board/list";
		}
	</script>
	
	<script>
	
	var formObj = $("#form1");
	
	
	$('#fn i').click(function(){
		
		var fileName = $(this).attr("data-file")
		
		console.log("click icon: " + fileName);
		
		var str = "<input type='hidden' name='file_fn' value='"+fileName+"'/>";
		formObj.append(str);
		
		$(this).parent().hide()
		
	});
</script>
</body>
</html>

