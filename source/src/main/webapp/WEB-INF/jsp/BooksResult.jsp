<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登録更新の是非を示そう | MaMoral</title>
    <link rel="stylesheet" href="css/BooksResult.css">
</head>
<body id="top">
    <!-- ヘッダー -->
    <header class="header">
        <div class="logo">
            <a href="/webapp/MenuServlet"><img src="images/businesscard.png" alt="名刺管理"></a>
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
        <p class="copylight">Copyright 2026 &copy; YSL Solution. all rights reserved.</p>
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
    </script>
</body>
</html>
