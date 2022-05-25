function func(callback){
    //nextTick을 사용해 인자 값으로 전달된 callback 함수 호출
    process.nextTick(callback, "callback !!");
}

try{
    func((param) => {
        a.a = 0;
    });
}catch(e){
    console.log("exception!!");
}
//node nextTick.js