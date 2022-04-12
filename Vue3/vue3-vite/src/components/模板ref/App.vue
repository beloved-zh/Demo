<template>
  <h1>父组件</h1>
  number：{{number}}<br><br>
  <button @click="getNumber">点击获取子组件数据</button><br><br>
  <button @click="onChildFun">点击调用子组件方法</button><br><br>
  <Child ref="child"></Child>
</template>

<script setup lang="ts">
  import Child from './Child.vue'

  import { ref } from 'vue'

  // 父组件需要定义一个 ref 对象接收子组件实例
  // 名称需要和 ref 名称一致
  let child = ref()

  let number = ref()

  const getNumber = () => {
    number.value = child.value.number
  }

  const onChildFun = () => {
    child.value.addNumber()
  }

</script>
