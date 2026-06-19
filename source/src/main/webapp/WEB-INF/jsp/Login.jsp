<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
	<link rel = "stylesheet" href = "css/Login.css">
</head>

<body>

<header>
</header>

<main>
<div class="container">
		<img src = "images/mamorallogo.png" alt="アプリのタイトルであるマモラルのロゴ画像" class="title-logo">

	<form method="POST" action="/c1/LoginServlet">
		<div class="text-group">
			<p>
				<input type="text" name="id" placeholder = "ユーザーID" class="id_text">
			</p>
			<p>
				<input type="password" name="pw" placeholder = "Password" class="password_text">
			</p>
			<p>
				<input type="submit" name="login" value="ログイン" class="button">
			</p>
		</div>
	</form>
</div>

</main>

<footer>
</footer>

</body>

<script>
'use strict';

document.getElementById('form').onsubmit = function(event) {
            let id = document.getElementById('form').id.value;
            let pw = document.getElementById('form').pw.value;
            
			if (id === '' && pw === '') {
                window.alert('ＩＤとパスワードを入力してください');
                event.preventDefault();
			}else if (id === '' && pw !== '' ) {
                window.alert('ＩＤを入力してください！');
                event.preventDefault();
            }else if (id !== '' && pw === '') {
                window.alert('パスワードを入力してください！');
                event.preventDefault();
            }else if (id !== 'id' || pw !== 'password') {
                window.alert('ＩＤまたはパスワードが違います！');
                event.preventDefault();
            }
        }

</script>

</html>