# INNER JOIN vs OUTER JOIN

INNER JOIN 의 경우 교집합. O(n)

OUTER JOIN 의 경우 아래와 같음. O(n^2)

![img](JOIN%20:%20UNION.assets/img.png)

# UNION vs UNION ALL

둘의 차이는 UNION ALL의 경우 중복을 고려하지 않고 전부 나온다. UNION은 중복행이 있건 없건 중복검사를 수행하기 때문에 UNION ALL이 훨씬 빠르다.