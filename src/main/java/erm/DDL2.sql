DROP TABLE IF EXISTS post_detail;

CREATE TABLE post_detail (
	user_id VARCHAR(255), 
	category_code VARCHAR(10), 
	post_no INTEGER, 
	post_title VARCHAR(500), 
	post_sub_title VARCHAR(500), 
	contests VARCHAR(10000), 
	display_order VARCHAR(3), 
	map_info_flag VARCHAR(1), 
	file_info_flag VARCHAR(1), 
	created_user VARCHAR(255), 
	created_time TIMESTAMP, 
	edited_user VARCHAR(255), 
	edited_time TIMESTAMP
);

ALTER TABLE post_detail ADD CONSTRAINT IDX_post_detail_PK PRIMARY KEY (user_id, category_code, post_no);

COMMENT ON TABLE post_detail IS  'ポスト管理';
COMMENT ON COLUMN post_detail.user_id IS 'ユーザID';
COMMENT ON COLUMN post_detail.category_code IS 'カテゴリコード';
COMMENT ON COLUMN post_detail.post_no IS 'ポスト番号';
COMMENT ON COLUMN post_detail.post_title IS 'ポストタイトル';
COMMENT ON COLUMN post_detail.post_sub_title IS 'ポストサブタイトル';
COMMENT ON COLUMN post_detail.contests IS 'contents';
COMMENT ON COLUMN post_detail.display_order IS '整列順番';
COMMENT ON COLUMN post_detail.map_info_flag IS 'Googleマップ情報ありフラグ';
COMMENT ON COLUMN post_detail.file_info_flag IS 'ファイル情報ありフラグ';
COMMENT ON COLUMN post_detail.created_user IS '生成ユーザID';
COMMENT ON COLUMN post_detail.created_time IS '生成時間';
COMMENT ON COLUMN post_detail.edited_user IS '修正ユーザID';
COMMENT ON COLUMN post_detail.edited_time IS '修正時間';



