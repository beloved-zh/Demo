<template>
  <h2>B.vue</h2>
  number：{{number}}<br><br>
</template>

<script setup lang="ts">
  import { ref, getCurrentInstance } from 'vue'

  // 获取组件实例
  const instance = getCurrentInstance()

  let number = ref()

  const fun = (val: any) => {
    console.log('val：', val)
    number.value = val
  }

  // 注册并监听自定义事件
  //    参数1：事件名
  //    参数2：回调函数 参数为接收值
  instance?.proxy?.$EventBus.on('on-push', fun)

  // 注册并监听所有自定义事件
  //    参数1：*
  //    参数2：回调函数 第一个参数是事件名，第二个参数是接收值
//   instance?.proxy?.$EventBus.on('*', (type, val) => {
//       console.log('type：', type)
//       console.log('val：', val)
//   })

  
  // 取消指定事件的监听。注意：需要将回调定义在外部
//   instance?.proxy?.$EventBus.off('on-push', fun)

  // 取消所有事件监听
  instance?.proxy?.$EventBus.all.clear()
</script>