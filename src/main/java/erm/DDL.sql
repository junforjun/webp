DROP TABLE IF EXISTS menu_master;

CREATE TABLE menu_master (
	user_id VARCHAR(255), 
	menu_id VARCHAR(3), 
	menu_name VARCHAR(50), 
	display_order VARCHAR(3)
);

ALTER TABLE menu_master ADD CONSTRAINT IDX_menu_master_PK PRIMARY KEY (user_id, menu_id);

COMMENT ON TABLE menu_master IS  'メニューマスタ';
COMMENT ON COLUMN menu_master.user_id IS 'ユーザID';
COMMENT ON COLUMN menu_master.menu_id IS 'メニューID';
COMMENT ON COLUMN menu_master.menu_name IS 'メニュー名';
COMMENT ON COLUMN menu_master.display_order IS '整列順番';



DROP TABLE IF EXISTS menu_detail;

CREATE TABLE menu_detail (
	user_id VARCHAR(255), 
	menu_id VARCHAR(3), 
	menu_detail VARCHAR(255)
);

ALTER TABLE menu_detail ADD CONSTRAINT IDX_menu_detail_PK PRIMARY KEY (user_id, menu_id);

COMMENT ON TABLE menu_detail IS  'メニュー詳細';
COMMENT ON COLUMN menu_detail.user_id IS 'ユーザID';
COMMENT ON COLUMN menu_detail.menu_id IS 'メニューID';
COMMENT ON COLUMN menu_detail.menu_detail IS 'メニュー詳細';



DROP TABLE IF EXISTS category_detail;

CREATE TABLE category_detail (
	user_id VARCHAR(255), 
	category_code VARCHAR(5), 
	catecory_name VARCHAR(255), 
	parents_category_code VARCHAR(10), 
	font_bold_flag VARCHAR(1), 
	font_color_code VARCHAR(7), 
	top_category_flag VARCHAR(1)
);

ALTER TABLE category_detail ADD CONSTRAINT IDX_category_detail_PK PRIMARY KEY (user_id, category_code);

COMMENT ON TABLE category_detail IS  'カテゴリ詳細';
COMMENT ON COLUMN category_detail.user_id IS 'ユーザID';
COMMENT ON COLUMN category_detail.category_code IS 'カテゴリコード';
COMMENT ON COLUMN category_detail.catecory_name IS 'カテゴリ名';
COMMENT ON COLUMN category_detail.parents_category_code IS '上位カテゴリコード';
COMMENT ON COLUMN category_detail.font_bold_flag IS '太文字';
COMMENT ON COLUMN category_detail.font_color_code IS '文字色';
COMMENT ON COLUMN category_detail.top_category_flag IS 'トップカテゴリコード';



DROP TABLE IF EXISTS post_detail;

CREATE TABLE post_detail (
	user_id VARCHAR(255), 
	category_code VARCHAR(5), 
	post_no INTEGER, 
	post_title VARCHAR(500), 
	post_sub_title VARCHAR(500), 
	display_order VARCHAR(3), 
	map_info_flag VARCHAR(1), 
	file_info_flag VARCHAR(1), 
	contents VARCHAR, 
	created_user VARCHAR(255), 
	created_time TIMESTAMP, 
	edited_user VARCHAR(255), 
	edited_time TIMESTAMP
);

ALTER TABLE post_detail ADD CONSTRAINT IDX_post_detail_PK PRIMARY KEY (user_id, category_code, post_no, created_user, created_time, edited_user, edited_time);

COMMENT ON TABLE post_detail IS  'ポスト管理';
COMMENT ON COLUMN post_detail.user_id IS 'ユーザID';
COMMENT ON COLUMN post_detail.category_code IS 'カテゴリコード';
COMMENT ON COLUMN post_detail.post_no IS 'ポスト番号';
COMMENT ON COLUMN post_detail.post_title IS 'ポストタイトル';
COMMENT ON COLUMN post_detail.post_sub_title IS 'ポストサブタイトル';
COMMENT ON COLUMN post_detail.display_order IS '整列順番';
COMMENT ON COLUMN post_detail.map_info_flag IS 'Googleマップ情報ありフラグ';
COMMENT ON COLUMN post_detail.file_info_flag IS 'ファイル情報ありフラグ';
COMMENT ON COLUMN post_detail.contents IS 'コンテンツ';
COMMENT ON COLUMN post_detail.created_user IS '生成ユーザID';
COMMENT ON COLUMN post_detail.created_time IS '生成時間';
COMMENT ON COLUMN post_detail.edited_user IS '修正ユーザID';
COMMENT ON COLUMN post_detail.edited_time IS '修正時間';



