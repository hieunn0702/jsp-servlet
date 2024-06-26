<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Information</title>
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

<style type="text/css">
.red {
	color: red;
}
</style>

</head>
<body>
	
	<jsp:include page="../header.jsp"></jsp:include>

	<%
	Object obj = session.getAttribute("khachHang");
	KhachHang khachHang = null;
	if (obj != null)
		khachHang = (KhachHang) obj;
	if (khachHang == null) {
	%>
	<h1>You are not logged into the system, please return to the
		homepage!</h1>
	<%
	} else {
	%>

	<div class="container">
		<%
		String errorMessage = request.getAttribute("errorMessage") + "";
		errorMessage = (errorMessage.equals("null")) ? "" : errorMessage;

		String fullName = khachHang.getHoVaTen();

		String gender = khachHang.getGioiTinh();

		String dateOfBirth = khachHang.getNgaySinh().toString();

		String address = khachHang.getDiaChi();

		String purchaseAddress = khachHang.getDiaChiMuaHang();

		String deliveryAddress = khachHang.getDiaChiNhanHang();

		String phoneNumber = khachHang.getSoDienThoai();

		String email = khachHang.getEmail();

		boolean agreeToreceiveEmail = khachHang.isDangKyNhanBanTin();
		%>

		<div class="container">
			<div class="text-center">
				<h1>ACCOUNT INFORMATION</h1>
			</div>
			<div class="red" id="errorMessage">
				<%=errorMessage%>
			</div>
			<%
			String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
			%>
			<form class="form" action="<%=url1 %>/customer" method="POST">
				<input type="hidden" name="action" value="change-information" />
				<div class="row">
					<div class="col-sm-6">
						<h3>Customer Information</h3>
						<div class="mb-3">
							<label for="fullName" class="form-label">Full Name</label> <input
								type="text" class="form-control" id="fullName" name="fullName"
								placeholder="Enter your full Name" value="<%=fullName%>">
						</div>

						<div class="mb-3">
							<label for="gender" class="form-label">Gender</label> <select
								class="form-control" id="gender" name="gender">
								<option>Select your gender</option>
								<option value="Male"
									<%=(gender).equals("Male") ? "selected='selected'" : ""%>>Male</option>
								<option value="Female"
									<%=(gender).equals("Female") ? "selected='selected'" : ""%>>Female</option>
								<option value="Other"
									<%=(gender).equals("Other") ? "selected='selected'" : ""%>>Other</option>
							</select>
						</div>

						<div class="mb-3">
							<label for="dateOfBirth" class="form-label">Date of Birth</label>
							<input type="date" class="form-control" id="dateOfBirth"
								name="dateOfBirth" value="<%=dateOfBirth%>">
						</div>
					</div>

					<div class="col-sm-6">
						<h3>Address</h3>
						<div class="mb-3">
							<label for="address" class="form-label">Address</label> <input
								type="text" class="form-control" id="address" name="address"
								placeholder="Enter your address" value="<%=address%>">
						</div>

						<div class="mb-3">
							<label for="purchaseAddress" class="form-label">Purchase
								Address</label> <input type="text" class="form-control"
								id="purchaseAddress" name="purchaseAddress"
								placeholder="Enter your purchase address"
								value="<%=purchaseAddress%>">
						</div>

						<div class="mb-3">
							<label for="deliveryAddress" class="form-label">Delivery
								Address</label> <input type="text" class="form-control"
								id="deliveryAddress" name="deliveryAddress"
								placeholder="Enter your delivery address"
								value="<%=deliveryAddress%>">
						</div>

						<div class="mb-3">
							<label for="phoneNumber" class="form-label">Phone Number</label>
							<input type="tel" class="form-control" id="phoneNumber"
								name="phoneNumber" placeholder="Enter your phone number"
								value="<%=phoneNumber%>">
						</div>

						<div class="mb-3">
							<label for="email" class="form-label">Email</label> <input
								type="email" class="form-control" id="email" name="email"
								placeholder="Enter your email" value="<%=email%>">
						</div>
						<hr />

						<div class="mb-3">
							<label for="agreeToreceiveEmail" class="form-label">Agree
								to receive email</label> <input type="checkbox" class="form-check-input"
								id="agreeToreceiveEmail" name="agreeToreceiveEmail"
								<%=(agreeToreceiveEmail ? "checked" : "")%>>
						</div>

						<input class="btn btn-primary form-control mb-4" type="submit"
							value="Save information" name="submit" id="submit" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<%
	}
	%>
	
	<%@include file="../footer.jsp" %>
</body>

</html>