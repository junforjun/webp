DROP TABLE IF EXISTS verification_email;

CREATE TABLE verification_email (
	verfiy_str VARCHAR(255), 
	verfiy_time TIMESTAMP, 
	email VARCHAR(255), 
	pass VARCHAR(255), 
	is_verificationed VARCHAR(1)
);



COMMENT ON TABLE verification_email IS  'ユーザ認証';
COMMENT ON COLUMN verification_email.verfiy_str IS '認証文字列';
COMMENT ON COLUMN verification_email.verfiy_time IS '認証時間';
COMMENT ON COLUMN verification_email.email IS 'E-Mail';
COMMENT ON COLUMN verification_email.pass IS 'Password';
COMMENT ON COLUMN verification_email.is_verificationed IS '認証確認';