DROP TABLE IF EXISTS attched_file;

CREATE TABLE attched_file (
	user_id VARCHAR(255), 
	category_code VARCHAR(10), 
	post_no VARCHAR(10), 
	reply_code VARCHAR(10), 
	file_order VARCHAR(2), 
	file_location VARCHAR
);

ALTER TABLE attched_file ADD CONSTRAINT IDX_attched_file_PK PRIMARY KEY (user_id, category_code, post_no, reply_code, file_order);

COMMENT ON TABLE attched_file IS  '添付ファイル管理';
COMMENT ON COLUMN attched_file.user_id IS 'ユーザID';
COMMENT ON COLUMN attched_file.category_code IS 'カテゴリコード';
COMMENT ON COLUMN attched_file.post_no IS 'ポスト番号';
COMMENT ON COLUMN attched_file.reply_code IS 'Replyコード';
COMMENT ON COLUMN attched_file.file_order IS 'ファイル順番';
COMMENT ON COLUMN attched_file.file_location IS '実サーバファイル位置';



DROP TABLE IF EXISTS imoji_post;

CREATE TABLE imoji_post (
	user_id VARCHAR(255), 
	post_no VARCHAR(10), 
	reply_code VARCHAR(10), 
	imoji_code VARCHAR(10), 
	imoji_count INTEGER, 
	imoji_order INTEGER
);

ALTER TABLE imoji_post ADD CONSTRAINT IDX_imoji_post_PK PRIMARY KEY (user_id, post_no, reply_code, imoji_code, imoji_order);

COMMENT ON TABLE imoji_post IS  'Imojiポスト';
COMMENT ON COLUMN imoji_post.user_id IS 'ユーザID';
COMMENT ON COLUMN imoji_post.post_no IS 'ポスト番号';
COMMENT ON COLUMN imoji_post.reply_code IS 'Replyコード';
COMMENT ON COLUMN imoji_post.imoji_code IS 'Imojiコード';
COMMENT ON COLUMN imoji_post.imoji_count IS 'Imojiカウント';
COMMENT ON COLUMN imoji_post.imoji_order IS 'Imoji順番';



DROP TABLE IF EXISTS imoji_master;

CREATE TABLE imoji_master (
	imoji_code VARCHAR(10), 
	imoji_desc VARCHAR, 
	hidden_flag VARCHAR(1)
);

ALTER TABLE imoji_master ADD CONSTRAINT IDX_imoji_master_PK PRIMARY KEY (imoji_code);

COMMENT ON TABLE imoji_master IS  'Imojiマスタ';
COMMENT ON COLUMN imoji_master.imoji_code IS 'imojiコード';
COMMENT ON COLUMN imoji_master.imoji_desc IS 'Imoji説明';
COMMENT ON COLUMN imoji_master.hidden_flag IS '非活性フラグ';



DROP TABLE IF EXISTS reply;

CREATE TABLE reply (
	user_id VARCHAR(255), 
	category_code VARCHAR(5), 
	post_no VARCHAR(10), 
	reply_code VARCHAR(10), 
	parents_reply_code VARCHAR(10), 
	contents VARCHAR(1000), 
	file_info_flag VARCHAR(1), 
	created_user VARCHAR(255), 
	created_time TIMESTAMP, 
	edited_user VARCHAR(255), 
	edited_time TIMESTAMP, 
	hidden_flag VARCHAR(1)
);

ALTER TABLE reply ADD CONSTRAINT IDX_reply_PK PRIMARY KEY (user_id, category_code, post_no, reply_code);

