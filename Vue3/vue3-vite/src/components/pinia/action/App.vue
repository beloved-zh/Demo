<template>
  <hr>
  <h2>actions：</h2>
  username：{{store.user.username}}<br><br>
  age：{{store.user.age}}<br><br>
  <button @click="setUser">同步setUser</button>
  <button @click="Login">异步Login</button>
</template>

<script setup lang="ts">
  import { useTestStore } from './store/index'
  
  const store = useTestStore()
  
  const setUser = () => {
    store.setUser()
  }
  
  const Login = () => {
    store.Login()
  }
</script>

<style scoped>

</style>
