<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<title>GoDressUp - 로그인</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css"></link>
</head>
<body>
	<form action="http://localhost:8080/cmk_free/login" method="post"
		class="login-container">
		<div class="brand-header">
			<h1 class="brand-title">GoDressUp</h1>
			<p class="brand-subtitle">Welcome Back</p>
		</div>

		<!-- 에러 메시지 표시 영역 -->
		<c:if test="${not empty error}">
			<div class="error-message">${error}</div>
		</c:if>

		<div class="form-group">
			<input type="text" name="username" placeholder="아이디를 입력하세요" required />
		</div>

		<div class="form-group">
			<input type="password" name="password" placeholder="비밀번호를 입력하세요"
				required />
		</div>

		<button type="submit" class="login-btn">로그인</button>

		<div class="divider">
			<span>or</span>
		</div>

		<div class="links-container">
			<c:url value="/signup" var="url" />
			<a href="${url}" class="signup-link">회원가입</a> <br>

			<c:url value="/" var="url" />
			<a class="main-link" href="${url}"> <span>←</span> <span>메인
					페이지로 돌아가기</span>
			</a>
		</div>
	</form>
</body>
</html>