<template>
  number：{{ number }} <br><br>
  <button @click="numberAdd">更新数据</button>
</template>

<script setup lang="ts">
  import { isRef, Ref, ref } from 'vue'

  let number = ref<number>(10)
  
  // let number:Ref<number> = ref(10)

  let msg = 'hello'

  console.log('number：', isRef(number))
  console.log('msg：', isRef(msg))
  
  const numberAdd = () => {
    number.value++
    console.log(number)
  }

</script>
