<template>
  <h1>App.vue</h1>
  number：{{number}}<br><br>
  <button @click="addNumber">number++</button><br><br>
  <Child></Child>
</template>

<script setup lang="ts">
  import Child from './Child.vue'

  import { ref, provide  } from 'vue'

  let number = ref(10)

  // 参数1 是key值
  // 参数2 是value
  provide('number', number)

  const addNumber = () => {
    number.value++
  }

</script>
