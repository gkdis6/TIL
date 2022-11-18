# for 정리

---

## Array.every()

조건을 만족하지 않는 값이 나오면 그 즉시 순회 중단(return false)

## Array.some()

조건을 만족하는 값이 나오면 그 즉시 순회(return true)

```js
let result = data.every(x => {
	return x.age >= 20
});
```

---

## for

```js
const array = new Array(10000000).fill().map((v, i) => i)
const start = new Date()
let str = "";
for (let i = 0; i < array.length; i++) {
    str += array[i]
}
console.log(new Date() - start)

// 결과 - 1291.1
```

## forEach

```js
const array = new Array(10000000).fill().map((v, i) => i)
const start = new Date()
let str = "";
array.forEach(value, index => {
    str += value
});
console.log(new Date() - start)

// 결과 - 1385.8
```

## map

```js
const array = new Array(10000000).fill().map((v, i) => i)
const start = new Date()
let str = "";
array.map(v => {
    str += v
});
console.log(new Date() - start)

// 결과 - 1458.2
```

## reduce

```js
const array = new Array(10000000).fill().map((v, i) => i)
const start = new Date()
let str = "";
array.reduce((acc, v) => {
    str += v
});
console.log(new Date() - start)

// 결과 - 1335.9
```

## $.each

배열 뿐만 아니라 객체, selector를 통한 DOM 객체도 array처럼 동작시킬 수 있다.

```js
const array = new Array(10000000).fill().map((v, i) => i)
const start = new Date()
let str = "";
$.each(array, (index, value) => {
    str += value
});
console.log(new Date() - start)

// 결과 - 1971.3
```

![image](https://k.kakaocdn.net/dn/cqA4kC/btrrbSP5H88/WNXugIP09jZSlwrvDqU5Kk/img.png)

**크롬 기준 **for loop > reduce > foreach > map >>> $.each의 순으로 속도가 더 빠른 거 같습니다.

출처 : https://niceman.tistory.com/78, https://gurtn.tistory.com/121