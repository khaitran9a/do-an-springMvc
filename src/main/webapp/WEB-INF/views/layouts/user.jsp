<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="master-layout" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/assets/user/css/bootstrap.css"/>"rel="stylesheet" />
<link href="<c:url value="/assets/user/css/bootstrap.min.css"/>"rel="stylesheet" />
<link href="<c:url value="/assets/user/css/bootstrap-responsive.css"/>"rel="stylesheet" />
<link href="<c:url value="/assets/user/css/bootstrap-responsive.min.css"/>"rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/assets/user/style.css"/>" rel="stylesheet" />

<!-- font awesome styles -->
<link href="<c:url value="/assets/user/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet">
<link href="<c:url value="/assets/user/font-awesome/css/font-awesome-ie7.min.css"/>" rel="stylesheet">

<!-- font awesome 6.2.1 -->
<link href="<c:url value="/assets/user/font_new/css/all.min.css"/>" rel="stylesheet">

<script src="<c:url value="http://html5shim.googlecode.com/svn/trunk/html5.js"/>"></script>


<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value="/assets/user/ico/favicon.ico" />">

<decorator:head />
</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					
					<a class="active" href="<c:url value="/" />"> <span class="icon-home"></span>
						Trang ch???
					</a> 
					<c:if test="${ not empty LoginInfo }">
						<a href="#"> <span class="icon-user"></span> ${LoginInfo.display_name  }</a>
						<a href="<c:url value="/dang-xuat"/>"><span class="icon-edit"></span>????ng xu???t</a>
						
					</c:if>
					
					
					<c:if test="${  empty LoginInfo }">
						<a href="<c:url value="/dang-ky" />"><span class="icon-edit"></span> ????ng k?? ngay </a> 
					</c:if>
				
					<a href="contact.html"><span class="icon-envelope"></span>
						Li??n h???</a> <a href="gio-hang"><span
						class="icon-shopping-cart"></span>  ${TotalQuantityCart } S???n ph???m - <span
						class="badge badge-warning"><fmt:formatNumber
											type="number" groupingUsed="true" value="${TotalPriceCart }" /> ??? </span></a>
				</div>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
		<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>

		<!-- body start -->
		<decorator:body />
		<!-- body end -->

		<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>


	</div>
	<!-- /container -->

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img
					src="<c:url value="assets/user/img/maestro.png"/>" alt="payment"></a>
				<a href="#"><img src="assets/user/img/mc.png" alt="payment"></a>
				<a href="#"><img src="assets/user/img/pp.png" alt="payment"></a>
				<a href="#"><img src="assets/user/img/visa.png" alt="payment"></a>
				<a href="#"><img src="assets/user/img/disc.png" alt="payment"></a>
			</p>
			<span>Copyright &copy; 2013<br> bootstrap ecommerce
				shopping template
			</span>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value = "/assets/user/js/jquery.js"/>"></script>
	<script src="<c:url value = "/assets/user/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value = "/assets/user/js/jquery.easing-1.3.min.js"/>"></script>
	<script src="<c:url value = "/assets/user/js/jquery.scrollTo-1.4.3.1-min.js"/>"></script>
	<script src="<c:url value = "/assets/user/js/shop.js"/>"></script>
	<decorator:getProperty property="page.script" />
</body>
</html>

