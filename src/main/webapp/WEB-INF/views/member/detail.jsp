<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 상세</title>
	</head>
	<body>
		ID : ${member.memberId } / NAME : ${member.memberName } / EMAIL : ${member.memberEmail } / PHONE : ${member.memberPhone } / ADDRESS : ${member.memberAddr} <br>
		가입날짜 : ${member.enrollDate } / 수정날짜 : ${member.updateDate }
	</body>
</html>