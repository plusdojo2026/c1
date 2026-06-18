<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ一覧</title>
    <link rel="stylesheet" href="css/NoticeRegist.css">
</head>

<body>
<header>

<!--ここからJavascript-->
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

    <!-- ロゴ -->
    <div class="logo">
            <img src="../img/mamorallogo.png" alt="名刺管理JOYFULL">
    </div>
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
                    <li><a href="#">ホーム</a></li>
                    <li><a href="#">お知らせ</a></li>
                    <li><a href="#">シフト・出退勤管理</a></li>
                    <li><a href="#">用語本棚一覧</a></li>
                    <li><a href="#">マイページ</a></li>
                    <li><a href="#">ログアウト</a></li>
                </ul>
            </nav>
        </div>

</header>
<h1>お知らせ登録</h1>
<form action="save_notice.php" method="post">
    <label>タイトル
        <input type="text" name="registTitle" required>
    </label>
    <label>日付
        <input type="date" id="datepicker">
<script>
window.onload = function() {
const today = new Date();
const yyyy = today.getFullYear();
const mm = String(today.getMonth() + 1).padStart(2, '0');
const dd = String(today.getDate()).padStart(2, '0');
const formattedDate = `${yyyy}-${mm}-${dd}`;
document.getElementById("datepicker").value = formattedDate;
};
</script>
    </label>
	<label>
    <p>内容</p>
        <p>
        <textarea name="registText" required></textarea>
    </label>
    <input type="submit" value="登録">
</p>
</form>

</body>
<footer>
    <p class="copylight">Copyright 2026 &copy; クエン酸. all rights reserved.</p>
</footer>
</html>