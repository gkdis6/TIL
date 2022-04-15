# kotlin 정규식

## 한글 정규식 valid

```kotlin
val pattern = Regex("^[가-힣]*$")
value : String = "afdjekaeaF"
regex : boolean = Pattern.matches(pattern, value)
return regex
fun isKoreanNameValid(name: String): Int? {
        return when {
            name.isBlank() -> R.string.invalid_empty
            !Pattern.matches(
                "^[a-zA-Z]*\$",
                name
            ) //|| nickname.length > 16 -> R.string.invalid_nickname
            else -> null
        }
    }
```

