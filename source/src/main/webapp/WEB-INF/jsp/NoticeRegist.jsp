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
<!-- ヘッダー -->
    <header class="header">
        <!-- ロゴ -->
        <img src="images/mamorallogo.png" alt="Mamoral" class="logo">
        <!-- 時計 -->
        <div id="clock"  ></div>
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