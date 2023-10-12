-- 실행 단축키 실행할 명령문 블럭 지정 후 alt + x, alt + c
-- test_member.sql
show databases;

-- develop_sql schema에 등록된 테이블 목록
show tables;

-- sample table 생성
CREATE TABLE IF NOT EXISTS member(
	num INT PRIMARY KEY auto_increment,
	name VARCHAR(50) NOT NULL,
	addr VARCHAR(200) NOT NULL
);
DESC member;
