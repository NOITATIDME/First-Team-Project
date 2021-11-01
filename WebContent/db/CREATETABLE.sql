-- CMD 이용해서 오라클 계정 만들기
-- 1) sqlplus /nolog
-- 2) conn sys/1234 as sysdba
-- 3) create user hair identified 1234;
-- 4) grant connect, resource to hair;
---------------------------------------------

-- 회원정보 테이블 생성 ( 테이블 명 : CLIENTINFO )
CREATE TABLE CLIENTINFO
(
    CID     VARCHAR2(10)    PRIMARY KEY, 

    CPWD    VARCHAR2(10)    NOT NULL,

    CBIRTH  NUMBER(8)       NOT NULL,

    CNAME   VARCHAR2(10)    NOT NULL,
 
    CEMAIL  VARCHAR2(20)    UNIQUE,

    CRESULT VARCHAR2(20)    NULL,

    RESDAY  VARCHAR2(20)	NULL           
);

COMMIT;

-- 게시판 테이블 생성 ( 테이블 명 : HBOARD )
CREATE TABLE HBOARD
(
    IDX	        NUMBER(5,0)         PRIMARY KEY,
    MENU_ID 	CHAR(6 BYTE)        NOT NULL,
    TITLE	    VARCHAR2(100 BYTE)  NOT NULL,
    CONT	    VARCHAR2(4000 BYTE),
    WRITER	    VARCHAR2(10)        NOT NULL,
    CONSTRAINT  FK_WRITER FOREIGN KEY(WRITER)
    REFERENCES  CLIENTINFO(CID),
    REGDATE	    DATE                DEFAULT SYSDATE,
    READCOUNT	NUMBER(5,0),
    BNUM	    NUMBER(5,0),
    LVL	        NUMBER(5,0),
    STEP	    NUMBER(5,0),
    NREF	    NUMBER(5,0),
    DELNUM	    NUMBER(1,0)
);

COMMIT;

-- 설문조사 생성 ( 테이블명 : SURVEY )
CREATE TABLE SURVEY
(
    QNUM        NUMBER(2,0)         NOT NULL,
    QCON        VARCHAR2(30)        NOT NULL,
    QANS        VARCHAR2(30)        NOT NULL
);

COMMIT;

INSERT INTO SURVEY VALUES ( '1', '계란형얼굴', 'Pushed Back Long');
INSERT INTO SURVEY VALUES ( '1', '계란형얼굴', 'Side Parted Short');
INSERT INTO SURVEY VALUES ( '1', '계란형얼굴', 'UnderCut');
INSERT INTO SURVEY VALUES ( '1', '계란형얼굴', 'Fringe Up');
INSERT INTO SURVEY VALUES ( '2', '사각형얼굴', 'Crew aka Buzz cut');
INSERT INTO SURVEY VALUES ( '2', '사각형얼굴', 'Undercut');
INSERT INTO SURVEY VALUES ( '2', '사각형얼굴', 'Faux Hawk');
INSERT INTO SURVEY VALUES ( '2', '사각형얼굴', 'Slicked Back Side Part');
INSERT INTO SURVEY VALUES ( '3', '직사각형얼굴', 'Side Parted');
INSERT INTO SURVEY VALUES ( '3', '직사각형얼굴', 'Buzz Cut');
INSERT INTO SURVEY VALUES ( '3', '직사각형얼굴', 'Fringe Up');
INSERT INTO SURVEY VALUES ( '3', '직사각형얼굴', 'Side Fringe');
INSERT INTO SURVEY VALUES ( '4', '삼각형얼굴', 'Fringe Up');
INSERT INTO SURVEY VALUES ( '4', '삼각형얼굴', 'Side Fringe');
INSERT INTO SURVEY VALUES ( '4', '삼각형얼굴', 'Side Parted');
INSERT INTO SURVEY VALUES ( '5', '둥근얼굴', 'Faux Hawk With Shorter Sides');
INSERT INTO SURVEY VALUES ( '5', '둥근얼굴', 'Fringe Up');
INSERT INTO SURVEY VALUES ( '5', '둥근얼굴', 'Undercut');
INSERT INTO SURVEY VALUES ( '5', '둥근얼굴', 'Quiff');
INSERT INTO SURVEY VALUES ( '6', '다이아몬드얼굴', 'Quiff');
INSERT INTO SURVEY VALUES ( '6', '다이아몬드얼굴', 'Long Hair Pushed Back');
INSERT INTO SURVEY VALUES ( '6', '다이아몬드얼굴', 'Faux Hawk');
INSERT INTO SURVEY VALUES ( '6', '다이아몬드얼굴', 'Side Fringe');
INSERT INTO SURVEY VALUES ( '7', '다이아몬드얼굴', 'Long Fringes');
INSERT INTO SURVEY VALUES ( '7', '다이아몬드얼굴', 'Side Parted Long');
INSERT INTO SURVEY VALUES ( '7', '다이아몬드얼굴', 'Pushed Back');
INSERT INTO SURVEY VALUES ( '7', '다이아몬드얼굴', 'Undercut');