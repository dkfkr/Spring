<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4 :: register</title>
	</head>
	<body>
		<h3>user4 목록</h3>
		<a href="/Ch06/index">메인</a>
		<a href="/Ch06/user4/register"> user4 등록</a>	
		<table border="1">
			<tr>
				<td>이름</td>
				<td>성별</td>
				<td>나이</td>
				<td>주소</td>
				<td>관리</td>
			</tr>
			<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name}</td>
				<td>${user.gender}</td>
				<td>${user.age}</td>
				<td>${user.addr}</td>
				<td>
					<a href="/Ch06/user4/modify?uid=${user.name}">수정</a>
					<a href="/Ch06/user4/delete?uid=${user.name}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	</body>
</html>