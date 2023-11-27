<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>views 폴더 안에 sample 폴더 안에 ex04Form.jsp 소스 코딩</title>
</head>
<body>
	
		<form action="/sample/ex04" method="get">
			이름 : <input type="text" name="name"> <br><br>
			나이 : <input type="text" name="age"> <br><br>
			페이지 : <input type="text" name="page"> <br><br>
			<input type="submit" value="제출!"> 		
			<input type="reset" value="취소!">
		</form>

</body>
</html>