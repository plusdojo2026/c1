<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用語本棚 | MaMoral</title>
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
                    <li><a href="/c1/BooksServlet">シフト・出退勤管理</a></li>
                    <li><a href="/c1/BooksServlet">用語本棚一覧</a></li>
                    <li><a href="/c1/MypageServlet">マイページ</a></li>
                    <li><a href="/c1/LoginServlet">ログアウト</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <!-- ヘッダーここまで -->
    <h1 class="heading-6">用語本棚</h1>
    <!-- メイン -->
    <main>
        <!-- 絞り込み検索 -->
        <details class="accordion-008"><!--折り畳み機能-->
            <summary>絞り込み検索/並び替え</summary><!--折り畳み状態タイトル-->
            <form action="/c1/BooksServlet"><!--検索ボックス-->
                <table>
                    <tr>
                        <td>
                            <!--カテゴリープルダウン選択-->
                            <select name="category">
                                <option hidden>カテゴリー選択</option>
                                <option></option>
                                <option value="manual">マニュアル</option>
                                <option value="term">用語</option>
                                <option value="others">その他</option>
                            </select>
                        </td>
                        <td>
                            <!--月選択-->
                            <input type="month">
                        </td>
                        <td>
                            <!--並び替えプルダウン選択-->
                            <select name="sort">
                                <option hidden>並び替え</option>
                                <option>デフォルト</option>
                                <option value="nameUp">名前昇順</option>
                                <option value="nameDown">名前降順</option>
                                <option value="dateUp">日付昇順</option>
                                <option value="dateDown">日付降順</option>
                            </select>
                        </td>
                        <td>
                            <input type="text" name="teacher" placeholder="登録者">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="title" placeholder="タイトル検索">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="manual" placeholder="キーワード検索">
                        </td>
                        <td>
                            <input type="submit" name="submit" value="実行">
                        </td>
                    </tr>
                </table>
            </form>
        </details>

        <input type="submit" name="submit" value="デフォルト表示の並び替え">

        <!--用語一覧-->
        <div>
            <form>
            <tr>
                <td>
                    <h2>　マニュアル <button type="button" class="gazo" onclick="document.getElementById('realIn_modal').showModal()"><span>＋</span></button><!-- 新規登録ボタン --></h2>


                    <!-- 新規登録モーダル -->
                        <dialog id="realIn_modal">
                            <form method="POST"  action="/c1/BooksRegistServlet">
                            	<input  type="hidden" name="id" readonly="readonly" style="background-color: lightgray" ><br>
                                <input type="text" name="title" placeholder="タイトル"><br>
                                <textarea name="maintaxt" placeholder="本文"></textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal').close()">キャンセル</button>
                                <input id="add1" type="submit" name="submit" value="登録" >
                            </form>
                        </div>
                        </dialog>
                <div class="container">
                    <div id="dropzone1" class="dropzone">
                        <div id="item1" class="draggable" draggable="true">
            <details class="accordion-005"><!--折り畳み機能-->
                <summary><!--折り畳み状態タイトル-->
                    <tr>
                        <td>
                            <c:out value="${cardList.title}" />
                        </td>
                        <td>
                            日付
                        </td>
                        <td>
                            登録者名
                        </td>
                    </tr>
                </summary>
                <p>本文1</p>
                    <tr>
                        <td>
                            最終更新日
                        </td>
                        <td>
                            最終更新者
                        </td>
                    </tr>
                        <button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal2').showModal()">編集</button><!-- 編集ボタン -->
	                    <input id="delete1" type="submit" name="delete" value="削除">

                    <!-- 編集モーダル -->
                        <dialog id="realIn_modal2">
                            <form onsubmit="return checkdelete()" method="POST" action="/c1/BooksUpdateDeleteServlet">
                                <input type="text" name="title" value="タイトル"><br>
                                <textarea name="maintaxt">本文</textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal2').close()">キャンセル</button>
                                <input id="update1" type="submit" name="submit" value="更新" >
                            </form>
                        </div>
                        </dialog>
            </details></div>

                        <div id="item2" class="draggable" draggable="true">
            <details class="accordion-005"><!--折り畳み機能-->
                <summary><!--折り畳み状態タイトル-->
                    <tr>
                        <td>
                            タイトル2
                        </td>
                        <td>
                            日付
                        </td>
                        <td>
                            登録者名
                        </td>
                    </tr>
                    </table> 
                </summary>
                <p>本文2</p>
                    <tr>
                        <td>
                            最終更新日
                        </td>
                        <td>
                            最終更新者
                        </td>
                    </tr>
                        <button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal3').showModal()">編集</button><!-- 編集ボタン -->
	                    <input id="delete2" type="submit" name="delete" value="削除">

                    <!-- 編集モーダル -->
                        <dialog id="realIn_modal3">
                            <form onsubmit="return checkdelete()" method="POST" action="/c1/BooksUpdateDeleteServlet">
                                <input type="text" name="title" value="タイトル"><br>
                                <textarea name="maintaxt">本文</textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal3').close()">キャンセル</button>
                                <input id="update2" type="submit" name="submit" value="更新" >
                            </form>
                        </div>
                        </dialog>
            </details>
        </div></div></div>

        <div>
            <h2>　用語 <button type="button" class="gazo" onclick="document.getElementById('realIn_modal').showModal()"><span>＋</span></button><!-- 新規登録ボタン --></h2>

                    <!-- 新規登録モーダル -->
                        <dialog id="realIn_modal4">
                            <form method="POST" action="/c1/BooksRegistServlet">
                            	<input  type="hidden" name="id" readonly="readonly" style="background-color: lightgray" ><br>
                                <input type="text" name="title" placeholder="タイトル"><br>
                                <textarea name="maintaxt" placeholder="本文"></textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal4').close()">キャンセル</button>
                                <input id="add2" type="submit" name="submit" value="登録" >
                            </form>
                        </div>
                        </dialog>
            <details class="accordion-005"><!--折り畳み機能-->
                <summary><!--折り畳み状態タイトル-->
                    <tr>
                        <td>
                            タイトル1
                        </td>
                        <td>
                            日付
                        </td>
                        <td>
                            登録者名
                        </td>
                    </tr>
                    </table> 
                </summary>
                <p>本文1</p>
                    <tr>
                        <td>
                            最終更新日
                        </td>
                        <td>
                            最終更新者
                        </td>
                    </tr>
                        <button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal5').showModal()">編集</button><!-- 編集ボタン -->
	                    <input id="delete3" type="submit" name="delete" value="削除">

                    <!-- 編集モーダル -->
                        <dialog id="realIn_modal5">
                            <form onsubmit="return checkdelete()" method="POST" action="/c1/BooksUpdateDeleteServlet">
                                <input type="text" name="title" value="タイトル"><br>
                                <textarea name="maintaxt">本文</textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal5').close()">キャンセル</button>
                                <input id="update3" type="submit" name="submit" value="更新" >
                            </form>
                        </div>
                        </dialog>
            </details>

            <details class="accordion-005"><!--折り畳み機能-->
                <summary><!--折り畳み状態タイトル-->
                    <tr>
                        <td>
                            タイトル2
                        </td>
                        <td>
                            日付
                        </td>
                        <td>
                            登録者名
                        </td>
                    </tr>
                    </table> 
                </summary>
                <p>本文2</p>
                    <tr>
                        <td>
                            最終更新日
                        </td>
                        <td>
                            最終更新者
                        </td>
                    </tr>
                        <button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal6').showModal()">編集</button><!-- 編集ボタン -->
	                    <input id="delete4" type="submit" name="delete" value="削除">

                    <!-- 編集モーダル -->
                        <dialog id="realIn_modal6">
                            <form onsubmit="return checkdelete()" method="POST" action="/c1/BooksUpdateDeleteServlet">
                                <input type="text" name="title" value="タイトル"><br>
                                <textarea name="maintaxt">本文</textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal6').close()">キャンセル</button>
                                <input id="update4" type="submit" name="submit" value="更新" >
                            </form>
                        </div>
                        </dialog>
            </details>
        </div>

        <div>
            <h2>　その他 
                <button type="button" class="gazo" onclick="document.getElementById('realIn_modal').showModal()"><span>＋</span>
                </button><!-- 新規登録ボタン --></h2>

                    <!-- 新規登録モーダル -->
                        <dialog id="realIn_modal7">
                            <form method="POST" action="/c1/BooksRegistServlet">
                            	<input  type="hidden" name="id" readonly="readonly" style="background-color: lightgray" ><br>
                                <input type="text" name="title" placeholder="タイトル"><br>
                                <textarea name="maintaxt" placeholder="本文"></textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal7').close()">キャンセル</button>
                                <input id="add3" type="submit" name="submit" value="登録" >
                            </form>
                        </div>
                        </dialog>
            <details class="accordion-005"><!--折り畳み機能-->
                <summary><!--折り畳み状態タイトル-->
                    <tr>
                        <td>
                            タイトル1
                        </td>
                        <td>
                            日付
                        </td>
                        <td>
                            登録者名
                        </td>
                    </tr>
                    </table> 
                </summary>
                <p>本文1</p>
                    <tr>
                        <td>
                            最終更新日
                        </td>
                        <td>
                            最終更新者
                        </td>
                    </tr>
                        <button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal8').showModal()">編集</button><!-- 編集ボタン -->
	                    <input id="delete5" type="submit" name="delete" value="削除">

                    <!-- 編集モーダル -->
                        <dialog id="realIn_modal8">
                            <form onsubmit="return checkdelete()" method="POST" action="/c1/BooksUpdateDeleteServlet">
                                <input type="text" name="title" value="タイトル"><br>
                                <textarea name="maintaxt">本文</textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal8').close()">キャンセル</button>
                                <input id="update5" type="submit" name="submit" value="更新" >
                            </form>
                        </div>
                        </dialog>
            </details>

            <details class="accordion-005"><!--折り畳み機能-->
                <summary><!--折り畳み状態タイトル-->
                    <tr>
                        <td>
                            タイトル2
                        </td>
                        <td>
                            日付
                        </td>
                        <td>
                            登録者名
                        </td>
                    </tr>
                    </table> 
                </summary>
                <p>本文2</p>
                    <tr>
                        <td>
                            最終更新日
                        </td>
                        <td>
                            最終更新者
                        </td>
                    </tr>
                        <button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal9').showModal()">編集</button><!-- 編集ボタン -->
	                    <input id="delete6" type="submit" name="delete" value="削除">

                    <!-- 編集モーダル -->
                        <dialog id="realIn_modal9">
                            <form onsubmit="return checkdelete()" method="POST" action="/c1/BooksUpdateDeleteServlet">
                                <input type="text" name="title" value="タイトル"><br>
                                <textarea name="maintaxt">本文</textarea><br>
                                    <div class="button">
                            <!-- close()でモーダルを閉じる -->
                                <button type="button" onclick="document.getElementById('realIn_modal9').close()">キャンセル</button>
                                <input id="update6" type="submit" name="submit" value="更新" >
                            </form>
                        </div>
                        </dialog>
            </details>
        </div>
        

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
<!--並び替え-->
const draggables = document.querySelectorAll(".draggable"); const dropzones = document.querySelectorAll(".dropzone"); draggables.forEach(item => { item.addEventListener("dragstart", (e) => { e.dataTransfer.setData("text/plain", e.target.id); item.classList.add("dragging"); }); item.addEventListener("dragend", () => { item.classList.remove("dragging"); }); }); dropzones.forEach(zone => { zone.addEventListener("dragover", (e) => { e.preventDefault(); }); zone.addEventListener("drop", (e) => { e.preventDefault(); const data = e.dataTransfer.getData("text/plain"); const draggedEl = document.getElementById(data); zone.appendChild(draggedEl); }); }); 

