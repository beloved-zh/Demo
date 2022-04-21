<template>
  <h1>App.vue</h1>
  <div style="height: 300px;display: flex;align-content: center">
    <img src="@assets/logo.png" id="img">
    <textarea style="width: 100%" readonly v-model="base64"></textarea>
  </div>
  <br><br>
</template>

<script setup lang="ts">
import {ref} from 'vue'
// 引入自定义 hook，命名规则一般是 use 开头
import useBase64 from './hooks'


let base64 = ref()

// 调用自定义 hook 函数
useBase64({
  el: '#img'
}).then(res => {
  base64.value = res
})

</script>
