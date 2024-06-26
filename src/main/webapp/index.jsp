<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BookStore</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- header -->
	 <%-- <%@include file="" %> --%><!-- dung cho trang tinh -->
	<jsp:include page="header.jsp"></jsp:include> <!-- dung cho trang dong (thuong duoc dung nhieu) -->

	<!-- Start Content -->
	<div class="container mt-4">
		<div class="row">
			
			<!-- menu left -->
			<jsp:include page="left.jsp"></jsp:include>
			<!-- end menu left -->
			
			<!-- Start Slider and Products -->
			<div class="col-lg-9">
				<!-- start slider -->
				<div id="carouselExampleIndicators" class="carousel slide">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="./img/slider/1.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="./img/slider/2.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="./img/slider/3.png" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- end slider -->

				<!-- Start product -->
				<div class="row">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" alt=""
								src="./img/products/p1.png" height="400px"></a>
							<div class="card-body">
								<h4 class="card-title">T-shirt</h4>
								<h5>$30</h5>
								<p class="card-text">Description for t-shirt</p>

							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" alt=""
								src="./img/products/p2.png" height="400px"></a>
							<div class="card-body">
								<h4 class="card-title">T-shirt</h4>
								<h5>$30</h5>
								<p class="card-text">Description for t-shirt</p>

							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" alt=""
								src="./img/products/p3.png" height="400px"></a>
							<div class="card-body">
								<h4 class="card-title">T-shirt</h4>
								<h5>$30</h5>
								<p class="card-text">Description for t-shirt</p>

							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" alt=""
								src="./img/products/p1.png" height="400px"></a>
							<div class="card-body">
								<h4 class="card-title">T-shirt</h4>
								<h5>$30</h5>
								<p class="card-text">Description for t-shirt</p>

							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
				</div>


				<!-- End product -->

			</div>

			<!-- End Slider and Products -->
		</div>
	</div>
	<!-- End Content -->
	
	<!-- footer -->
	<%@include file="footer.jsp"%> <!-- su dung cai nay vi phan footer da phan la khong thay doi (trang tinh) -->
	
</body>
</html>