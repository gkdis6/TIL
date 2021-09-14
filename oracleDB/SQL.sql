SELECT player_id, player_name, team_id, POSITION, height, weight, back_no FROM admin.player;

SELECT PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION, HEIGHT,
           WEIGHT, BACK_NO 
 FROM PLAYER;
 
SELECT POSITION FROM PLAYER;

SELECT * FROM PLAYER;

select  player_name 선수명, 
           position as 포지션, 
           height as 키, 
           weight as 몸무게
  from  player;
  
select  player_name as "선수 명", 
           position as 위치, 
           height as 키, 
           weight as 몸무게
  from  player;
  
SELECT player_name 선수명,
		height-weight "키 - 몸무게"	
FROM PLAYER;

SELECT player_name 선수명,
		ROUND(weight/((height/100)*(height/100)),2) "BMI 비만지수"
		FROM PLAYER;
		
SELECT player_name||' 선수, '||height||' cm, '||weight||' kg, ' AS 체격정보 FROM PLAYER p ;

SELECT LENGTH('SQL Expert') as LEN
   FROM DUAL;
   
SELECT SYSDATE FROM dual;

SELECT CONCAT(player_name,' 축구선수') 선수명 
FROM player; 

SELECT player_name||' 축구선수' 선수명 
FROM player;

SELECT stadium_id, ddd||')'||tel AS tel, length(ddd||'-'||tel) AS t_len
FROM STADIUM

SELECT ename as 사원명, hiredate as 입사일자
           , extract(year from hiredate) as 입사년도
           , extract(month from hiredate) as 입사월
           , extract(day from hiredate) as 입사일
 FROM EMP;

SELECT ename as 사원명, hiredate as 입사일자
          , to_number(to_char(hiredate, 'yyyy')) as 입사년도
          , to_number(to_char(hiredate, 'mm')) as 입사월
          , to_number(to_char(hiredate, 'dd')) as 입사일
FROM emp;

SELECT TO_CHAR(SYSDATE,'yyyy/mm/dd') 날짜,
		TO_CHAR(SYSDATE,'yyyy.mon, day') 문자형
		FROM dual;
		
SELECT TO_CHAR(123456789/1200,'$999,999,999.99') 환율반영달러, 
          TO_CHAR(123456789,'L999,999,999') 원화
FROM DUAL; 

SELECT TEAM_ID as 팀ID
           , to_number(zip_code1, '999') + to_number(zip_code2, '999') as 우편번호합
 FROM TEAM;
 


SELECT ename
	,CASE 
	WHEN sal>2000 THEN sal
	ELSE 2000
	END AS revied_salary
	FROM emp;
	
SELECT loc
	,CASE loc
		WHEN 'NEW YORK' THEN 'EAST'
		WHEN 'BOSTON'	THEN 'EASE'
		WHEN 'CHICAGO'	THEN 'CENTER'
		WHEN 'DALLAS'	THEN 'CENTER'
		ELSE 'ETC'
	END AS area
FROM dept;

SELECT ename
	, CASE 
		WHEN sal >= 3000 THEN 'HIGH'
		WHEN sal >= 1000 THEN 'MID'
		ELSE 'LOW'
	END AS salary_grade
FROM emp;

SELECT ENAME, SAL
	, CASE
		WHEN SAL >= 2000 THEN 1000
		WHEN SAL >= 1000 THEN 500
		ELSE 0
	END AS BONUS
  FROM EMP;
  
 SELECT ename, sal
 	, CASE 
 		WHEN sal >= 2000 THEN 1000
 		else(CASE
 				WHEN sal >= 1000 THEN 500
	 			ELSE 0
 			end)
 		END AS bonus
FROM emp;



SELECT nvl(NULL, 'NVL-OK') NVL_TEST
FROM dual;

SELECT NVL('Not-Null','NVL-OK') NVL_TEST
FROM dual;

SELECT player_name 선수명, POSITION,NVL(POSITION,'없음') 포지션
FROM PLAYER
WHERE TEAM_ID = 'K08';

SELECT player_name 선수명, POSITION AS 포지션
	, CASE 
		WHEN POSITION IS NULL THEN '없음'
		ELSE POSITION
	END AS NL포지션
FROM PLAYER
WHERE TEAM_ID = 'K08';

SELECT ENAME AS 사원명, SAL AS 월급, COMM AS 커미션,
           (SAL * 12) + COMM AS 연봉A, 
           (SAL *12)+NVL(COMM, 0) AS 연봉B
FROM EMP;


SELECT MGR
FROM EMP 
WHERE ENAME='KING';

SELECT NVL(MGR,9999) AS MGR, ENAME 
FROM EMP 
WHERE ENAME='KING';


SELECT MGR
FROM EMP
WHERE ENAME='JSC';

SELECT NVL(MGR,9999)
FROM EMP
WHERE ENAME='JSC';



SELECT ENAME, EMPNO, MGR, NULLIF(MGR, 7698) AS NUIF
  FROM EMP;
  
 SELECT ENAME, EMPNO, MGR
         , CASE
                 WHEN MGR = 7698 THEN NULL
                 ELSE MGR
           END AS NUIF
FROM EMP;


SELECT ENAME, COMM,SAL,COALESCE(COMM, SAL) AS COAL
FROM EMP;

SELECT ENAME, COMM, SAL
        , CASE
                WHEN COMM IS NOT NULL THEN COMM
                ELSE ( CASE
                               WHEN SAL IS NOT NULL THEN SAL
                               ELSE NULL
                          END)
          END AS COAL
FROM EMP;



SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE TEAM_ID = 'K02';

SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE POSITION = 'MF';

SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE HEIGHT >= 170;
--주석
SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE TEAM_ID IN ('K02','K07');

--OR
SELECT ENAME, JOB, DEPTNO
FROM EMP
WHERE (JOB,DEPTNO) IN (('MANAGER',20),('CLERK',30),('MANAGER',30));

--job 끼리 OR, deptno 끼리 OR
SELECT ENAME, JOB, DEPTNO
FROM EMP
WHERE JOB IN ('MANAGER','CLERK') AND DEPTNO IN (20,30);

--like 는 = 과 같음
SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE POSITION LIKE 'MF';

--0개 이상의 문자
SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE PLAYER_NAME LIKE '장%';

--1개의 단일 문자
SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE PLAYER_NAME LIKE '장_호';



SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE HEIGHT BETWEEN 170 AND 180;

SELECT PLAYER_NAME 선수명, POSITION 포지션, TEAM_ID 
FROM PLAYER
WHERE POSITION IS NULL;


SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE TEAM_ID = 'K02' 
AND HEIGHT >= 170;

SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE TEAM_ID IN ('K02','K07')
AND POSITION = 'MF';

SELECT TEAM_ID 팀ID, PLAYER_NAME 선수명, POSITION 포지션, 
          BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE
     (TEAM_ID = 'K02' 
OR TEAM_ID = 'K07' )
AND POSITION = 'MF'
AND HEIGHT >= 170
AND HEIGHT <= 180;

SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE TEAM_ID IN ('K02','K07')
AND POSITION = 'MF'
AND HEIGHT BETWEEN 170 AND 180 ; 


--NOT
SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE TEAM_ID = 'K02'
AND NOT POSITION = 'MF'
AND NOT HEIGHT BETWEEN 175 AND 185;

--표준 부정문
SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE TEAM_ID = 'K02' 
AND POSITION <> 'MF'
AND HEIGHT NOT BETWEEN 175 AND 185;

--NULL
SELECT PLAYER_NAME 선수이름, NATION 국적 
FROM PLAYER 
WHERE NATION IS NOT NULL;


--집계함수(Aggregate function)
SELECT count(*) "전체 행수",
	count(height) "키 건수",
	max(height) 최대키,
	min(height) 최소키,
	round(avg(height),2) 평균키
FROM PLAYER;

--GROUP BY
SELECT POSITION 포지션, round(AVG(HEIGHT),2) 평균키
FROM PLAYER
GROUP BY POSITION;

SELECT POSITION 포지션, COUNT(*) 인원수, COUNT(HEIGHT) 키대상, 
          MAX(HEIGHT) 최대키, MIN(HEIGHT) 최소키, 
          ROUND(AVG(HEIGHT),2) 평균키 
FROM PLAYER 

SELECT POSITION 포지션, round(avg(height),2) 평균키
FROM PLAYER
--WHERE avg(HEIGHT) >= 180 (where에는 집계함수를 쓸 수 없다.)
GROUP BY POSITION;

--having절 
SELECT POSITION 포지션, ROUND(avg(height),2) 평균키
FROM PLAYER
GROUP BY POSITION 
HAVING avg(HEIGHT) >= 180;

--where와 having의 차이 where가 메모리를 좀 더 아낄 수 있다.
SELECT TEAM_ID 팀ID, COUNT(*) 인원수
FROM PLAYER
WHERE TEAM_ID IN ('K09', 'K02')
GROUP BY TEAM_ID; 
--having은 다 계산하고 마지막에 거르는 느낌
SELECT TEAM_ID 팀ID, COUNT(*) 인원수
FROM PLAYER
GROUP BY TEAM_ID
HAVING TEAM_ID IN ('K09', 'K02'); 

SELECT POSITION 포지션, ROUND(AVG(HEIGHT),2) 평균키
FROM PLAYER
GROUP BY POSITION
HAVING MAX(HEIGHT) >= 190;

SELECT POSITION 포지션, ROUND(AVG(HEIGHT),2) 평균키
FROM PLAYER
--WHERE POSITION = 'MF'
GROUP BY POSITION
HAVING POSITION= 'MF';

SELECT ename 사원명, deptno 부서번호,
	EXTRACT (MONTH FROM hiredate) 입사월,
	sal 급여
FROM emp;



SELECT ENAME AS 사원명, DEPTNO AS 부서번호
	, CASE MONTH WHEN 1 THEN SAL END AS M01
	, CASE MONTH WHEN 2 THEN SAL END AS M02
	, CASE MONTH WHEN 3 THEN SAL END AS M03
	, CASE MONTH WHEN 4 THEN SAL END AS M04
    , CASE MONTH WHEN 5 THEN SAL END AS M05
    , CASE MONTH WHEN 6 THEN SAL END AS M06
	, CASE MONTH WHEN 7 THEN SAL END AS M07
	, CASE MONTH WHEN 8 THEN SAL END AS M08
	, CASE MONTH WHEN 9 THEN SAL END AS M09
	, CASE MONTH WHEN 10 THEN SAL END AS M10
	, CASE MONTH WHEN 11 THEN SAL END AS M11
	, CASE MONTH WHEN 12 THEN SAL END AS M12
FROM (SELECT ENAME , DEPTNO ,
          EXTRACT (MONTH FROM HIREDATE) AS MONTH, SAL
          FROM EMP);

SELECT DEPTNO AS 부서번호
         ,  AVG (CASE MONTH WHEN 1 THEN SAL END) AS M01
         , AVG (CASE MONTH WHEN 2 THEN SAL END) AS M02
         , AVG (CASE MONTH WHEN 3 THEN SAL END) AS M03
         , AVG (CASE MONTH WHEN 4 THEN SAL END) AS M04
         , AVG (CASE MONTH WHEN 5 THEN SAL END) AS M05
         , AVG (CASE MONTH WHEN 6 THEN SAL END) AS M06
 , AVG (CASE MONTH WHEN 7 THEN SAL END) AS M07
 , AVG (CASE MONTH WHEN 8 THEN SAL END) AS M08
 , AVG (CASE MONTH WHEN 9 THEN SAL END) AS M09
 , AVG (CASE MONTH WHEN 10 THEN SAL END) AS M10
 , AVG (CASE MONTH WHEN 11 THEN SAL END) AS M11
,  AVG (CASE MONTH WHEN 12 THEN SAL END ) AS M12
FROM (SELECT ENAME , DEPTNO ,
          EXTRACT (MONTH FROM HIREDATE) AS MONTH, SAL
          FROM EMP)
GROUP BY DEPTNO;

SELECT DEPTNO AS 부서번호
         , AVG (DECODE (MONTH, 1, SAL)) AS M01
         , AVG (DECODE (MONTH, 2, SAL)) AS M02
         , AVG (DECODE (MONTH,3, SAL)) AS M03
         , AVG (DECODE (MONTH,4, SAL)) AS M04
         , AVG (DECODE (MONTH,5, SAL)) AS M05
         , AVG (DECODE (MONTH,6, SAL)) AS M06
 , AVG (DECODE (MONTH,7, SAL)) AS M07
 , AVG (DECODE (MONTH,8, SAL)) AS M08
 , AVG (DECODE (MONTH,9, SAL)) AS M09
 , AVG (DECODE (MONTH,10, SAL)) AS M10
 , AVG (DECODE (MONTH,11, SAL)) AS M11
 , AVG (DECODE (MONTH,12, SAL)) AS M12
FROM (SELECT ENAME , DEPTNO ,
          EXTRACT (MONTH FROM HIREDATE) AS MONTH, SAL
          FROM EMP)
GROUP BY DEPTNO;


SELECT TEAM_ID
          , NVL( SUM ( CASE POSITION WHEN 'FW' THEN 1 END), 0) AS FW
          , NVL( SUM ( CASE POSITION WHEN 'MF' THEN 1 END), 0) AS MF
          , NVL( SUM ( CASE POSITION WHEN 'DF' THEN 1 END), 0) AS DF
          , NVL( SUM ( CASE POSITION WHEN 'GK' THEN 1 END), 0) AS GK
          , COUNT(*) AS SUM
FROM PLAYER
GROUP BY TEAM_ID;

--이건 너무 더러움
SELECT team_id, POSITION , count(POSITION)
FROM PLAYER
GROUP BY TEAM_ID , POSITION;

