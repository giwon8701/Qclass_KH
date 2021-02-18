
DROP SEQUENCE MDBOARDSEQ;
DROP TABLE MDBOARD;

CREATE SEQUENCE MDBOARDSEQ;

CREATE TABLE MDBOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(100) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO MDBOARD
VALUES(MDBOARDSEQ.NEXTVAL, '������', '��Ƽ����Ʈ �׽�Ʈ', '��ձ׳�.', SYSDATE);

INSERT INTO MDBOARD
VALUES(MDBOARDSEQ.NEXTVAL, '�������� 1��', 'õõ�� ���ּ���', 'õõ�� �ҰԿ�.', SYSDATE);

SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE
FROM MDBOARD
ORDER BY SEQ DESC;