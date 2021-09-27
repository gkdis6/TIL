## XMLHttpRequest 객체의 속성

- onreadystatechange - 응답이 도착하면 특정 자바스크립트 함수를 호출해서 결과의 알맞은 작업을 합니다. 그때 사용할 자바스크립트 함수(callback 함수)를 지정합니다. 
  
- readyState - XMLHttpRequest 객체의 요청에 대한 상태를 숫자로 표시 이상태의 변화(로딩중, 처리중, 처리완료)가 있을때마다 XMLHttpRequest 객체의 onreadystatechange속성에 설정된 callback함수가 호출됩니다.
  
- status - XMLHttpRequest객체는 웹서버가 전달한  http 상태코드를 status 속성에 저장합니다.
  
- responseText/responseXml - 응답의 결과값(텍스트/ XML DOM)을 참조하기 위해서 사용합니다. 

javascript 사용 시. vanila javascript가 요즘 실무에서 우세하기 때문에 유용하다.

----

## XMLHttpRequest의 객체 생성



```html
let xhttp;
if (window.XMLHttpRequest){
	xhttp = new XMLHttpRequest();
	}else{
	//code for IE6, IE5
	xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}
```

