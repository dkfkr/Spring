<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user5 :: register</title>
	</head>
	<body>
		<h3>user5 목록</h3>
		<a href="/Ch06/index">메인</a>
		<a href="/Ch06/user5/register"> user5 등록</a>	
		<table border="1">
			<tr>
				<td>이름</td>
				<td>생년월일</td>
				<td>나이</td>
				<td>주소</td>
				<td>휴대폰번호</td>
				<td>아이디</td>
				<td>관리</td>
			</tr>
			<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name}</td>
				<td>${user.birth}</td>
				<td>${user.age}</td>
				<td>${user.address}</td>
				<td>${user.hp}</td>
				<td>${user.uid}</td>
				<td>
					<a href="/Ch06/user5/modify?uid=${user.uid}">수정</a>
					<a href="/Ch06/user5/delete?uid=${user.uid}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	</body>
</html>