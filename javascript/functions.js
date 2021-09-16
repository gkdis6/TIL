function printHello() {
    console.log("Hello");
}

printHello();

function log(message) {
    console.log(message);
}

log("Hello @");
log(12345);

function changeName(obj) {
    obj.name = "coder";
}

const kim = {name: "ju hyun"};

changeName(kim);
log(kim);

//default 처리
function showMessage(message, from = "unknown") {
    console.log(`${message} by ${from}`);
}

showMessage("hi");

function printAll(...args) {
    for(let i = 0; i < args.length; i++){
        console.log(args[i]);
    }
    for(const arg of args){
        console.log(arg);
    }
    args.forEach((arg) => console.log(arg));
}

printAll("developer", "coder", "teams");

//local scope

let globalMessage = "global";
function printMessage3() {
    let message = "Hello";
    console.log(message);
    console.log(globalMessage);
}

printMessage3();
console.log(globalMessage);

console.log(sum(3,3));

function sum(n1, n2) {
    return n1+n2;
}

//print();

const print = function(){
    console.log("print");
}
print();

const printAgain = print;
printAgain();

const sumAgain = sum;
console.log(sumAgain(1,3));