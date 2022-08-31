-- WHERE절의 서브쿼리



-- 1.전체 사원의 인원수,급여합계/평균/최대/최소 조회하기
SELECT
    (SELECT COUNT(*) FROM EMPLOYEE)
   ,(SELECT SUM(SALARY) FROM EMPLOYEE)
   ,(SELECT AVG(SALARY) FROM EMPLOYEE)
   ,(SELECT MAX(SALARY) FROM EMPLOYEE)
   ,(SELECT MIN(SALARY) FROM EMPLOYEE)
 
 FROM DUAL;
   
   

-- 2.부서번호가 1인 부서와 같은 지역에서 근무하는 사원 조회하기
-- 사원번호(EMP_NO),사원명(NAME),부서번호(DEPART),부서명(DEPT_NAME) 조회
SELECT E.EMP_NO,E.NAME,E.DEPART,D.DEPT_NAME
 FROM DEPARTMENT D INNER JOIN EMPLOYEE E
 ON D.DEPT_NO=E.DEPART
 WHERE D.LOCATION=(SELECT LOCATION
                        FROM DEPARTMENT
                     WHERE DEPT_NO=1);   
                     
                     
-- 스칼라 서브쿼리 접근
-- 스칼라 서브쿼리는 일치하지 않는 정보를 NULL로 처리함
-- 따라서 스칼라 서브쿼리와 동일한 방식의 조인은 '외부조인'

SELECT
       E.EMP_NO
      ,E.NAME
      ,E.DEPART
      ,(SELECT D.DEPT_NAME
         FROM DEPARTMENT D
        WHERE D.DEPT_NO=E.DEPART
          AND D.DEPT_NO=1)
  FROM
      EMPLOYEE E;
 
 
 -- 조인 접근
 
 SELECT E.EMP_NO,E.NAME,E.DEPART,D.DEPT_NAME
FROM DEPARTMENT D RIGHT OUTER JOIN EMPLOYEE E
    ON D.DEPT_NO=E.DEPART
WHERE D.LOCATION=(SELECT LOCATION
                    FROM DEPARTMENT
                    WHERE DEPT_NO=1);
    
    
-- FROM 절의 서브쿼리

-- 인라인뷰
-- 1.INLINE-View
-- 2.FROM절에서 사용하는 서브쿼리를 의미함
-- 3.인라인뷰는 주로 테이블 형식임
-- 4.인라인뷰에 별명을 주고 사용함
-- 5.인라인뷰에서 조회한 칼럼만 메인쿼리에서 조회할 수 있음
-- 6.SELECT문의 실행순서를 바꿀 때 사용



SELECT A.EMP_NO,A.NAME,A.POSITION -- 인라인뷰가 조회한 칼럼만 작성할 수 있다
    FROM(SELECT EMP_NO,NAME,POSITION
         FROM EMPLOYEE
        WHERE DEPART=1) A; -- 인라인뷰의 별명:A
        

     
