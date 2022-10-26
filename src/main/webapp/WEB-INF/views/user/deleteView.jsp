<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
		$(document).ready(function(){
		
			$("#deletee").on("click", function(){
				
				if($("#userpw").val()==""){
					alert("비밀번호를 입력해주세요");
					$("#userpw").focus();
					return false
				}
				
				if($("#userpw2").val()==""){
					alert("비밀번호 확인을 입력해주세요");
					$("#userpw2").focus();
					return false
				}
				
				if(confirm("탈퇴하시겠습니까?")){
					   document.deleteForm.submit();
					}
			});
		})
	</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="delete" method="post" id="deleteForm" name="deleteForm">
                       <input type="hidden" id="userid" name="userid" value="${login.userid}">
    <div class="col-sm-8 col-sm-offset-2">
        <div class="panel panel-default panel-margin-10">
            <div class="panel-body panel-body-content text-center">
                <p class="lead">회원탈퇴를 하려면 비밀번호를 입력해주세요.</p>
                <div class="form-group">
                    <input type="password" id = "userpw" name="userpw" class="form-control form-control-inline text-center" placeholder="비밀번호" />
                </div>
                <div class="form-group">
                    <input type="password" id="userpw2" name="userpw2"  class="form-control form-control-inline text-center" placeholder="비밀번호 확인" />
                </div>
                <button type="button" id="deletee" name="delete" class="btn btn-primary">회원탈퇴</button> <a href="home" class="btn btn-default">취소</a>
            </div>
        </div>
    </div>
    </form>
</body>
</html>