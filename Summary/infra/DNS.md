# DNS

Domain Name Service

- Domain - 인터넷 사이트 접속 시 맨 앞의 주소 
  ex) naver.com
- Nameserver - Client가 도메인에 접근했으 때 도메인 주소와 아이피 맵핑에 대한 정보를 가지고 있다가 이를 알려주는 서버(이런 맵핑 데이터를 DNS Zone file로 가지고 있다)
- 인터닉(InterNIC) - 보통 도메인을 구매하려고 할 때 cafe24, aws등을 선택하는데 이런 회사들을 도메인 대행사라 하고 도메인 대행사는 인터닉으로부터 도메인을 제공(등록)받음. 루트에 해당

DNS 방식 이전에는 local에 zone file을 저장(Local DNS, local name server, ***Recursive DNS(Resolver)***)하여 해커들이 파일을 수정하여 계정 정보 등을 수신받을 수 있다는 문제가 발생하여 DNS로 변경

인터넷 연결 속도를 빠르게 하기 위해 이미 질의했던 도메인의 경우 root에게 ip를 질의하지 않고 바로 com에게 도메인의 ip를 질의하는 **캐싱(Caching)** 방식을 사용한다.