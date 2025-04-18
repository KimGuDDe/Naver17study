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

.profilelargephoto {
	width: 150px;
	height: 150px;
	border: 1px solid gray;
	border-radius: 100px;
	top: -300px;
}

.changecamera {
	position: relative;
	cursor: pointer;
	font-size: 1.5em;
	left: -25px;
	top: 50px;
}

.section {
	margin-top: 30px;
	margin-left : 70px;
	width: 600px;
	clear: both;
}

.section h5 {
	margin-bottom: 15px;
	color: #03c75a;
}
</style>
</head>

<body>
	<jsp:include page="../../layout/title.jsp" />
	<div style="margin: 30px;">
		<%-- <img src="../save/${dto.mphoto}" class="profilelargephoto"
			onerror="this.src='../save/noimage.png'"> --%>

		<!-- naver storage 사진으로 출력 -->
		<img src="${naverurl}/member/${dto.mphoto}" class="profilelargephoto"
			onerror="this.src='../save/noimage.png'"> <input type="file"
			id="fileupload" style="display: none;"> <i
			class="bi bi-camera-fill changecamera"></i>
		<script type="text/javascript">
    		$(".changecamera").click(function(){
    			$("#fileupload").trigger("click");
    		});
    		
    		//사진 변경 이벤트
    		$("#fileupload").change(function(e){
    			let form = new FormData();
    			form.append("upload",e.target.files[0]);
    			form.append("num",${dto.num});
    			
    			$.ajax({
    				type:"post",
    				dataType:"text",
    				data:form,
    				url:"./changephoto",
    				processData:false,
    				contentType:false,
    				success:function(){
    					location.reload();
    				}
    					
    			});
    		});
    		
    	</script>
		<div style="display: inline-block; margin: 20px 50px;">
			<h6>회원명 : ${dto.mname}</h6>
			<h6>아이디 : ${dto.myid}</h6>
			<h6>핸드폰 : ${dto.mhp}</h6>
			<h6>주 소 : ${dto.maddr}</h6>
			<h6>
				가입일 :
				<fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm" />
			</h6>
			<button type="button" class="btn btn-sm btn-danger"
				onclick="memberdel(${dto.num})">회원탈퇴</button>

			<script type="text/javascript">
    			function memberdel(num)
    			{
					let ans=confrim("정말 탈퇴하시겠습니까");
					if(ans){
						$.ajax({
							type:"get",
							dataType:"text",
							data:{"num":num},
							url:"./mypagedel",
							success:function(){
								location.href='../';
							}
						});
					}
				}
    		</script>
			<!-- 문제: 아이디를 제외한 나머지 정보(mname,mhp,maddr) 수정 (모달)
    		수정 후 reload 할거니까 @responseBody 로 메서드 구현 -->
			<!-- 회원정보수정 버튼 -->
			<button type="button" class="btn btn-sm btn-success"
				data-bs-toggle="modal" data-bs-target="#editModal">회원정보수정</button>


			<!-- Modal -->
			<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
				aria-labelledby="editModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="editModalLabel">회원정보 수정</h5>
						</div>
						<div class="modal-body">
							<form id="editForm">
								<div class="form-group">
									<label for="mname">이름</label> <input type="text"
										class="form-control" id="mname" name="mname"
										value="${dto.mname}">
								</div>
								<div class="form-group">
									<label for="mhp">핸드폰</label> <input type="text"
										class="form-control" id="mhp" name="mhp" value="${dto.mhp}">
								</div>
								<div class="form-group">
									<label for="maddr">주소</label> <input type="text"
										class="form-control" id="maddr" name="maddr"
										value="${dto.maddr}">
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-primary" id="saveChanges">저장</button>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">
$(document).ready(function() {
    $('#saveChanges').click(function() {
        var mname = $('#mname').val();
        var mhp = $('#mhp').val();
        var maddr = $('#maddr').val();
        var num = ${dto.num};

        // 입력값 검증
        if (mname.trim() === "") {
            alert("이름을 입력해주세요.");
            return;
        }
        if (mhp.trim() === "") {
            alert("핸드폰 번호를 입력해주세요.");
            return;
        }
        if (maddr.trim() === "") {
            alert("주소를 입력해주세요.");
            return;
        }

        // 다중 제출 방지
        $(this).prop('disabled', true);

        $.ajax({
            type: "post",
            url: "./updateMember",
            data: {
                num: num,
                mname: mname,
                mhp: mhp,
                maddr: maddr
            },
            success: function() {              
                    location.reload();
            }
        });
    });
});
</script>

		</div>
	</div>
	<div class="section">
		<h5>내가 작성한 글</h5>
		<table class="table table-bordered tabmyboard">
			<thead>
			<tr>
				<th width="60">번  호</th>
				<th width="350">제  목</th>
				<th width="100">작성일</th>
				<th>조회</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${myBoards}" varStatus="i">
			<tr>
				<td align="center">${i.count }</td>
				<td>
					<a href="../board/detail?idx=${dto.idx}" style="color:black;text-decoration: none">
					  <c:if test="${dto.relevel!=0}"><mark>[답글]</mark></c:if>
					  ${dto.subject}
					</a>
				</td>
				<td align="center">
					<span style="font-size: 0.8em;">
						<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
					</span>
				</td>
				<td align="center">${dto.readcount}</td>
			</tr>
		</c:forEach>
					<c:if test="${empty myBoards}">
						<li class="list-group-item">작성한 글이 없습니다.</li>
					</c:if>
					
			</tbody>
		</table>
	</div>
</body>
</html>