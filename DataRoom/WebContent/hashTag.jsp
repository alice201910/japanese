<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
span {
	border: 1px solid pink;
	background-color: pink;
	margin-right: 5px;
	font-size: 13px;
	line-height: 20px;
}

#hash {
	margin-top: 5px;
}
</style>
</head>
<body>
	<input type='text' id="tag" />
	<div id="hash"></div>
	<script>
		var divObj = $('#hash');
		$('#tag').keypress(function(e) {
			if (e.keyCode == 13 || e.keyCode == 32) {
				var val = $('#tag').val();
				if (val === "" || val === null || val === " ") 
				{
				
				}else {
					var str1 = val.replace(/ /gi, "");
					var str = "<span>#"+str1+"</span>";
					divObj.append(str.trim());
				}
				$('#tag').val("");
			}
		})
	</script>


</body>
</html>