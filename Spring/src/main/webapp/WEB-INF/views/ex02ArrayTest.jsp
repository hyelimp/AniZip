<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>views 폴더 안에 ex02ArrayTest.jsp 소스 코딩</title>
</head>
<body>

	<form action="/sample/ex02Array" method="get">
		좋아하는 과일
		<input type="checkbox" name="ids" value="사과">사과
		<input type="checkbox" name="ids" value="포도">포도
		<input type="checkbox" name="ids" value="수박">수박		
		<input type="submit" value="전송">
	</form>

</body>
</html>