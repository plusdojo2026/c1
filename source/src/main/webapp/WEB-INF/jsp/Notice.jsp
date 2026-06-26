<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ一覧</title>
<link rel="stylesheet" href="css/Notice.css">
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
                    <li><a href="/c1/BooksServlet">シフト・出退勤管理</a></li>
                    <li><a href="/c1/BooksServlet">用語本棚一覧</a></li>
                    <li><a href="/c1/MypageServlet">マイページ</a></li>
                    <li><a href="/c1/LoginServlet">ログアウト</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <!-- ヘッダーここまで -->

<!-- ここからメイン -->
<main>
<div class="image-container">
  <img src="images/fukidashi.png" alt="fukidashi" class="main-image">
  <div class="overlay-text">
    <span>お知らせ一覧</span>
    <!-- 画像をクリックすると別ページに移動 -->
<a href="NoticeRegistServlet" target="_blank">
    <img src="images/pen.png" alt="pen" class="icon">
</a>
  </div>
</div>

<!-- 検索フォーム -->

<form class="search-box" action="/c1/NoticeServlet" method="POST">
    <input type="text" name="title" placeholder="タイトル" >
    <input type="text" name="user_name" placeholder="記入者" >
    <button type="submit">検索</button>
</form>

<div class = "box-area">
<c:forEach var="e" items="${cardList}" >
<form action="/c1/NoticeUpdateDeleteServlet" method="POST">
    <table id="newsTable">
    <label>タイトル
        <input type="text" name="title" value="${e.title}">
    </label>
    <label>日付
        <input type="date" id="datepicker" name="date"value="${e.date}">
        </label>

<p>内容</p>
        <p><textarea name="notice" >${e.notice}</textarea>

<p>状態: <span id="status">未確認</span></p>
<button id="checkBtn">確認</button>

<label for="member">確認者リスト:</label>
 	<select id="member" name="member">
    <option value=""> -- 選択してください -- </option>
    <option value="001">斎藤由利</option>
    <option value="002">高橋翔</option>
    <option value="003">山田祐樹</option>
  </select>

 
 	<form onsubmit="return checkdelete()" id="resultform" class="search_result" method="POST" action="/c1/NoticeUpdateDeleteServlet">

<tr>
<td>
${e.notice}<br><br></td>
<input type="hidden" name="id" value="${e.id}">
<input type="hidden" name="user_id" value="${e.user_id}">
<input type="hidden" name="user_name" value="${e.user_name}">
<input type="hidden" name="date" value="${e.date}">
<input type="hidden" name="notice" value="${e.notice}">
<input type="hidden" name="update_namel" value="${e.update_name}">
<input type="hidden" name="update_date" value="${e.update_date}">
</tr>
<tr>
<td>
	最終更新日：${e.update_date}<br>
</td>
</tr>
<tr>
<td>
	最終更新者：${e.update_name}<br>
</td>
</tr>
<tr>
<td>
	<button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal2${e.id}').showModal()">編集</button><!-- 編集ボタン -->
	<input class="delete1" type="submit" name="submit" value="削除">
</td>
</tr>
</form>



<!-- 編集モーダル -->
<dialog id="realIn_modal2${e.id}">
<form  onsubmit="return checkupdate()" id="resultform" class="search_result" method="POST" action="/c1/NoticeUpdateDeleteServlet">
<input type="hidden" name="id" value="${e.id}">
<input type="hidden" name="user_id" value="${e.user_id}">
<input type="hidden" name="user_name" value="${e.user_name}">
<input type="hidden" name="notice" value="${e.notice}">
<input type="hidden" name="update_namel" value="${e.update_name}">
<input type="hidden" name="update_date" value="${e.update_date}">
						
<textarea name="manual">${e.notice}</textarea><br>
<div class="button">
<!-- close()でモーダルを閉じる -->
<button type="button" onclick="document.getElementById('realIn_modal2${e.id}').close()">キャンセル</button>
<input class="update1" type="submit" name="submit" value="更新" >
</div>
</form>
                               </dialog>
</details></div></div></div></form></c:forEach>

<c:if test="${empty cardList}">
<p>指定された条件に一致するデータはありません。</p>
</c:if>
   
<input type="submit"name="submit"value="更新">
</table>
</div>
</main>

<!-- ここからフッター -->
<footer>
    <p class="copylight">Copyright 2026 &copy; クエン酸. all rights reserved.</p>
</footer>

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
    </script>

 <script>
document.getElementById("checkBtn").addEventListener("click", function() {
    // 確認ダイアログを表示
    if (confirm("本当に確認しますか？")) {
        document.getElementById("status").textContent = "確認済";
        document.getElementById("status").style.color = "green";
        this.disabled = true; // ボタンを無効化
    }
});
</script>  

</body>
</html>