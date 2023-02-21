<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록</title>
		<style>
			table {
				border : 1px solid black;
			}
			th, td {
				border : 1px double black;
			}
		</style>
		<!-- 부트스트랩 사용 -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="../common/menuBar.jsp"></jsp:include>
		<table class="table table-hover">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>가입날짜</th>
				<th>수정날짜</th>
			</tr>
			<c:forEach items="${mList }" var="member" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td><a href="/member/detail.do?memberId=${member.memberId }">${member.memberId }</a></td>
					<td>${member.enrollDate }</td>
					<td>${member.updateDate }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>