<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>GoDressUp - ${dress.name}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dress/detail.css">
</head>
<body>

	<header>
		<h1>GoDressUp</h1>
		<div style="display: flex; gap: 40px; align-items: center;">
			<c:if test="${empty sessionScope.loginUser}">
				<div class="auth-buttons">
					<c:url value="/login" var="url" />
					<a href="${url}">로그인</a>
					<c:url value="/signup" var="url" />
					<a href="${url}">회원가입</a>
				</div>
			</c:if>
			<c:if test="${not empty sessionScope.loginUser}">
				<div class="auth-buttons">
					<c:url value="/mypage" var="url" />
					<a href="${url}">${sessionScope.loginUser.username}님</a>
					<c:url value="/logout" var="url" />
					<a href="${url}">로그아웃</a>
				</div>
			</c:if>
		</div>
	</header>

	<div class="detail-container">
		<div class="detail-card">
			<div class="image-section">
				<img src="${pageContext.request.contextPath}/${dress.image_url}"
					alt="${dress.name}" class="dress-image">
			</div>

			<div class="info-section">
				<h1 class="dress-title">${dress.name}</h1>

				<div class="dress-details">
					<div class="detail-item">
						<span class="detail-label">색상:</span> <span class="detail-value">${dress.color}</span>
					</div>
					<div class="detail-item">
						<span class="detail-label">사이즈:</span> <span class="detail-value">${dress.size}</span>
					</div>
				</div>

				<div class="price-section">
					<p class="price">
						<span class="currency">₩</span>${dress.price}
					</p>
				</div>

				<c:url value="/" var="url" />
				<a class="back-button" href="${url}"> 드레스 목록으로 돌아가기 </a>
			</div>
		</div>
	</div>

	<footer>
		<p>ⓒ 2025 GoDressUp. All rights reserved.</p>
	</footer>

</body>
</html>