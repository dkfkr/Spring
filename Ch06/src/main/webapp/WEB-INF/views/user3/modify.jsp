<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user3 :: modify</title>
	</head>
	<body>
		<h3>user3 수정</h3>
		<a href="/Ch06/index">메인</a>
		<form action="/Ch06/user3/modify" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" value="${user3DTO.uid}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user3DTO.name}"/></td>
				</tr>
				<tr>
					<td>휴대폰번호</td>
					<td><input type="text" name="hp" value="${user3DTO.hp}"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${user3DTO.age}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="등록"></td>
				</tr>
			
			</table>
		</form>
	</body>
</html>