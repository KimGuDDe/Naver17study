<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정</title>
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
        #content {
            height: 500px;
        }
        .file-item {
            margin-bottom: 10px;
            display: flex;
            align-items: center;
        }
        .delete-btn {
            margin-left: 10px;
            cursor: pointer;
            color: red;
        }
        .file-preview {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <c:if test="${sessionScope.loginstatus==null}">
        <script type="text/javascript">
            alert("회원게시판입니다\n 먼저 로그인을 해주세요");
            history.back();
        </script>
    </c:if>

    <jsp:include page="../../layout/title.jsp"/>
    <div class="container" style="margin: 30px;">
        <h3>게시글 수정</h3>
        <form action="/board/update" method="post" enctype="multipart/form-data" id="updateForm">
            <input type="hidden" name="idx" value="${dto.idx}">
            <input type="hidden" name="pageNum" value="${pageNum}">
            <div class="mb-3">
                <label for="subject" class="form-label">제목</label>
                <input type="text" class="form-control" id="subject" name="subject" value="${dto.subject}" required>
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control" id="content" name="content" rows="5" required>${dto.content}</textarea>
            </div>
            <!-- 기존 파일 목록 -->
            <div class="mb-3">
                <label class="form-label">기존 첨부파일</label>
                <div id="file-list">
                    <c:forEach var="file" items="${files}">
                        <div class="file-item" data-file-num="${file.num}">
                            <img src="${naverurl}/board/${file.filename}" style="max-width: 100px;">
                            <span class="delete-btn" onclick="deleteFile(${file.num}, ${dto.idx}, this)">삭제</span>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!-- 새 파일 업로드 -->
            <div class="mb-3">
                <label for="upload" class="form-label">새 파일 업로드</label>
                <input type="file" class="form-control" id="upload" name="upload" multiple onchange="addFiles()">
                <div id="new-file-preview" class="file-preview"></div>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-success">수정 완료</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 100px;" onclick="location.href='./detail?idx=${dto.idx}&pageNum=${pageNum}'">이전으로</button>
            </div>
        </form>
    </div>

    <script type="text/javascript">
        function addFiles() {
            var files = $("#upload")[0].files;
            if (files.length > 0) {
                var formData = new FormData();
                for (var i = 0; i < files.length; i++) {
                    formData.append("file", files[i]);
                }
                formData.append("idx", ${dto.idx});

                $.ajax({
                    type: "post",
                    url: "/board/addfile",
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function(fileDto) {
                        if (fileDto) {
                            var fileItem = '<div class="file-item" data-file-num="' + fileDto.num + '">' +
                                '<img src="${naverurl}/board/' + fileDto.filename + '" style="max-width: 100px;">' +
                                '<span class="delete-btn" onclick="deleteFile(' + fileDto.num + ', ${dto.idx}, this)">삭제</span>' +
                                '</div>';
                            $("#file-list").append(fileItem);
                            $("#upload").val(""); // 파일 입력 초기화
                        } else {
                            alert("파일 업로드 실패");
                        }
                    },
                    error: function() {
                        alert("서버 오류로 업로드 실패");
                    }
                });
            }
        }
        
        function deleteFile(num, idx, element) {
            if (confirm("정말 삭제하시겠습니까?")) {
                $.ajax({
                    type: "post",
                    url: "/board/deletefile",
                    data: { "num": num, "idx": idx },
                    success: function(response) {
                        if (response === "success") {
                            $(element).closest(".file-item").remove();
                            alert("파일이 삭제되었습니다.");
                        } else {
                            alert("파일 삭제 실패");
                        }
                    },
                    error: function() {
                        alert("서버 오류로 삭제 실패");
                    }
                });
            }
        }
    </script>
</body>
</html>