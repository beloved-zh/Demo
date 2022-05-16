<template>
  <hr>
  <h2>state：</h2>
  age：{{store.age}} <button @click="ageAdd">age++</button><br><br>
  username：{{store.username}} <br><br>
  <hr>
  <h2>getters：</h2>
  nameAge：{{store.nameAge}}<br><br>
  sex：{{store.sex}}<br><br>
  nameAgeSex：{{store.nameAgeSex}}<br><br>
</template>

<script setup lang="ts">
  import { useTestStore } from '@store/index'
  
  const store = useTestStore()
  
  const ageAdd = () => {
    store.age++
  }
  
</script>

<style scoped>

</style>
