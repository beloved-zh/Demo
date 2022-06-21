import { defineStore } from 'pinia'

type User = {
    username: string,
    age: number
}

type LoginUser = {
    username: string,
    password: string
}

const Login = (): Promise<User> => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve({
            username: '张三',
            age: 25
        })
    }, 1000)  
  })
}

// 定义存储库（hook 一般使用 use 开头）
// 参数：
//   id：存储的唯一id，pinia 使用它连接 devtools
export const useTestStore = defineStore('TEST', {
    state: () => {
        return {
            user: <User>{},
            loginUser: <LoginUser>{},
            sex: '男'
        }
    },
    // 等效于 计算属性
    getters: {
    },
    // 等效于 方法，可以做同步异步
    actions: {
        async Login() {
            const data = await Login()
            this.user = data
        },
        LoginUser(user:LoginUser) {
            this.loginUser = user
        }
    }
})