SELECT  ROUND (AVG (CASE WHEN POSITION = 'MF' THEN HEIGHT END), 2) AS 미드필드
          , ROUND (AVG (CASE WHEN POSITION = 'FW' THEN HEIGHT END), 2) AS 포워드
          , ROUND (AVG (CASE WHEN POSITION = 'DF' THEN HEIGHT END), 2) AS 디펜더
          , ROUND (AVG (CASE WHEN POSITION = 'GK' THEN HEIGHT END), 2) AS 골키퍼
          , ROUND (AVG (HEIGHT), 2) 전체평균키
FROM PLAYER;

SELECT POSITION , ROUND(avg(height),2)
FROM PLAYER
GROUP BY POSITION;



SELECT player_name, POSITION, back_no
FROM PLAYER
ORDER BY PLAYER_NAME DESC;

SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버
FROM PLAYER
ORDER BY 포지션 DESC;

SELECT player_name, POSITION, back_no, height
FROM PLAYER
WHERE HEIGHT IS NOT NULL 
ORDER BY HEIGHT DESC,BACK_NO;

SELECT player_name, POSITION, back_no
FROM PLAYER
WHERE BACK_NO IS NOT NULL
ORDER BY 3 DESC, 2,1;

--order by 절
SELECT DNAME, LOC, DEPTNO 
FROM DEPT 
ORDER BY DNAME, LOC, DEPTNO DESC;

SELECT DNAME DEPT, LOC AREA, DEPTNO 
FROM DEPT 
ORDER BY DNAME, AREA, DEPTNO DESC;

SELECT DNAME, LOC AREA, DEPTNO 
FROM DEPT 
ORDER BY 1, AREA, 3 DESC;

SELECT EMPNO, ENAME 
FROM EMP 
ORDER BY MGR;

SELECT ename
FROM 
(SELECT EMPNO, ENAME FROM EMP ORDER BY MGR); 

SELECT job--, sal
FROM EMP
GROUP BY JOB 
HAVING count(*)> 0
--ORDER BY sal;

SELECT JOB, SUM(SAL) AS SALARY_SUM
FROM EMP
GROUP BY JOB
HAVING  SUM(SAL) > 5000
ORDER BY  SUM(SAL);



--join문
SELECT player.PLAYER_NAME , team.TEAM_NAME 
FROM PLAYER, TEAM
WHERE player.TEAM_ID = team.TEAM_ID;
--표준, inner join
SELECT player.PLAYER_NAME , team.TEAM_NAME 
FROM PLAYER INNER JOIN TEAM
ON PLAYER.TEAM_ID = TEAM.TEAM_ID;


SELECT p.PLAYER_NAME , p.BACK_NO , p.TEAM_ID ,
	t.TEAM_NAME , t.REGION_NAME 
FROM PLAYER p , TEAM t 
WHERE p.TEAM_ID = t.TEAM_ID ;

SELECT p.PLAYER_NAME , p.BACK_NO , p.TEAM_ID , 
	t.TEAM_NAME , t.REGION_NAME 
FROM PLAYER p INNER JOIN TEAM t 
on p.TEAM_ID  = t.TEAM_ID ;


SELECT p.PLAYER_NAME , p.BACK_NO ,
	t.REGION_NAME , t.TEAM_NAME , p."POSITION" 
FROM PLAYER p , TEAM t 
WHERE p.TEAM_ID = t.TEAM_ID 
AND p."POSITION" = 'GK'
ORDER BY p.BACK_NO ;

SELECT P.PLAYER_NAME 선수명, P.BACK_NO 백넘버, 
          T.REGION_NAME 연고지, T.TEAM_NAME 팀명
FROM PLAYER P INNER JOIN TEAM T
ON P.TEAM_ID = T.TEAM_ID
WHERE P.POSITION = 'GK'
--AND 
ORDER BY P.BACK_NO;


SELECT T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, S.STADIUM_NAME, 
          S.SEAT_COUNT
FROM TEAM T, STADIUM S 
WHERE T.STADIUM_ID = S.STADIUM_ID;

SELECT T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, S.STADIUM_NAME, 
          S.SEAT_COUNT
FROM TEAM T INNER JOIN STADIUM S
ON T.STADIUM_ID = S.STADIUM_ID;


CREATE TABLE salgrade(
grade char(1) NOT NULL,
losal NUMBER NOT NULL,
hisal NUMBER NOT NULL,
CONSTRAINT salgrade_pk_grade PRIMARY key(grade)
		--테이블	  제약조건명 컬럼명
);

INSERT INTO salgrade(grade, losal, hisal)
values('1', 700, 1200);
INSERT INTO salgrade(grade, losal, hisal)
 VALUES('2',1201,1400);
INSERT INTO salgrade(grade, losal, hisal)
 VALUES('3',1401,2000);
INSERT INTO salgrade(grade, losal, hisal)
 VALUES('4',2001,3000);
INSERT INTO salgrade(grade, losal, hisal)
 VALUES('5',3001,9999);
 
SELECT e.ename, e.job, e.sal, s.grade
FROM EMP e, SALGRADE s 
WHERE e.sal BETWEEN s.LOSAL AND s.HISAL;

--3개 이상 inner join
SELECT P.PLAYER_NAME 선수명, P.POSITION 포지션, 
          T.REGION_NAME 연고지, T.TEAM_NAME 팀명, 
          S.STADIUM_NAME 구장명
FROM PLAYER P, TEAM T, STADIUM S
WHERE P.TEAM_ID = T.TEAM_ID
AND T.STADIUM_ID = S.STADIUM_ID 
ORDER BY 선수명;

SELECT P.PLAYER_NAME 선수명, P.POSITION 포지션, 
          T.REGION_NAME 연고지, T.TEAM_NAME 팀명, S.STADIUM_NAME 구장명
FROM PLAYER P INNER JOIN TEAM T 
ON P.TEAM_ID = T.TEAM_ID INNER JOIN STADIUM S 
ON T.STADIUM_ID = S.STADIUM_ID 
ORDER BY 선수명;

--outter join
SELECT A.STADIUM_NAME, A.STADIUM_ID, A.SEAT_COUNT,
            A.HOMETEAM_ID,  B.TEAM_NAME
FROM STADIUM A, TEAM B
WHERE B.TEAM_ID = A.HOMETEAM_ID(+)
ORDER BY A.HOMETEAM_ID;

SELECT A.ENAME, A.DEPTNO, B.DNAME, B.LOC
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO(+);


SELECT e.DEPTNO, e.EMPNO , e.ENAME ,d.DNAME 
FROM EMP e , DEPT d
WHERE e.DEPTNO = d.DEPTNO ;

SELECT e.DEPTNO , e.EMPNO , e.ENAME , d.DNAME 
FROM EMP e INNER JOIN DEPT d 
ON e.DEPTNO = d.DEPTNO ;

SELECT e.DEPTNO , e.EMPNO , e.ENAME , d.DNAME 
FROM EMP e JOIN DEPT d 
ON e.DEPTNO = d.DEPTNO ;

