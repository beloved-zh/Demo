<template>
  name：<input type="text" v-model="name"><br><br>
  age：<input type="text" v-model="age"><br><br>
  money：<input type="text" v-model="money"><br><br>
  <!-- 调用 watchEffect 的返回值可以停止监听 -->
  <button @click="watchEffectResult()">停止监听</button><br><br>
</template>

<script setup lang="ts">
  import { ref, reactive, watch, watchEffect } from 'vue'

  let name = ref()
  let age = ref()
  let money = ref()

  // 立即执行传入的一个函数，同时响应式追踪其依赖，并在其依赖变更时重新运行该函数。只要作用域中用到的属性发生变化就会回调。
  //    传入一个函数，函数的参数是一个回调函数。会在调用整体代码块之前调用
  //    返回值也是一个回调函数，可通过返回值停止监听。停止监听时也会调一次 onInvalidate
  const watchEffectResult =  watchEffect(onInvalidate => {
    console.log('name：', name.value)
    console.log('age：', age.value)
    // 会在调用整体代码块之前调用
    onInvalidate(() => {
      console.log('watchEffectBefer')
    })
  },{
    //flush: 'pre'    // 默认  组件更新前执行
    //flush: 'sync'   // 强制效果始终同步触发
    flush: 'sync',   // 组件更新后执行
    // onTrack 和 onTrigger 选项可用于调试侦听器的行为。只能在开发模式下工作
    onTrack () {  // 将在响应式 property 或 ref 作为依赖项被追踪时被调用。

    },
    onTrigger () {  // 将在依赖项变更导致副作用被触发时被调用。

    }
  })

  
</script>
