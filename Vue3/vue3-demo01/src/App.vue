<template>
  <h2>父组件</h2>
  number：{{number}}<br><br>
  <button @click="number++">更新数据</button>
</template>

<script lang="ts">
import {
  defineComponent,
  ref
} from 'vue';

export default defineComponent({
  name: 'App',
  setup () {

    let number = ref(10)

    return {
      number
    }
  }
});
</script>