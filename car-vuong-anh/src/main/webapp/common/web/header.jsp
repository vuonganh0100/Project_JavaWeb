
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
	   <img alt="" src="anh.jpg">
		<a class="navbar-brand" href="#">Cửu Hàng Xe Máy Vương Anh</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="<c:url value='/trang-chu'/>">Trang chủ
						<span class="sr-only">(current)</span>
				</a></li>
				
					<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
			
				
					<li class="nav-item"><a class="nav-link" href="#">Wellcome</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a></li>
			
			</ul>
		</div>
	</div>
</nav>