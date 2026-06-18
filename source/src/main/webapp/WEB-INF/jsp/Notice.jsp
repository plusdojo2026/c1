<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<!-- 検索フォーム -->
<form class="search-box" action="search.php" method="get">
    <input type="text" name="q" placeholder="タイトル" required>
    <input type="text" name="q" placeholder="記入者" required>
    <button type="submit">検索</button>
</form>

<form action="save_notice.php" method="post">
    <table id="newsTable">
    <label>タイトル
        <input type="text" name="registTitle" required>
    </label>
    <label>日付
        <input type="date" id="datepicker" name="date">
        </label>
 

<p>内容</p>
        <p><textarea name="registText" required></textarea>

    </label>
<p>状態: <span id="status">未確認</span></p>
<button id="checkBtn">確認</button>

<label for="member">確認者リスト:</label>
 	<select id="member" name="member">
    <option value=""> -- 選択してください -- </option>
    <option value="001">山田 太郎</option>
    <option value="002">佐藤 花子</option>
    <option value="003">鈴木 一郎</option>
    <option value="004">田中 美咲</option>
  </select>

	</label>
    
<input type="submit"name="submit"value="更新">
</table>
</form>
</main>

<!-- ここからフッター -->
<footer>
    <p class="copylight">Copyright 2026 &copy; クエン酸. all rights reserved.</p>
</footer>

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