COMMENT ON TABLE reply IS  'reply管理';
COMMENT ON COLUMN reply.user_id IS 'ユーザID';
COMMENT ON COLUMN reply.category_code IS 'カテゴリコード';
COMMENT ON COLUMN reply.post_no IS 'ポスト番号';
COMMENT ON COLUMN reply.reply_code IS 'Replyコード';
COMMENT ON COLUMN reply.parents_reply_code IS '上位Replyコード';
COMMENT ON COLUMN reply.contents IS 'Reply内容';
COMMENT ON COLUMN reply.file_info_flag IS 'ファイルありフラグ';
COMMENT ON COLUMN reply.created_user IS '生成ユーザID';
COMMENT ON COLUMN reply.created_time IS '生成時間';
COMMENT ON COLUMN reply.edited_user IS '修正ユーザID';
COMMENT ON COLUMN reply.edited_time IS '修正時間';
COMMENT ON COLUMN reply.hidden_flag IS '非活性フラグ';



DROP TABLE IF EXISTS user_info;

CREATE TABLE user_info (
	user_id VARCHAR(255), 
	user_pass VARCHAR(255), 
	sex VARCHAR(1), 
	first_name VARCHAR(100), 
	last_name VARCHAR(100), 
	is_verificationed VARCHAR(1), 
	post_code VARCHAR(10), 
	address1 VARCHAR(255), 
	address2 VARCHAR(255), 
	avatar_file_loc VARCHAR(255), 
	self_introduce_text VARCHAR(1000), 
	hidden_flag VARCHAR(1), 
	created_user VARCHAR(255), 
	created_time TIMESTAMP, 
	edited_user VARCHAR(255), 
	edited_time TIMESTAMP
);

ALTER TABLE user_info ADD CONSTRAINT IDX_user_info_PK PRIMARY KEY (user_id);

COMMENT ON TABLE user_info IS  'ユーザ情報';
COMMENT ON COLUMN user_info.user_id IS 'ユーザID';
COMMENT ON COLUMN user_info.user_pass IS 'ユーザパスワード';
COMMENT ON COLUMN user_info.sex IS '性別';
COMMENT ON COLUMN user_info.first_name IS '性';
COMMENT ON COLUMN user_info.last_name IS '名';
COMMENT ON COLUMN user_info.is_verificationed IS '認証済みフラグ';
COMMENT ON COLUMN user_info.post_code IS '郵便番号';
COMMENT ON COLUMN user_info.address1 IS '住所１';
COMMENT ON COLUMN user_info.address2 IS '住所２';
COMMENT ON COLUMN user_info.avatar_file_loc IS 'プロファイル画像';
COMMENT ON COLUMN user_info.self_introduce_text IS 'プロファイル文言';
COMMENT ON COLUMN user_info.hidden_flag IS '非活性フラグ';
COMMENT ON COLUMN user_info.created_user IS '生成ユーザID';
COMMENT ON COLUMN user_info.created_time IS '生成時間';
COMMENT ON COLUMN user_info.edited_user IS '修正ユーザID';
COMMENT ON COLUMN user_info.edited_time IS '修正時間';



DROP TABLE IF EXISTS user_detail;

CREATE TABLE user_detail (
	user_id VARCHAR(255), 
	user_nick VARCHAR(255), 
	url_id VARCHAR(255), 
	blog_title VARCHAR(50), 
	blog_sub_title VARCHAR(255), 
	avatar_file_loc VARCHAR(255), 
	info_open_level VARCHAR(1), 
	self_introduce_text VARCHAR(1000), 
	hidden_flag VARCHAR(1), 
	created_user VARCHAR(255), 
	created_time TIMESTAMP, 
	edited_user VARCHAR(255), 
	edited_time TIMESTAMP
);

ALTER TABLE user_detail ADD CONSTRAINT IDX_user_detail_PK PRIMARY KEY (user_id);