--natural join
SELECT e.EMPNO , e.ENAME , DEPTNO , d.DNAME 
FROM EMP e NATURAL JOIN DEPT d 

SELECT * 
 FROM EMP NATURAL JOIN DEPT;w
 
 SELECT *
 FROM EMP e INNER JOIN DEPT d 
 ON e.DEPTNO = d.DEPTNO ;
 
CREATE TABLE dept_temp AS SELECT*FROM dept;

UPDATE dept_TEMP SET DNAME ='consullting'
WHERE DNAME = 'RESEARCH';

UPDATE DEPT_TEMP SET DNAME = 'MARKETING'
WHERE DNAME = 'SALES';

SELECT * FROM DEPT_TEMP;

SELECT * 
FROM DEPT NATURAL INNER JOIN DEPT_TEMP;

SELECT * 
FROM DEPT A JOIN DEPT_TEMP B
ON  A.DEPTNO = B.DEPTNO
AND A.DNAME = B.DNAME
AND A.LOC = B.LOC;

--using, inner의 특성을 가짐
SELECT * 
FROM DEPT JOIN DEPT_TEMP 
USING (DEPTNO);

SELECT DEPTNO, A.DNAME,  A.LOC, B.DNAME, B.LOC
FROM DEPT A JOIN DEPT_TEMP B
USING (DEPTNO);

SELECT * 
FROM DEPT JOIN DEPT_TEMP 
USING (DNAME);

SELECT * 
FROM DEPT JOIN DEPT_TEMP 
USING (LOC, DEPTNO);

SELECT *
FROM DEPT JOIN DEPT_TEMP 
USING (DEPTNO, DNAME);

SELECT E.EMPNO, E.ENAME, E.DEPTNO, D.DNAME
FROM EMP E JOIN DEPT D
ON (E.DEPTNO = D.DEPTNO);

--where절과 혼용 
SELECT e.ENAME , e.DEPTNO , d.DEPTNO , d.DNAME 
FROM EMP e JOIN DEPT d 
ON d.DEPTNO = e.DEPTNO 
WHERE d.DEPTNO = 30;

SELECT t.TEAM_NAME , t.STADIUM_ID , s.STADIUM_NAME 
FROM TEAM t JOIN STADIUM s 
ON (s.STADIUM_ID = t.STADIUM_ID)
ORDER BY t.STADIUM_ID ;

SELECT t.TEAM_NAME , STADIUM_ID , s.STADIUM_NAME 
FROM TEAM t JOIN STADIUM s 
using (STADIUM_ID)
ORDER BY STADIUM_ID ;

SELECT t.TEAM_NAME , t.TEAM_ID , s.STADIUM_NAME 
FROM TEAM t JOIN STADIUM s 
ON (t.TEAM_ID = s.HOMETEAM_ID)
ORDER BY t.TEAM_ID ;


SELECT e.EMPNO , e.DEPTNO , d.DNAME , t.dname
FROM EMP e JOIN DEPT d 
ON e.DEPTNO = d.DEPTNO JOIN DEPT_TEMP t 
ON t.deptno = d.DEPTNO;

SELECT e.EMPNO , e.DEPTNO , d.DNAME , t.DNAME 
FROM EMP e , DEPT d , DEPT_TEMP t 
WHERE e.DEPTNO = d.DEPTNO 
AND d.DEPTNO = t.deptno;


SELECT p.PLAYER_NAME , p."POSITION" , t.REGION_NAME,
	t.TEAM_NAME , s.STADIUM_NAME 
FROM PLAYER p JOIN TEAM t 
ON p.TEAM_ID = t.TEAM_ID JOIN STADIUM s 
ON s.STADIUM_ID = t.STADIUM_ID 
WHERE p."POSITION" = 'GK'
ORDER BY PLAYER_NAME ;

SELECT p.PLAYER_NAME , p.POSITION , t.REGION_NAME,
	t.TEAM_NAME , s.STADIUM_NAME 
FROM PLAYER p , TEAM t , STADIUM s 
WHERE p.POSITION = 'GK'
AND t.TEAM_ID = p.TEAM_ID 
AND s.STADIUM_ID = t.STADIUM_ID 
ORDER BY PLAYER_NAME ;


SELECT s.STADIUM_NAME , s2.SCHE_DATE , t.TEAM_NAME , t2.TEAM_NAME
FROM STADIUM s JOIN SCHEDULE s2
ON s2.STADIUM_ID = s.STADIUM_ID JOIN TEAM t 
ON t.TEAM_ID = s2.HOMETEAM_ID JOIN TEAM t2 
ON t2.TEAM_ID = s2.AWAYTEAM_ID 
WHERE s2.HOME_SCORE >= s2.AWAY_SCORE + 3;

SELECT s.STADIUM_NAME , s2.SCHE_DATE , t.TEAM_NAME , t2.TEAM_NAME 
FROM TEAM t , STADIUM s , SCHEDULE s2 , TEAM t2 
WHERE (s2.HOME_SCORE - s2.AWAY_SCORE >= 3)
AND s2.STADIUM_ID = s.STADIUM_ID 
AND s2.HOMETEAM_ID = t.TEAM_ID 
AND s2.AWAYTEAM_ID = t2.TEAM_ID ;

--cross join 모든 조합 
SELECT e.ENAME, d.DNAME 
FROM EMP e CROSS JOIN DEPT d 
ORDER BY ename;

--left outer join
SELECT A.STADIUM_NAME, A.STADIUM_ID, A.SEAT_COUNT, A.HOMETEAM_ID,
          B.TEAM_NAME
 FROM STADIUM A LEFT OUTER JOIN TEAM B
    ON  B.TEAM_ID =  A.HOMETEAM_ID
ORDER BY A.HOMETEAM_ID;
--outer 생략 가능 
SELECT A.STADIUM_NAME, A.STADIUM_ID, A.SEAT_COUNT, A.HOMETEAM_ID,
          B.TEAM_NAME
 FROM STADIUM A LEFT JOIN TEAM B
    ON  B.TEAM_ID =  A.HOMETEAM_ID
ORDER BY A.HOMETEAM_ID;

SELECT E.ENAME, D.DEPTNO, D.DNAME
 FROM EMP E RIGHT OUTER JOIN DEPT D
     ON E.DEPTNO = D.DEPTNO;

SELECT * FROM DEPT_TEMP;

UPDATE DEPT_TEMP
SET
DEPTNO = DEPTNO + 20;

--full outer join 합집합 느낌 
SELECT *
FROM DEPT A FULL OUTER JOIƒN DEPT_TEMP B
     ON A.DEPTNO = B.DEPTNO;
    
    
    
SELECT COUNT(*) FROM EMP WHERE 1=0;
   
SELECT MAX(EMPNO) FROM EMP WHERE 1=0;
  
SELECT NVL(EMPNO,9999) FROM EMP WHERE 1=0;
 
SELECT NVL(MAX(EMPNO),0000) FROM EMP WHERE 1=0;


