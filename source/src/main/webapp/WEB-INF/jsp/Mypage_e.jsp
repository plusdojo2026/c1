<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>マイページ-従業員画面</title>
		<link rel = "stylesheet" href = "css/Mypage_e.css">
	</head>
	<body>

	<header>
		<!-- ヘッダーはあとで統一 -->
		<!-- ロゴ -->
		<div class="logo">
			<img src="images/mamorallogo.png" alt="Mamoral" class="logo">
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


	<main>
		<h1>マイページ</h1>

		<form method="POST" action="/c1/Mypage_e.Servlet" onsubmit="confirmSubmit(event)">
			<div class="change-group">
				<h2>パスワード変更</h2>
				<table class="change-table">
					<tr>
						<th>現在使用しているパスワード</th>
						<td><input type="text" name="nowPassword" class="text-box"></td>
					</tr>
					<tr>
						<th>新たに変更するパスワード</th>
						<td><input type="text" name="newPassword" class="text-box"></td>
					</tr>
				</table>
				<p><input type="submit" name="change" value="変更する" class="change-button"></p>
			</div>
		</form>

	</main>

	<footer>
		<p class="copyright">&copy; 2026クエン酸 All Rights Reserved.</p>
	</footer>

	</body>

	<script>
		'use strict';


		function confirmSubmit(event) {
			// 確認ダイアログを表示
			const result = confirm("この内容で登録してよろしいですか？");

			// キャンセルが押された場合は送信を中止
			if (!result) {
				event.preventDefault(); // デフォルトの送信動作を止める
			}
		}

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

		document.getElementById('form').onsubmit = function(event) {
            let nowPassword = document.getElementById('form').nowPassword.value;
            let newPassword = document.getElementById('form').newPassword.value;
            
			if (nowPassword === '' && newPassword === '') {
                window.alert('現在のパスワードと新しいパスワードを入力してください');
                event.preventDefault();
			}else if (nowPassword === '' && newPassword !== '' ) {
                window.alert('現在のパスワードを入力してください！');
                event.preventDefault();
            }else if (nowPassword !== '' && newPassword === '') {
                window.alert('新しいパスワードを入力してください！');
                event.preventDefault();
            }else if (nowPassword === newPassword ) {
                window.alert('同じパスワードを入力しています。違うものを入力してください。');
                event.preventDefault();
            }
        }



	</script>

</html>