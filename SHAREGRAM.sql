INSERT INTO 
    DEPARTMENTS
        (DEPT_NO , DEPT_NAME)
    VALUES
        (DEPT_SEQ.NEXTVAL , '관리부');

INSERT INTO 
    POSITION
        (JOB_NO , JOB_NAME)
    VALUES
        (POSITION_SEQ.NEXTVAL , '사장');
        
INSERT INTO 
    EMPLOYEES
        (EMP_NO , EMP_PW , NAME , BIRTHDAY , JOIN_DATE , PROF_IMG , INFO_MODIFY_DATE , STATUS , SALARY , JOB_NO , DEPT_NO)
    VALUES
        (EMP_SEQ.NEXTVAL , '1111', '정종길', '19940101', SYSDATE, NULL , SYSDATE, '노예' , 2000000, 1 ,20 );