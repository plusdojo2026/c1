<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登録更新の是非 | MaMoral</title>
<link rel="stylesheet" href="css/Books.css">
</head>
    <!-- ヘッダー -->
    <header class="header">
     <!-- ロゴ -->
    <div class="logo">
            <img src="images/mamorallogo.png" alt="MaMoral">
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
                    <li><a href="/c1/LoginServlet">ログアウト</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <!-- ヘッダーここまで -->
    <!-- 見出し&ヒーロー -->
    <!-- 見出し&ヒーローここまで -->
    <!-- メイン -->
    <main>
<h1><c:out value="${result.title}" /></h1>
<p><c:out value="${result.message}" /></p>
<a href="${result.backTo}">戻る</a>
    </main>
        <!-- メインここまで -->
    <!-- フッター -->
    <footer>
        <div class="gotop">
            <a href="#top"><img src="images/gotop.svg" alt="ページトップへ戻る"></a>
        </div>
        <p class="copyright">&copy; クエン酸. all rights reserved.</p>
    </footer>
    <!-- フッターここまで -->
    <script>
        'use strict';

        const render = function(q) {
            const parent = document.getElementById('result');
            for (const item of q) {
                parent.insertAdjacentHTML('beforeend', `<tr><td>${item[0]}</td><td>${item[1]}</td></tr>`);
            }
        }

        window.addEventListener('DOMContentLoaded', (e) => {
            try {
                const urlParam = decodeURIComponent(location.search.replace(/\+/g, ' ')).slice(1);
                const qList = urlParam.split('&');
                const queries = [];
                for (const item of qList) {
                    const split = item.split('=');
                    queries.push([split[0], split[1].split('<').join('&lt;').split('>').join('&gt;')]);
                }
                render(queries);
            } catch(err) {
                console.log(err);
            }
        });
        
        /* 時刻　*/
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
</body>
</html>
