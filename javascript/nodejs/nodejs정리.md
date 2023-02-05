# NodeJS

https://edu.goorm.io/learn/lecture/332/todo-앱을-직접-만들면서-배우는-node-js-express-bootstrap-jquery/lesson/10134/누구를-위한-실습인가

https://github.com/Jayde-Im/nodejs-todo-list

---

## 웹 어플리케이션의 구조

1. public : 정적 리소스
   1. images : 이미지
   2. javascript : 프론트엔드 자바스크립트
   3. stylesheets : css
2. views : 탬플릿(페이지)
3. routes : 요청을 처리하는 핸들러
4. node_modules : Node.js 확장 모듈
5. app.js : 메인 웹 서버

---

## 라우팅 정의

라우팅 핸들러는 routes 디렉토리의 하위에 정의

---

## 파일

fs 모듈 필요

fs.exists : 존재 여부 확인

fs.readFile : 파일 읽기

fs.writeFile : 파일 쓰기

---

## CSS

.ejs 를 사용

ejs는 <%= %> 를 통해 변수를 사용할 수 있음

---

## 선택자

- $('.class') 혹은 $('#id')를 주로 쓸 것으로 보임

- $('.class').click(function(){}) 은 원래 존재하던 객체의 경우만 할당할 수 있음.
  동적으로 생성되는 객체의 경우 ***$('.class').on('click', element, function)***을 사용한다.
  on이 선택 요소에 이벤트를 바인딩하는 역할을 함.
- $(element).parent() 선택 요소의 부모 요소
- $(element).siblings(element) 선택 요소와 같은 레벨에 있는 요소들 가져옴(형제)

---

## 미들웨어 레벨

1. 애플리케이션 레벨과 라우터 레벨로 나뉘어 애플리케이션 -> 라우터 단계로 실행.
2. 둘은 실행단계의 차이지 기능적으론 같음
3. 애플리케이션 분기 + 라우터 분기로 더 세세하게 요청 URL을 분리하여 제어가 가능



### **애플리케이션** 단계의 URL 제어

```javascript
var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

app.use('/', indexRouter);
app.use('/users', usersRouter);
```

위의 경우 **애플리케이션** 단계에서 '/'와 '/users'로 분리하여 처리하도록 설계

---

### **라우터** 단계의 URL 제어

```javascript
var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  console.log('originalUrl : '+req.originalUrl);
  console.log('baseUrl : '+req.baseUrl);
  console.log('path : '+req.path);
  res.send('respond with a resource');
});

router.get('/user', function(req, res, next) {
  console.log('originalUrl : '+req.originalUrl);
  console.log('baseUrl : '+req.baseUrl);
  console.log('path : '+req.path);
  res.send('respond with a resource');
});

module.exports = router;
```

이것이 **라우터** 단계의 미들웨어

둘 다 use()와 METHOD() 사용 가능

---

### use와 method의 차이점

use()는 모든 method에서 동작하고

METHOD()는 지정된 요청(GET, POST, PUT, DELETE)에서만 동작



같이 사용될 경우

```javascript
app.use(cookieParser());
app.use('/users', usersRouter);
.
.
.

router.get('/', function(req, res, next) {
  console.log('originalUrl : '+req.originalUrl);
  console.log('baseUrl : '+req.baseUrl);
  console.log('path : '+req.path);
  res.send('respond with a resource');
});

router.get('/user', function(req, res, next) {
  console.log('originalUrl : '+req.originalUrl);
  console.log('baseUrl : '+req.baseUrl);
  console.log('path : '+req.path);
  res.send('respond with a resource');
});
```

baseUrl - 애플리케이션 레벨에 등록된 URL 위의 경우 
cookieParser는 등록된 것이 없기 때문에 비어있고
userRouter는 /users가 출력됨

path - 라우터 레벨에 등록된 URL
cookieParser는 /users/user
userRouter는 /user가 출력



METHOD()를 사용할 경우 next를 사용할 수 있음(다음 함수를 건너뛰는 것으로 보임)