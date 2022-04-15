# room 사용 예

## 검색 시 null 체크

값이 들어오지 않더라도 정상적으로 값이 출력됨
여러 파라미터를 동시에 넣어 합쳐 리스트 출력 쿼리와 검색 쿼리를 하나의 function만을 사용하여 표현할 수 있다.(효율성은 체크하지 못함)

```kotlin
@Query("select * from table_name "+
"where 1=1 "+
"and (:param_1 is null or name like '%' || :param_1 || '%' ")
fun searchName(param : String?)
```

