# git

분산 버전 관리 시스템 그 자체

- 코드의 히스토리(버전)를 관리하는 도구
- 개발되어온 과정 파악 가능
- 이전 버전과의 변경 사항 비교 및 분석



## GitHub

git 기반의 저장소 서비스



## Terminal

| cd    | 디렉토리로 이동                  |
| ----- | -------------------------------- |
| cd .. | 상위 폴더로 이동                 |
| cd ~  | 홈 디렉토리로 이동               |
|       |                                  |
| ls    | 현재 위치의 파일, 폴더 목록 출력 |
|       |                                  |
| mkdir | 폴더 생성                        |
| touch | 파일 생성                        |
| rm    | 파일 삭제하기                    |
| rm -r | 폴더와 그 안에 있는거까지 삭제   |



## Commit

- working directory - 내가 작업하고 있는 실제 디렉토리, git add로 스테이징 할 수 있음
- staging area - git commit 으로 아래의 reposity로 이동
- repository

라는 3가지 영역을 바탕으로 작동

| git init      | .git 만들며 git repository 생성  |
| ------------- | -------------------------------- |
| git add .     | 폴더 내의 모든 파일 add          |
| git commit -m | 커밋 실행하며 메시지를 같이 보냄 |



## git 기본 설정

| git config --global user.name "user_name"  | 이름 설정   |
| ------------------------------------------ | ----------- |
| git config --global user.email "user_name" | 이메일 설정 |



## status

| git status | 깃의 상태를 알 수 있음 |
| ---------- | ---------------------- |



## git log

| git log  | 깃의 수정사항과 메시지 등을 볼 수 있다.         |
| -------- | ----------------------------------------------- |
| git diff | 두 commit간 차이를 출력함 뒤의 주소가 기준이 됨 |



## git remote repo

| git remote add origin {깃 레포지토리 주소} | 깃허브 연결                                     |
| ------------------------------------------ | ----------------------------------------------- |
| git push -u origin master                  | 로컬 저장소의 데이터를 리모트 저장소로 보내기   |
| git pull origin master                     | 리모트 저장소로부터 데이터를 로컬 저장소로 받기 |



## git clone

| git clone {remote repo}   | 리모트 레포지토리에서 복제해옴. 복제해오기 때문에 이미 연결되어있다는 장점이 있음 |
| ------------------------- | ------------------------------------------------------------ |
| git clone {remote repo} . | 현재 위치에 clone 진행                                       |



## git restore

| git restore --staged {file name} | add된 staged 파일을 되돌림       |
| -------------------------------- | -------------------------------- |
| git restore {file name}          | 이전에 커밋한 파일 상태로 되돌림 |



## git reset

| git reset --hard {c_id} | working directory를 과거의 특정 커밋의 내용과 똑같게 만듬 |
| ----------------------- | --------------------------------------------------------- |
| --soft                  | HEAD가 과거의 특정 커밋을 가리키도록 함                   |
| --mix                   | staging area를 과거의 특정 커밋의 내용과 똑같게 함        |



## git ignore

| 위치         | .git이 있는 폴더에 .gitignore 생성 |
| ------------ | ---------------------------------- |
| 특정 파일 명 | 특정파일 무시                      |
| 특정폴더/    | 특정폴더 무시                      |
| *.png        | 특정 확장자 무시                   |
| !profile.png | Profile.png는 무시하지 않기        |



## git branch

| git branch {branch_name}      | 브랜치 생성         |
| ----------------------------- | ------------------- |
| git checkout {branch_name}    | 브랜치 이동         |
| git checkout -b {branch_name} | 브랜치 생성 및 이동 |
| git branch                    | 브랜치 목록 출력    |
| git branch -d {branch_name}   | 브랜치 삭제         |



## git merge

| git merge {branch_name} | 합칠 곳에서 입력하면 브랜치가 합쳐지고 기준이 되는 브랜치로부터 단발적인 변화만 있다면 fast forward로 충돌이 나지 않고 합쳐진다. |
| ----------------------- | ------------------------------------------------------------ |



## git pull request

branch를 만들어서 깃허브에 push하면 pull request를 보낼 수 있고 open이라고 함. 다 pull해서 마스터에 push 하면 close 상태가 되고 마스터와 합쳐진 상태가 됨
