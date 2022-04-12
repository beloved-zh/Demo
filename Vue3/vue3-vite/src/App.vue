<template>
  <h1>父组件</h1>
  number：{{number}}<br><br>
  <Child @on-click="getNumber"></Child>
</template>

<script setup lang="ts">
  import Child from './Child.vue'

  import { ref } from 'vue'

  let number = ref()

  const getNumber = (val: number) => {
    number.value = val
  }

</script>
