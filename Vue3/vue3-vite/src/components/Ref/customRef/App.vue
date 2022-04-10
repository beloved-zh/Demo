<template>
  message：<input type="text" v-model="message"><br><br>
  {{message}}
</template>

<script setup lang="ts">
  import { customRef } from 'vue'

  // 自定义防抖 Ref
  function MyRef<T>(value:string, delay = 500) {
    let timeout:any
    return customRef((track, trigger) => {
      return {
        get() {
          track()  // 追踪当前数据
          return value 
        },
        set(newValue:string) {
          clearTimeout(timeout)
          timeout = setTimeout(() => {
            value = newValue
            trigger()  // 触发响应,即更新界面
          }, delay)
        }
      }
    })
  }

  let message = MyRef<string>('')

</script>
