<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${result.title}" /></h1>
<p><c:out value="${result.message}" /></p>
<a href="${result.backTo}">戻る</a>
</body>
</html>