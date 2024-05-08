브라우저 검색창에 도메인 이름을 입력하면 네임서버를 통해 ip주소로 변환됩니다.

우리는 보통 localhost나 127.0.0.1을 통해 개발 서버로 접속합니다. 
'localhost'도 네임서버를 통해 ip 주소로 변환되는걸까요? 아닙니다.

ubuntu의 경우 /etc/hosts 파일을 우선 참고하여 도메인 이름을 ip 주소로 변경합니다.

```vi

##
# Host Database
#
# localhost is used to configure the loopback interface
# when the system is booting.  Do not change this entry.
##
127.0.0.1	localhost
255.255.255.255	broadcasthost
::1             localhost

```
맥의 경우 위와 같은 파일을 기본으로 가지고 있습니다.

우측의 도메인 네임을 좌측의 ip 주소로 변경하여 접근하는 것이죠.

보통은 바로 적용되지만, 적용이 안될 때 아래의 방법을 적용해 볼 수 있습니다.

network 데몬을 재실행하는 방법입니다.
`sudo /etc/init.d/networking restart`
