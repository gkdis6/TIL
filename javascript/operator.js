console.log("my" + "dog");
console.log("1"+2);
console.log(`string literals: 1+2 = ${1+2}`);

console.log(1+1);
console.log(1-1);
console.log(1/1);
console.log(1*1);
console.log(5%1);
console.log(2 ** 3);

let counter = 2;
let preIncrement = ++counter;
console.log(`preIncrement: ${preIncrement}, counter: ${counter}`);

preIncrement = counter++;
console.log(`preIncrement: ${preIncrement}, counter: ${counter}`);

let x = 3;
let y = 6;
x += y;
x -= y;
x /= y;
x *= y;

console.log(10<6);
console.log(10 <= 6);
console.log(10 > 6);
console.log(10 >= 6);

const value1 = true;
const value2 = 4<2;
console.log(`or: ${value1 || value2 || check()}`);
console.log(`and: ${value1 && value2 && check()}`);
console.log(`and: ${check() && value1 && value2}`);
//check가 앞자리면 무조건 실행되니 뒤로 넘김

function check(){
    for(let i = 0; i< 10; i++){
        console.log("waiting")
    }
    return true;
}

console.log(!value1);

//equality(==,===)
const stringfive = "5";
const numberfive = 5;

//== 약한 비교
console.log(stringfive == numberfive);
console.log(stringfive != numberfive);

//=== 엄격한 비교
console.log(stringfive === numberfive);
console.log(stringfive !== numberfive);

const js1 = {name:"js"};
const js2 = {name:"js"};
const js3 = js1;

console.log(js1 == js2);
console.log(js1 === js2);

console.log(js1 === js3);

console.log(0 == false);
console.log(0 === false);

console.log("" == false);
console.log("" === false);

console.log(null == undefined);
console.log(null === undefined);