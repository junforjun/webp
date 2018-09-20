DROP TABLE IF EXISTS verification_email;

CREATE TABLE verification_email (
	verfi_str VARCHAR(255), 
	verfi_time TIMESTAMP, 
	email VARCHAR
);



COMMENT ON TABLE verification_email IS  'ユーザ認証';
COMMENT ON COLUMN verification_email.verfi_str IS '認証文字列';
COMMENT ON COLUMN verification_email.verfi_time IS '認証時間';
COMMENT ON COLUMN verification_email.email IS 'E-Mail';



