# Parcelable

안드로이드에서 Intent를 통해 Activity로 data를 전달할 때, String이나 Int와 같은 기본형이 아닌 객체를 전달해야한다면
Java에서 제공하는 Serializable을 implement하면 객체를 직렬화해주고 다시 복원할 수 있게 해준다.
putExtra()에 인자로 넣어 넘겨주기만 하면 되어 구현해야할 메소드도 없고 사용하기 편리합니다.

다른 방법이 Parcelable이라는 interface를 사용하는 것입니다.
구현하는 것이 좀 더 복잡하지만 Serializable을 사용하는 것보다 안드로이드에서 훨씬 빠른 속도를 보여줌

implement를 하면 CREATOR를 생성해주는데, 이것은 Parcelable에서 필수적으로 가져야 하는, non-null static 필드입니다.



이후 보충 조사 필요

developer88.tistory.com/64