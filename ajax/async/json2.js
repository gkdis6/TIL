//2. JSON to Object
//parse(json)

console.clear();
json = JSON.stringify(rabbit);
const obj = JSON.parse(json);
console.log(obj);
rabbit.jump();
//obj.jump();

console.log(rabbit.birthdate.getDate());
//console.log(obj.birthdate.getDate());

const obj2 = JSON.parse(json, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === "birthdate" ? new Date(value) : value;
})
console.log(obj2.birthdate.getDate());