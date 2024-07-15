## 가공하기

전체 요소 중에서 다음과 같은 API 를 이용해서 내가 원하는 것만 뽑아낼 수 있습니다. 이러한 가공 단계를 중간 작업(_intermediate operations_)이라고 하는데, 이러한 작업은 스트림을 리턴하기 때문에 여러 작업을 이어 붙여서(_chaining_) 작성할 수 있습니다.

`List<String> names = Arrays.asList("Eric", "Elena", "Java");`
아래 나오는 예제 코드는 위와 같은 리스트를 대상으로 합니다.

### Filtering

필터(_filter_)은 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업입니다. 인자로 받는 Predicate 는 boolean 을 리턴하는 함수형 인터페이스로 평가식이 들어가게 됩니다.
`Stream<T> filter(Predicate<? super T> predicate);`

```java
Stream<String> stream =   
  names.stream()  
  .filter(name -> name.contains("a"));  
```
스트림의 각 요소에 대해서 평가식을 실행하게 되고 ‘_a_’ 가 들어간 이름만 들어간 스트림이 리턴됩니다.

### Mapping

맵(_map_)은 스트림 내 요소들을 하나씩 특정 값으로 변환해줍니다. 이 때 값을 변환하기 위한 람다를 인자로 받습니다.
`<R> Stream<R> map(Function<? super T, ? extends R> mapper);`

스트림에 들어가 있는 값이 input 이 되어서 특정 로직을 거친 후 output 이 되어 (리턴되는) 새로운 스트림에 담기게 됩니다. 이러한 작업을 맵핑(_mapping_)이라고 합니다.

```java
Stream<String> stream =   
  names.stream()  
  .map(String::toUpperCase);  
  
Stream<Integer> stream =   
  productList.stream()  
  .map(Product::getAmount);  
  //요소 내 들어있는 Product 개체의 수량을 꺼내올 수도 있다.
```

`map` 이외에도 조금 더 복잡한 `flatMap` 메소드도 있습니다.
`<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);`

인자로 `mapper`를 받고 있는데, 리턴 타입이 Stream 입니다. 즉, 새로운 스트림을 생성해서 리턴하는 람다를 넘겨야합니다. `flatMap` 은 중첩 구조를 한 단계 제거하고 단일 컬렉션으로 만들어주는 역할을 합니다. 이러한 작업을 플래트닝(_flattening_)이라고 합니다.

```java
List<List<String>> list =   
  Arrays.asList(Arrays.asList("a"),   
                Arrays.asList("b"));  

List<String> flatList =   
  list.stream()  
  .flatMap(Collection::stream)  
  .collect(Collectors.toList());  

//객체
students.stream()  
  .flatMapToInt(student ->   
                IntStream.of(student.getKor(),   
                             student.getEng(),   
                             student.getMath()))  
  .average().ifPresent(avg ->   
                       System.out.println(Math.round(avg * 10)/10.0));
```

위 예제에서는 학생 객체를 가진 스트림에서 학생의 국영수 점수를 뽑아 새로운 스트림을 만들어 평균을 구하는 코드입니다. 이는 `map` 메소드 자체만으로는 한번에 할 수 없는 기능입니다.

### Sorting

정렬의 방법은 다른 정렬과 마찬가지로 Comparator 를 이용합니다.

```java
Stream<T> sorted();  
Stream<T> sorted(Comparator<? super T> comparator);
```

```java
IntStream.of(14, 11, 20, 39, 23)  
  .sorted() //인자 없이 호출 시 오름차순
  .boxed()  
  .collect(Collectors.toList());  
```

```java
List<String> lang =   
  Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");  
  
lang.stream()  
  .sorted()  
  .collect(Collectors.toList());  
  
lang.stream()  
  .sorted(Comparator.reverseOrder()) //역순 정렬
  .collect(Collectors.toList());  
```

Comparator 의 `compare` 메소드는 두 인자를 비교해서 값을 리턴합니다.

`int compare(T o1, T o2)`

기본적으로 Comparator 사용법과 동일합니다. 이를 이용해서 문자열 길이를 기준으로 정렬해보겠습니다.

```java
lang.stream()  
  .sorted(Comparator.comparingInt(String::length))  
  .collect(Collectors.toList());  

lang.stream()  
  .sorted((s1, s2) -> s2.length() - s1.length()) //이 방법이 제일 쓰기 쉬운 것 같다.
  .collect(Collectors.toList());  
```

### Iterating

스트림 내 요소들 각각을 대상으로 특정 연산을 수행하는 메소드로는 `peek` 이 있습니다. ‘_peek_’ 은 그냥 확인해본다는 단어 뜻처럼 특정 결과를 반환하지 않는 함수형 인터페이스 Consumer 를 인자로 받습니다.

`Stream<T> peek(Consumer<? super T> action);`

따라서 스트림 내 요소들 각각에 특정 작업을 수행할 뿐 결과에 영향을 미치지 않습니다. 다음처럼 작업을 처리하는 중간에 결과를 확인해볼 때 사용할 수 있습니다.

```java
int sum = IntStream.of(1, 3, 5, 7, 9)  
  .peek(System.out::println)  
  .sum();
```