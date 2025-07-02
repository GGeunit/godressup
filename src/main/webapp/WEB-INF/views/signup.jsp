<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>GoDressUp - 회원가입</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/signup.css"
	type="text/css">
</head>
<body>
	<form action="http://localhost:8080/cmk_free/signup" method="post"
		class="signup-container">
		<div class="brand-header">
			<h1 class="brand-title">GoDressUp</h1>
			<p class="brand-subtitle">Join Our Elegant Community</p>
		</div>

		<div class="form-progress">
			<div class="progress-dot active"></div>
			<div class="progress-dot active"></div>
			<div class="progress-dot active"></div>
			<div class="progress-dot active"></div>
			<div class="progress-dot active"></div>
			<div class="progress-dot active"></div>
			<div class="progress-dot active"></div>
		</div>

		<!-- 에러 메시지 표시 영역 -->
		<c:if test="${not empty error}">
			<div class="error-message">${error}</div>
		</c:if>

		<!-- 계정 정보 섹션 -->
		<div class="form-section">
			<div class="section-title">계정 정보</div>
			<div class="form-group">
				<input type="text" name="username" placeholder="아이디를 입력하세요" required />
			</div>

			<div class="form-group">
				<input type="password" name="password" placeholder="비밀번호를 입력하세요"
					required />
				<div class="password-hint">8자 이상, 영문과 숫자를 포함해주세요</div>
			</div>

			<div class="form-group">
				<input type="password" name="confirmPassword"
					placeholder="비밀번호를 다시 입력하세요" required />
			</div>

			<div class="form-group">
				<input type="email" name="email" placeholder="이메일 주소를 입력하세요"
					required />
			</div>
		</div>

		<!-- 개인 정보 섹션 -->
		<div class="form-section">
			<div class="section-title">개인 정보</div>
			<div class="form-group">
				<input type="text" name="nickname" placeholder="닉네임을 입력하세요" required />
			</div>

			<div class="form-row">
				<div class="form-group">
					<input type="number" name="age" placeholder="나이" min="1" max="150"
						required />
				</div>
				<div class="form-group">
					<select name="region" required>
						<option value="">거주지 선택</option>
						<option value="서울">서울특별시</option>
						<option value="부산">부산광역시</option>
						<option value="대구">대구광역시</option>
						<option value="인천">인천광역시</option>
						<option value="광주">광주광역시</option>
						<option value="대전">대전광역시</option>
						<option value="울산">울산광역시</option>
						<option value="세종">세종특별자치시</option>
						<option value="경기">경기도</option>
						<option value="강원">강원도</option>
						<option value="충북">충청북도</option>
						<option value="충남">충청남도</option>
						<option value="전북">전라북도</option>
						<option value="전남">전라남도</option>
						<option value="경북">경상북도</option>
						<option value="경남">경상남도</option>
						<option value="제주">제주특별자치도</option>
						<option value="기타">기타</option>
					</select>
				</div>
			</div>
		</div>

		<button type="submit" class="signup-btn">회원가입</button>

		<div class="divider">
			<span>already have an account?</span>
		</div>

		<div class="links-container">
			<c:url value="/login" var="url" />
			<a href="${url}" class="login-link">로그인으로 돌아가기</a> <br>

			<c:url value="/" var="url" />
			<a class="main-link" href="${url}"> <span>←</span> <span>메인
					페이지로 돌아가기</span>
			</a>
		</div>
	</form>
</body>
</html>