<template>
  <h2>子组件</h2>
  number：{{number}} <br><br>
  <button @click="addNumber">点击增加传递给父组件</button>
</template>

<script setup lang="ts">

  import {ref} from 'vue'

  let number = ref(10)

  // defineEmits 定义自定义事件
  const emit = defineEmits(['on-click'])

  const addNumber = () => {
    number.value++
    // 调用
    emit('on-click', number)
  }
</script>