# lpad 쿼리문(자릿수 채우는 쿼리)

```sql
select lpad(ifnull(count(distinc id)+1, 1), '2'자릿수, '0'비어있을 경우 채울 문자) from table where date = #{date}
```

비슷한 기능으로 rpad가 있음

lpad는 왼쪽으로 자릿수를 채우는 것이고 rpad는 오른쪽으로 자릿수를 채우는 쿼리.