import { defineStore } from 'pinia'

// 定义存储库（hook 一般使用 use 开头）
// 参数：
//   id：存储的唯一id，pinia 使用它连接 devtools
export const useTestStore = defineStore('TEST', {
    state: () => {
        return {
            age: 1,
            username: '张三'
        }
    },
    // 等效于 方法，可以做同步异步
    actions: {
        addAge (num:number) {
            this.age += num
        }
    }
})