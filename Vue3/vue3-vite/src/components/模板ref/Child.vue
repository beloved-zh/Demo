<template>
  <h2>子组件</h2>
  number：{{number}} <br><br> 
</template>

<script setup lang="ts">

  import { ref } from 'vue'

  let number = ref<number>(10)

  const addNumber = () => {
    console.log('Child#addNumber()调用了');
    
    number.value++
  }

  // 通过 defineExpose 暴露父组件可以通过 ref 访问的属性或方法
  defineExpose({
    number,
    addNumber
  })
</script>