# Spring framework

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

.xml파일을 이용해 참조, 값 입력, 의존관계의 빈을 속성에 주입하여 빈의 기능을 사용할 수 있다. 아직 덜 이해된 부분으로 더 자세한 학습 필요

### 의존성을 주입하는 이유

- 필요에 따라 클래스의 기능을 변경하거나 다른 클래스의 기능으로 대체해야 하는 경우가 생기는데 이것을 하나하나 확인하며 수정하는 것은 비효율적이고 실수가 발생할 확률이 높음.
- 프로젝트의 규모가 커진다면 모든 코드를 수정하는 것은 거의 불가능한 영역까지 도달함
- 의존성을 주입하면 클래스들 간의 의존관계를 최소화하여 코드를 단순화 할 수 있음
- 애플리케이션을 더 쉽게 유지 및 관리할 수 있음
- 객체의 생성, 소멸과 객체 간의 의존 관계를 컨테이너가 제어

---

## AOP관련 용어

| 용어      | 설명                                                         |
| --------- | ------------------------------------------------------------ |
| aspect    | 구현하고자 하는 보조 기능                                    |
| advice    | aspect의 실제 구현체(클래스)를 의미. 메서드 호출을 기준으로 여러 지점에서 실행. |
| joinpoint | advice를 적용하는 지점. 스프링은 method 결합점만 제공.       |
| pointcut  | advice가 적용되는 대상을 지정. 패키지이름/클래스이름/메서드이름을 정규식으로 지정하여 사용. |
| target    | advice가 적용되는 클래스                                     |
| weaving   | advice를 주기능에 적용하는 것                                |

----

## 스프링 API를 이용한 AOP 기능 구현 과정

- 스프링 프레임워크에서 제공하는 API를 이용하는 방법

> 1. Target 클래스를 지정
> 2. Advice 클래스를 지정
> 3. 설정 파일에서 Pointcut을 설정
> 4. 설정 파일에서 Advice와 Pointcut을 결합하는 Advisor를 설정
> 5. 설정 파일에서 스프링의 ProxyFactoryBean 클래스를 이용해 Target에 Advice를 설정
> 6. getBean() 메서드로 빈 객체에 접근해 사용

| 인터페이스           | 추상 메서드                                                  | 설명                                         |
| -------------------- | ------------------------------------------------------------ | -------------------------------------------- |
| MethodBeforeAdvice   | Void before(Method method,<br />Object[] args,<br />Object target)<br />throws Throwable | 해당 메서드가 실행되기 전 실행               |
| AfterReturningAdvice | Void afterReturning(<br />Object returnValue,<br />Method method,<br />Object[] args,<br />Object target)<br />throws Throwable | 해당 메서드가 실행된 후 실행                 |
| ThrowsAdvice         | Void afterThrowing(<br />Method method,<br />Object[] args,<br />Object target,<br />Exception ex) | 해당 메서드에서 예외 발생 시 실행            |
| MethodInterceptor    | Object invoke(<br />MethodInvocation<br />invocation)<br />throws Throwable | 해당 메서드의 실행 전/후와 예외 발생 시 실행 |



- @Aspect 애너테이션을 이용하는 방법

---

# Spring MVC

## MVC 특징

- 모델2 아키텍쳐를 지원
- 스프링과 다른 모듈과의 연계가 쉽다
- tiles나 sitemesh 같은 View 기술과의 연계가 쉽다
- 태크 라이브러리를 통해 message 출력, theme 적용 그리고 입력 폼을 보다 쉽게 구현 가능

----

## MVC 구성 요소

| 구성 요소         | 설명                                                         |
| ----------------- | ------------------------------------------------------------ |
| DispatcherServlet | 클라이언트의 요청을 전달받아 해당 요청에 대한 컨트롤러를 선택하여 클라이언트의 요청을 전달. 또한 컨트롤러가 반환한 값을 View에 전달하여 알맞은 응답을 생성 |
| HandlerMapping    | 클라이언트가 요청한 URL을 처리할 컨트롤러를 지정             |
| Controller        | 클라이언트의 요청을 처리한 후 그 결과를 DispatcherServlet에 전달 |
| ModelAndView      | 컨트롤러가 처리한 결과 및 뷰 선택에 필요한 정보를 저장       |
| ViewResolver      | 컨트롤러의 처리 결과를 전달할 뷰를 지정                      |
| View              | 컨트롤러의 처리 결과 화면을 생성                             |

---

## MVC 기능 수행 과정

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FQBJhP%2Fbtqw9NWXUND%2F6LqFMZKPhk2BQxcQ3yZGKK%2Fimg.png)

