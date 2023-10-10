drop table tbl_member;


CREATE TABLE tbl_member(
	mNum INT PRIMARY KEY auto_increment,
	mName VARCHAR(50),
	mId VARCHAR(20) NOT NULL UNIQUE,
	mPw VARCHAR(30) NOT NULL,
	reg BIGINT DEFAULT 0
);

desc tbl_member;

INSERT INTO tbl_member(mName,mId,mPw)
VALUES('관리자','root','root');

SELECT * FROM tbl_member;
SELECT * FROM back_up_member;

commit;

-- 탈퇴한 회원의 정보를 임시 저장할 back_up_table 생성
-- tbl_member table의 구조만 동일한 테이블 생성

CREATE TABLE back_up_member LIKE tbl_member;

desc back_up_member;

-- 회원탈퇴 정보가 back_up 된 시간을 저장한 column 추가

alter table back_up_member add column deleteDate timestamp default now();