SELECT PLAYER_NAME , "POSITION" , BACK_NO , TEAM_ID
FROM PLAYER
WHERE TEAM_ID = (SELECT TEAM_ID
FROM PLAYER
WHERE PLAYER_NAME = '정남일')
ORDER BY PLAYER_NAME;

SELECT p.player_name, p."POSITION" , p.BACK_NO , p.HEIGHT
FROM PLAYER p
WHERE HEIGHT <=(SELECT AVG(height)
FROM PLAYER p2)
ORDER BY PLAYER_NAME ;


SELECT REGION_NAME , TEAM_NAME , E_TEAM_NAME 
FROM TEAM t 
WHERE t.TEAM_ID IN (SELECT p.TEAM_ID 
FROM PLAYER p 
WHERE PLAYER_NAME = '정현수')
ORDER BY TEAM_NAME ;

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
            BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE (TEAM_ID, HEIGHT) IN (SELECT TEAM_ID, MIN(HEIGHT)
FROM PLAYER
GROUP BY TEAM_ID )
ORDER BY TEAM_ID, PLAYER_NAME;

SELECT t.TEAM_NAME , p.TEAM_ID , p.PLAYER_NAME , p."POSITION" , p.BACK_NO , p.HEIGHT
FROM PLAYER p , TEAM t
WHERE p.TEAM_ID = t.TEAM_ID
AND p.HEIGHT < (SELECT AVG(p2.HEIGHT)
FROM PLAYER p2
WHERE p2.TEAM_ID = p.team_id
GROUP BY p.TEAM_ID )
ORDER BY PLAYER_NAME ;

SELECT *
FROM SCHEDULE x
WHERE x.SCHE_DATE BETWEEN '20120501' AND '20120502';
  
 SELECT STADIUM_ID ID, STADIUM_NAME 경기장명
FROM STADIUM A
WHERE EXISTS ( SELECT 1
FROM SCHEDULE X
WHERE X.STADIUM_ID = A.STADIUM_ID
AND X.SCHE_DATE BETWEEN '20120501' AND '20120502' );
	
SELECT p2.PLAYER_NAME , p2.HEIGHT , ROUND((SELECT avg(HEIGHT) 
FROM PLAYER p 
WHERE p.TEAM_ID = p2.team_id),3)
FROM PLAYER p2 ;

SELECT t.team_name, p.player_name, p.back_no
FROM (SELECT TEAM_ID , PLAYER_NAME , BACK_NO 
FROM PLAYER
WHERE POSITION = 'MF') p, TEAM t
WHERE p.team_id = t.team_id
ORDER BY player_name;


--order by가 마지막에 들어가기 때문에 먼저 정렬하고 나서 rownum을 넣어서 출력 
SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키
FROM (SELECT PLAYER_NAME, POSITION, BACK_NO, HEIGHT
	FROM PLAYER
	WHERE HEIGHT IS NOT NULL
	ORDER BY HEIGHT DESC )
WHERE ROWNUM <= 5;

SELECT P.TEAM_ID 팀ID, T.TEAM_NAME 팀명, 
            ROUND( AVG(P.HEIGHT), 3) 평균키
FROM PLAYER P, TEAM T
WHERE P.TEAM_ID = T.TEAM_ID
GROUP BY P.TEAM_ID, T.TEAM_NAME
HAVING AVG(P.HEIGHT) <(SELECT AVG(X.HEIGHT)
FROM PLAYER X
WHERE X.TEAM_ID IN (SELECT TEAM_ID
FROM TEAM
WHERE TEAM_NAME = '삼성블루윙즈'));

CREATE VIEW v_player_team AS
SELECT p.PLAYER_NAME , p.POSITION, p.BACK_NO , p.TEAM_ID , t.TEAM_NAME 
FROM player p, team t
WHERE p.TEAM_ID = t.TEAM_ID ;




SELECT PLAYER_NAME 선수명, BACK_NO 백넘버
FROM PLAYER
WHERE TEAM_ID = 'K02'
UNION
SELECT PLAYER_NAME 선수명, BACK_NO 백넘버
FROM PLAYER
WHERE TEAM_ID = 'K07' ORDER BY 1;

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
           BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE TEAM_ID = 'K02'
UNION
 SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
           BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE TEAM_ID = 'K07';
 
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
          BACK_NO 백넘버, HEIGHT 키
 FROM PLAYER
WHERE TEAM_ID = 'K02'
UNION
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
          BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE POSITION = 'GK';

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
           BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE TEAM_ID = 'K02'
UNION ALL
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션,  
          BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE POSITION = 'GK';

SELECT 'P' 구분코드, POSITION 포지션, ROUND(AVG(HEIGHT), 3) 평균키
FROM PLAYER
GROUP BY POSITION
UNION ALL
SELECT 'T' 구분코드, TEAM_ID 팀명, ROUND(AVG(HEIGHT), 3) 평균키
FROM PLAYER
GROUP BY TEAM_ID
ORDER BY 1;

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션,
           BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE TEAM_ID = 'K02'
MINUS
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션,
          BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE POSITION = 'MF'
ORDER BY 1, 2, 3, 4, 5;

SELECT DISTINCT 
	p.TEAM_ID , p.PLAYER_NAME , p."POSITION" , p.BACK_NO , p.HEIGHT
FROM PLAYER p
WHERE p.TEAM_ID = 'K02'
AND NOT EXISTS (SELECT 1
FROM PLAYER p2
WHERE p2."POSITION" = 'MF'
AND p2.PLAYER_ID = p.PLAYER_ID)
ORDER BY 1, 2, 3, 4, 5;

SELECT DISTINCT
          A.TEAM_ID 팀코드, A.PLAYER_NAME 선수명, A.POSITION 포지션, 
           A.BACK_NO 백넘버, A.HEIGHT 키
FROM PLAYER A
WHERE A.TEAM_ID = 'K02'
AND PLAYER_ID NOT IN(SELECT PLAYER_ID
FROM PLAYER
WHERE POSITION = 'MF')
ORDER BY 1, 2, 3, 4, 5;

--교집합
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
          BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE TEAM_ID = 'K02'
INTERSECT
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
          BACK_NO 백넘버, HEIGHT 키
 FROM PLAYER
WHERE POSITION = 'GK'
ORDER BY 1, 2, 3, 4, 5;

SELECT DISTINCT
          A.TEAM_ID 팀코드, A.PLAYER_NAME 선수명, A.POSITION 포지션, 
           A.BACK_NO 백넘버, A.HEIGHT 키
 FROM PLAYER A
WHERE A.TEAM_ID = 'K02'
   AND EXISTS(SELECT 1
                             FROM PLAYER X
                             WHERE X.POSITION = 'GK'
                               AND X.PLAYER_ID = A.PLAYER_ID)
ORDER BY 1, 2, 3, 4, 5;

