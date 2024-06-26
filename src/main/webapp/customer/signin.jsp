<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<!-- Custom styles for this template -->
<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/css/signin.css" rel="stylesheet">
</head>
<body>
	<main class="form-signin">
		<%
		String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
		%>
		<form class="text-center" action="<%=url1 %>/customer" method="POST">
			<input type="hidden" name="action" value="signin" /> 
			<img class="mb-4" src="<%=url%>/img/logo/tahenpiaoliang.png"
				alt="" width="72">
			<h1 class="h3 mb-3 fw-normal">Sign in</h1>
			<%
				String errorMessage = request.getAttribute("errorMessage") + "";
				if(errorMessage.equals("null")) {
					errorMessage = "";
				}
			%>
			<div class="text-center"><span class="red"><%=errorMessage %></span></div>

			<div class="form-floating">
				<input type="text" class="form-control" id="username"
					placeholder="Username" name="username"> <label for="username">Username</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					placeholder="Password" name="password"> <label for="password">Password</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
				in</button>
			Don't have an account?<a href="register.jsp"> Register here</a>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2030</p>
		</form>
	</main>
</body>
</html>