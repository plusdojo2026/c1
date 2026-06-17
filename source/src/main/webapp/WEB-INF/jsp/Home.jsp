<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mamoral</title>
	<link rel="stylesheet" href="css/Home.css">
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

    <!-- メイン -->
    <main>
        <!-- ボタンとご意見箱の位置を決めるクラス -->
        <div class="buttonOpinion">
            <div>
                <div>
                    <!-- 出勤ボタン -->
                    <button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal').showModal()">出勤</button>&emsp;
                    <!-- 退勤ボタン -->
                    <button type="button" class="buttonOut" onclick="document.getElementById('realOut_modal').showModal()">退勤</button>
                </div>
            </div>
            <!-- ご意見箱 -->
            <form action="new_result.html" onsubmit="confirmSubmit(event)">
                <div class="opinion">
                    <p class="opinionT">ご意見箱</p>
                    <p class="opinionM">従業員の方はご自由に</p>
                    <textarea class="textarea"></textarea>
                    <input class="opinionS" type="submit" value="送信">
                </div>
            </form>
        </div>
        <!-- お知らせ -->
        <h1 class="noticeB">
            <p class="noticeLogo">お知らせ</p>
                    <dive class="noticeB-content">
                        <input type="checkbox" id="cb">
                            <p class="noticeTittle">タイトル1</p>
                            <p class="noticeTittle">タイトル1</p>
                        <div class="more_wrap">
                            <p class="noticeTittle">タイトル1</p>
                            <p class="noticeTittle">タイトル1</p>
                            <p class="noticeTittle">タイトル1</p>
                        </div>
                        <label for="cb" class="more_btn"></label>
                    </dive>
        </h1>
        <!-- バイトテロTips -->
        <h2 class="terrorTips">
            <p class="terrorLogo">バイトテロTips</p>
                <p class="terrorC">バイトテロの内容</p>
                <p class="terrorC">バイトテロの内容</p>
                <p class="terrorC">バイトテロの内容</p>
                <div class="update">
                    <input type="submit" value="更新">
                </div>
        </h2>
        <!-- 用語マナーTips -->
        <h3 class="termTips">
            <p class="termLogo">用語マナーTips</p>
                <p class="termC">用語マナーの内容</p>
                <p class="termC">用語マナーの内容</p>
                <p class="termC">用語マナーの内容</p>
                <div class="update">
                    <input type="submit" value="更新">
                </div>
        </h3>
        <!-- 出勤確認モーダル -->
        <dialog id="realIn_modal">
            <form action="new_result.html" name="check">
                    <p class="realIn">出勤確認<p>
                    <!-- required属性を付与 -->
                    <input type="checkbox" class="realInC" required>SNSの不適切な使用はしていません<br>
                    <input type="checkbox" class="realInC" required>手洗いうがいはしました<br>
                    <input type="checkbox" class="realInC" required>風邪などの体調不良ではありません<br>
                    <input type="checkbox" class="realInC" required>SNSの使用はしていません<br>
                    <input type="checkbox" class="realInC" required>SNSの使用はしていません<br>
                
                <div class="button">
                    <!-- close()でモーダルを閉じる -->
                    <button type="button" onclick="document.getElementById('realIn_modal').close()">キャンセル</button>
                    <input type="submit" name="submit" value="確定" onclick="boxCheck;">
                </div>
            </form>
        </dialog>
        <!-- 退勤確認モーダル -->
        <dialog id="realOut_modal">
            <form action="new_result.html" >
                <p class="realOut">退勤確認<p><br>
                    <p class="realOutT">バイトテロ事例</p><br>
                    <p class="realOutC">バイトテロ事例の内容</p><br>
                    <input type="checkbox" class="realOutC" required>上記の行動はしていません<br>

                <div class="button">
                    <!-- close()でモーダルを閉じる -->
                    <button type="button" onclick="document.getElementById('realOut_modal').close()">キャンセル</button>
                    <input type="submit" name="submit" value="確定" >
                </div>
            </form>
        </dialog>
    </main>
    <!-- メインここまで -->
    <!-- フッター -->
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
            `${month}月${date}日(${day}) ${h}:${m}:${s}`;
        }

        setInterval(updateClock, 1000);
        updateClock();
    </script>
    <script>
        'use strict'
        function confirmSubmit(event) {
        // 確認ダイアログを表示
            const result = confirm("送信してよろしいですか？");

            // キャンセルが押された場合は送信を中止
            if (!result) {
                event.preventDefault(); // デフォルトの送信動作を止める
            }
        }
    </script>
    <!-- <script>
        'use strict'
        function boxCheck() {
            var flag = false;

            // elementsにはボタンの要素も含まれてしまうため-1にする
            for (var i = 0; i < document.check.elements.length -1; i++)
                if (document.check.elements[i].checked) {
                    flag = true;
                    alert(document.check.elements[i].value + "が選択されました。");
                }

                if (!flag) {
                    alert("項目が選択されていません。");
                }
        }
    </script> -->
</body>

</html>
