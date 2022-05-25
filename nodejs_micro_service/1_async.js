function func(callback){
    callback("callback !!");
}

func((param) => {
    console.log(param);
});
//node async.js