import {createApp, ref} from 'vue'

createApp({
    setup() {
        return {
            count: ref(0)
        }
    }
}).mount('#app')

<div id="app">
    <button @click="count++">
    숫자 세기: {{ count }}
    </button>
</div>