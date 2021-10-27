DROP TABLE ondo;
CREATE TABLE ondo(
  ondono NUMBER(8)    NOT NULL PRIMARY KEY, -- 온도 번호
  kit    VARCHAR(32)  NOT NULL, -- 수집기 키트명
  ondo   NUMBER(3, 1) NOT NULL, -- 온도, 정수 2자리, 소수 1자리, 소수자리 반올리됨.
  rdate  DATE         NOT NULL -- 등록일
);

DROP SEQUENCE ondo_seq;
 
CREATE SEQUENCE ondo_seq 
  START WITH 1           -- 시작 번호
  INCREMENT BY 1       -- 증가값
  MAXVALUE 99999999  -- 최대값: 99999999 --> NUMBER(8) 대응
  CACHE 2                  -- 2번은 메모리에서만 계산
  NOCYCLE;                 -- 다시 1부터 생성되는 것을 방지
  
 
INSERT INTO ondo(ondono, kit, ondo, rdate)
VALUES(ondo_seq.nextval, 'amk1', 25.0, sysdate);
INSERT INTO ondo(ondono, kit, ondo, rdate)
VALUES(ondo_seq.nextval, 'amk1', 15.5, sysdate);
INSERT INTO ondo(ondono, kit, ondo, rdate)
VALUES(ondo_seq.nextval, 'amk1', 15.55, sysdate);
INSERT INTO ondo(ondono, kit, ondo, rdate)
VALUES(ondo_seq.nextval, 'amk1', -15.55, sysdate);
 
SELECT ondono, kit, ondo, TO_CHAR(rdate, 'yyyy-mm-dd hh:mi:ss') as rdate 
FROM ondo 
ORDER BY ondono ASC;
commit;
 
-- ERROR: ORA-01438: 이 열에 대해 지정된 전체 자릿수보다 큰 값이 허용됩니다.
INSERT INTO ondo(ondono, kit, ondo, rdate)
VALUES(ondo_seq.nextval, 'amk1', -150.55, sysdate);
 
-- 목록
SELECT ondono, kit, ondo, TO_CHAR(rdate, 'yyyy-mm-dd hh:mi:ss') as rdate 
FROM ondo 
ORDER BY ondono ASC;
 
-- 조회
SELECT ondono, kit, ondo, TO_CHAR(rdate, 'yyyy-mm-dd hh:mi:ss') as rdate 
FROM ondo 
WHERE ondono=2;
         
-- 수정
UPDATE ondo
SET kit='amk2', ondo=20.0, rdate=sysdate
WHERE ondono=1;
 
SELECT ondono, kit, ondo, TO_CHAR(rdate, 'yyyy-mm-dd hh:mi:ss') as rdate 
FROM ondo 
WHERE ondono=1;
         
-- 삭제
DELETE FROM ondo
WHERE ondono=1;
 
SELECT ondono, kit, ondo, TO_CHAR(rdate, 'yyyy-mm-dd hh:mi:ss') as rdate 
FROM ondo 
ORDER BY ondono ASC;
commit;
 
-- 30개만 출력
SELECT ondono, kit, ondo, rdate, r
FROM (
      SELECT ondono, kit, ondo, rdate, rownum as r
      FROM (
            SELECT ondono, kit, ondo, TO_CHAR(rdate, 'yyyy-mm-dd hh:mi:ss') as rdate 
            FROM ondo 
            ORDER BY ondono ASC
      )       
)
WHERE r >= 1 AND r <= 30;
