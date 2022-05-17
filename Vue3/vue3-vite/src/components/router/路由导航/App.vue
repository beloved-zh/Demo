<template>
  <h1>App.vue</h1>
  <!-- 路由跳转 -->
  <span>path跳转：</span>
  <router-link to="/">main</router-link>&emsp;
  <router-link to="/setup">setup</router-link><br><br>
  <span>name跳转：</span>
  <router-link :to="{name: 'Main'}">main</router-link>&emsp;
  <router-link :to="{name: 'Setup'}">setup</router-link><br><br>
  <span>编程式导航path：</span>
  <button @click="toPagePath('/')">main</button>&emsp;
  <button @click="toPagePath('/setup')">setup</button><br><br>
  <span>编程式导航name：</span>
  <button @click="toPageName('Main')">main</button>&emsp;
  <button @click="toPageName('Setup')">setup</button><br><br>
  <hr>
  <!-- 路由渲染 -->
  <router-view></router-view>
</template>

<script setup lang="ts">

  import { useRouter } from 'vue-router'
  
  const router = useRouter()

  const toPagePath = (url: string) => {
    // 字符串
    // router.push(url)
    router.push({
      path: url
    })
  }

  const toPageName = (name: string) => {
    router.push({
      name: name
    })
  }

</script>

<style scoped>

</style>
