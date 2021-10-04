CREATE TABLE memo ( 
  memono    NUMBER(7)       NOT NULL,   -- 글 일련 번호, -9999999 ~ +9999999 
  wname   VARCHAR(20)    NOT NULL,   -- 글쓴이 
  title        VARCHAR(100)  NOT NULL,   -- 제목(*) 
  content   VARCHAR(4000) NOT NULL,  -- 글 내용 
  passwd   VARCHAR(15)     NOT NULL,  -- 비밀 번호 
  viewcnt   NUMBER(5)       DEFAULT 0,  -- 조회수, 기본값 사용 
  wdate     DATE               NOT NULL,  -- 등록 날짜, sysdate 
  PRIMARY KEY (no)  
); 

INSERT INTO memo(memono, wname, title, content, passwd, wdate)
values((SELECT nvl(max(no)) +1 FROM memo), 
'홍길동', '오늘의 일정', '2시 점심약속', '1234', sysdate)