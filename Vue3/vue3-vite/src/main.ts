import { createApp } from 'vue'
import App from './App.vue'
// 引入 mitt
import mitt from 'mitt'

const Mitt = mitt()

const app = createApp(App)

// 扩展 globalProperties 声明 
declare module 'vue' {
    export interface ComponentCustomProperties {
        $EventBus: typeof Mitt
    }
}

// 挂载全局实例，要挂载在config.globalProperties上
app.config.globalProperties.$EventBus = Mitt

app.mount('#app')
