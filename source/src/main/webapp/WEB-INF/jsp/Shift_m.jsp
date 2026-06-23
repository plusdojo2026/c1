<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト管理</title>
<link rel="stylesheet" href="css/Shift.css">
<link rel="stylesheet" href="css/header.css">
</head>
<body>
   <!-- ヘッダー -->
    <header class="header">
        <!-- ロゴ -->
        <img src="images/mamorallogo.png" alt="Mamoral" class="logo">
        <!-- 時計 -->
        <div id="clock"  ></div>
        <!-- メニューバーの設置 -->
        <div class="menu-wrapper">
                <input type="checkbox" id="menu-toggle" hidden>

            <label class="menu-icon" for="menu-toggle">
                <span></span>
                <span></span>
                <span></span>
            </label>

            <div class="overlay"></div>

            <nav class="menu">
                <ul>
                    <li><a href="/c1/HomeServlet">ホーム</a></li>
                    <li><a href="/c1/NoticeServlet">お知らせ</a></li>
                    <li><a href="/c1/ShiftServlet">シフト・出退勤管理</a></li>
                    <li><a href="/c1/BooksServlet">用語本棚一覧</a></li>
                    <li><a href="/c1/MypageServlet">マイページ</a></li>
                    <li><a href="/c1/LogoutServlet">ログアウト</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <!-- ヘッダーここまで -->

<div class="background"><!-- 背景を表示する範囲の div -->
<h1 class="hero">シフト・出退勤管理一覧(店長)</h1>
<main>
	<c:if test="${not empty successMessage}">
	    <div class="alert alert-success">${successMessage}</div>
	    <c:remove var="successMessage" scope="session"/>
	</c:if>
	
	<c:if test="${not empty errorMessage}">
	    <div class="alert alert-danger">${errorMessage}</div>
	    <c:remove var="errorMessage" scope="session"/>
	</c:if>
    <!-- 出退勤、シフト一覧 -->
        <div class="shift-card">
            <!-- 検索 -->
            <form action="ShiftServlet" method="get">
                <input type="text" name="word" placeholder="名前・社員IDであいまい検索" class="searchWord">
                <label for="year">年:</label>
				<select id="year"></select>
				<label for="month">月:</label>
				<select id="month"></select>
                <button type="submit" class="shiftSearch">検索</button>
            </form>

            <!--    シフトデータ -->
<c:forEach var="e" items="${shiftList}">
<form action="ShiftRUDServlet" method="post" class="shift-row">

    <div class="shift-left">
        <div class="shiftName">${e.user_name}</div>
        <div class="date">${e.date}</div>
    </div>

    <div class="shift-right">
	    <div class="shift-time">
	        シフト
	        <input type="text" name="clock_in" value="${e.clock_in}">
	        〜
	        <input type="text" name="clock_out" value="${e.clock_out}">
		</div>
        <div class="shiftIn">
            出勤 <input type="text" name="real_in" value="${e.real_in}">
        </div>
        <div class="shiftOut">
            退勤 <input type="text" name="real_out" value="${e.real_out}">
        </div>
    </div>

    <div class="shift-buttons">
        <input type="hidden" name="id" value="${e.id}">
        <input type="hidden" name="date" value="${e.date}">

        <button type="submit" name="action" value="update" class="update">更新</button>
        <button type="submit" name="action" value="delete" class="delete">削除</button>
    </div>

</form>
</c:forEach>
        </div>
</main>
</div>
</body>

<script>
    'use strict'
function updateClock() {
    const now = new Date();

    const year = now.getFullYear();
    const month = now.getMonth() + 1; // 0始まりなので+1
    const date = now.getDate();

    const week = ["日", "月", "火", "水", "木", "金", "土"];
    const day = week[now.getDay()];

    const h = String(now.getHours()).padStart(2, '0');
    const m = String(now.getMinutes()).padStart(2, '0');
    const s = String(now.getSeconds()).padStart(2, '0');

    document.getElementById("clock").textContent =
    	<!-- `${month}月${date}日(${day}) ${h}:${m}:${s}`; -->
        month + "月" +
        date + "日(" +
        day + ") " +
        h + ":" +
        m + ":" +
        s;
}

setInterval(updateClock, 1000);
updateClock();

document.addEventListener('DOMContentLoaded', () => {
    const yearSelect = document.getElementById('year');
    const monthSelect = document.getElementById('month');

    try {
        const startYear = 2025;
        const endYear = new Date().getFullYear() + 5;

        yearSelect.appendChild(new Option('--', ''));
        monthSelect.appendChild(new Option('--', ''));

        for (let y = startYear; y <= endYear; y++) {
            const option = document.createElement('option');
            option.value = y;
            option.textContent = y + '年';
            yearSelect.appendChild(option);
        }

     
        for (let m = 1; m <= 12; m++) {
            const option = document.createElement('option');
            option.value = m;
            option.textContent = m + '月';
            monthSelect.appendChild(option);
        }
    } catch (err) {
        console.error('年月セレクト生成中にエラー:', err);
    }
});
</script>

<footer>
    <p class="copylight">Copyright 2026 &copy; クエン酸. all rights reserved.</p>
</footer>
</html>