

-- 테이블 삭제
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;



-- 테이블 생성
CREATE TABLE DEPARTMENT (
    DEPT_NO NUMBER NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION VARCHAR2(15 BYTE) NOT NULL
);

CREATE TABLE EMPLOYEE (
    EMP_NO NUMBER NOT NULL, --1001번부터 시작한다
    NAME VARCHAR2(20 BYTE) NOT NULL,
    DEPART NUMBER NULL, --외래키
    POSITION VARCHAR2(20 BYTE) NULL,
    GENDER CHAR(2 BYTE) NULL,
    HIRE_DATE DATE NULL,
    SALARY NUMBER NULL
);


-- 기본키 생성
ALTER TABLE DEPARTMENT
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
    
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);
    
    
-- 외래키 생성
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO)
            ON DELETE SET NULL;
            
            
    
-- 시퀀스(SEQUENCE)
-- 1.일련번호를 생성하는 데이터베이스 객체
-- 2.자동으로 증가하는 번호를 생성
-- 3.기본키(PK)에서 주로 사용(인공키)
-- 4.NEXTVAL을 이용하면 새로운 번호가 생성
-- 5.CURRVAL를 이용하면 현재 번호를 확인 할 때 사용(현재 번호표가 몇번까지 나갔는지)


-- 시퀀스 생성 형식 (순서 없음)
-- CREATE SEQUENCE 시퀀스_이름
-- START WITH 시작값   (생략하면 1, 생성 이후 수정 불가)
-- INCREMENT BY 증가값 (생략하면 1씩 증가한다)
-- MINVALUE 최소값
-- MAXVALUE 최대값
-- CACHE사용유무  (메모리 캐시를 사용할거냐는 말,NOCACHE 권장)
-- CYCLE사용유무  (PK에서 사용한다면 NOCYCLE,생략하면 NOCYCLE임)


-- 부서 테이블에서 사용할 부서_시퀀스
-- 테이블 하나당 시퀀스 하나씩 사용한다
-- 드랍시퀀스를 먼저 만들어 두자

DROP SEQUENCE DEPARTMENT_SEQ;
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1 
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100 --NOVALUE 최대값 없음
    NOCACHE
    NOCYCLE;
    

-- 2.모든 칼럼에 데이터 삽입(칼럼 리스트 생략)
-- INSERT INTO 테이블 VALUES(값1,값2...)

-- 부서테이블 행(Row)삽입
-- 부모 테이블(관계에서 PK를 가진 테이블)에 먼저 삽입을 해야 함
INSERT INTO DEPARTMENT
    (DEPT_NO,DEPT_NAME,LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL,'영업부','대구'); -
    
INSERT INTO DEPARTMENT
    (DEPT_NO,DEPT_NAME,LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL,'인사부','서울');
    
INSERT INTO DEPARTMENT
    (DEPT_NO,DEPT_NAME,LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL,'총무부','대구');
    
INSERT INTO DEPARTMENT
    (DEPT_NO,DEPT_NAME,LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL,'기획부','서울');
 
-- 작업의 완료
 COMMIT;
 
 
 
-- 한글 하나에 3바이트
-- LOCATION 값으로 부에노스아이리스를 줄 경우 한글 하나에 3바이트이기 때문에 크기가 넘쳐 오류 발생
-- DEPT_NO 값으로 4(중복값)를 줄 경우 DEPT_NO은 PK로 UNIQUE를 갖기 때문에 오류 발생
-- INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,LOCATION) VALUES(4,'개발부','인천');



-- 사원 테이블 행(Row)삽입
-- 자식 테이블(관계에서 FK를 가진 테이블)은 참조 무결성에 위배되지 않는 데이터만 삽입 가능

-- 부서(부서번호(PK)) - 사원(소속부서(FK))
-- 1,2,3,4           - 1,2,3,4중 하나만 가능

-- DATE 날짜 입력은 / 또는 -
-- '95/05/01' 또는 '95-05-01'


-- 사원테이블에서 사용할 사원_시퀀스
DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001 
    NOCACHE;
    

INSERT INTO 
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL,'구창민',1,'과장','M','95/05/01',5000000);
    
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL,'김민서',1,'사원','F','17/09/01',2000000);
    
   
   
    
-- 빈칸을 넣고 싶을땐 NULL이라고 직접 명시할 것
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL,'이은영',2,'부장',NULL,'90-09-01',5500000);
    
 
 
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL,'한성일',2,'과장','M','93-04-01',5000000);
    
    
    
    
    
-- 오류가 발생하는 INSERT (부서번호 5는 없기 때문)
-- INSERT는 실패하였으나 시퀀스의 번호는 사용
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL,'신현준',5,'대리','M','98-12-01',3500000);    
    


-- 정상데이터로 다시 INSERT(오류 발생으로 사원번호 1005를 건너 뛰고 1006으로 생성된다)
-- 구멍난 번호가 맘에 안든다면 새로 만드는 수 밖에 없다(DROP SEQUNCE)

INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL,'신현준',3,'대리','M','98-12-01',3500000);    
    


COMMIT;


DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    NO1 NUMBER,
    NO2 NUMVER
);

DROP SEQUENCE SAMPLE_SEQ;
CREATE SEQUENCE SAMPLE_SEQ NOCACHE;


-- 최초 1번은 NEXTVAL를 사용해야 CURRVAL도 사용 가능함
INSERT INTO SAMPLE(NO1) VALUES(SAMPLE_SEQ.CURRVAL);


-- NEXTVAL,CURRVAL 함께 사용
INSERT INTO SAMPLE(NO1,NO2) VALUES(SAMPLE_SEQ.NEXTVAL,SQMPLE_SEQ.CURRVAL);

COMMIT;




