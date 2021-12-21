# HTTP

- Hyper Text Tranfer Protocol - Hyper Text를 전송하기 위해 만든 프로토콜
- HTTP는 클라이언트(웹 브라우저)와 서버 사이의 요청/응답 프로토콜입니다.
- 웹상에서 통신을 할 때 사용됩니다.

약점

- 암호화하지 않은 통신이기 때문에 도청할 수 있다.
- 통신 상대를 확인하지 않기 때문에 위장할 수 있다.
- 완전성을 증명할 수 없기 때문에 변조할 수 있다.

![스크린샷 2021-12-06 오전 10.03.19](/Users/sangyongpark/Library/Application%20Support/typora-user-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-12-06%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2010.03.19.png)

# HTTPS

HTTP에 SSL(혹은 TLS) 보안 프로토콜을 조합한 것

SSL을 사용하면 암호화를 할 수 있고, 통신 상대를 보증할 수 있다.

CA(Certificate Authority)를 통해 SSL보증서를 발급받을 수 있다. https://letsencrypt.org