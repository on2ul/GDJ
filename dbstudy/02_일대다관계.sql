-- ctrl+/ 누르면 주석 단축키



-- 일대다 관계의 테이블 생성
-- 1.명칭:
    --1)부모테이블:일(1),PK를 가진 테이블
    --2)자식테이블:다(M),FK를 가진 테이블
-- 2.생성:부모 테이블을 먼저 생성하고, 자식테이블을 나중에 생성한다
-- 3.삭제:자식 테이블을 먼저 삭제하고, 부모테이블을 나중에 삭제한다



-- 학교 테이블 생성
-- 부모테이블:PK를 가진 테이블
-- 1번째 방법

DROP TABLE SCHOOL; -- 1.원래 있던거 지우고 
CREATE TABLE SCHOOL( --2.새로 만든다
    SCH_CODE NUMBER(1) NOT NULL PRIMARY KEY,
    SCH_NAME VARCHAR2(20 BYTE) NOT NULL
);


-- 2번째 방법
DROP TABLE SCHOOL;
CREATE TABLE SCHOOL( 
    SCH_CODE NUMBER(1) NOT NULL,
    SCH_NAME VARCHAR2(20 BYTE) NOT NULL,
    PRIMARY KEY(SCH_CODE) -- 기본키가 스쿨코드에 등록된다
);


-- 3번째 방법(제약조건 이름 주는 방법)
-- NOT NULL은 이름주지 않는다
-- PK와 FK에는 제약 조건 이름 들어가는게 대부분
-- 제약조건의 이름은 제약조건 앞에 적는다
DROP TABLE SCHOOL;
CREATE TABLE SCHOOL(
    SCH_CODE NUMBER(1) NOT NULL CONSTRAINT PK_SCHOOL PRIMARY KEY,
    SCH_NAME VARCHAR2(20 BYTE) NOT NULL
);


-- 4번째 방법(제약조건 이름 주는 방법)
DROP TABLE SCHOOL;
CREATE TABLE SCHOOL( 
    SCH_CODE NUMBER(1) NOT NULL,
    SCH_NAME VARCHAR2(20 BYTE) NOT NULL,
   CONSTRAINT PK_SCHOOL PRIMARY KEY(SCH_CODE) 
);


-- 학생 테이블 생성
-- 자식테이블:FK를 가진 테이블
-- 1번째 방법

DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    STU_NO CHAR(5 BYTE) NOT NULL PRIMARY KEY,
    
    --외래키를 지정하는 가장 심플한 방법
    -- REFERENCES는 참조한다는 뜻
    SCH_CODE NUMBER(1) NOT NULL REFERENCES SCHOOL(SCH_CODE), 
    
    STU_NAME VARCHAR2(20 BYTE) NULL
);    


-- 2번째 방법
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    STU_NO CHAR(5 BYTE) NOT NULL, 
    SCH_CODE NUMBER(1) NOT NULL, 
    STU_NAME VARCHAR2(20 BYTE) NULL,
    PRIMARY KEY(STU_NO),
    
    -- 외래키를 주겠다 참조는 SCHOOL 테이블에 SCH_CODE이다
    FOREIGN KEY(SCH_CODE) REFERENCES SCHOOL(SCH_CODE)
);    


-- 3번째 방법 (제약 조건 이름 주기)
DROT TABLE STUDENT;
CREATE TABLE STUDENT(
    STU_NO CHAR(5 BYTE) NOT NULL,
    SCH_CODE NUMBER(1) NOT NULL,
    STU_NAME VARCHAR2(20 BYTE) NULL,
    CONSTRAINT PK_STUDENT PRIMARY KEY(STU_NO),
    CONSTRAINT FK_STUDENT_SCHOOL FOREIGN KEY(SCH_CODE) REFERENCES SCHOOL(SCH_CODE)
);  


-- 최종 정리
-- 생성: 부모 먼저, 자식 나중
-- 삭제: 자식 먼저, 부모 나중

DROP TABLE STUDENT;
DROP TABLE SCHOOL;
CREATE TABLE SCHOOL(

);
CREATE TABLE STUDENT(

);

