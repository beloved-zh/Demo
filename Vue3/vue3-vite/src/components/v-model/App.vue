<template>
  <h1>App.vue</h1>
  showChild：{{showChild}}<br><br>
  title：{{title}}<br><br>
  <button @click="showChild = !showChild">切换Chile</button>
  <!-- 多个 v-model 可使用：指定 -->
  <Child v-model.test="showChild" v-model:title.test="title"></Child>
</template>

<script setup lang="ts">
  import Child from './Child.vue'
  import {ref} from 'vue'

  let showChild = ref(true)
  let title = ref('提示标题111')
</script>
