<template>
  <h1>App.vue</h1>
  <span>没有历史记录：</span>
  <router-link replace to="/">main</router-link>&emsp;
  <router-link replace to="/setup">setup</router-link><br><br>
  <span>有历史记录：</span>
  <router-link to="/">main</router-link>&emsp;
  <router-link to="/setup">setup</router-link><br><br>
  <span>没有历史记录：</span>
  <button @click="toReplace('/')">main</button>&emsp;
  <button @click="toReplace('/setup')">setup</button><br><br>
  <span>有历史记录：</span>
  <button @click="toPush('/')">main</button>&emsp;
  <button @click="toPush('/setup')">setup</button><br><br>
  <!-- 前进后退 -->
  <button @click="prev()">后退</button>&emsp;
  <button @click="next()">前进</button><br><br>
  <hr>
  <!-- 路由渲染 -->
  <router-view></router-view>
</template>

<script setup lang="ts">

  import { useRouter } from 'vue-router'
  
  const router = useRouter()

  const toPush = (url: string) => {
    router.push(url)
  }

  const toReplace = (url: string) => {
    router.replace(url)
  }

  const next = () => {
    router.go(1)
  }
  
  const prev = () => {
    // router.go(-1)
    router.back()
  }

</script>

<style scoped>

</style>
