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
    
<h1 class="heading-6">お知らせ一覧</h1>

<!-- ここからメイン -->
<main>

<!-- 画像をクリックすると別ページに移動 -->
<a href="https://NoticeRegist.com" target="_blank">

    <img src="images/fukidashi.png" alt="fukidashi">

	<img src="images/fukidashi.png" alt="fukidashi">

</a>
<!-- 検索フォーム -->

<form class="search-box" action="Notice.jsp" method="get">
    <input type="text" name="q" placeholder="タイトル" required>
    <input type="text" name="q" placeholder="記入者" required>
    <button type="submit">検索</button>
</form>

<form action="Notice.jsp" method="post">
    <table id="newsTable">

    <label>タイトル
        <input type="text" name="title" required>  
    
    <form id="editForm" method="post" action="/update">
    <!-- タイトル -->
    <label for="title">タイトル</label>
    <input type="text" id="title" name="registTitle" value="サンプルタイトル" required>

    <!-- 日付 -->
    <label for="date">日付</label>
    <input type="date" id="date" name="date" value="2026-06-22" required>

    <!-- 内容 -->
    <p>
    <label for="content">内容</label>
  	</p>  
    <textarea id="content" name="registText" rows="5" required>ここに内容が入ります。</textarea>
    
</form>
<select id="member" name="member">
    <option value=""> -- 選択してください -- </option>
    <option value="001">斎藤由利</option>
    <option value="002">高橋翔</option>
  </select>
<button id="checkBtn">確認</button>

<p>
<label for="member">確認者リスト:</label>
<ul id="confirmedList"></ul>

 	<select id="member" name="member">
    <option value="001">斎藤由利</option>
    <option value="002">高橋翔</option>
  </select>
</p>

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
'use strict'
    const confirmBtn = document.getElementById('confirmBtn');
    const peopleList = document.getElementById('peopleList');
    let counter = 0; // 押した人数カウント

    confirmBtn.addEventListener('click', () => {
        counter++;

        // 最初の「まだ誰も押していません」オプションを削除
        if (peopleList.options.length === 1 && peopleList.options[0].value === "") {
            peopleList.remove(0);
        }

        // 新しいオプションを追加
        const label = `ユーザー${counter}`;
        const option = document.createElement('option');
        option.value = label;
        option.textContent = label;
        peopleList.appendChild(option);
    });
</script>

<script>
'use strict'
// 簡易バリデーション
document.getElementById("editForm").addEventListener("submit", function(e) {
    const title = document.getElementById("registTitle").value.trim();
    const date = document.getElementById("date").value;
    const content = document.getElementById("registText").value.trim();

    if (!title || !date || !content) {
        alert("すべての項目を入力してください。");
        e.preventDefault();
    }
});
</script>

<script>
'use strict'
document.getElementById("confirmBtn").addEventListener("click", function() {
    const select = document.getElementById("nameSelect");
    const name = select.value.trim();
    const list = document.getElementById("confirmedList");

    // 入力チェック
    if (!name) {
        alert("名前を選択してください。");
        return;
    }

    // 重複チェック
    const existingNames = Array.from(list.children).map(li => li.textContent);
    if (existingNames.includes(name)) {
        alert("この名前はすでにリストにあります。");
        return;
    }

    // リストに追加
    const li = document.createElement("li");
    li.textContent = name;
    list.appendChild(li);
});
</script>

</body>
</html>