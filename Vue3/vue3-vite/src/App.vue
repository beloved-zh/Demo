<template>
  <h1>App.vue</h1>
  count：{{store.count}} <button @click="countAdd">count++</button><br><br>
  username：{{store.username}} <br><br>
</template>

<script setup lang="ts">
  import { useTestStore } from './store/index'
  
  const store = useTestStore()
  
  const countAdd = () => {
    store.count++
  }
  
</script>

<style scoped>

</style>
