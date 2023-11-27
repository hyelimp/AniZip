<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>views 폴더 안에 ex03.jsp 소스 코딩</title>
</head>
<body>

	<form action="/sample/ex03" method="get">		
		제목 : <input type="text" name="title"> <br><br>		
		날짜 : <input type="date" name="dueDate"> <br><br>	
		<input type="submit" value="날짜 등록!">
		<input type="reset" value="등록 취소!">
	</form>

</body>
</html>