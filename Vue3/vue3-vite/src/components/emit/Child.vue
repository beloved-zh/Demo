<template>
  <h2>子组件</h2>
  number：{{number}} <br><br>
  <button @click="addNumber">点击增加传递给父组件</button>
</template>

<script setup lang="ts">

  import {Ref, ref} from 'vue'

  let number = ref<number>(10)

  // defineEmits 定义自定义事件
  // const emit = defineEmits(['on-click'])

  // TS 专门写法定义函数参数类型和返回值
  const emit = defineEmits<{
    (e: 'on-click', number: number): void
  }>()

  const addNumber = () => {
    number.value++
    // 调用
    emit('on-click', number.value)
  }
</script>