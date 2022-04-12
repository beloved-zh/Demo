<template>
  <h1>父组件</h1>
  <Child :name="name" :age="22"></Child>
</template>

<script setup lang="ts">
  // <script setup> 中引用组件之后，可以直接在模板中使用
  import Child from './Child.vue'

  import { ref } from 'vue'

  let name = ref('张三')
  let age = ref(20)

</script>
