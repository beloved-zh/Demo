<template>
  user{{ user }} <br><br>
  <button @click="update">更新数据</button>
</template>

<script setup lang="ts">
  import { shallowRef } from 'vue'

  let user = shallowRef({
    name: '张三'
  })

  
  const update = () => {
    // 其 .value 是响应式 但内部的值不是响应式
    // user.value.name = '李四'     // 不是响应式修改
    user.value = {                  // 响应式
        name: '李四'
    }
    console.log(user)
  }

</script>
