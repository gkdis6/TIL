1111111111111111111111111
var v1 = 'v1';
var v2 = 'v2';

22222222222222222222222222
var o = {
    v1 : 'v1',
    v2 : 'v2'
}

function f1(){
    console.log(o.v1);
}

function f2(){
    console.log(o.v2);
}

f1();
f2();

33333333333333333333333
var o = {
    v1 : 'v1',
    v2 : 'v2',
    f1 : function(){
        console.log(this.v1);
    },    
    f2 : function(){
        console.log(this.v2);
    }
}
o.f1();
o.f2();