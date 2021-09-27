//3. Promise chaining
const fetchNumber = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve(1)
    }, 1000);
});
fetchNumber
    .then(num => num * 2)
    .then(num => num * 3)
    .then(num => {
        return new Promise((resolve, reject) => {
            setTimeout(() => resolve(num - 1), 1000);
        });
    })
    .then(num => console.log(num));

//4. Error Handling
const getHen = () =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve("🐓"), 1000);
    });

const getEgg = hen =>
    new Promise((resolve, reject) => {
        // setTimeout(() => resolve(`${hen} => 🥚`), 1000);
        setTimeout(() => reject(new Error(`error! ${hen} => ?`)),1000);
    });

const cook = egg =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${egg} => 🍳`), 1000);
    });

getHen()
    .then(hen => getEgg(hen))
    .catch(error => {
        return '🌭';
    })
    .then(egg => cook(egg))
    .then(meal => console.log(meal))
    .catch(error =>{
        console.log(error);
    });