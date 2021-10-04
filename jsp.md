# jsp

헷갈리는 부분 다시 체크

----

## useBean과 import의 차이

### import

- import는 클래스 패스 내에 존재하는 클래스를 참조하기 위해 선언해주는 것
- import 시 클래스를 선언하거나 패키지를 선언해서 패키지 내의 모든 클래스를 참조할 수 있게 함

### useBean

- useBean은 해당 bean을 사용하겠다는 것
- 자바 개발 시 `Map map = new Map();` 과 동일한 효과
- scope를 지정하여 bean의 범위를 조정할 수 있다.
- useBean이라는 태그를 사용하면 scope를 나타내는 객체에서 useBean에 선언된 객체가 있다면 그것을 찾아오고 없다면 기본 생성자로 객체를 생성하는 역할

| scope       | 범위                                                         |
| ----------- | ------------------------------------------------------------ |
| application | 사이트 전체에서 사용                                         |
| session     | 세션의 지속시간과 동일                                       |
| request     | 폼 값 등의 변수를 전달받았을 경우 사용<br />다른 페이지로 forword 했을 때 같은 request를 사용할 수 있다. |
| page        | 현 페이지에서만 사용<br />다른 페이지로 forword 했을 때 이전 페이지의 값을 사용할 수 없다. |



## useBean 사용

```jsp
<%@ page import="model.Product" %>
<%
	request.setCharacterEncoding("utf-8");
	String bit = request.getParameter("bit");
	String brand = request.getParameter("brand");
	String core = request.getParameter("core");
	String etc = request.getParameter("etc");
	String filepath = request.getParameter("filepath");

	Prodect prod = new Product();
	prod.setBit(bit);
	prod.setBrand(brand);
	prod.setCore(core);
	prod.setEtc(etc);
	prod.setFilePath(filepath);
%>
```

위의 코드를 useBean으로 하면 훨씬 간결한 코드를 얻을 수 있음. 위 아래 코드는 같은 기능을 가짐.

```jsp
<jsp:useBean class="model.Product" id="cpu" scope="request"/>
<jsp:setProperty name="cpu" property="*" />
```

----

```jsp
<%@ page import="model.Product" %>
<% Prodect prod = (Product) session.getAttribute("product");%>
Bit:<%=product.getBit() %>
Brand:<%=product.getBrand() %>
Core:<%=product.getCore() %>
```

useBean 사용 코드

```jsp
<jsp:useBean id="product" class="model.Product" scope="request"/>
Bit:<jsp:getProperty name="product" property="bit"/>
Brand:<jsp:getProperty name="product" property="brand"/>
Core:<jsp:getProperty name="product" property="core"/>
```

