<template>
  <h1>App.vue</h1>
  count：{{store.count}}<br><br>
  username：{{store.username}}
</template>

<script setup lang="ts">
  import { ref } from 'vue'
  import { useTestStore } from './store/index'
  
  const store = useTestStore()
</script>

<style scoped>

</style>
