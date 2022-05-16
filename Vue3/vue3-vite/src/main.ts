import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)

// 引入 mitt
import mitt from 'mitt'
const Mitt = mitt()

type Filter = {
    format: <T extends any>(str: T) => T
}

// 扩展 globalProperties 声明 
declare module 'vue' {
    export interface ComponentCustomProperties {
        $EventBus: typeof Mitt,
        $filters: Filter,
        $userName: string
    }
}

// 挂载全局实例，要挂载在config.globalProperties上
app.config.globalProperties.$EventBus = Mitt

// 定义全局方法、变量
app.config.globalProperties.$filters = {
    format<T extends any>(str: T): string {
        return `${str}---${str}`
    }
}
app.config.globalProperties.$userName = 'Beloved'

// ElementPlus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
app.use(ElementPlus)

// pinia
import {createPinia} from 'pinia'
import { piniaPlugin } from './store/piniaPlugin'
const store = createPinia()
store.use(piniaPlugin())

app.use(store)

import router from './router'
app.use(router)


app.mount('#app')
