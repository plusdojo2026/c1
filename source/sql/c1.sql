/* 権利者テーブル */
CREATE TABLE authority (
authority_id INTEGER AUTO_INCREMENT PRIMARY KEY,
authority VARCHAR(200)
);

INSERT INTO authority VALUES (
NULL,
'管理者'
);

INSERT INTO authority VALUES (
NULL,
'従業員'
);


/* ユーザーテーブル */
CREATE TABLE user (
user_id VARCHAR(100) PRIMARY KEY,
user_name VARCHAR(100) NOT NULL,
password VARCHAR(32) NOT NULL,
authority_id INT NOT NULL,
FOREIGN KEY (authority_id) REFERENCES authority(authority_id)
);

INSERT INTO user VALUES (
'yamada-yuki-m',
'山田祐樹',
'001',
'1'
);

INSERT INTO user VALUES (
'saito-yuri-e',
'斎藤由利',
'123',
'2'
);

INSERT INTO user VALUES (
'takahashi-sho-e',
'高橋翔',
'321',
'2'
);


/* シフトテーブル */
CREATE TABLE shift (
id INTEGER AUTO_INCREMENT PRIMARY KEY,
user_id VARCHAR(100) NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(user_id),
date DATE NOT NULL,
clock_in TIME,
clock_out TIME,
real_in TIME,
real_out TIME
);

INSERT INTO shift VALUES (
NULL,
'saito-yuri-e',
'2026-06-01',
'17:00',
'22:00',
NULL,
NULL
);

INSERT INTO shift VALUES (
NULL,
'saito-yuri-e',
'2026-06-02',
'17:00',
'22:00',
'17:00',
'22:00'
);


/* ご意見箱のテーブル */
CREATE TABLE suggestion (
id INTEGER AUTO_INCREMENT PRIMARY KEY,
user_id VARCHAR(100) NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(user_id),
suggestion_date DATE NOT NULL,
suggestion VARCHAR(400) NOT NULL
);

INSERT INTO suggestion VALUES (
NULL,
'saito-yuri-e',
'2025-07-01',
'カウンターのメニュー表を新しくした方が良いと思います。'
);

INSERT INTO suggestion VALUES (
NULL,
'takahashi-sho-e',
'2025-07-02',
'斎藤さんが最近苦手で困ってます...'
);


/* 用語本棚-カテゴリーのテーブル */
CREATE TABLE books_category (
category_id INTEGER AUTO_INCREMENT PRIMARY KEY,
category VARCHAR(100) NOT NULL
);

INSERT INTO books_category VALUES (
NULL,
'用語'
);

INSERT INTO books_category VALUES (
NULL,
'マナー'
);

INSERT INTO books_category VALUES (
NULL,
'その他'
);


/* 用語本棚のテーブル */
CREATE TABLE books (
id INTEGER AUTO_INCREMENT PRIMARY KEY,
user_id VARCHAR(100),
FOREIGN KEY (user_id) REFERENCES user(user_id),
date VARCHAR(30),
category_id VARCHAR(100),
title VARCHAR(50),
teacher VARCHAR(20),
manual_x VARCHAR(600),
update_name VARCHAR(100),
update_date VARCHAR(30)
);


INSERT INTO books VALUES (
NULL,
'takahashi-sho-e',
'2025-07-01',
'1',
'テーブルの番号',
'店長',
'奥から１，２，３，４',
"",
""
);

INSERT INTO books VALUES (
NULL,
'saito-yuri-e',
'2025-08-01',
'2',
'挨拶について',
'斎藤由利',
'何時に入ってきてもおはようございます。で統一　【追記】お疲れさまも忘れずに！',
'山田祐樹',
'2025-08-02'
);


/* お知らせのテーブル */
CREATE TABLE notice (
id INTEGER AUTO_INCREMENT PRIMARY KEY,
user_id VARCHAR(100) NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(user_id),
user_name VARCHAR(20),
date DATE NOT NULL,
title VARCHAR(50) NOT NULL,
notice VARCHAR(600) NOT NULL,
update_name VARCHAR(100),
update_date DATE
);

INSERT INTO notice VALUES (
NULL,
'saito-yuri-e',
'斎藤由利',
'2025-08-01',
'新メニューについて',
'新しいメニューが増えたので、各自マニュアルの確認をお願いします',
NULL,
NULL
);

INSERT INTO notice VALUES (
NULL,
'saito-yuri-e',
'斎藤由利',
'2025-08-01',
'ごみの捨て方について',
'燃えるゴミは緑、プラごみは黄色の袋でお願いします。【追記】紙ごみは紫で！',
'高橋翔',
'2025-08-02'
);