
DROP SEQUENCE MYMEMBERSEQ;
DROP TABLE MYMEMBER;

CREATE SEQUENCE MYMEMBERSEQ;

CREATE TABLE MYMEMBER(
	MYNO NUMBER NOT NULL,
	MYID VARCHAR2(500) NOT NULL,
	MYPW VARCHAR2(500) NOT NULL,
	MYNAME VARCHAR2(500) NOT NULL,
	MYADDR VARCHAR2(2000) NOT NULL,
	MYPHONE VARCHAR2(18) NOT NULL,
	MYEMAIL VARCHAR2(100) NOT NULL,
	MYENABLED VARCHAR2(2) NOT NULL,
	MYROLE VARCHAR2(100) NOT NULL,
	CONSTRAINT MYMEMBER_MYNO_PK PRIMARY KEY (MYNO),
	CONSTRAINT MYMEMBER_MYID_UQ UNIQUE (MYID),
	CONSTRAINT MYMEMBER_MYPHONE_UQ UNIQUE (MYPHONE),
	CONSTRAINT MYMEMBER_MYEMAIL_UQ UNIQUE (MYEMAIL),
	CONSTRAINT MYMEMBER_MYENABLED_CHK CHECK(MYENABLED IN ('Y', 'N'))
);

INSERT INTO MYMEMBER
VALUES(MYMEMBERSEQ.NEXTVAL, 'admin', 'admin1234', '이동헌', '경기도 수원시', '010-0000-0000', 'admin@admin.com', 'Y', 'ADMIN');

SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE
FROM MYMEMBER
ORDER BY MYNO DESC;