<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style>
body * {
	font-family: 'Jua';
}

.profilePhoto {
	width: 50px;
	height: 50px;
	border: 1px solid gray;
	border-radius: 100px;
	margin-right: 10px;
}

.day {
	font-size: 13px;
	color: gray;
}

.reple-item {
	border-bottom: 1px solid #ddd;
	padding: 10px;
}
</style>

<script type="text/javascript">
function addReple() {
    let message = $("#repleMessage").val();
    let photoFile = $("#photoFile")[0].files[0]; // 파일 객체 가져오기

    let formData = new FormData(); // FormData 객체 생성
    formData.append("idx", ${dto.idx}); // idx 추가
    formData.append("message", message); // 메시지 추가
    if (photoFile) {
        formData.append("photoFile", photoFile); // 파일 추가
    }

    $.ajax({
        type: "POST", // POST 요청
        url: "./reple/insert", // 요청 URL
        data: formData, // FormData 객체 전송
        dataType: "text", // 응답 형식: 텍스트
        processData: false, // jQuery가 데이터를 처리하지 않도록 설정
        contentType: false, // 콘텐츠 타입을 자동으로 설정
        success: function(response) {
            if (response === "success") {
                alert("댓글 등록 성공!");
                location.reload();
                $("#repleMessage").val(""); // 입력 필드 초기화
                $("#photoFile").val(""); // 파일 입력 필드 초기화
            } else {
                alert("댓글 등록 실패: " + response); // 실패 메시지 표시
            }
        },
        error: function(xhr, status, error) {
            console.error("AJAX 오류: " + status + " - " + error); // 오류 로깅
            alert("AJAX 요청 실패!");
        }
    });
}
    
    // 여기에 삭제 코드 넣는 부분
    function deleteList(num) {
	    if (confirm("이 댓글을 삭제하시겠습니까?")){
	        $.ajax({
	            type: "get",
	            url: "./reple/delete",
	            data: { "num": num },
	            dataType: "text",
	            success: function(response) {
	                if (response === "success") {
	                    alert("댓글이 삭제되었습니다.");
	                    location.reload();
	                } else {
	                    alert("댓글 삭제에 실패했습니다: " + response);
	                }
	            },
            	error: function(xhr, status, error) {
                	console.error("AJAX 오류: " + status + " - " + error);
                	alert("댓글 삭제 요청 실패!");
            	}
       		 });
	    }
    }
    
    $(document).ready(function() {
        $("#photoFile").change(function() {
            previewImage(this);
        });
    });

    function previewImage(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                $("#preview-container").show(); // Show the container
                $("#preview-image").attr('src', e.target.result);

            }
            reader.readAsDataURL(input.files[0]);
        } else {
            $("#preview-image").attr('src', ""); // Clear the preview
            $("#preview-container").hide();     // Hide the container
        }
    }

    // Clear Preview
    function clearPreview() {
        $("#preview-container").hide();
        $("#preview-image").attr('src', '');
        $("#photoFile").val(''); // clear the selected file
    }
    
 	// 댓글 수정 모달 열기
    function openEditRepleModal(num, message) {
        $("#editRepleNum").val(num);
        $("#editRepleMessage").val(message);
        $('#editRepleModal').modal('show');
    }

    // 수정할 댓글 내용 미리보기
    $(document).ready(function() {
        $("#editPhotoFile").change(function() {
            previewEditImage(this);
        });
    });

    function previewEditImage(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                $("#edit-preview-container").show();
                $("#edit-preview-image").attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        } else {
            $("#edit-preview-image").attr('src', "");
            $("#edit-preview-container").hide();
        }
    }

    // 수정할 댓글 이미지 미리보기 삭제
    function clearEditPreview() {
        $("#edit-preview-container").hide();
        $("#edit-preview-image").attr('src', '');
        $("#editPhotoFile").val('');
    }

    // 댓글 수정
    function updateReple() {
        let num = $("#editRepleNum").val();
        let message = $("#editRepleMessage").val();
        let photoFile = $("#editPhotoFile")[0].files[0];

        let formData = new FormData();
        formData.append("num", num);
        formData.append("message", message);
        if (photoFile) {
            formData.append("photoFile", photoFile);
        }

        $.ajax({
            type: "POST",
            url: "./reple/update",
            data: formData,
            dataType: "text",
            processData: false,
            contentType: false,
            success: function(response) {
                if (response === "success") {
                    alert("댓글이 수정되었습니다.");
                    location.reload();
                } else {
                    alert("댓글 수정에 실패했습니다: " + response);
                }
            },
            error: function(xhr, status, error) {
                console.error("AJAX 오류: " + status + " - " + error);
                alert("댓글 수정 요청 실패!");
            }
        });
        $('#editRepleModal').modal('hide');
    }
    
</script>
</head>

