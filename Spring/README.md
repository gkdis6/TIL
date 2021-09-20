# spring framework

- 스프링 수업 전 예습을 위한 공부를 정리하는 자료

--------

## framework란?

1. **자주 사용하는 기능**을 클래스나 인터페이스  등으로 미리 만들어 제공
2. 개발자는 이를 자신의 상황에 맞게 변형 및 추가해서 사용하는 것
3. 개인마다 다른 개발방식을 따르는 것이 아닌 일정한 틀에 맞춰 개발하기 때문에 유지보수 및 기능의 확정성에서 좀 더 쉽게 보편적으로 적용할 수 있다는 장점이 생김

-----

## 스프링의 특징

1. **EJB**(Enterprise JavaBeans)보다 가볍고 배우기 쉬우며 경량 컨테이너의 기능을 수행
2. **제어 역행**(**IoC**, Inversion of Control)기술을 이용해 사용자가 제어하지 않고 특별한 객체에 위임
3. **의존성 주입**(**DI**, Dependecy Injection)기능을 지원
4. **관점지향**(**AOP**, Aspect-Oriented Programming)기능을 이용해 중복된 코드를 줄여 자원관리와 재활용성 극대화
5. 영속성과 관련된 다양한 서비스를 지원
6. 수많은 라이브러리와의 연동 기능을 지원
7. **POJO**(Plain Old Java Object)방식의 프레임워크
8. model은 view와 controller의 어떠한 정보도 가지고 있어선 안된다.
9. view는 model이 가지고 있는 정보를 저장해선 안되고 model, controller의 구성요소를 알아선 안된다.
10. controller는 model과 view의 정보에 대해 알고있어야 한다.

---

## 스프링의 주요 기능

| 스프링 기능 | 설명                                                         |
| ----------- | ------------------------------------------------------------ |
| Core        | 다른 기능과 설정을 분리하기 위한 IoC 기능을 제공, Bean Factory Container로 IoC패턴을 적용하여 객체 구성부터 의존성 처리까지 모든 일을 처리하는 역할 |
| Context     | 스프링의 기본 기능으로서 애플리케이션의 각 기능을 하는 빈(Bean)에 대한 접근 방법을 제공, context 정보들을 제공하는 설정 파일. JNDI, EJB, Validation, Scheduiling, Internalization 등 엔터프라이즈 서비스들을 포함 |
| DAO         | Database Data에 접근하는 객체로 JDBC 기능의 추상 레이어를 지원하여 코딩이나 예외처리 부분을 간편화시켜 좀 더 쉽고 일관된 방법으로 코드르 짤 수 있게 도와줌 |
| ORM         | Object Relational Mapping으로 객체와의 관계를 설정하는 것. Hibernate, Ibatis, JDO, MyBatis 같은 영속성 관련 프레임워크와 연동된 기능을 제공 |
| AOP         | 관점 지향 기능을 제공하는 Module                             |
| Web         | Web context module은 Application module에 내장되어 있고 web 기반의 응용프로그램에 대한 context를 제공하여 일반적인 웹 애플리케이션 개발에 필요한 기능을 제공. Jakarta Structs와의 통합을 지원 |
| WebMVC      | 스프링에서 MVC 구현에 관련된 기능을 제공                     |



---

## 의존성 주입하기



### 의존성을 주입하는 이유

- 필요에 따라 클래스의 기능을 변경하거나 다른 클래스의 기능으로 대체해야 하는 경우가 생기는데 이것을



