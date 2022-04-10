<template>
  Object：{{user}}<br><br>
  name：{{name}}<br><br>
  name：{{wife}}<br><br>
  <button @click="update">更新数据</button>
</template>

<script setup lang="ts">
  import { reactive, toRefs } from 'vue'

  let user = reactive({
    name: '张三',
    wife: {
      name: '小红'
    }
  })

  // 将源响应式对象上的所有 property 结构成 ref
  let {name, wife} = toRefs(user)

  const update = () => {

    // 修改结构对象也会改变原始对象
    name.value += '1'
    wife.value.name += '!'

    console.log('name', name);
    console.log('wife', wife);
    console.log('user：', user);  
  }

</script>
