<template>
  <hr/>
  <h2>Child.vue</h2>
  number：{{number}} <br><br>
  <button @click="addNumber">number++</button><br><br>
  <Sun></Sun>
</template>

<script setup lang="ts">
  import Sun from './Sun.vue'
  import { inject, ref } from 'vue'

  let number = inject('number', ref(15))

  const addNumber = () => {
    number.value++
  }
</script>