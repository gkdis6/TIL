# Apache vs Tomcat

## Apache

흔히 아파치라고 부르는 것은 **Apache HTTP Server**를 의미하는데 이는 오픈 소스 소프트웨어 그룹인 아파치 소프트웨어 재단(ASF)에서 만든 웹서버 프로그램이다.

> **웹서버**
>
> 웹서버는 하드웨어와 소프트웨어에서 다른 의미로 부른다.
>
> 1. 하드웨어
>    웹 서버 소프트웨어와 웹 사이트의 구성 요소 파일을 저정하는 컴퓨터
>    (예 : HTML 문서, 이미지, CSS 스타일 시트 및 JavaScript파일)
>
> 2. 소프트웨어
>    보통 HTTP 서버를 의미
>    HTTP 서버는 URL(웹주소) 및 HTTP(프로토콜 주소)를 이애하는 소프트웨어
>    HTTP 서버는 저장하는 웹 사이트의 도메인 이름을 통해 액세스 할 수 있으며 이러한 호스팅 된 웹사이트의 콘텐츠를 최종 사용자의 장치로 전달.
>
>    브라우저에 웹 서버에서 호스팅되는 파일이 필요할 때마다 브라우저는 HTTP를 통해 파일을 요청.
>    요청이 올바른 웹서버(하드웨어)에 도달하면 HTTP서버(소프트웨어)가 요청을 수락하고 요청된 문서를 찾은 다음에 HTTP를 통해 브라우저로 다시 보냄
>    (서버가 요청된 문서를 찾지 못하면 대신 404 응답을 반환)
>
> 결국 아파치 서버란 클라이언트에서 요청하는 HTTP 요청을 처리하는 웹서버
> **이는 정적타입(HTML, CSS, 이미지 등)의 데이터만을 처리하기 때문에 Tomcat이란 것이 등장했다.**

## Tomcat

톰캣 WAS(Web Application Server) : 컨테이너, 웹 컨테이너, 서블릿 컨테이너로도 불림
