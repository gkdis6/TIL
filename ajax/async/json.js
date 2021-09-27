//1 Object -> JSON
//stringify(obj)
let json = JSON.stringify(true);
console.log(`vlaue : ${json}, type : ${typeof json}`);

json = JSON.stringify(['apple', 'banana']);
console.log(`vlaue : ${json}, type : ${typeof json}`);

const rabbit = {
    name : "tori",
    color : "white",
    size : null,
    birthdate : new Date(),
    jump: () => { //json에서 제외됨
        console.log(`${name} can jump!`);
    }
}
json = JSON.stringify(rabbit);
console.log(json);

json = JSON.stringify(rabbit,['name','color']);
console.log(json);

json = JSON.stringify(rabbit, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'name' ? 'rab' : value;
});
console.log(json);