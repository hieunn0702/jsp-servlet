<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>

<!-- Start Navbar -->
<%@page import="model.KhachHang"%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> <img
			src="https://i.pinimg.com/564x/1f/53/f6/1f53f6d7cf466959573b00a446a0c023.jpg"
			alt="Logo" height="24">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Discount</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Category </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Jean</a></li>
						<li><a class="dropdown-item" href="#">T-Shirt</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">dress</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link disabled"
					aria-disabled="true">Out of Stock</a></li>
			</ul>
			<form class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
				<%
				Object obj = session.getAttribute("khachHang");
				KhachHang khachHang = null;
				if (obj != null) {
					khachHang = (KhachHang) obj;
				}
				if (khachHang == null) {
				%>
				<a class="btn btn-primary" style="white-space: nowrap;"
					href="customer/signin.jsp">Sign in</a>
				<%
				} else {
				%>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
					<li class="nav-item dropdown dropstart"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Account <b><%=khachHang.getHoVaTen()%></b></a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">My order</a></li>
							<li><a class="dropdown-item" href="#">Notification</a></li>
							<li><a class="dropdown-item"
								href="<%=url %>/customer/changeavatar.jsp">Change avatar</a></li>
							<li><a class="dropdown-item"
								href="<%=url %>/customer/changeinformation.jsp">Change information</a></li>
							<li><a class="dropdown-item"
								href="<%=url %>/customer/changepassword.jsp">Change password</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="<%=url %>/customer?action=logout">Logout</a></li>
						</ul></li>
				</ul>
				<%
				}
				%>


			</form>
		</div>
	</div>
</nav>
<!-- End Navbar -->