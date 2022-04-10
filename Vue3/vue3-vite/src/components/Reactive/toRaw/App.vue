<template>
</template>

<script setup lang="ts">
  import { reactive, toRaw, isReactive, isProxy } from 'vue'

  let user = reactive({
    name: '张三',
    wife: {
      name: '小红'
    }
  })

  // 将响应式对象转为原始对象
  let copyUser = toRaw(user)

  console.log(user)
  console.log(isProxy(user))
  console.log(isReactive(user))

  console.log(copyUser)
  console.log(isProxy(copyUser))
  console.log(isReactive(copyUser))
  
  

</script>
