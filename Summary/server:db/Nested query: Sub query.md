# Nested query / Sub query

중첩 질의(Nested query)는 SQL문 안에 또 다른 SQL문을 포함하는 구조
데이터의 중복성과 종속성을 최소화하기 위해 데이터를 여러 테이블에 분산 저장하고 분산된 데이터를 조회하기 위해 여러 테이블에 select문을 수행해야 하는 단점이 생겨 이러한 단점을 극복하기 위해 사용되는 방법 중 하나. 다른 하나는 조인 연산.

내가 알고 있던 개념으로는 서브쿼리.

- SELECT(스칼라 서브쿼리), FROM(인라인 뷰) ,WHERE, HAVING 절에 모두 올 수 있다
- 모든 서브쿼리는 괄호()를 가져야 한다
- 메인 쿼리와 항상 '연산'해야 한다

상관 서브쿼리를 제외하고 메인 쿼리보다 먼저 실행됨

서브쿼리의 개수가 많은 SQL을 Optimizer가 잘못된 Cost 계산으로 비효율적인 실행계획이 수립되어, DB 서버의 성능에 악영향을 미치는 경우가 있을 수 있어 주의해야함

## 사용패턴

1. SELECT * FROM emp WHERE sal > (SELECT AVG(sal) FROM emp)
   이 경우 서브쿼리가 먼저 실행된 후 메인 쿼리가 수행되는 형태.
   서브쿼리의 추출 결과가 반드시 1건이어야 오류가 발생하지 않음.

2. SELECT c1, c2, c3 FROM SUBQUERY_T2 t2 WHERE c2= 'A' AND EXISTS ( SELECT /*+ NO_UNNEST */ 'x' FROM SUBQUERY_T1 t1 WHERE t1.c5 = t2.c2 )

   EXISTS나 IN 연산자 (또는 NOT EXISTS, NOT IN)를 사용한 경우로 서브 쿼리의 결과가 여러건 추출될 수 있다.
   서브쿼리 내에 Main SQL과 연결 조건인 T1.C5 = T2.C2가 존재(EXISTS, NOT EXISTS의 경우)하여, Main SQL에서 추출한 값을 상속 받아 서브쿼리의 테이블에 해당 값이 존재하는지 체크하는 방식으로 수행.
   반대로 서브쿼리가 먼저 수행되고 Main SQL에 값을 전달할 수도 있다.

실제 서브쿼리 사용시 성능 문제를 발생시키는 대부분의 유형은 2번과 같은 형태

서브쿼리에서 추출되는 데이터가 중복 값이 많더라도 Unique 값만 처리하므로, 서브쿼리를 조인으로 변경하는 SQL 작성시 서브쿼리의 중복된 데이터는 제거된다는 특성을 가지고 있다.

## 동작방식

서브쿼리의 동작방식은 크게 Filter 동작방식과 조인 동작방식으로 나눌 수 있다.

1. Filter 동작방식은 Main SQL에서 추출된 데이터 건수만큼 서브쿼리가 반복적으로 수행되며 처리되는 방식입니다. 즉, Main SQL의 추출 결과에 대해서, 매 로우마다 서브쿼리에 조인연결 값(이하 Input값)을 제공한 후 수행해 보고, 결과가 TRUE일 경우 데이터를 추출합니다.

   예를 들어, Main SQL의 추출 결과가 100만건이라면 서브쿼리는 최대 100만번 수행됩니다. 그러나 Main SQL의 추출 결과가 많더라도 서브쿼리의 Input 값이 모두 동일하다면, 마치 Main SQL에서 1건만 추출한 것과 같이 1번만 수행하기 때문에 성능 문제가 발생하지 않습니다.

   반면에, MainSQL의 추출건수가 2건인 경우 Filter 동작방식으로 처리 된다면, 서브쿼리는 최대 2번만 수행하면 됩니다. 게다가 서브쿼리의 조인 연결 컬럼으로 구성된 Unique Index가 존재한다면, 매우 효율적인 처리를 할 수 있을 것입니다.

2. 조인 동작방식을 Filter 동작방식과 비교했을 때 가장 큰 차이점은 가변성

   앞서 알아본 Filter 동작방식은 수행 순서나 수행 방법이 고정되어, 다양한 상황에 유연한 대처가 어려운 반면, 조인 동작방식은 Nested Loops Joins, Hash Join, Sort Merge Join, Semi Join, Anti Join 등의 다양한 조인 방법 중 유리한 것을 선택할 수 있으며, Semi / Anti / Join을 제외하고 수행 순서까지 선택할 수 있어 보다 유연한 처리가 가능합니다.

   그러나 조인 동작방식 중에 Nested Loops Join Semi를 제외한 나머지 조인 방법은 Filter 동작방식이 가지고 있는 FILTER 오퍼레이션 효과에 의한 이득을 얻지 못합니다.

   




