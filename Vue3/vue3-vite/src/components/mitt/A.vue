<template>
  <h2>A.vue</h2>
  number：{{number}}<br><br>
  <button @click="cli">传递number</button>
</template>

<script setup lang="ts">
  import { ref, getCurrentInstance } from 'vue'

  // 获取组件实例
  const instance = getCurrentInstance()

  let number = ref(10)

  const cli = () => {
    // 触发自定义事件
    instance?.proxy?.$EventBus.emit('on-push', number)

    instance?.proxy?.$EventBus.emit('push-msg', 'message')
  }
</script>