1. 브라우저가 DispatcherServlet에 URL로 접근하여 해당 정보를 요청
2. 핸들러 매핑에서 해당 요청에 대해 매핑된 컨트롤러가 있는지 요청
3. 매핑된 컨트롤러에 대해 처리를 요청
4. 컨트롤러가 클라이언트의 요청을 처리한 결과와 View 이름을 ModelAndView에 저장해서 DispatcherServlet으로 반환
5. DispatcherServlet에서는 컨트롤러에서 보내온 View 이름을 ViewResolver로 보내 해당 View를 요청
6. ViewResolver는 요청한 View를 보냄
7. View의 처리 결과를 DispatcherServlet으로 보냄
8. DispatcherServlet은 최종 결과를 브라우저로 전송

----

# 애너테이션

| 브라우저 URL 요청 처리 애너테이션 관련 클래스 | 기능                                   |
| --------------------------------------------- | -------------------------------------- |
| DefaultAnnotationHandlerMapping               | 클래스 레벨에서 @RequestMapping을 처리 |
| AnnotationMethodHandlerAdapter                | 메서드 레벨에서 @RequestMapping을 처리 |



| 스테레오 타입 에너테이션 | 기능                                                         |
| ------------------------ | ------------------------------------------------------------ |
| @Controller              | 스프링 컨테이너가 component-scan에 의해 지정한 클래스를 컨트롤러 빈으로 자동 변환 |
| @Service                 | 스프링 컨테이너가 component-scan에 의해 지정한 클래스를 서비스 빈으로 자동 변환 |
| @Repository              | 스프링 컨테이너가 component-scan에 의해 지정한 클래스를 DAO빈으로 자동 변환 |
| @Component               | 스프링 컨테이너가 component-scan에 의해 지정한 클래스를 빈으로 자동 변환 |



@Autowired



# Spring Boot

Spring Boot는 Spring framework보다 의존성 관리가 용이할 뿐만 아니라 배포 또는 테스트 역시 Spring Framework보다 쉽게 빠르게 할 수 있다. Spring Boot로 개발하면 메이븐의 라이브러리 자동 업데이트 기능을 이어받을 수 있을 뿐만 아니라 기존 스프링 프레임워크의 복잡한 설정 과정을 최대한 줄일 수 있어 편리하다. 즉, 일반 응용 프로그램처럼 웹 애플리케이션을 개발할 수 있다. 현재는 STS4를 사용한다.

## Spring Boot 특징

- 일반적인 응용 프로그램을 단독으로 실행하는 수준으로 스프링 애플리케이션을 구현할 수 있다.
- 프로젝트 환경을 구축할 때 필요한 톰캣, Jetty, UnderFlow 같은 서버 외적인 툴이 내장되어 있어 따로 설치할 필요가 없다.
- XML 기반 설정이나 코드 없이 환경 설정을 자동화 할 수 있다.
- 의존성 관리를 쉽게 자동으로 할 수 있다.
- 화면 기능은 간결하게 구현하면서 스프링과 더 빠르고 쉽게 연동할 수 있는 기능을 제공하는 thymeleaf가 표준

# 비동기

backend

```java
@PostMapping(value = "/", produces = "application/json")
	@ResponseBody
	public Map<String,String> login(@RequestBody UserDTO dto, HttpServletRequest request) throws IOException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", (String)dto.getId());
		map.put("password", (String)dto.getPassword());
		int pcnt = service.login(map);

		System.out.println("id : " +map.get("id") + " password : " + map.get("password") +" pcnt : " + pcnt);
		
		return map;
	}
```

frontend

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <title>Company</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  </head>
  <body>
    <form method="post">
      <input class="login" id="id" name="id">
      <button type="button" id="login">login</button>
    </form>
  </body>
  <script type="text/javascript">
	$('#login_btn').on('click',function(){
		let form = {
			id : $('#id').val(),
			password : $('#password').val()
		};
		alert(form.id+":"+form.password);
		$.ajax({
			url : "./",
			type : "POST",
			data : JSON.stringify(form),
			contentType : "application/json; charset=utf-8;",
			dataType : 'json',
			success : function(data){
				alert("Data: "+data.id+"님 login ok Status : success");
			},
			error : function(request, status, error){
				alert("code = "+request.status+" message = "+request.responseText+" error = "+error);
			}
		});
	});//버튼 클릭 이벤트
	</script>
</html>
  
  var cal=function(value){
	console.log("값변경 : "+ value);
	$("#totall").text(value*${dto.price});
	$("#total").val(value*${dto.price});
	
  }
```



