-- 1.순위
--  1)RANK() OVER(ORDER BY 순위구할칼럼 ASC) : 오름차순 순위, 낮은 값이 1등, ASC는 생략 가능
--  2)RANK() OVER(ORDER BY 순위구할칼럼 DESC): 내림차순 순위, 높은 값이 1등
--  3)같은 값이면 같은 등수(동점)로 처리







-- 1) EMPLOYEES 테이블의 사원 정보를 연봉 높은 순으로 조회하기
--  연봉 순위를 함게 조회하기
SELECT 
      RANK() OVER (ORDER BY SALARY DESC) AS 연봉순위
     ,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SALARY
   FROM
        EMPLOYEES;
        

-- 2) EMPLOYEES  테이블의 사원 정보를 입사순으로 조회하기
--   먼저 입사한 사원이 1등
SELECT
    RANK() OVER(ORDER BY HIRE_DATE) AS 입사순위
    ,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,HIRE_DATE
    FROM 
        EMPLOYEES;
        
        
-- 2.그룹화
-- OVER(PARTITION BY 그룹화칼럼)
-- 그룹화 작업을 수행하므로 집계함수(그룹함수)와 함게 사용이 가능함
SELECT 
      DISTINCT DEPARTMENT_ID
     ,SUM(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별연봉합계
     ,FLOOR(AVG(SALARY) OVER(PARTITION BY DEPARTMENT_ID)) AS 부서별연봉평균
     ,MAX(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별최대연봉
     ,MIN(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별최저연봉
     ,COUNT(*)    OVER(PARTITION BY DEPARTMENT_ID) AS 부서별사원수  
 FROM
      EMPLOYEES --DISTINCT 중복제거
 WHERE
      DEPARTMENT_ID IS NOT NULL; -- NULL이 아니다 널 값을 제외해라
      


-- RANK() 함수와 PARTITION BY 함게 사용하면 그룹 내 순위 구하기
SELECT
    RANK() OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) AS 부서내연봉순위
    ,EMPLOYEE_ID
    ,FIRST_NAME
    ,LAST_NAME
    ,SALARY
    ,DEPARTMENT_ID
  FROM
    EMPLOYEES
  ORDER BY
    DEPARTMENT_ID ASC;
    


-- 3.분기 처리(IF)
-- DECODE(표현식
--      ,값1, 결과1
--      ,값2, 결과2
--      ,값3, 결과3
--      , ...)
-- 표현식의 결과가 값1이면 결과 1 반환, 값2이면 결과2 반환,...
-- 표현식의 결과와 값의 비교는 동등 비교(=)만 가능함

-- JOIN 없이 EMPLOYEES 테이블만 이용하여 EMPLOYEE_ID,DEPARTMENT_NAME 조회하기
-- JOIN은 성능이 낮다 성능을 높이기 위해 DECODE 함수를 써서 하나 하나 직접 입력하는 노가다를 한다(속도를 높이기 위함)
SELECT
     EMPLOYEE_ID
    ,DECODE(DEPARTMENT_ID
        ,10,'Administration'
        ,20,'Marketing'
        ,30,'Purchasing'
        ,40,'Human Resources'
        ,50,'Shipping'
        ,60,'IT')AS 부서명
   FROM
        EMPLOYEES;
        
        
-- PHONE_NUMBER     REGION
-- 011              MOBILE
-- 515              EAST
-- 590              WEST
-- 603              SOUTH
-- 650              NORTH
-- 위의 다섯개로 시작하는 번호가 있다
-- EMPLOYEE_ID,PHONE_NUMBER,REGION 조회하기

SELECT
      EMPLOYEE_ID 
     ,PHONE_NUMBER 
     ,DECODE(SUBSTR(PHONE_NUMBER,1,3) -- SUBSTR 결과는 문자이기 때문에 번호들을 괄호로 묶어줌
        ,'011','MOBILE'
        ,'515','EAST'
        ,'590','WEST'
        ,'603','SOUTH'
        ,'650','NORTH')AS REGION
    FROM
        EMPLOYEES;  
        
        
-- 4. 분기 표현 식
-- CESE-END문
-- WHEN을 IF라고 생각하면 된다
-- CASE
--    WHEN 조건식 THEN 결과값1
--    WHEN 조건식2 THEN 결과값2
--    ...
--     ELSE 결과값N
--END

-- SALARY<10000  : C
-- SALARY<20000  : B
-- SALARY>=20000 : A
SELECT
    EMPLOYEE_ID
   ,SALARY
   ,CASE
        WHEN SALARY<10000 THEN 'C'
        WHEN SALARY<20000 THEN 'B'
        ELSE 'A'
    END AS 구분
FROM
    EMPLOYEES;


-- EMPLOYEE_ID,HIRE_DATE(YYYY-MM-DD),근무개월수,퇴직금정산대상유무 조회하기
-- 퇴직금 정산 대상: 근무개월수가 240개월 이상이면 '정산대상', 아니면 '빈 문자열'
SELECT
    EMPLOYEE_ID
    ,TO_CHAR(HIRE_DATE,'YYYY-MM-DD') AS 입사일
    ,FLOOR(MONTHS_BETWEEN(SYSDATE,HIRE_DATE))AS 근무개월수
    ,CASE
        WHEN MONTHS_BETWEEN(SYSDATE,HIRE_DATE) >=240 THEN '정산대상'
        ELSE ' '
      END AS 퇴직금정산대상
       FROM EMPLOYEES
        ORDER BY 퇴직금정산대상 DESC;
   
   
    
    