<body>
	<c:if test="${sessionScope.loginstatus==null}">
		<script type="text/javascript">
            alert("회원게시판입니다\n 먼저 로그인을 해주세요");
            history.back();
        </script>
	</c:if>

	<jsp:include page="../../layout/title.jsp" />

	<div style="margin: 30px;">
		<h3>
			<b>${dto.subject}</b>
		</h3>
		<img src="${naverurl}/member/${memberPhoto}" class="profilePhoto"
			align="left" onerror="this.src='../save/noimage.png'"> <span>${dto.writer}</span><br>
		<span class="day"> <fmt:formatDate value="${dto.writeday}"
				pattern="yyyy-MM-dd HH:mm" />    조회 ${dto.readcount}
		</span>
		<pre style="margin-top: 30px; font-size: 15px;">${dto.content}</pre>
		<div style="margin-top: 30px;">
			<c:forEach var="photo" items="${dto.photos}">
				<img src="${naverurl}/board/${photo}" style="max-width: 500px;">
				<br>
			</c:forEach>
		</div>

		<div style="margin-top: 30px;">
			<button type="button" class="btn btn-success btn-sm"
				style="width: 80px;" onclick="location.href='./writeform'">
				<i class="bi bi-pencil-fill"></i> 글쓰기
			</button>
			<button type="button" class="btn btn-success btn-sm"
				style="width: 80px;"
				onclick="location.href='./writeform?idx=${dto.idx}®roup=${dto.regroup}&restep=${restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">
				답글쓰기</button>
			<c:if test="${sessionScope.loginid==dto.myid}">
				<button type="button" class="btn btn-outline-secondary btn-sm"
					style="width: 80px;"
					onclick="location.href='./updateform?idx=${dto.idx}&pageNum=${pageNum}'">
					수정</button>

				<button type="button" class="btn btn-outline-secondary btn-sm"
					style="width: 80px;" onclick="boarddel()">삭제</button>
				<script type="text/javascript">
    				function boarddel()
    				{
    					//삭제할 지 물어보고 확인 누르면 삭제 후 목록으로 이동
    					let ans = confirm("해당 글을 삭제하시겠습니까?")
    					if(ans){
    						$.ajax({
    							type:"get",
    							dataType:"text",
    							data:{"idx":${dto.idx}},
    							url: "./delete",
    							success : function(){
    								alert("삭제되었습니다")
    								//삭제 성공후 목록으로 이동
    								location.href="./list?pageNum="+${pageNum};
    							}
    						});
    					}
    				}
    			</script>
			</c:if>
			<button type="button" class="btn btn-outline-secondary btn-sm"
				style="width: 80px; margin-left: 50px;"
				onclick="location.href='./list?pageNum=${pageNum}'">목록</button>
		</div>

		<div style="margin: 30px;">
			<h3>${dto.subject}</h3>
			<!-- 댓글 영역 -->
			<div style="margin-top: 50px;">
				<h5>댓글 작성</h5>
				<input type="text" id="repleMessage" class="form-control"
					placeholder="댓글 입력" style="width: 300px; display: inline-block;">
				<input type="file" id="photoFile" accept="image/*"
					style="display: inline-block; margin-left: 10px;">
				<button type="button" class="btn btn-primary btn-sm"
					onclick="addReple()">등록</button>
				<div id="preview-container" style="display: none;">
					<img id="preview-image" src="#" alt="Preview" /> <span
						id="delete-preview" onclick="clearPreview()">X</span>
				</div>
				<div id="repleList" style="margin-top: 20px;"></div>
			</div>
		</div>
		<div style="margin-top: 50px;">
			<h5>댓글</h5>
			<c:forEach var="reple" items="${repleList}">
				<div class="reple-item"
					style="border-bottom: 1px solid #ddd; padding: 10px;">
					<strong>${reple.myid}</strong> <span class="day"> <fmt:formatDate
							value="${reple.writeday}" pattern="yyyy-MM-dd HH:mm" />
					</span>
					<p>${reple.message}</p>
					<c:if test="${not empty reple.photo}">
						<img src="${naverurl}/board/${reple.photo}"
							style="max-width: 100px;">
					</c:if>
					<c:if test="${sessionScope.loginid == reple.myid}">
						<button type="button" class="btn btn-danger btn-sm"
							onclick="deleteList(${reple.num})">삭제</button>
						<button type="button" class="btn btn-primary btn-sm"
							onclick="openEditRepleModal(${reple.num}, '${reple.message}')">수정</button>
					</c:if>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- 댓글 수정 Modal -->
	<div class="modal fade" id="editRepleModal" tabindex="-1"
		aria-labelledby="editRepleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="editRepleModalLabel">댓글 수정</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<input type="hidden" id="editRepleNum">
					<div class="mb-3">
						<label for="editRepleMessage" class="form-label">수정할 댓글 내용</label>
						<textarea class="form-control" id="editRepleMessage" rows="3"></textarea>
					</div>
					<div class="mb-3">
						<label for="editPhotoFile" class="form-label">사진 수정
							</label> <input type="file" class="form-control" id="editPhotoFile"
							accept="image/*">
						<!-- Preview Image -->
						<div id="edit-preview-container" style="display: none;">
							<img id="edit-preview-image" src="#" alt="미리보기"
								style="max-width: 100px; max-height: 100px; border: 1px solid #ccc;">
							<span id="edit-delete-preview" onclick="clearEditPreview()"
								style="position: relative; top: -5px; right: -5px; background-color: rgba(255, 0, 0, 0.7); color: white; border-radius: 50%; width: 20px; height: 20px; text-align: center; line-height: 20px; cursor: pointer;">X</span>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary"
						onclick="updateReple()">수정</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>