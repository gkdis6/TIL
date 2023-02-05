// array, object

var f = function(){
    console.log(1+1);
    console.log(1+2);
}
console.log(f);
f();//함수는 구문이면서 값이 될 수 있다

var a = [f];
a[0]();//배열에도 들어갈 수 있음

var o = {
    func:f
}
o.func();//객체에도 들어갈 수 있다

//var i = if(true{console.log(1)})
//var w = while(true){console.log(1)}
//구문으로만 작용, 값이 될 수 없음.