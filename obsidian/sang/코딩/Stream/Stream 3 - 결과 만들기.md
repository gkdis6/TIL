## 결과 만들기

가공한 스트림을 가지고 내가 사용할 결과값으로 만들어내는 단계입니다. 따라서 스트림을 끝내는 최종 작업(_terminal operations_)입니다.

### Calculating

스트림 API 는 다양한 종료 작업을 제공합니다. 최소, 최대, 합, 평균 등 기본형 타입으로 결과를 만들어낼 수 있습니다.

```java
long count = IntStream.of(1, 3, 5, 7, 9).count();  
long sum = LongStream.of(1, 3, 5, 7, 9).sum();  
```

만약 스트림이 비어 있는 경우 `count` 와 `sum` 은 0을 출력하면 됩니다. 하지만 평균, 최소, 최대의 경우에는 표현할 수가 없기 때문에 [Optional](https://futurecreator.github.io/2018/08/14/java-8-optional/) 을 이용해 리턴합니다.

```java
OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();  
OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();  
```

스트림에서 바로 `ifPresent` 메소드를 이용해서 Optional 을 처리할 수 있습니다.

```java
DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)  
  .average()  
  .ifPresent(System.out::println);  
```

이 외에도 사용자가 원하는대로 결과를 만들어내기 위해 `reduce` 와 `collect` 메소드를 제공합니다. 이 두 가지 메소드를 좀 더 알아보겠습니다.

>- isPresent, ifPresent
>1. isPresent
>   Boolean 타입으로 Optional 객체가 값을 가지고 있다면 true, 없으면 false를 리턴
>   `Optional<User> user = userRepository.findByEmail(email);`
>   `if(user.isPresent()) System.out.println("이미 존재하는 이메일입니다.");`
>   
>2. ifPresent
>   Void 타입으로 Optional 객체가 값을 가지고 있으면 실행하고 없으면 넘어간다.
>   `userRepository.findById(id).ifPresent(a -> { throw new Exception("이미 존재합니다.") });`


### Reduction

스트림은 `reduce`라는 메소드를 이용해서 결과를 만들어냅니다. 스트림에 있는 여러 요소의 총합을 낼 수도 있습니다.

다음은 `reduce` 메소드는 총 세 가지의 파라미터를 받을 수 있습니다.

-   accumulator : 각 요소를 처리하는 계산 로직. 각 요소가 올 때마다 중간 결과를 생성하는 로직.
-   identity : 계산을 위한 초기값으로 스트림이 비어서 계산할 내용이 없더라도 이 값은 리턴.
-   combiner : 병렬(_parallel_) 스트림에서 나눠 계산한 결과를 하나로 합치는 동작하는 로직.

```java
// 1개 (accumulator)  
Optional<T> reduce(BinaryOperator<T> accumulator);  
  
// 2개 (identity)  
T reduce(T identity, BinaryOperator<T> accumulator);  
  
// 3개 (combiner)  
<U> U reduce(U identity,  
  BiFunction<U, ? super T, U> accumulator,  
  BinaryOperator<U> combiner);  
```

먼저 인자가 하나만 있는 경우입니다. 여기서 `BinaryOperator<T>` 는 같은 타입의 인자 두 개를 받아 같은 타입의 결과를 반환하는 함수형 인터페이스입니다. 다음 예제에서는 두 값을 더하는 람다를 넘겨주고 있습니다. 따라서 결과는 6(_1 + 2 + 3_)이 됩니다.

```java
OptionalInt reduced =   
  IntStream.range(1, 4) // [1, 2, 3]  
  .reduce((a, b) -> {  
    return Integer.sum(a, b);  
  });  
```

이번엔 두 개의 인자를 받는 경우입니다. 여기서 10은 초기값이고, 스트림 내 값을 더해서 결과는 16(_10 + 1 + 2 + 3_)이 됩니다. 여기서 람다는 [메소드 참조](https://futurecreator.github.io/2018/08/02/java-lambda-method-references/)(_method reference_)를 이용해서 넘길 수 있습니다.

```java
int reducedTwoParams =   
  IntStream.range(1, 4) // [1, 2, 3]  
  .reduce(10, Integer::sum); // method reference  
```

마지막으로 세 개의 인자를 받는 경우입니다. Combiner 가 하는 역할을 설명만 봤을 때는 잘 이해가 안갈 수 있는데요, 코드를 한번 살펴봅시다. 그런데 다음 코드를 실행해보면 이상하게 마지막 인자인 combiner 는 실행되지 않습니다.

```java
Integer reducedParams = Stream.of(1, 2, 3)  
  .reduce(10, // identity  
          Integer::sum, // accumulator  
          (a, b) -> {  
            System.out.println("combiner was called");  
            return a + b;  
          });  
```

Combiner 는 병렬 처리 시 각자 다른 쓰레드에서 실행한 결과를 마지막에 합치는 단계입니다. 따라서 병렬 스트림에서만 동작합니다.

```java
Integer reducedParallel = Arrays.asList(1, 2, 3)  
  .parallelStream()  
  .reduce(10,  
          Integer::sum,  
          (a, b) -> {  
            System.out.println("combiner was called");  
            return a + b;  
          });  
```

결과는 다음과 같이 36이 나옵니다. 먼저 accumulator 는 총 세 번 동작합니다. 초기값 10에 각 스트림 값을 더한 세 개의 값(_10 + 1 = 11, 10 + 2 = 12, 10 + 3 = 13_)을 계산합니다. Combiner 는 identity 와 accumulator 를 가지고 여러 쓰레드에서 나눠 계산한 결과를 합치는 역할입니다. 12 + 13 = 25, 25 + 11 = 36 이렇게 두 번 호출됩니다.

```java
combiner was called  
combiner was called  
36  
```

병렬 스트림이 무조건 시퀀셜보다 좋은 것은 아닙니다. 오히려 간단한 경우에는 이렇게 부가적인 처리가 필요하기 때문에 오히려 느릴 수도 있습니다.

### Collecting

`collect` 메소드는 또 다른 종료 작업입니다. `Collector` 타입의 인자를 받아서 처리를 하는데요, 자주 사용하는 작업은 `Collectors` 객체에서 제공하고 있습니다.

이번 예제에서는 다음과 같은 간단한 리스트를 사용합니다. Product 객체는 수량(_amout_)과 이름(_name_)을 가지고 있습니다.

```java
List<Product> productList =   
  Arrays.asList(new Product(23, "potatoes"),  
                new Product(14, "orange"),  
                new Product(13, "lemon"),  
                new Product(23, "bread"),  
                new Product(13, "sugar"));  
```

#### _Collectors.toList()_

스트림에서 작업한 결과를 담은 리스트로 반환합니다. 다음 예제에서는 `map` 으로 각 요소의 이름을 가져온 후 `Collectors.toList` 를 이용해서 리스트로 결과를 가져옵니다.

```java
List<String> collectorCollection =  
  productList.stream()  
    .map(Product::getName)  
    .collect(Collectors.toList());  
// [potatoes, orange, lemon, bread, sugar]  
```

#### _Collectors.joining()_

스트림에서 작업한 결과를 하나의 스트링으로 이어 붙일 수 있습니다.

```java
String listToString =   
 productList.stream()  
  .map(Product::getName)  
  .collect(Collectors.joining());  
// potatoesorangelemonbreadsugar  
```

`Collectors.joining` 은 세 개의 인자를 받을 수 있습니다. 이를 이용하면 간단하게 스트링을 조합할 수 있습니다.

-   delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자. 보통 ", " 사용
-   prefix : 결과 맨 앞에 붙는 문자. [], {}, (), <> 등등 
-   suffix : 결과 맨 뒤에 붙는 문자.

```java
String listToString =   
 productList.stream()  
  .map(Product::getName)  
  .collect(Collectors.joining(", ", "<", ">"));  
// <potatoes, orange, lemon, bread, sugar>  
```

#### _Collectors.averageingInt()_

숫자 값(_Integer value_ )의 평균(_arithmetic mean_)을 냅니다.

```java
Double averageAmount =   
 productList.stream()  
  .collect(Collectors.averagingInt(Product::getAmount));  
// 17.2  
```


#### _Collectors.summingInt()_

숫자값의 합(_sum_)을 냅니다.

```java
Integer summingAmount =   
 productList.stream()  
  .collect(Collectors.summingInt(Product::getAmount));  
// 86 
```

IntStream 으로 바꿔주는 `mapToInt` 메소드를 사용해서 좀 더 간단하게 표현할 수 있습니다.

```java
Integer summingAmount =   
  productList.stream()  
  .mapToInt(Product::getAmount)  
  .sum(); // 86  
```

#### _Collectors.summarizingInt()_

만약 합계와 평균 모두 필요하다면 스트림을 두 번 생성해야 할까요? 이런 정보를 한번에 얻을 수 있는 방법으로는 `summarizingInt` 메소드가 있습니다.

```java
IntSummaryStatistics statistics =   
 productList.stream()  
  .collect(Collectors.summarizingInt(Product::getAmount));  
```

이렇게 받아온 IntSummaryStatistics 객체에는 다음과 같은 정보가 담겨 있습니다.

```java
IntSummaryStatistics {count=5, sum=86, min=13, average=17.200000, max=23}  
```

-   개수 _getCount()_
-   합계 _getSum()_
-   평균 _getAverage()_
-   최소 _getMin()_
-   최대 _getMax()_

이를 이용하면 `collect` 전에 이런 통계 작업을 위한 `map` 을 호출할 필요가 없게 됩니다. 위에서 살펴본 averaging, summing, summarizing 메소드는 각 기본 타입(_int, long, double_)별로 제공됩니다.

#### _Collectors.groupingBy()_

특정 조건으로 요소들을 그룹지을 수 있습니다. 수량을 기준으로 그룹핑해보겠습니다. 여기서 받는 인자는 함수형 인터페이스 Function 입니다.

```java
Map<Integer, List<Product>> collectorMapOfLists =  
 productList.stream()  
  .collect(Collectors.groupingBy(Product::getAmount));  
```

결과는 Map 타입으로 나오는데요, 같은 수량이면 리스트로 묶어서 보여줍니다.

```java
{23=[Product{amount=23, name='potatoes'},   
     Product{amount=23, name='bread'}],   
 13=[Product{amount=13, name='lemon'},   
     Product{amount=13, name='sugar'}],   
 14=[Product{amount=14, name='orange'}]}  
```

#### _Collectors.partitioningBy()_

위의 `groupingBy` 함수형 인터페이스 Function 을 이용해서 특정 값을 기준으로 스트림 내 요소들을 묶었다면, `partitioningBy` 은 함수형 인터페이스 Predicate 를 받습니다. Predicate 는 인자를 받아서 boolean 값을 리턴합니다.

```java
Map<Boolean, List<Product>> mapPartitioned =   
  productList.stream()  
  .collect(Collectors.partitioningBy(el -> el.getAmount() > 15));  
```

따라서 평가를 하는 함수를 통해서 스트림 내 요소들을 true 와 false 두 가지로 나눌 수 있습니다.

```java
{false=[Product{amount=14, name='orange'},   
        Product{amount=13, name='lemon'},   
        Product{amount=13, name='sugar'}],   
 true=[Product{amount=23, name='potatoes'},   
       Product{amount=23, name='bread'}]}  
```

#### _Collectors.collectingAndThen()_

특정 타입으로 결과를 `collect` 한 이후에 추가 작업이 필요한 경우에 사용할 수 있습니다. 이 메소드의 시그니쳐는 다음과 같습니다. `finisher` 가 추가된 모양인데, 이 피니셔는 collect 를 한 후에 실행할 작업을 의미합니다.

```java
public static<T,A,R,RR> Collector<T,A,RR> collectingAndThen(  
  Collector<T,A,R> downstream,  
  Function<R,RR> finisher) { ... }  
```

다음 예제는 `Collectors.toSet` 을 이용해서 결과를 Set 으로 collect 한 후 수정불가한 Set 으로 변환하는 작업을 추가로 실행하는 코드입니다.

```java
Set<Product> unmodifiableSet =   
 productList.stream()  
  .collect(Collectors.collectingAndThen(Collectors.toSet(),  
                                        Collections::unmodifiableSet));  
```

#### _Collector.of()_

여러가지 상황에서 사용할 수 있는 메소드들을 살펴봤습니다. 이 외에 필요한 로직이 있다면 직접 collector 를 만들 수도 있습니다. accumulator 와 combiner 는 `reduce` 에서 살펴본 내용과 동일합니다.

```java
public static<T, R> Collector<T, R, R> of(  
  Supplier<R> supplier, // new collector 생성  
  BiConsumer<R, T> accumulator, // 두 값을 가지고 계산  
  BinaryOperator<R> combiner, // 계산한 결과를 수집하는 함수.  
  Characteristics... characteristics) { ... }  
```


코드를 보시면 더 이해가 쉬우실 겁니다. 다음 코드에서는 collector 를 하나 생성합니다. 컬렉터를 생성하는 supplier 에 LinkedList 의 생성자를 넘겨줍니다. 그리고 accumulator 에는 리스트에 추가하는 `add`메소드를 넘겨주고 있습니다. 따라서 이 컬렉터는 스트림의 각 요소에 대해서 LinkedList 를 만들고 요소를 추가하게 됩니다. 마지막으로 combiner 를 이용해 결과를 조합하는데, 생성된 리스트들을 하나의 리스트로 합치고 있습니다.

```java
Collector<Product, ?, LinkedList<Product>> toLinkedList =   
  Collector.of(LinkedList::new,   
               LinkedList::add,   
               (first, second) -> {  
                 first.addAll(second);  
                 return first;  
               }); 
```


따라서 다음과 같이 `collect` 메소드에 우리가 만든 커스텀 컬렉터를 넘겨줄 수 있고, 결과가 담긴 LinkedList 가 반환됩니다.

```java
LinkedList<Product> linkedListOfPersons =   
  productList.stream()  
  .collect(toLinkedList); 
```

### Matching

매칭은 조건식 람다 Predicate 를 받아서 해당 조건을 만족하는 요소가 있는지 체크한 결과를 리턴합니다. 다음과 같은 세 가지 메소드가 있습니다.

-   하나라도 조건을 만족하는 요소가 있는지(_anyMatch_)
-   모두 조건을 만족하는지(_allMatch_)
-   모두 조건을 만족하지 않는지(_noneMatch_)

```java
boolean anyMatch(Predicate<? super T> predicate);  
boolean allMatch(Predicate<? super T> predicate);  
boolean noneMatch(Predicate<? super T> predicate);  
```

간단한 예제입니다. 다음 매칭 결과는 모두 `true` 입니다.

```java
List<String> names = Arrays.asList("Eric", "Elena", "Java");  
  
boolean anyMatch = names.stream()  
  .anyMatch(name -> name.contains("a"));  
boolean allMatch = names.stream()  
  .allMatch(name -> name.length() > 3);  
boolean noneMatch = names.stream()  
  .noneMatch(name -> name.endsWith("s"));  
```

### Iterating

`foreach` 는 요소를 돌면서 실행되는 최종 작업입니다. 보통 `System.out.println` 메소드를 넘겨서 결과를 출력할 때 사용하곤 합니다. 앞서 살펴본 `peek` 과는 중간 작업과 최종 작업의 차이가 있습니다.

```java
names.stream().forEach(System.out::println);
```