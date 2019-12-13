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



<style type="text/css">
.board-container, .container {
	width: 100%;
}

.board-table {
	width: 100%;
	background: #fff;
	padding-bottom: 10px;
}

.board-head div {
	font-size: 16px;
	font-weight: bold;
	padding: 15px 0px;
	padding-left: 15px;
}

.board-body {
	font-size: 16px;
	padding: 15px 0px;
}

.board-body:hover {
	background-color: #eee;
}

.btn-div a {
	float: right;
}

.page-div {
	text-align: center;
}

.viewcnt {
	text-align: right;
}

.btn-div {
	text-align: right;
}

.fa-paperclip {
	margin-left: 5px;
}

.file-cnt {
	font-size: 12px;
}

.active {
	background: #228896;
	color: #fff;
}

.pagination {
	color: #228896;
}

.search-select {
	width: 10%;
	display: inline-block;
	background: #fff;
}

.search-input {
	width: 70%;
	display: inline-block;
	background: #fff;
}

.search-div {
	margin-top: 60px;
}

.search-div label {
	font-size: 16px;
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
					<small>&copy; 2016 Blend Free HTML5. All Rights Reserved.</span> <span>Designed
							by <a href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a>
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
				<span class="bnt-logout">
					<form action="/member/logout" method="POST">
						<c:choose>
							<c:when test="${!empty result}">
							<button class="btn btn-primary" data-toggle="modal"
							data-target=".bs-example-modal-sm">Logout</button>
							</c:when>
							<c:otherwise>
							<button class="btn btn-primary" data-toggle="modal"
							data-target=".bs-example-modal-sm">Login</button>
							</c:otherwise>
						</c:choose>
					</form>
				</span>
				<h2 class="fh5co-heading animate-box"
					data-animate-effect="fadeInLeft">Data Room</h2>
				<div class="row row-bottom-padded-md">
					<div class="btn-div">
						<div class="btn-group btn-group-sm" role="group"
							aria-label="Basic example">
							<button type="button" class="btn active" onclick="setAmount(10)">10개</button>
							<button type="button" class="btn" onclick="setAmount(20)">20개</button>
							<button type="button" class="btn" onclick="setAmount(30)">30개</button>
							<button type="button" class="btn" onclick="setAmount(40)">40개</button>

						</div>
					</div>
					<div class="col-padding animate-box board-container"
						data-animate-effect="fadeInLeft">

						<div class="container show-grid board-table">
							<div class="row board-head">
								<div class="col-md-1">번호</div>
								<div class="col-md-4">제목</div>
								<div class="col-md-2">작성자</div>
								<div class="col-md-1">조회수</div>
								<div class="col-md-3">날짜</div>
							</div>

							<c:forEach items="${list}" var="board">
								<!-- 게시물 행 -->
								<div class="row board-body">
									<div class="col-md-1">${board.bno}</div>
									<div class="col-md-4">
										<a
											href="/board/read?bno=${board.bno}&page=${pm.paging.page}&amount=${pm.paging.amount}">
											${board.title} <!-- 파일이 1개 이상이면 첨부파일 표시 --> <c:if
												test="${board.filecnt + 0 > 0}">
												<i class="fa fa-paperclip"></i>
												<span class="file-cnt">${board.filecnt}</span>
											</c:if>
										</a>
									</div>
									<div class="col-md-2">${board.writer}</div>
									<div class="col-md-1 viewcnt">${board.viewcnt}</div>
									<div class="col-md-3">${board.regdate}</div>
								</div>
							</c:forEach>


						</div>

						<div class="page-div">
							<ul class="pagination">
								<c:if test="${pm.prev}">
									<li class="page-item"><a class="page-link"
										href="/board/list?page=${pm.start-1}&amount=${pm.paging.amount}">«</a>
									</li>
								</c:if>
								<c:forEach begin="${pm.start}" end="${pm.end}" var="num">
									<li class='page-item ${pm.paging.page == num ? "active" : ""}'>
										<a class="page-link"
										href="/board/list?page=${num}&amount=${pm.paging.amount}">${num}</a>
									</li>
								</c:forEach>
								<c:if test="${pm.next}">
									<li class="page-item"><a class="page-link"
										href="/board/list?page=${pm.end+1}&amount=${pm.paging.amount}">»</a>
									</li>
								</c:if>
							</ul>
						</div>
						<c:choose>
						<c:when test="${!empty result}">
						<div class="btn-div">
							<a href="/board/create">
								<button type="button" class="btn btn-primary">글쓰기</button>
							</a>
						</div>
						</c:when>
						</c:choose>
						<div class="form-group search-div">
							<form action="/board/search" method="GET">
								<label for="searchSelect">검색</label> <select
									class="form-control search-select" id="searchSelect"
									name="type">
									<option value="title">title</option>
									<option value="writer">writer</option>
									<option value="hashtag">hashtag</option>
								</select> <input type="text" class="form-control search-input"
									placeholder="Search..." name="keyword">
								<button type="submit" class="btn btn-primary">Submit</button>
							</form>
						</div>
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


	<script type="text/javascript">
	function setAmount(index) {
		location.href='../board/list?page=${param.page}&amount='+index;
	}
	</script>
</body>
</html>

