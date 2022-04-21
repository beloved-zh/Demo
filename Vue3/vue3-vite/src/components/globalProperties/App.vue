<template>
  <h1>App.vue</h1>
  <!-- 模板中可直接读取 -->
  $userName：{{$userName}}<br><br>
  $filters：{{$filters.format('张三')}}<br><br>
</template>

<script setup lang="ts">

// setup 读取
import { getCurrentInstance, ComponentInternalInstance } from 'vue'

const { appContext } = <ComponentInternalInstance>getCurrentInstance()

console.log(appContext.config.globalProperties.$userName)
console.log(appContext.config.globalProperties.$filters.format('李四'))

</script>
