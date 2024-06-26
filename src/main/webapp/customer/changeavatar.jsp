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

		String duongDanAnh = khachHang.getDuongDanAnh();
		%>

		<div class="container">
			<div class="text-center">
				<h1>CHANGE AVATAR</h1>
			</div>
			<div class="red" id="errorMessage">
				<%=errorMessage%>
			</div>
			<%
			String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
			%>
			<form class="form" action="<%=url1 %>/change-avatar" method="POST" enctype="multipart/form-data">
				<input type="hidden" name="action" value="change-avatar" />
				<div class="row">
					<div class="col-sm-6">
						<h3>Customer Information</h3>
						<img alt="Avatar" src="<%=url1%>/avatar/<%=duongDanAnh%>">
						<div class="mb-3">
							<label for="linkAvatar" class="form-label">Link Avatar</label> <input
								type="file" class="form-control" id="linkAvatar" name="linkAvatar">
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