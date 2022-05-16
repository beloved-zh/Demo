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
    // 等效于 计算属性
    getters: {
        // 使用箭头函数后 不能使用 this，需要使用 state
        nameAge: (state) => {
            return `${state.username}---${state.age}`
        },
        // 普通函数 可以使用 this
        sex(): string {
          return this.age % 2 === 0 ? '男' : '女'  
        },
        // 互相调用
        nameAgeSex() {
          return `${this.nameAge}---${this.sex}`  
        }
    },
    // 等效于 方法，可以做同步异步
    actions: {
        addAge (num:number) {
            this.age += num
        }
    }
})