SELECT DISTINCT
          A.TEAM_ID 팀코드, A.PLAYER_NAME 선수명, A.POSITION 포지션, 
           A.BACK_NO 백넘버, A.HEIGHT 키
 FROM PLAYER A
WHERE A.TEAM_ID = 'K02'
   AND PLAYER_ID IN(SELECT PLAYER_ID
                                       FROM PLAYER 
                                      WHERE POSITION = 'GK')
ORDER BY 1, 2, 3, 4, 5;

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, 
           BACK_NO 백넘버, HEIGHT 키
 FROM PLAYER
WHERE TEAM_ID = 'K02'
   AND POSITION = 'GK'
ORDER BY 1, 2, 3, 4, 5;



--group by
SELECT       B.DNAME, A.JOB, COUNT(*) EMP_CNT, SUM(A.SAL) SAL_SUM
      FROM  EMP A, DEPT B
     WHERE  B.DEPTNO = A.DEPTNO
GROUP BY  B.DNAME, A.JOB;

SELECT       B.DNAME, A.JOB, COUNT(*) EMP_CNT, SUM(A.SAL) SAL_SUM
      FROM  EMP A, DEPT B
     WHERE  B.DEPTNO = A.DEPTNO
 GROUP BY ROLLUP (B.DNAME, A.JOB);
 ORDER BY B.DNAME, A.JOB;
 
SELECT B.DNAME, GROUPING(B.DNAME) AS DNAME_GRP,
               A.JOB, GROUPING(A.JOB) AS JOB_GRP,
               COUNT(*) EMP_CNT, SUM(A.SAL)  SAL_SUM
     FROM  EMP A, DEPT B
   WHERE  B.DEPTNO = A.DEPTNO
GROUP BY ROLLUP (B.DNAME, A.JOB)
ORDER BY B.DNAME, A.JOB;

SELECT CASE GROUPING(B.DNAME)
WHEN 1 THEN 'All Departments'
ELSE B.DNAME
END AS DNAME,
               CASE GROUPING(A.JOB)
