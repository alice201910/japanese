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
<script>
	function del() {
		var condel = confirm("정말 삭제하시겠습니까?");
		if (condel) {
			location.href = '/board/delete?bno=${param.bno}&page=${param.page}&amount=${param.amount}';
		} else {

		}
	}
</script>
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
					<form class="form-horizontal" method="post" action="/board/create"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-1 control-label">title</label>
							<div class="col-sm-10">
								<input style="background-color: #FFFFFF;" readonly="readonly"
									value="${read.title}" class="form-control" name="mem_title"
									placeholder="title">
							</div>
						</div>
						<div class="form-group">
							<label for="contents" class="col-sm-1 control-label">content</label>
							<div class="col-sm-10">
								<textarea style="background-color: #FFFFFF; resize: none"
									readonly="readonly" rows="10" cols="100" class="form-control"
									name="mem_content">${read.content }</textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-1 control-label">writer</label>
							<div class="col-sm-10">
								<input style="background-color: #FFFFFF;" readonly="readonly"
									value="${read.writer }" type="text" class="form-control"
									name="mem_wrtier" placeholder="wirter">
							</div>
						</div>
						<div class="form-group">
							<c:if test="${!empty read.fnames}">
								<label for="inputEmail3" class="col-sm-1 control-label">file</label>
								<div class="col-sm-10">
									<c:forEach var="fnames" items="${read.fnames}"
										varStatus="status">
										<label class="form-control"><a
											href="/board/download?fname=${fnames }">${status.count}:<c:out
													value="${fnames}"></c:out></a></label>
									</c:forEach>
								</div>
							</c:if>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-6" id="tagdiv"></div>
						</div>


						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-6">
							<!-- --------------[추가] 검색타입 또는 키워드 존재여부에 따른 버튼 링크 변경-------------------- -->
							<c:if test="${empty param.type || empty param.keyword}">
								<button
									onclick="location.href='/board/list?page=${param.page}&amount=${param.amount}'"
									id="register" type="button" class="btn btn-default">list</button>
							</c:if>
							<c:if test="${!empty param.type || !empty param.keyword}">
								<button
									onclick="location.href='/board/search?page=${param.page}&amount=${param.amount}&type=${param.type}&keyword=${param.keyword}'"
									id="register" type="button" class="btn btn-default">list</button>
							</c:if>
							<!-- ------------------------------------------------------------------------------------------- -->
							</div>
							<c:choose>
								<c:when test="${!empty result}">
									<c:if test="${result.mem_id eq read.writer}">

										<div class="col-sm-offset-1 col-sm-1">
											<button
												onclick="location.href='/board/update?bno=${param.bno}&page=${param.page}&amount=${param.amount}'"
												id="update" type="button" class="btn btn-default">update</button>
										</div>
										<div class="col-sm-offset-1 col-sm-1">
											<button onclick="del()" id="delete" type="button"
												class="btn btn-default">delete</button>
										</div>
									</c:if>
								</c:when>
							</c:choose>
						</div>
					</form>
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
		var hashtag = '${read.hashtag}'
		var hashtags = hashtag.split(",");
		var tags = null;
		var divtag = $('#tagdiv')
		if(hashtag.length!=0){
		for(let i =0; i<hashtags.length; i++){
			divtag.append("<a href='/board/search?type=hashtag&keyword="+hashtags[i]+"'><span>#"+hashtags[i]+"</span> </a>")
		}
		}
	</script>
</body>
</html>

