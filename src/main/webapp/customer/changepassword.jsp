<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Change Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="css/changepassword-notification.css">

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>
<!-- <script src="js/changepassword-notification.js"></script> -->
<!-- Include your JavaScript file here -->

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
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null && !errorMessage.isEmpty()) {
	%>
	<div class="alert alert-danger">
		<%=errorMessage%>
	</div>
	<%
	} else if (errorMessage != null) {
	%>
	<div class="alert alert-success">
		<%=errorMessage%>
	</div>
	<%
	String redirectUrl = request.getContextPath() + "/index.jsp"; // Đổi URL này thành URL chuyển hướng mong muốn
	%>
	<script>
        redirectAfterSuccess('<%=redirectUrl%>
		');
	</script>
	<%
	}
	%>
	<main class="container mt-5">
		<div class="text-center">
			<h1>CHANGE PASSWORD</h1>
		</div>
		
		<%
		String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
		%>
		
		<form action="<%=url1 %>/customer" method="POST">
			<input type="hidden" name="action" value="change-password" />
			<div class="mb-3">
				<label for="currentPassword" class="form-label">Current
					Password</label> <input type="password" class="form-control"
					id="currentPassword" name="currentPassword"
					placeholder="Enter current password" required>
			</div>
			<div class="mb-3">
				<label for="newPassword" class="form-label">New Password</label> <input
					type="password" class="form-control" id="newPassword"
					name="newPassword" placeholder="Enter new password" required>
			</div>
			<div class="mb-3">
				<label for="confirmNewPassword" class="form-label">Confirm
					New Password</label> <input type="password" class="form-control"
					id="confirmNewPassword" name="confirmNewPassword"
					placeholder="Confirm new password" required>
			</div>
			<button type="submit" class="btn btn-primary">Change
				Password</button>
		</form>
	</main>
	<%
	}
	%>
	
	<%@include file="../footer.jsp" %>
</body>
</html>
