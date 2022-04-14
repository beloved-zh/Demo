<template>
  <hr/>  
  <h3>Sun.vue</h3>
  number：{{number}} <br><br>
  <button @click="addNumber">number++</button><br><br>
</template>

<script setup lang="ts">
    
  import { inject, ref } from 'vue'

  // 参数1 是需要接收的key
  // 参数2 是默认值
  let number = inject('number', ref(20))

  // 参数是响应式 任何一层进行修改会通知到所有使用者
  const addNumber = () => {
    number.value++
  }
inject
  
</script>