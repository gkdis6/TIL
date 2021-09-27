## JSON VS XML Example

JSON Example

```
{"employees":[
    {"firstName":"John", "lastName":"Doe"},
    {"firstName":"Anna", "lastName":"Smith"},
    {"firstName":"Peter", "lastName":"Jones"}
]}
```

XML Example
```
<employees>
    <employee>
        <firstName>John</firstName> <lastName>Doe</lastName>
    </employee>
    <employee>
        <firstName>Anna</firstName> <lastName>Smith</lastName>
    </employee>
    <employee>
        <firstName>Peter</firstName> <lastName>Jones</lastName>
    </employee>
</employees>
```
---


## 직렬화 
직렬화 Object -> JSON
- 클라이언트에서 서버로 객체를 전송할때는 JSON의 문자열로 변환해서 보낸다 
- stringify(obj)

역직렬화 JSON -> Object
- 클라이언트가 서버로부터 JSON의 문자열 데이터를 받아서 객체로 변환해서 사용한다.
- parse(json)