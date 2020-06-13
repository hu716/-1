<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title> 图书系统 </title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/angularjs/angular-1.6.2.min.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/angularjs/angular-ui-router.min.js"></script>	
</head>
<body ng-app="book-app" ng-controller="MainController as main">
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" style="padding-top:0" ui-sref="main">
				<img alt="图书管理" src="${pageContext.request.contextPath}/images/fklogo.gif"
					style="width:52px;height:52px">
			</a>
		</div>
		<ul class="nav navbar-nav">
			<li role="presentation"><a ui-sref="main">主页</a></li>
			<li role="presentation"><a ui-sref="listCategories">种类管理</a></li>
			<li role="presentation"><a ui-sref="listBooks">图书管理</a></li>	
			<li role="presentation"><a ui-sref="listInventories">图书入库</a></li>
			<li role="presentation"><a ui-sref="listSales">图书销售</a></li>
		</ul>
	</div>
</nav>
<div class="container">
	<div  ui-view>
	</div>
	<footer class="text-center well">
	All Rights Reserved.&copy; 
	<a href="http://www.crazyit.org">疯狂Java联盟</a><br />
		版权所有 Copyright&copy;2001-2018 Yeeku.H.Lee <br />
	</footer>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/category.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/book.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/inventory.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sale.js"></script>	
</body>
</html>