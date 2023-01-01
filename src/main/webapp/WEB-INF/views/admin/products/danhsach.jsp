<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Danh sách sản phẩm</title>
<style type="text/css">
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #F89406;
	color: white;
	border: 1px solid #F89406;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

</head>

<body>

	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Sản Phẩm</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
						<li class="breadcrumb-item active">Sản phẩm</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Danh sách sản phẩm</h3>
					
				</div>
				<div class="card-header">					
					<a href="<c:url value ="/quan-tri/add-product"/>" class="btn btn-success btn-sm">Thêm sản phẩm</a>
				</div>
				<!-- ./card-header -->
				<div class="card-body">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>Số thứ tự</th>
								<th>Danh mục</th>
								<th>Tên Sản Phẩm</th>
								<th>Giá</th>
								<th>Hình ảnh</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<h1>${ products.size() }</h1>
							<c:forEach var="item" items="${ products }"
								varStatus="loop" >
								
								<tr data-widget="expandable-table" aria-expanded="false">
									<td>${loop.index + 1 }</td>
									<td>${ item.name_category }</td>
									<td>${ item.name }</td>
									<td>Approved</td>
									<td><img alt="" style="width: 100px; height: 70px; object-fit: cover;"   
										src="<c:url value="/assets/user/img/products/${ item.image }"/>"></td>
									<td><a href="#" class="btn btn-primary btn-sm">Sửa</a> <a
										href="#" class="btn btn-danger btn-sm">Xóa</a></td>
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</div>
				<!-- /.card-body -->
			</div>
			<!-- /.card -->
		</div>
	</div>
</body>