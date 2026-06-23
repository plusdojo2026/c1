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



    <h1 class="hero">シフト・出退勤管理一覧(従業員)</h1>
    <main>
    <c:if test="${not empty successMessage}">
	    <div class="alert alert-success">${successMessage}</div>
	    <c:remove var="successMessage" scope="session"/>
	</c:if>
	
	<c:if test="${not empty errorMessage}">
	    <div class="alert alert-danger">${errorMessage}</div>
	    <c:remove var="errorMessage" scope="session"/>
	</c:if>
      <!-- シフト登録 -->
      <div class="shift-add-box">
        <h2 class="shift-add-title">シフト登録</h2>
        <form action="ShiftRUDServlet" method="post" 
      onsubmit="return confirm(' 登録してもよろしいですか？');" 
      class="shift-add-form">

    <input type="hidden" name="action" value="insert">
	<input type="hidden" name="user_id" value="${sessionScope.user_id}">
    <div class="shift-add-row">
        <input type="date" name="date" class="registDate" placeholder="年/月/日">
    </div>

    <div class="shift-add-row">
        <input type="text" name="clock_in" class="registIn" placeholder="出勤時刻">
    </div>

    <div class="shift-add-row">
        <input type="text" name="clock_out" class="registOut" placeholder="退勤時刻">
    </div>

    <div class="shift-add-row">
        <button type="submit" class="shiftAdd">登録</button>
    </div>
</form>

      </div>


    <!-- 給与 -->
    <div class="salary">
    <h2>給与</h2>
        <table border="1">
            <tr>
            <th>月</th>
            <th>日数</th>
            <th>時間</th>
            <th>給与</th>
            </tr>
            <tr>
            <td>6月</td>
            <td>4</td>
            <td>20</td>
            <td>26000</td>
            </tr>

            </table>
    </div>
      <!-- 出退勤、シフト一覧 -->
      <div class="shift-card">
        <form action="ShiftServlet" method="get">
        	<input type="text" name="word" placeholder="名前であいまい検索" class="searchWord">
        	<label for="year">年:</label>
			<select id="year" name="year"></select>
			
			<label for="month">月:</label>
			<select id="month" name="month"></select>

          <button type="submit" class="shiftSearch">検索</button>
        </form>

        <!-- シフトデータ -->
        <c:forEach var="e" items="${shiftList}">
        <div class="shift-row">
          <div class="shift-left">
            <div class="shiftName">${e.user_name}</div>
            <div class="date">${e.date}</div>
          </div>
          <div class="shift-right">
            <div class="inandOut">シフト${e.clock_in}〜${e.clock_out}</div>
            <div>
              <div class="shiftIn">出勤${e.real_in}</div>
              <div class="shiftOut">退勤${e.real_out}</div>
            </div>
           
          </div>
        </div>
       </c:forEach>
      </div>
     
    </main>
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