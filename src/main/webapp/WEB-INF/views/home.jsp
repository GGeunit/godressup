<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>GoDressUp - 메인</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home.css">
<style>
/* 드레스 등록 버튼 스타일 */
.register-dress-btn {
	background: linear-gradient(f135deg, #8b5a5c 0%, #d4929e 100%);
	color: white;
	padding: 16px 32px;
	border: none;
	border-radius: 50px;
	font-family: 'Inter', sans-serif;
	font-size: 15px;
	font-weight: 600;
	text-decoration: none;
	display: inline-flex;
	align-items: center;
	gap: 8px;
	box-shadow: 0 8px 25px rgba(139, 90, 92, 0.25);
	transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
	position: relative;
	overflow: hidden;
	letter-spacing: 0.3px;
	margin-bottom: 40px;
}

.register-dress-btn::before {
	content: '';
	position: absolute;
	top: 0;
	left: -100%;
	width: 100%;
	height: 100%;
	background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.2),
		transparent);
	transition: left 0.5s;
}

.register-dress-btn:hover {
	transform: translateY(-3px);
	box-shadow: 0 12px 35px rgba(139, 90, 92, 0.35);
	background: linear-gradient(135deg, #9a6466 0%, #e0a1ae 100%);
}

.register-dress-btn:hover::before {
	left: 100%;
}

.register-dress-btn:active {
	transform: translateY(-1px);
}

/* 플러스 아이콘 */
.register-dress-btn::after {
	content: '+';
	font-size: 18px;
	font-weight: 300;
	margin-left: 4px;
}

/* 섹션 헤더 영역 조정 */
.section-header {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-bottom: 60px;
}

/* 반응형 디자인 */
@media ( max-width : 768px) {
	.register-dress-btn {
		padding: 14px 28px;
		font-size: 14px;
		margin-bottom: 30px;
	}
}
</style>
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

	<div class="hero">
		<div class="hero-content">
			<h2>당신의 하루를 빛내줄 드레스</h2>
			<p class="hero-subtitle">Elegance that speaks your language</p>
		</div>
	</div>

	<div class="section">
		<div class="section-header">
			<h3>드레스 컬렉션</h3>
			<c:if test="${not empty sessionScope.loginUser}">
				<c:url value="/dress/register" var="url" />
				<a href="${url}" class="register-dress-btn">드레스 등록</a>
			</c:if>
		</div>
		<div class="products">
			<c:forEach var="dress" items="${dresses}">
				<div class="product-card">
					<c:url value="/dress/${dress.id}" var="url" />
					<a href="${url}"> <img
						src="${pageContext.request.contextPath}/${dress.image_url}"
						alt="${dress.name}" />
						<div class="product-info">
							<h4>${dress.name}</h4>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<footer>
		<p>ⓒ 2025 GoDressUp. All rights reserved.</p>
	</footer>

</body>
</html>