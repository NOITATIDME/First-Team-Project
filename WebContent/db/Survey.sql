CREATE TABLE SURVEY(
  QNUM  NUMBER(2,0)   PRIMARY KEY NOT NULL,
QCON  VARCHAR2(20)  NOT NULL,
QANS  VARCHAR2(10)  NOT NULL
);

COMMIT;

insert into SURVEY(QNUM, QCON, QANS) values ( 1, '계란형얼굴', 'Pushed Back Long');
insert into SURVEY(QNUM, QCON, QANS) values ( 1, '계란형얼굴', 'Side Parted Short');
insert into SURVEY(QNUM, QCON, QANS) values ( 1, '계란형얼굴', 'UnderCut');
insert into SURVEY(QNUM, QCON, QANS) values ( 1, '계란형얼굴', 'Fringe Up');

insert into SURVEY(QNUM, QCON, QANS) values ( 2, '사각형얼굴', 'Crew aka Buzz cut');
insert into SURVEY(QNUM, QCON, QANS) values ( 2, '사각형얼굴', 'UnderCut');
insert into SURVEY(QNUM, QCON, QANS) values ( 2, '사각형얼굴', 'Faux Hawk');
insert into SURVEY(QNUM, QCON, QANS) values ( 2, '사각형얼굴', 'Slicked Back Side Part');

insert into SURVEY(QNUM, QCON, QANS) values ( 3, '직사각형얼굴', 'Side Parted');
insert into SURVEY(QNUM, QCON, QANS) values ( 3, '직사각형얼굴', 'Buzz Cut');
insert into SURVEY(QNUM, QCON, QANS) values ( 3, '직사각형얼굴', 'Fringe Up');
insert into SURVEY(QNUM, QCON, QANS) values ( 3, '직사각형얼굴', 'Side Fringe');

insert into SURVEY(QNUM, QCON, QANS) values ( 4, '삼각형얼굴', 'Fringe Up');
insert into SURVEY(QNUM, QCON, QANS) values ( 4, '삼각형얼굴', 'Side Fringe');
insert into SURVEY(QNUM, QCON, QANS) values ( 4, '삼각형얼굴', 'Side Parted');

insert into SURVEY(QNUM, QCON, QANS) values ( 5, '둥근얼굴', 'Faux Hawk With Shorter Sides');
insert into SURVEY(QNUM, QCON, QANS) values ( 5, '둥근얼굴', 'Fringe Up');
insert into SURVEY(QNUM, QCON, QANS) values ( 5, '둥근얼굴', 'Undercut');
insert into SURVEY(QNUM, QCON, QANS) values ( 5, '둥근얼굴', 'Quiff');

insert into SURVEY(QNUM, QCON, QANS) values ( 6, '다이아몬드얼굴', 'Quiff');
insert into SURVEY(QNUM, QCON, QANS) values ( 6, '다이아몬드얼굴', 'Long Hair Pushed Back');
insert into SURVEY(QNUM, QCON, QANS) values ( 6, '다이아몬드얼굴', 'Faux Hawk');
insert into SURVEY(QNUM, QCON, QANS) values ( 6, '다이아몬드얼굴', 'Side Fringe');
insert into SURVEY(QNUM, QCON, QANS) values ( 7, '다이아몬드얼굴', 'Long Fringes');
insert into SURVEY(QNUM, QCON, QANS) values ( 7, '다이아몬드얼굴', 'Side Parted Long');
insert into SURVEY(QNUM, QCON, QANS) values ( 7, '다이아몬드얼굴', 'Pushed Back');
insert into SURVEY(QNUM, QCON, QANS) values ( 7, '다이아몬드얼굴', 'Undercut');

COMMIT;