<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Đăng ký</title>

</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${categories }">

						<li><a href="<c:url value = "/san-pham/${item.id }"/>"><span
								class="icon-circle-blank"></span> ${ item.name }</a></li>

					</c:forEach>

					<li><a class="totalInCart" href="gio-hang"><strong>Tiền
								giỏ hàng <span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${TotalPriceCart }" />
									₫ </span>
						</strong></a></li>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img src="assets/img/paypal.jpg"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="assets/img/bootstrap-ecommerce-templates.png"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="assets/img/shopping-cart-template.png"
							alt="shopping cart template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="assets/img/bootstrap-template.png"
							alt="bootstrap template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="./">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Đăng ký</li>
			</ul>
			<hr class="soft" />

			<div class="row ">
				<div class="span6" style="transform: translateX(25%);">
					<div class="well">
						<h3>Đăng ký tài khoản</h3>
						
						<br />
						<form:form action="dang-ky" method ="POST" modelAttribute="user">  
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail </label>
								<div class="controls">
									<form:input class="span5" type="email" required="required"   placeholder="email" path="user" />  
									<p class="text-error ml-3"> ${ status }</p>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputEmail">Mật khẩu</label>
								<div class="controls">
									<form:input  class="span5" type="text" required="required" placeholder="password" path="password"  />  
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputEmail">Họ và tên</label>
								<div class="controls">
									<form:input  class="span5" type="text" required="required" placeholder="name" path="display_name"  />  
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputEmail">Địa chỉ</label>
								<div class="controls">
									<form:input  class="span5" type="text" placeholder="address" path="address"  />  
								</div>
							</div>
							<div class="controls">
								<a href="<c:url value="./dang-nhap"/>" class="btn  btn-primary">Đăng Nhập</a>
								<button type="submit" style="margin-left: 195px" class=" btn btn-success">Đăng Ký</button>
							</div>
						</form:form>
					</div>
				</div>

			</div>

		</div>
	</div>
</body>