<!--登録ホップアップ-->
document.getElementById("add1").addEventListener("click", function() {
 confirm("登録してよろしいですか？");
});

document.getElementById("add2").addEventListener("click", function() {
 confirm("登録してよろしいですか？");
});

document.getElementById("add3").addEventListener("click", function() {
 confirm("登録してよろしいですか？");
});

<!--更新ホップアップ-->
document.getElementById("update1").addEventListener("click", function() {
 confirm("更新してよろしいですか？");
});

document.getElementById("update2").addEventListener("click", function() {
 confirm("更新してよろしいですか？");
});

document.getElementById("update3").addEventListener("click", function() {
 confirm("更新してよろしいですか？");
});

document.getElementById("update4").addEventListener("click", function() {
 confirm("更新してよろしいですか？");
});

document.getElementById("update5").addEventListener("click", function() {
 confirm("更新してよろしいですか？");
});

document.getElementById("update6").addEventListener("click", function() {
 confirm("更新してよろしいですか？");
});

<!--削除ホップアップ-->
document.getElementById("delete1").addEventListener("click", function() {
 confirm("削除してよろしいですか？");
});

document.getElementById("delete2").addEventListener("click", function() {
 confirm("削除してよろしいですか？");
});

document.getElementById("delete3").addEventListener("click", function() {
 confirm("削除してよろしいですか？");
});

document.getElementById("delete4").addEventListener("click", function() {
 confirm("削除してよろしいですか？");
});

document.getElementById("delete5").addEventListener("click", function() {
 confirm("削除してよろしいですか？");
});

document.getElementById("delete6").addEventListener("click", function() {
 confirm("削除してよろしいですか？");
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