# [Apache] 아파치 HTTPD Server v2.4.54 설치 (Source Compile)

## **1. configure 작업 시 필요한 유틸리티 설치**

1. **C 및 C++ Compiler 설치**

   - Source Compile을 진행하기 위해서는 gcc Compiler가 필요하다.

   ```bash
   sudo apt install gcc 
   sudo apt install g++
   #sudo yum install -y gcc 
   #sudo yum install -y gcc-c++
   
   # 한 줄에 한번에 설치
   sudo apt install gcc g++
   #sudo yum install -y gcc gcc-c++
   ```

2. **XML parser 라이브러리 설치**

   - Apache 2.4를 설치하기 위해서는 apr, apr-util, pcre 패키지를 설치해야 한다.
   - 이 패키지들을 설치하기 위해서는 XML parser 라이브러리를 설치해야 한다.

   ```bash
   sudo apt install expat
   sudo apt-get install libexpat1-dev
   sudo apt install expat-static
   #sudo yum -y install expat
   #sudo yum -y install expat-devel
   #sudo yum -y install expat-static
   
   # 한줄에 한번에 설치
   #sudo yum install -y expat expat-devel expat-static
   ```

3.  **PCRE 설치**

   - PCRE( Perl Compatible Regular Expressions )는 펄 호환 정규 표현식으로서, 정규식 패턴 일치를 구현하는 함수의 집합
   - 최근 Apache, PHP, KDE 등을 포함한 오프 소스 프로젝트에서 사용되고 있으며, 아파치 2.4 버전을 설치할 때는 pcre를 설치해야 한다.

   >  💡 **apr (Apache Portable Runtime ) , apr-util** 💡
   > \- 아파치 2.0을 설치할 때는 yum으로 apr, apri-util을 설치하지 않았음
   > \- 아파치 2.4 이상에서는 apr, apr-util이 없기 때문에 별도로 설치해야 함.

   ```bash
   # /tmp/lib 디렉토리 이동 웹에서 필요파일 다운로드
   mkdir /server/src
   cd /server/src
   
   # 아파치 공식홈페이지를 통한 다운로드 & 압축해제
   # https://www.pcre.org/
   wget https://sourceforge.net/projects/pcre/files/pcre/8.45/pcre-8.45.tar.gz/download
   tar xvfz download
   ```

## 2. apache 설치

```bash
# Apache 설치 & 압축해제
wget https://dlcdn.apache.org//httpd/httpd-2.4.52.tar.gz
tar xvfz httpd-2.4.52.tar.gz

# APR 설치 & 압축해제
wget https://mirror.navercorp.com/apache//apr/apr-1.7.0.tar.gz
tar xvfz apr-1.7.0.tar.gz

# APR-util 설치 & 압축해제
wget https://mirror.navercorp.com/apache//apr/apr-util-1.6.1.tar.gz
tar xvfz apr-util-1.6.1.tar.gz

# /tmp/lib 내용 확인
[root@bastion lib]# ls
apr-1.7.0  apr-1.7.0.tar.gz  apr-util-1.6.1  apr-util-1.6.1.tar.gz  download  httpd-2.4.51  httpd-2.4.51.tar.gz  pcre-8.45
```

### 2-1. APR 설치

```bash
# APR 설치
cd /server/src/apr-1.7.0

# 절대경로 지정
# ./configure = 설치를 위한 환경 설정 | --prefix = 절대경로 --with 라이브러리 참조
./configure --prefix=/server/apr-1.7.0 

# 설치
make && make install
```

> 💡 **make & make install**
> make = configure에 의해 만들어진 makefile로 프로그램 컴파일 
> make install = 컴파일된 프로그램, 환경파일, 데이터 파일을 지정된 위치에 복사하는 과정

### 2-2. APR-UTIL 설치

```bash
# APR-UTIL 경로 이동
cd /server/src/apr-util-1.6.1

# 반드시 --with 뒤에 내가 설치한 APR 버전을 넣는다
./configure --prefix=/server/apr-util-1.6.1 --with-apr=/server/apr-1.7.0

# 설치
make && make install
```

### 2-3. PCRE 설치

```bash
cd /server/src/pcre-8.45

# 반드시 --with 뒤에 내가 설치한 APR 버전을 넣는다
./configure --prefix=/server/pcre-8.45 \
--with-apr-util=/server/apr-util-1.6.1 \
--with-apr=/server/apr-1.7.0

# 설치
make && make install
```

### 2-4. Apache(httpd) 설치

```bash
# 압축해제한 httpd 디렉토리 이동
cd /server/src/httpd-2.4.54/

# 절대경로 지정
./configure --prefix=/server/httpd2.4.54 \
--enable-modules=most --enable-mods-shared=all --enable-so \
--with-apr=/server/apr-1.7.0 \
--with-apr-util=/server/apr-util-1.6.1 \
--with-pcre=/server/pcre-8.45/bin/pcre-config

# 설치
make && make install

# 서버 이름 설정
vim /usr/local/apache2.4/conf/httpd.conf

#'ServerName 127.0.0.1:80' 추가
```

> 💡 **ServerName**
>
> 서버의 자신의 도메인 명을 적는 부분이다. 처음 설치 시 기본적으로 주석처리가 되어 있으며 도메인이 없으면 IP 주소를 적는다.
>
> 💡 **Proxy 연동시 ServerName & <Directory>반드시 설정**
>
> - Require all granted: 무조건 허용
> - Require all denied: 무조건 금지
> - Require ip 10 172.20 192.168.2: 특정 아이피만 접근 허용.
>   (여기서는 10, 172.20, 192.168.2로 시작하는 아이피 세 개를 허용한다는 의미)

## 3. 실행

```bash
sudo chown root:ubuntu ./bin/httpd
sudo ./bin/apachectl start

sudo su
netstat -tulpn | grep httpd

curl localhost
결과 : <html><body><h1>It works!</h1></body></html>
```

참고 : https://anggeum.tistory.com/entry/Apache-HTTP-Server-v24-설치-Source-Compile
