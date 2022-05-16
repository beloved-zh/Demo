<template>
  <h1>App.vue</h1>
  <!-- 路由跳转 -->
  <span>path跳转：</span>
  <router-link to="/">main</router-link>&emsp;
  <router-link to="/setup">setup</router-link><br><br>
  <span>name跳转：</span>
  <router-link :to="{name: 'Main'}">main</router-link>&emsp;
  <router-link :to="{name: 'Setup'}">setup</router-link><br><br>
  <span>编程式导航：</span>
  <button @click="toPage('/')">main</button>&emsp;
  <button @click="toPage('/setup')">setup</button><br><br>
  <hr>
  <!-- 路由渲染 -->
  <router-view></router-view>
</template>

<script setup lang="ts">

  import { useRouter } from 'vue-router'
  
  const router = useRouter()

  const toPage = (url: string) => {
    // router.push(url)
    router.push({
      path: url
    })
  }

</script>

<style scoped>

</style>
