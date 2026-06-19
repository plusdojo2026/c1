<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <li><a href="/c1/ShiftServlet">シフト・出退勤管理</a></li>
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
        <details class="accordion-008"><!--折り畳み機能-->
            <summary>絞り込み検索/並び替え</summary><!--折り畳み状態タイトル-->
<form method="POST" action="/c1/BooksServlet"  id="searchform">
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
                     <input type="text" name="company"  placeholder="会社">
                </td>
                <td>
                     <input type="text" name="address"  placeholder="住所">
                </td>
            </tr>
            <tr>
                <td>
                     <input type="text" name="remarks"  placeholder="備考"></p>
                </td>
            <tr>
                <td>
                 <input type="submit" id="search" name="submit" value="実行">
                </td>
            </tr>
        </table>
</form>
        </details>
        
        <div>
          <h2>　用語 <button type="button" class="gazo" onclick="document.getElementById('realIn_modal').showModal()"><span>＋</span></button><!-- 新規登録ボタン --></h2>
                    
                    <!-- 新規登録モーダル -->
                            <dialog id="realIn_modal">
                    <form onsubmit="return checkregist()" method="POST" action="/c1/BooksRegistServlet" id="registform">
<table>
<tr>
<td>
<input  type="hidden" name="id" readonly="readonly" style="background-color: lightgray" ><br>
</td>
</tr>
<tr>
<td>
                     <input  type="text" name="company" placeholder="会社" >
</td>
</tr>
<tr>
<td>
                     <textarea name="remarks" placeholder="備考"></textarea>
</td>
</tr>
<tr>
<td>
                     <div class="button">
                     <!-- close()でモーダルを閉じる -->
						<button type="button" onclick="document.getElementById('realIn_modal').close()">キャンセル</button>
                 		<input  type="submit"name="submit" value="登録">
</td>
</tr>
                 		</table>
                 		</form>
                 		</dialog></div>

<c:forEach var="e" items="${cardList}">
<form>
                <div class="container">
                    <div id="dropzone1" class="dropzone">
                        <div id="item1" class="draggable" draggable="true">
<form>
            <details class="accordion-005"><!--折り畳み機能-->
                <summary><!--折り畳み状態タイトル-->
	<form>
	<form>
<tr>
  <td>
	${e.title} 
</td>
<td>
	/ 登録日：${e.date} 
</td>
<td>
	/ 登録者：${e.teacher}
</td>
</tr>
	</form>
</summary>
	<form onsubmit="return checkdelete()" id="resultform" class="search_result" method="POST" action="/c1/BooksUpdateDeleteServlet">
<tr>
<td>
${e.manual}<br><br>
                        <input type="hidden" name="id" value="${e.id}">
                        <input type="hidden" name="user_id" value="${e.user_id}">
                        <input type="hidden" name="date" value="${e.date}">
						<input type="hidden" name="category_id" value="${e.category_id}">
						<input type="hidden" name="title" value="${e.title}">
						<input type="hidden" name="teacher" value="${e.teacher}">
						<input type="hidden" name="manual" value="${e.manual}">
						<input type="hidden" name="update_name" value="${e.update_name}">
						<input type="hidden" name="update_date" value="${e.update_Date}">
</td>
</tr>
<tr>
<td>
	最終更新日：${e.update_date}<br>
</td>
</tr>
<tr>
<td>
	最終更新者：${e.update_name}<br>
</td>
</tr>
<tr>
<td>
	<button type="button" class="buttonIn" onclick="document.getElementById('realIn_modal2${e.id}').showModal()">編集</button><!-- 編集ボタン -->
	<input class="delete1" type="submit" name="submit" value="削除">
</td>
</tr>
</form>

                    <!-- 編集モーダル -->
                        <dialog id="realIn_modal2${e.id}">
                        <form  onsubmit="return checkupdate()" id="resultform" class="search_result" method="POST" action="/c1/BooksUpdateDeleteServlet">
                        <input type="text" name="title" value="${e.title}"><br>
                        
						<input type="hidden" name="id" value="${e.id}">
                        <input type="hidden" name="user_id" value="${e.user_id}">
                        <input type="hidden" name="date" value="${e.date}">
						<input type="hidden" name="category_id" value="${e.category_id}">
						<input type="hidden" name="teacher" value="${e.teacher}">
						<input type="hidden" name="update_name" value="${e.update_name}">
						<input type="hidden" name="update_date" value="${e.update_Date}">
						
                        <textarea name="manual">${e.manual}</textarea><br>
                        <div class="button">
                        <!-- close()でモーダルを閉じる -->
                        <button type="button" onclick="document.getElementById('realIn_modal2${e.id}').close()">キャンセル</button>
                        <input class="update1" type="submit" name="submit" value="更新" >
                        </div>
                        </form>
                               </dialog>
</details></div></div></div></form></c:forEach>

<c:if test="${empty cardList}">
<p>指定された条件に一致するデータはありません。</p>
</c:if>
</main>
    <!--メインここまで-->
    <!--フッター-->
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

/* 登録確認 */
function checkregist(){
    let ans = window.confirm('登録してよろしいですか？');
    if (ans === false) {
        event.preventDefault();
    }
};

/* 更新確認 */
function checkupdate(){
    let ans = window.confirm('更新してよろしいですか？');
    if (ans === false) {
        event.preventDefault();
    }
};

/* 削除確認 */
function checkdelete(){
    let ans = window.confirm('削除してよろしいですか？');
    if (ans === false) {
        event.preventDefault();
    }
};

</script>
</body>
</html>
