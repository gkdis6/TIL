//async & await
//clear style of using promise
//1. async : 코드블럭이 자동으로 promise로 변환
// function fetchUser(){
//     return new Promise((resolve, reject) => {
//         //do network request in 10 secs....
//         resolve('study');
//     });
// }
//위의 내용을 아래코드로 간단히 만든다.

async function fetchUser() {
    //do network request in 10 secs....
    return 'study';
}

const user = fetchUser();
user.then(console.log)
console.log(user);

//2. await
//async 함수 안에서 사용
function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms))
}

async function getApple() {
    await delay(2000); //delay함수호출이 끝날때까지 기다린다.
    //throw 'error'; //임의의 에러발생시킴
    return '🍎';
}

async function getBanana() {
    await delay(1000);
    return '🍌';
}

//Promise도 중첩적으로 체인잉을 하면 콜백지옥 같은 문제점 발생
// function pickFruits() {
//     return getApple()
//         .then(apple => {
//             return getBanana().then(banana => `${apple} + ${banana}`);
//         });
// }
// pickFruits().then(console.log);

//좀더 개선된 코드,그러나 49 라인에서 1초, 50라인에서 1초 해서 총 2초가 소요
async function pickFruits(){
    try{
        const apple = await getApple();
        const banana = await getBanana();
        return `${apple} + ${banana}`;
    }catch{
        console.log(new Error('error'));//29라인 에러처리
    }
}
pickFruits().then(console.log);

