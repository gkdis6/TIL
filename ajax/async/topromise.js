class UserStorage {
    loginUser(id, password) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                if (
                    (id === 'study' && password === 'aistudy') ||
                    (id === 'coder' && password === 'academy')
                ) {
                    resolve(id);
                } else {
                    reject(new Error('not found'))
                }
            }, 2000)
        });
    }

    getRoles(user) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                if (user === 'study') {
                    resolve({ name: 'study', role: 'admin' });
                } else {
                    reject(new Error('no access'))
                }
            }, 1000)
        });
    }
    async getUserWithRole(id, password) {
        const user = await this.loginUser(id, password);
        const role = await this.getRoles(user);
        return role;
    }
}



const userStorage = new UserStorage();
const id = prompt("enter your id");
const password = prompt("enter your password");
userStorage
    .getUserWithRole(id, password)
    .then(role => alert(`Hello ${role.name}, you have a ${role.role} role`))
    .catch(console.log);