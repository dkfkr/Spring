<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1 :: register</title>
	</head>
	<body>
		<h3>User1 목록</h3>
		<a href="/Ch05/index">메인</a>
		<a href="/Ch05/user1/register"> User1 등록</a>	
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>휴대폰 번호</td>
				<td>나이</td>
				<td>관리</td>
			</tr>
			<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.uid}</td>
				<td>${user.name}</td>
				<td>${user.hp}</td>
				<td>${user.age}</td>
				<td>
					<a href="/Ch05/user1/modify?uid=${user.uid}">수정</a>
					<a href="/Ch05/user1/delete?uid=${user.uid}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	</body>
</html>