WHEN 1 THEN 'All Jobs'
ELSE A.JOB
END AS JOB,
               COUNT(*) EMP_CNT, SUM(A.SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY ROLLUP (B.DNAME, A.JOB)
ORDER BY B.DNAME, A.JOB;

SELECT DECODE(GROUPING(B.DNAME), 1, 'All Departments', B.DNAME) AS DNAME, 
            DECODE(GROUPING(A.JOB),      1, 'All Jobs', A.JOB)      AS JOB, 
            COUNT(*) EMP_CNT, SUM(A.SAL)  SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY ROLLUP (B.DNAME, A.JOB)
ORDER BY B.DNAME, A.JOB;


SELECT CASE GROUPING(B.DNAME)
WHEN 1 THEN 'All Departments'
ELSE B.DNAME
END AS DNAME,
               CASE GROUPING(A.JOB)
WHEN 1 THEN 'All Jobs'
ELSE A.JOB
END AS JOB,
               COUNT(*) EMP_CNT, SUM(A.SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY B.DNAME, ROLLUP (A.JOB)
ORDER BY B.DNAME, A.JOB;

SELECT B.DNAME, A.JOB, A.MGR,
               COUNT(*) AS EMP_CNT, SUM(A.SAL) AS SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY ROLLUP (B.DNAME, (A.JOB, A.MGR))
ORDER BY B.DNAME, A.JOB, A.MGR;



--cube
SELECT CASE GROUPING(B.DNAME)
WHEN 1 THEN 'All Departments'
ELSE B.DNAME
END AS DNAME,
               CASE GROUPING(A.JOB)
WHEN 1 THEN 'All Jobs'
ELSE A.JOB
END AS JOB,
               COUNT(*) EMP_CNT, SUM(A.SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY CUBE(B.DNAME, A.JOB)
ORDER BY B.DNAME, A.JOB;

--union all로 표현
SELECT DNAME, JOB, 
                COUNT(*) EMP_CNT, SUM(SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY DNAME, JOB
UNION ALL
SELECT DNAME, 'All Jobs' AS JOB ,
                COUNT(*) EMP_CNT, SUM(SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY DNAME
UNION ALL
SELECT 'All Departments' AS DNAME, JOB,
                COUNT(*) EMP_CNT, SUM(SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY JOB
UNION ALL
SELECT 'All Departments' AS DNAME , 'All Jobs' AS JOB,
               COUNT(*) EMP_CNT, SUM(SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO ;


SELECT DNAME, 'All Jobs' JOB, 
               COUNT(*) EMP_CNT, SUM(SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY DNAME
UNION ALL
SELECT 'All Departments' AS DNAME, JOB,
                COUNT(*) EMP_CNT, SUM(SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY JOB;



--grouping set
SELECT DECODE( GROUPING(B.DNAME), 1, 'All Departments', B.DNAME) AS DNAME, 
               DECODE( GROUPING(A.JOB), 1, 'All Jobs', A.JOB) AS JOB,  
               COUNT(*) EMP_CNT, SUM(SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY GROUPING SETS (B.DNAME, A.JOB)
ORDER BY B.DNAME, A.JOB;

SELECT DECODE( GROUPING(B.DNAME), 1, 'All Departments', B.DNAME) AS DNAME, 
                DECODE( GROUPING(A.JOB), 1, 'All Jobs', A.JOB) AS JOB,  
                COUNT(*) EMP_CNT, SUM(SAL) SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY GROUPING SETS ( A.JOB, B.DNAME)
ORDER BY B.DNAME, A.JOB;

SELECT B.DNAME, A.JOB, A.MGR,
               COUNT(*) AS EMP_CNT, SUM(A.SAL) AS SAL_SUM
FROM EMP A, DEPT B
WHERE B.DEPTNO = A.DEPTNO
GROUP BY GROUPING SETS ((B.DNAME, A.JOB, A.MGR), (B.DNAME, A.JOB), (A.JOB, A.MGR));


--window 
--rank
SELECT JOB, ENAME, SAL,
             RANK( ) OVER (
ORDER BY SAL DESC) ALL_RANK,
             RANK( ) OVER (PARTITION BY JOB
ORDER BY SAL DESC) JOB_RANK
FROM EMP;

SELECT JOB, ENAME, SAL,
             RANK() OVER (PARTITION BY JOB
ORDER BY SAL DESC) JOB_RANK
FROM EMP;

--2,2면 다음이 3인 랭킹 dense rank
SELECT JOB, ENAME, SAL,
            RANK( ) OVER (
ORDER BY SAL DESC) AS RK ,
            DENSE_RANK( ) OVER (
ORDER BY SAL DESC) AS DK
FROM EMP;
   
--row number 동일해도 2,3으로 동등한 순위가 없음
  SELECT JOB, ENAME, SAL, 
            RANK( ) OVER (
ORDER BY SAL DESC) AS RK,
            ROW_NUMBER() OVER (
ORDER BY SAL DESC) AS RN
FROM EMP;
   
--partition by
SELECT MGR , ENAME , SAL ,
	sum(sal) OVER (PARTITION BY mgr) mgr_sum  
FROM EMP;

--DML
INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION, 
                              HEIGHT, WEIGHT, BACK_NO)
VALUES
('2002007', '박지성', 'K07', 'MF', 178, 73, 7);

SELECT *
FROM PLAYER
WHERE PLAYER_NAME = '박지성';

INSERT INTO PLAYER
VALUES
('2002010', '이청용', 'K07', '', 'BlueDragon', '2002', 'MF', 17, NULL, NULL, '1', 180, 69); 

SELECT *
FROM PLAYER
WHERE PLAYER_NAME = '이청용'; 


--values 안에 서브쿼리
INSERT INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID)
VALUES ((SELECT TO_CHAR(MAX(TO_NUMBER(PLAYER_ID)) + 1)
		FROM PLAYER), '홍길동', 'K06');
		
SELECT *
FROM PLAYER
WHERE PLAYER_NAME = '홍길동'; 


--서브쿼리 이용해서 team 테이블에 데이터 입력
INSERT INTO TEAM (team_id, REGION_NAME, TEAM_NAME, ORIG_YYYY, STADIUM_ID)
SELECT REPLACE (TEAM_ID, 'K','A') AS TEAM_ID,
	REGION_NAME , REGION_NAME ||'올스타' AS TEAM_NAME ,
	2019 AS ORIG_YYYY , STADIUM_ID 
	FROM TEAM
WHERE REGION_NAME in('성남', '인천');

  INSERT 
     INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION)
  SELECT 'A' || SUBSTR(PLAYER_ID, 2) AS PLAYER_ID , PLAYER_NAME,
              REPLACE(TEAM_ID, 'K', 'A') AS TEAM_ID, POSITION
FROM PLAYER
WHERE TEAM_ID IN ('K04', 'K08');


SELECT *
FROM team 
--WHERE TEAM_ID LIKE 'A%';
WHERE region_name IN ('성남', '인천');

SELECT *
FROM PLAYER 
WHERE team_ID in ('A04', 'A08', 'K04', 'K08');

SELECT *
FROM PLAYER p 
WHERE "POSITION" IS NULL;

UPDATE PLAYER 
SET "POSITION" = 'MF'
WHERE "POSITION" IS NULL;

 UPDATE TEAM A
SET
A.ADDRESS = ( SELECT X.ADDRESS
FROM STADIUM X
WHERE X.HOMETEAM_ID = A.TEAM_ID)
WHERE A.ORIG_YYYY > 2000;

UPDATE STADIUM A
SET
(A.DDD, A.TEL) = (SELECT X.DDD, X.TEL
FROM TEAM X
WHERE X.TEAM_ID = A.HOMETEAM_ID);

--MERGE 
MERGE
   INTO STADIUM T
	USING TEAM S
     ON
(T.HOMETEAM_ID = S.TEAM_ID )
WHEN MATCHED THEN
      UPDATE
SET
T.DDD = S.DDD,
                  T.TEL = S.TEL;
                  
--DELETE 
DELETE  PLAYER
 WHERE  POSITION = 'DF'
     AND  JOIN_YYYY < 2010;
     
DELETE PLAYER A
WHERE EXISTS (SELECT 1
FROM TEAM X
WHERE X.TEAM_ID = A.TEAM_ID
AND X.ORIG_YYYY < 1980);

SELECT COUNT(*) 
FROM PLAYER p 
WHERE TEAM_ID = 'K03';

SELECT team_id, COUNT(*)
FROM PLAYER p 
GROUP BY TEAM_ID
ORDER BY team_id;

 DELETE  PLAYER 
 WHERE  TEAM_ID IN (SELECT  TEAM_ID
                               FROM  PLAYER
                         GROUP BY TEAM_ID
                             HAVING COUNT(*) <= 10);   
                             
--MERGE 
CREATE TABLE TEAM_TMP AS
SELECT NVL(B.TEAM_ID, 'K' ||
           ROW_NUMBER() OVER (ORDER BY B.TEAM_ID, A.STADIUM_ID)) AS TEAM_ID
        ,  SUBSTR(A.STADIUM_NAME, 1, 2) AS REGION_NAME
        ,  SUBSTR(A.STADIUM_NAME, 1, 2) || NVL2(B.TEAM_NAME, 'FC', '시티즌') AS TEAM_NAME
        ,  A.STADIUM_ID, A.DDD, A.TEL
  FROM STADIUM A, TEAM B
 WHERE B.STADIUM_ID(+) = A.STADIUM_ID;
 
SELECT * FROM TEAM_TMP;


 MERGE 
   INTO TEAM T
 	USING TEAM_TMP S
     ON (T.TEAM_ID = S.TEAM_ID)
 WHEN MATCHED THEN
    UPDATE
       SET  T.REGION_NAME = S.REGION_NAME
        ,   T.TEAM_NAME = S.TEAM_NAME
        ,   T.DDD = S.DDD
        ,   T.TEL = S.TEL
 WHEN NOT MATCHED THEN
    INSERT (T.TEAM_ID, T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, T.DDD, T.TEL)
    VALUES (S.TEAM_ID, S.REGION_NAME, S.TEAM_NAME, S.STADIUM_ID, S.DDD, S.TEL);
    
 SELECT *
 FROM TEAM t ;
 

MERGE 
   INTO TEAM T
 USING (SELECT * FROM TEAM_TMP WHERE REGION_NAME IN ('성남','부산','대구','전주')) S
     ON (T.TEAM_ID = S.TEAM_ID)
 WHEN MATCHED THEN
    UPDATE
       SET  T.REGION_NAME = S.REGION_NAME
        ,   T.TEAM_NAME = S.TEAM_NAME
        ,   T.DDD = S.DDD
        ,   T.TEL = S.TEL
 WHEN NOT MATCHED THEN
    INSERT (T.TEAM_ID, T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, T.DDD, T.TEL)
    VALUES (S.TEAM_ID, S.REGION_NAME, S.TEAM_NAME, S.STADIUM_ID, S.DDD, S.TEL);
    
   MERGE 
   INTO TEAM T
 USING TEAM_TMP S
     ON (T.TEAM_ID = S.TEAM_ID)
 WHEN MATCHED THEN
    UPDATE
       SET  T.REGION_NAME = S.REGION_NAME
        ,   T.TEAM_NAME = S.TEAM_NAME
        ,   T.DDD = S.DDD
        ,   T.TEL = S.TEL ;
        
MERGE 
   INTO TEAM T
 USING TEAM_TMP S
     ON (T.TEAM_ID = S.TEAM_ID)
 WHEN NOT MATCHED THEN
    INSERT (T.TEAM_ID, T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, T.DDD, T.TEL)
    VALUES (S.TEAM_ID, S.REGION_NAME, S.TEAM_NAME, S.STADIUM_ID, S.DDD, S.TEL);
    
   INSERT 
       INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO)
    VALUES ('1997035', 'K02', '이운재', 'GK', 182, 82, 1);
    
    SELECT * FROM PLAYER WHERE PLAYER_NAME LIKE '이%';
    
   --rollback
  ROLLBACK;
  
 INSERT 
      INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO)
   VALUES ('1999035', 'K02', '이운재', 'GK', 182, 82, 1);
   
   SELECT * FROM PLAYER WHERE PLAYER_ID = '1999035';
   
  
  UPDATE PLAYER SET HEIGHT = 200;
  
 SELECT HEIGHT  FROM PLAYER;
 ROLLBACK;
 
--savepoint
SAVEPOINT SVPT1;

ROLLBACK TO SVPT1;

DELETE FROM PLAYER p 
WHERE PLAYER_NAME = '이운재';


SELECT HEIGHT FROM PLAYER; 

SAVEPOINT SVPT2;

UPDATE PLAYER SET HEIGHT = 200;

ROLLBACK TO SVPT2;


SAVEPOINT SVPT3;

DELETE FROM PLAYER;

SELECT * FROM PLAYER;

ROLLBACK TO SVPT3; --롤백이 완료되었다.

ROLLBACK; -- DELETE에 대한 저장점 롤백이 안될수 있다.

DELETE FROM PLAYER p 
WHERE PLAYER_NAME = '이운재';

SELECT * FROM PLAYER
WHERE PLAYER_NAME='이운재';

ROLLBACK;

SELECT COUNT(*) FROM PLAYER p ; 


--DDL
CREATE TABLE TEAM_TEMP AS SELECT * FROM TEAM
DESC TEAM_TEMP;

ALTER TABLE PLAYER DROP COLUMN ADDRESS;

DESC PLAYER;

--ALTER 
 ALTER TABLE TEAM
          MODIFY (ORIG_YYYY VARCHAR2(8) DEFAULT '20020129' NOT NULL);

         
ALTER TABLE PLAYER RENAME COLUMN PLAYER_ID TO TEMP_ID;

 ALTER TABLE PLAYER RENAME COLUMN TEMP_ID TO PLAYER_ID;  
 
SELECT *
FROM      ALL_CONSTRAINTS
WHERE TABLE_NAME = 'PLAYER';

--DROP constraint 제약조건 삭제
ALTER TABLE PLAYER DROP CONSTRAINT PLAYER_FK;

--제약조건 확인
SELECT * FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'PLAYER';

--제약조건 추가
ALTER TABLE PLAYER 
ADD CONSTRAINT PLAYER_FK FOREIGN KEY (TEAM_ID) 
REFERENCES TEAM(TEAM_ID); 

--외래키에 의해 참조되고 있으면 테이블이 삭제되지 않음
DROP TABLE TEAM;

INSERT 
      INTO TEAM( TEAM_ID, REGION_NAME, TEAM_NAME, STADIUM_ID)
   VALUES ('KK0', '대전', '시티즌', 'D02');
   
   INSERT 
      INTO PLAYER( PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO)
   VALUES ('2000000', 'KK0', '유동우', 'DF', 177, 70, 40 );
   
 COMMIT;
 
DELETE TEAM 
WHERE TEAM_ID='KK0';

--rename table
RENAME TEAM TO TEAM_BACKUP;

RENAME TEAM_BACKUP TO TEAM; 

COMMIT;

 DROP TABLE PLAYER;
 
ROLLBACK;

SELECT * FROM PLAYER p ;


--range unbounded preceding
SELECT MGR, ENAME, SAL,
           SUM(SAL) OVER (PARTITION BY MGR
ORDER BY SAL
                                  RANGE UNBOUNDED PRECEDING) AS MGR_SUM
FROM EMP ;
 

SELECT  MGR, ENAME, SAL 
  FROM (SELECT MGR, ENAME, SAL, 
	RANK () OVER (PARTITION BY MGR ORDER BY SAL DESC) AS SAL_RK 
	FROM EMP) 
 WHERE  SAL_RK = 1;

--min
SELECT   MGR, ENAME, HIREDATE, SAL,
             MIN(SAL) OVER(PARTITION BY MGR) AS MGR_MIN
  FROM   EMP;
  
--preceding, following, avg
 SELECT MGR, ENAME, HIREDATE, SAL, 
            ROUND (AVG(SAL) OVER (PARTITION BY MGR
ORDER BY HIREDATE 
ROWS BETWEEN 1 PRECEDING 
AND 1 FOLLOWING)) AS MGR_AVG
FROM EMP; 

--range between
SELECT ENAME, SAL, 
COUNT(*) OVER (ORDER BY SAL RANGE BETWEEN 50 PRECEDING 
AND 150 FOLLOWING) AS EMP_CNT
FROM EMP; 

--first value
SELECT  DEPTNO, ENAME, SAL, 
FIRST_VALUE(ENAME) OVER (PARTITION BY DEPTNO ORDER BY SAL DESC 
ROWS UNBOUNDED PRECEDING) AS ENAME_FV
FROM  EMP; 

SELECT  DEPTNO, ENAME, SAL, 
FIRST_VALUE(ENAME) OVER (PARTITION BY DEPTNO ORDER BY SAL DESC , ENAME
ROWS UNBOUNDED PRECEDING) AS ENAME_FV
 FROM  EMP; 
 
--last value
SELECT  DEPTNO, ENAME, SAL, 
LAST_VALUE(ENAME) OVER (PARTITION BY DEPTNO ORDER BY SAL DESC 
ROWS BETWEEN CURRENT ROW 
AND UNBOUNDED FOLLOWING) 
AS ENAME_LV 
FROM  EMP; 

--lag 앞의 값
SELECT  ENAME, HIREDATE, SAL, 
LAG(SAL) OVER (ORDER BY HIREDATE)  AS LAG_SAL 
FROM  EMP 
 WHERE  JOB = 'SALESMAN' ;

--lag(기준, 몇번째 앞, null일 경우 들어갈 값)
SELECT   ENAME, HIREDATE, SAL, 
LAG(SAL, 2, 0) OVER (ORDER BY HIREDATE) AS LAG_SAL
FROM  EMP 
WHERE   JOB = 'SALESMAN';

--lead 뒤의 값
SELECT ename, hiredate,
	lead(HIREDATE,1) over(ORDER BY HIREDATE) AS lead_hiredate
FROM emp
WHERE job = 'SALESMAN';

--ratio_to_report
SELECT  ENAME, SAL, 
ROUND(RATIO_TO_REPORT(SAL) OVER (), 2) AS SAL_RR 
FROM EMP
WHERE JOB = 'SALESMAN';

--percent_rank
SELECT  DEPTNO, ENAME, SAL, 
           PERCENT_RANK() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS PR
FROM   EMP;

--cume_dist
SELECT  DEPTNO, ENAME, SAL, 
           CUME_DIST() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS CD
FROM  EMP;

--ntile
SELECT ENAME, SAL, 
          NTILE(4) OVER (ORDER BY SAL DESC) AS NT
 FROM EMP;