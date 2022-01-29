# ROOM

-----

## ROOM이란

데이터베이스의 데이터를 Java or Kotlin 객체로 매핑해주는 ORM 라이브러리이다.

ORM(Object Relational Mapping)이란?

- 객체 지향 프로그래밍은 클래스를 사용하고, 관계형 데이터베이스는 테이블을 사용하기 때문에 객체 모델과 관계형 모델 간에 불일치가 존재한다.
- ORM을 통해 객체 간의 관계를 바탕으로 SQL을 자동으로 생성하여 불일치를 해결한다.

ROOM은 SQLite에 대한 추상 레이어를 제공하여 SQLite의 모든 기능을 제공하면서 편한 데이터베이스의 접근을 허용한다.
Google은 SQLite 대신 ROOM의 사용을 권고한다.

----

## SQLite vs ROOM

- SQLite는 쿼리에 대한 에러를 컴파일 타임에 확인할 수 없지만 ROOM 은 컴파일 타임에 SQL 에 대한 유효성을 검사 할 수 있다.
- SQLite는 schema가 변경 될 경우 SQL 쿼리를 수동으로 업데이트 해야하지만 ROOM 은 쉽게 해결이 가능하다.
- SQLite는 java 데이터 객체를 변경하기 위해 많은 boilerplate code 를 사용해야 하지만 ROOM 은 boilerplate code 없이 매핑 가능하다.
  (Boilerplate code : 수정하지 않거나 최소한의 수정만을 거쳐 여러곳에 필수적으로 사용되는 코드)
- ROOM 은 LiveData 와 RxJava 를 위한 Observation 으로 생성하여 동작할 수 있지만 SQLite 는 할 수 없다.
  (LiveData : 관찰 가능한 데이터 홀더 클래스, 다른 관찰 가능한 일반 클래스와 달리 수명 주기를 인식한다. LiveData는 활성상태(active = started + resumed 상태)일 때 데이터를 업데이트 함. Android JetPack 라이브러리의 하나의 기능.
  RxJava : 자바로 리액티브 프로그래밍을 할 수 있는 라이브러리 비동기, 함수형 프로그래밍 기법을 함께 활용. 비동기에서 처리하기 힘든 에러 처리나 데이터 가공을 쉽게 할 수 있게 도와주기도 함. 이벤트를 콜백이 아닌 데이터 모음으로 모델링하기 때문에)

---

## ROOM 구성요소

- Database
  데이터베이스의 holder를 구성하며 지속적인 관계형 데이터의 기본 연결을 위한 access point 역할
  	`@Database` 
  		RoomDatabse를 extends 하는 abstract class여야 함
  		Annotation 내에 entities를 포함해야 함
  		클래스 내부에 인수가 0개인 @Dao annotation이 지정된 클래스를 반환하는 abstract class를 포함 `public abstract dao UserDao();`

- Entity
  Entity file은 class의 변수들이 column이 되어 database의 table이 된다.

  ​	`@Entity(tableName = StudentEntry.TABLE_NAME)` Table 이름을 선언(기본적으로 entity class 이름을 database table 이름으로 인식)
  ​	`@PrimaryKey`
  ​	`@ColumnInfo` Table 내 column을 변수와 매칭

  ​		`@ColumnInfo(name = StudentEntry.GRADE)`

  ​		`private int grade;`

- DAO(Data Access Objects)
  DAO는 database에 접근할 수 있는 메소드를 포함하며 SQL 쿼리를 지정할 수 있다.

  ​	`@Insert`
  ​		@Entity로 정의된 class만 인자로 받거나, 그 class의 collection 또는 array만 인자로 받을 수 있다.
  ​		인자가 하나인 경우 long type의 return(insert된 row id)을 받을 수 있고, 여러 개인 경우 long[], List를 받을 수 있다.

  ​	`@Update`
  ​		return 값으로 업데이트된 행 수를 받을 수 있다.

  ​	`@Delete`
  ​		return 값으로 삭제된 행 수를 받을 수 있다.

  ​	`@Query`
  ​		DB를 조회할 수 있다.
  ​		Complie time에 return 되는 object의 field와 sql결과로 나오는 column의 이름이 맞는지 확인하여 일부가 match되면 warning, match 되는 게 없다면 error를 보냄