COMMENT ON TABLE user_detail IS  'ユーザ詳細';
COMMENT ON COLUMN user_detail.user_id IS 'ユーザID';
COMMENT ON COLUMN user_detail.user_nick IS 'ユーザニックネーム';
COMMENT ON COLUMN user_detail.url_id IS 'ユーザブログURL';
COMMENT ON COLUMN user_detail.blog_title IS 'ブログタイトル';
COMMENT ON COLUMN user_detail.blog_sub_title IS 'ブログサブタイトル';
COMMENT ON COLUMN user_detail.avatar_file_loc IS 'プロファイル画像';
COMMENT ON COLUMN user_detail.info_open_level IS '情報公開レベル';
COMMENT ON COLUMN user_detail.self_introduce_text IS 'プロファイル文言';
COMMENT ON COLUMN user_detail.hidden_flag IS '非活性フラグ';
COMMENT ON COLUMN user_detail.created_user IS '生成ユーザID';
COMMENT ON COLUMN user_detail.created_time IS '生成時間';
COMMENT ON COLUMN user_detail.edited_user IS '修正ユーザID';
COMMENT ON COLUMN user_detail.edited_time IS '修正時間';



DROP TABLE IF EXISTS user_authentication;

CREATE TABLE user_authentication (
	user_id VARCHAR(255), 
	user_level VARCHAR(2), 
	created_user VARCHAR(255), 
	created_time TIMESTAMP, 
	edited_user VARCHAR(255), 
	edited_time TIMESTAMP
);

ALTER TABLE user_authentication ADD CONSTRAINT IDX_user_authentication_PK PRIMARY KEY (user_id, user_level);

COMMENT ON TABLE user_authentication IS  'ユーザ権限';
COMMENT ON COLUMN user_authentication.user_id IS 'ユーザID';
COMMENT ON COLUMN user_authentication.user_level IS 'ユーザレベル';
COMMENT ON COLUMN user_authentication.created_user IS '生成ユーザID';
COMMENT ON COLUMN user_authentication.created_time IS '生成時間';
COMMENT ON COLUMN user_authentication.edited_user IS '修正ユーザID';
COMMENT ON COLUMN user_authentication.edited_time IS '修正時間';



DROP TABLE IF EXISTS user_hobby;

CREATE TABLE user_hobby (
	user_id VARCHAR(255), 
	hobby_code VARCHAR(2)
);

ALTER TABLE user_hobby ADD CONSTRAINT IDX_user_hobby_PK PRIMARY KEY (user_id, hobby_code);

COMMENT ON TABLE user_hobby IS  'ユーザ趣味';
COMMENT ON COLUMN user_hobby.user_id IS 'ユーザID';
COMMENT ON COLUMN user_hobby.hobby_code IS '趣味コード';



DROP TABLE IF EXISTS user_interest;

CREATE TABLE user_interest (
	user_id VARCHAR(255), 
	interest_code VARCHAR(2)
);

ALTER TABLE user_interest ADD CONSTRAINT IDX_user_interest_PK PRIMARY KEY (user_id, interest_code);

COMMENT ON TABLE user_interest IS  'ユーザ興味';
COMMENT ON COLUMN user_interest.user_id IS 'ユーザID';
COMMENT ON COLUMN user_interest.interest_code IS '興味コード';



DROP TABLE IF EXISTS visitor_info;

CREATE TABLE visitor_info (
	user_id VARCHAR(255), 
	visitor_user_id VARCHAR(255), 
	visit_time TIMESTAMP
);

ALTER TABLE visitor_info ADD CONSTRAINT IDX_visitor_info_PK PRIMARY KEY (user_id, visit_time);

COMMENT ON TABLE visitor_info IS  '訪問者情報';
COMMENT ON COLUMN visitor_info.user_id IS 'ユーザID';
COMMENT ON COLUMN visitor_info.visitor_user_id IS '訪問ユーザID';
COMMENT ON COLUMN visitor_info.visit_time IS '訪問時間';



DROP TABLE IF EXISTS user_login;

CREATE TABLE user_login (
	user_id VARCHAR(255), 
	login_time TIMESTAMP, 
	login_count INTEGER, 
	login_ip TIMESTAMP
);

ALTER TABLE user_login ADD CONSTRAINT IDX_user_login_PK PRIMARY KEY (user_id, login_time);

COMMENT ON TABLE user_login IS  'ログイン管理テーブル';
COMMENT ON COLUMN user_login.user_id IS 'ユーザID';
COMMENT ON COLUMN user_login.login_time IS 'ログイン時間';
COMMENT ON COLUMN user_login.login_count IS 'ログインカウント';
COMMENT ON COLUMN user_login.login_ip IS 'ログインIP';



