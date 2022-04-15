# 내부 리스트와 함께 사용하는 MuatableLiveData

참조값이 바뀌는지 먼저 확인을 하기 때문에 그냥 객체의 값만을 바꾸면 view가 새로고침되지 않음

mutableLiveData와 LiveData를 나누어 값을 바꿔 새롭게 넣어주어야 view가 제대로 새로고침 됨

```kotlin
private val _List = MutableLiveData<List<ViewItem>>()
val List: LiveData<List<ViewItem>> = _List
private val exchangeItems = mutableListOf<ExchangeRate>()

fun exchange() {
         _List.postValue(
             Items.map { data ->
                 ViewItem(
                     param_1 = data.param_1,
                     param_2 = data.param_2,
                     variable_param = (data.param_2 / fixed_param_2) * fixed_param
                 )
             }
         )
     }
```

