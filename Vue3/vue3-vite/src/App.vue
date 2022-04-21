<template>
  <h1>App.vue</h1>
  <el-row class="mb-4">
    <el-button>Default</el-button>
    <el-button type="primary">Primary</el-button>
    <el-button type="success">Success</el-button>
    <el-button type="info">Info</el-button>
    <el-button type="warning">Warning</el-button>
    <el-button type="danger">Danger</el-button>
    <el-button>中文</el-button>
  </el-row><br><br>
  <el-input v-model="input" placeholder="Please input" class="eipt" />
  <div class="di1">
    <h1>saaaaaaa</h1>
  </div>
</template>

<script setup lang="ts">
  import { ref } from 'vue'
  const input = ref('')
</script>

<style scoped>
  /* 使用 :deep() 可样式穿透 */
  .eipt :deep(input) {
    background-color: aqua;
  }
  .di1 {
    background-color: aqua;
    height: 200px
  }

  .di1 h1 {
    color: blue;
  }
</style>
