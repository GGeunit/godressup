<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <title>GoDressUp - 드레스 등록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dress/register.css">
</head>
<body>
    <!-- 헤더 -->
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

    <!-- 메인 폼 컨테이너 -->
    <div class="form-container">
        <h2 class="form-title">드레스 등록</h2>

        <!-- 에러 메시지 -->
        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <!-- 등록 폼 -->
        <form action="${pageContext.request.contextPath}/dress/register" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name" class="form-label">드레스 이름 (고유)</label>
                <input type="text" id="name" name="name" class="form-input" placeholder="우아한 드레스의 이름을 입력해주세요" required />
            </div>

            <div class="form-group">
                <label for="price" class="form-label">가격</label>
                <input type="number" id="price" name="price" class="form-input" placeholder="가격을 입력해주세요" required />
            </div>

            <div class="form-group">
                <label for="size" class="form-label">사이즈</label>
                <select id="size" name="size" class="form-input">
                    <option value="Free">Free</option>
                </select>
            </div>

            <div class="form-group">
                <label for="color" class="form-label">색상</label>
                <input type="text" id="color" name="color" class="form-input" placeholder="드레스의 색상을 입력해주세요" />
            </div>

            <div class="form-group">
                <label for="image" class="form-label">드레스 이미지</label>
                <div class="file-input-wrapper">
                    <input type="file" id="image" name="imageFile" accept="image/*" class="file-input" />
                    <label for="image" class="file-input-label" id="fileLabel">
                        아름다운 드레스 사진을 선택해주세요
                    </label>
                </div>
                <div class="image-preview-container" id="imagePreviewContainer">
                    <img id="imagePreview" class="image-preview" alt="미리보기" />
                    <button type="button" class="remove-image-btn" id="removeImageBtn">×</button>
                    <div class="file-name-display" id="fileNameDisplay"></div>
                </div>
            </div>

            <button type="submit" class="submit-btn">우아하게 등록하기</button>
        </form>

        <div style="text-align: center;">
            <c:url value="/" var="url" />
            <a class="back-link" href="${url}">드레스 목록으로 돌아가기</a>
        </div>
    </div>

    <!-- 푸터 -->
    <footer>
        <p>ⓒ 2025 GoDressUp. All rights reserved.</p>
    </footer>

    <script>
        // 파일 입력 처리 및 미리보기 기능
        const fileInput = document.getElementById('image');
        const fileLabel = document.getElementById('fileLabel');
        const imagePreviewContainer = document.getElementById('imagePreviewContainer');
        const imagePreview = document.getElementById('imagePreview');
        const removeImageBtn = document.getElementById('removeImageBtn');
        const fileNameDisplay = document.getElementById('fileNameDisplay');

        fileInput.addEventListener('change', function(e) {
            const file = e.target.files[0];
            
            if (file) {
                // 파일이 이미지인지 확인
                if (file.type.startsWith('image/')) {
                    // 파일 리더 생성
                    const reader = new FileReader();
                    
                    reader.onload = function(e) {
                        // 미리보기 이미지 설정
                        imagePreview.src = e.target.result;
                        
                        // 파일명 표시
                        fileNameDisplay.textContent = file.name;
                        
                        // 미리보기 컨테이너 표시
                        imagePreviewContainer.style.display = 'block';
                        
                        // 라벨 스타일 변경
                        fileLabel.classList.add('has-file');
                        fileLabel.innerHTML = '이미지가 선택되었습니다';
                        
                        // 부드러운 페이드인 효과
                        setTimeout(() => {
                            imagePreviewContainer.style.opacity = '1';
                            imagePreviewContainer.style.transform = 'translateY(0)';
                        }, 10);
                    };
                    
                    reader.readAsDataURL(file);
                } else {
                    alert('이미지 파일만 선택해주세요.');
                    fileInput.value = '';
                }
            }
        });

        // 이미지 제거 버튼 클릭 이벤트
        removeImageBtn.addEventListener('click', function() {
            // 파일 입력 초기화
            fileInput.value = '';
            
            // 미리보기 숨기기
            imagePreviewContainer.style.display = 'none';
            
            // 라벨 원상복구
            fileLabel.classList.remove('has-file');
            fileLabel.innerHTML = '아름다운 드레스 사진을 선택해주세요';
        });

        // 미리보기 컨테이너 초기 스타일 설정
        imagePreviewContainer.style.opacity = '0';
        imagePreviewContainer.style.transform = 'translateY(20px)';
        imagePreviewContainer.style.transition = 'all 0.3s cubic-bezier(0.4, 0, 0.2, 1)';
    </script>
</body>
</html>