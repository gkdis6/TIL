# Route 53

AWS에서 제공하는 DNS(Domain Name Service)

## 일반 DNS

DNS 동작 과정은 도메인을 IP로 변환하여 IP 네트워크 통신하여 목적지 IP를 찾아가는 과정

![img](https://img1.daumcdn.net/thumb/R1280x0.fpng/?fname=http://t1.daumcdn.net/brunch/service/user/uSr/image/UXLCp2SuWs0md98zJWQgcEPQ-ms.png)

mattzip.com 도메인 등록 시 , 등록 대행기관에 네임서버를 ns1.mattzip.com , ns2.mattzip.com 등으로 등록한다.

## 일반 DNS와 다른 점

- Route 53에서 네임서버 등록 시 순서가 다르다.
  일반적으로 도메인 등록 시에 네임 서버를 지정
  Route 53에서는 할당 받은 후, 네임 서버 정보를 도메인 등록대행기관(가비아, 아이네임즈, 후이즈) 사이트에 접속해 네임서버를 지정
  Route 53은 사이트에서 NS레코더 정보를 확인하고 해당 정보를 도메인 등록 대행기관에 네임서버 정보로 입력한다.
  ![img](https://img1.daumcdn.net/thumb/R1280x0.fpng/?fname=http://t1.daumcdn.net/brunch/service/user/uSr/image/CBBBX1NhBjfZC5sVVMRPhQiB654.png)
  1. Create Hosted Zone 클릭하여 생성하면,  4개의 NS레코더가 생성되고 이 NS레코더들이 네임서버가 된다.
  2. Roue 53은 Public Host zone과 Private Host zone이 있다.
     Public Host zone은 일반 네임서버로 글로벌하게 동작하고 Private Host zone은 AWS내에서만 동작한다.
  3. Roue 53 특이 레코더,  ALIAS(별칭)가 있다.
     dns-book.com 이라는 도메인 자체에 대한 ALIAS Target을  www로 줄 수 있다.
     dns-book.com과 www.dns-book.com에 같은 IP로 응답 주는 것이 가능하다는 것이다.

## Route 53 기능

Route53 = DNS(네임서버) + 모니터링 + L4 + GSLB  기능을 제공한다.

1. 모니터링 기능
   특정 포트에 대해 모니터링
   ![img](https://img1.daumcdn.net/thumb/R1280x0.fpng/?fname=http://t1.daumcdn.net/brunch/service/user/uSr/image/zPI85qte13dC5N16Pmnz4oGXh34.png)

2. L4 기능 -> Failover 기능
   네트워크 장비 넷스케일러, 파운드리, 파이오링크와 같이 Failover 기능이 있다.

3. GSLB 기능

   GSLB은 Global Server Load Balancing으로  지역에 상관없이 부하를 분산해주는 기능을 제공한다.
   특정 IDC에 의존적이지 않게, 지역과 나라에 무관하게 Load Balancing 가능하다.

## 주사용처

S3, ELB, CloudFront, Elastic Beanstalk

## 장점

1. ~~GUI를 제공~~
2. 네임서버 자체 안정성이 높아짐
   Anycast network + 4개의 네임서버 + ddos로부터 안전 = 가용성 100% 제공
3. 글로벌 서비스가 가능해진다.
   GSLB를 이용한 속도 개선이 가능