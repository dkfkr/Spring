<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user5 :: modify</title>
	</head>
	<body>
		<h3>user5 수정</h3>
		<a href="/Ch06/index">메인</a>
		<form action="/Ch06/user5/modify" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user5DTO.namr}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birth" value="${user5DTO.birth}"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" value="${user5DTO.age}"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="${user5DTO.address}"/></td>
				</tr>
				<tr>
					<td>휴대폰번호</td>
					<td><input type="text" name="hp" value="${user5DTO.hp}"/></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" value="${user5DTO.uid}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="등록"></td>
				</tr>
			
			</table>
		</form>
	</body>
</html>