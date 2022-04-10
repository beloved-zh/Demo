<template>
  Object：{{user}}<br><br>
  wife：{{wife}}<br><br>
  <button @click="update">更新数据</button>
</template>

<script setup lang="ts">
  import { reactive, toRef } from 'vue'

  let user = reactive({
    name: '张三',
    wife: {
      name: '小红'
    }
  })

  // 从源响应式对象上的某个 property 结构一个 ref
  let wife = toRef(user, 'wife')

  const update = () => {

    // 修改结构对象也会改变原始对象
    wife.value.name += '!'

    console.log('wife', wife);
    console.log('user：', user);  
  }

</script>
