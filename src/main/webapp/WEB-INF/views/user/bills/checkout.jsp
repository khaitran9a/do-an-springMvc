<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Thanh toán</title>

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
				<li class="active">Đặt hàng</li>
			</ul>
			<hr class="soft" />

			<div class="row ">
				<div class="span6" style="transform: translateX(25%);">
					<div class="well">
						

						<br />
						<form:form class="form-horizontal" action="checkout" method="POST"
							modelAttribute="bills">

							<h3>Đặt hàng</h3>
							<div class="control-group">
								<label style="text-align:left" class="control-label d-block ">Họ và tên <sup>*</sup></label>
	
								<div class="controls">
									<form:input class="span3" type="text" placeholder="Nhập họ tên" path="display_name"/>
								</div>
							</div>
							<div class="control-group">
								<label  style="text-align:left" class="control-label">Email <sup>*</sup></label>
								<div class="controls">
									<form:input  class="span3"  type="text" placeholder="Nhập email" path="user"/>
								</div>
							</div>
							<div class="control-group">
								<label  style="text-align:left" class="control-label">Số điện thoại <sup>*</sup></label>
								<div class="controls">
									<form:input  class="span3"  type="text" placeholder="Nhập số điện thoại" path="phone"/>
								</div>
							</div>
							<div class="control-group">
								<label style="text-align:left" class="control-label">Địa chỉ <sup>*</sup></label>
								<div class="controls">
									<form:textarea rows="5" class="span3"  placeholder="Nhập địa chỉ" path="address"/>
								</div>
							</div>
							
							<div class="control-group">
								<label style="text-align:left" class="control-label">Ghỉ chú<sup>*</sup></label>
								<div class="controls">
									<form:textarea rows="5" class="span3" placeholder="Nhập ghi chú"   path="note"/>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Đặt hàng ngay"
										class="shopBtn exclusive">
								</div>
							</div>


						</form:form>
					</div>
				</div>

			</div>

		</div>
	</div>
</body>
