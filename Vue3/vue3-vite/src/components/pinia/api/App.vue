<template>
  <hr>
  <h2>actions：</h2>
  username：{{ store.user.username }}<br><br>
  age：{{ store.user.age }}<br><br>
  sex：{{ store.sex }}<br><br>
  <button @click="Login">Login</button>
  <button @click="reset">重置</button>
</template>

<script setup lang="ts">
  import { useTestStore } from './store/index'
  
  const store = useTestStore()
  
  const Login = () => {
    store.Login()
  }

  const reset = () => {
    // 重置 state
    store.$reset()
  }
  
  // 每次调用 Action 的回调
  //   参数1：调用前回调函数
  //   参数2：组件卸载之后当前监听是否有效
  store.$onAction((args) => {
    // 调用的 store
    console.log(args.store)
    // action 名称
    console.log(args.name)
    // action 接收的参数
    console.log(args.args)
    // action 调用成功后回调
    args.after((resolvedValue) => {
      console.log(resolvedValue)
    })
    // action 调用失败回调函数
    args.onError((error) => {
      console.error(error)
    })
  }, false)
  
  // state 的监听事件
  store.$subscribe((args,state) => {
    // store 等数据，修改前后
    console.log(args)
    // state 响应式数据对象
    console.log(state)
  }, {
    detached: false
  })
</script>

<style scoped>

</style>
