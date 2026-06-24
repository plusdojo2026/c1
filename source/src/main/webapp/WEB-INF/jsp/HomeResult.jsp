<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mamoral</title>
	<link rel="stylesheet" href="css/Home.css">
</head>
<body>
<!-- ヘッダー -->
    <header class="header">
        <!-- ロゴ -->
        <img src="images/mamorallogo.png" alt="Mamoral" class="logo">
        
    </header>
<main>
	<!-- <form method="GET" action="/c1/HomeServlet"> -->
	<h1><c:out value="${result.title}" /></h1>
	<p><c:out value="${result.message}" /></p>
	<a href="${result.backTo}">戻る</a>
	<!-- </form> -->
</main>
<footer>
        <p class="copylight">Copyright 2026 &copy; クエン酸. all rights reserved.</p>
</footer>

</body>
</html>