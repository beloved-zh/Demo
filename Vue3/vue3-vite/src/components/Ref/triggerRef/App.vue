<template>
  user{{ user }} <br><br>
  <button @click="update">更新数据</button>
</template>

<script setup lang="ts">
  import { shallowRef, triggerRef  } from 'vue'

  let user = shallowRef({
    name: '张三'
  })

  
  const update = () => {
    
    // 非响应式
    user.value.name = '李四'

    console.log(user)

    // 强制更新 DOM
    triggerRef(user)
  }

</script>
