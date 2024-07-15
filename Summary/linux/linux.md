```vi
:set number (라인수 보이게하기)
/ (뒤로 검색)
? (앞으로 검색)
gg (제일 아래로)
GG (제일 위로)
dd (라인 삭제 후 normal 모드, 잘라내기)
cc (라인 삭제 후 insert 모드, 잘라내기)
```

```vi
#비쥬얼모드
v (비쥬얼 모드, charater 기반 선택)
ctrl+v (비쥬얼 블럭모드, 직사각형으로 선택)
shift+v (비쥬얼 라인모드, 라인 전체를 선택)

d(자르기)
y(복사)
p(붙여넣기)
```

```linux
grep

tail -1000f | grep -A -B ''
tail -n 100 | grep -A -B ''

!${명령어} 직전 명령어로 시작하는 명령어 실행
```

```find
#find 표현식
name
type(d : 디렉토리, f : 일반 파일, l : 심볼릭 링크)
user(소유권)
empty(빈 디렉토리 or 빈 파일)
size(b : 블록단위, c : byte, k : kb, w : 2byte 워드)
delete(검색된 파일 삭제)
exec(검색된 파일 실행, -exec 뒤의 명령어 실행.'find . -type f -exec grep ".jsp" {} \;')
path(지정된 문자열 패턴에 해당하는 경로에서 검색)
print(검색 결과 출력, 기본값)
print0(검색 결과 출력, 검색 항목 null로 구분)
mindepth(디렉토리 최소 깊이 지정)
maxdepth(디렉토리 최대 깊이 지정)
atime(n일 이내에 액세스된 파일을 찾음)
ctime(n일 이내에 만들어진 파일을 찾음)
mtime(n일 이내에 수정된 파일을 찾음)
cnewer file(해당 파일보다 최근에 수정된 파일을 찾음)
```


```
sftp 계정@ip
비밀번호 입력
!(로컬 명령어)
put ${파일명} (파일 넣기)
```