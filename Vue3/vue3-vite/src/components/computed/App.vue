<template>
  原始数据：{{user}}<br><br>
  nameAge：{{nameAge}}<br><br>
  number：{{number}}<br><br>
  <input type="text" v-model="numberCom">
</template>

<script setup lang="ts">
  import { computed, reactive, ref } from 'vue'

  let user = reactive({
    name: '张三',
    age: '20'
  })

  let number = ref(10)

  // 接受一个 getter 函数，并根据 getter 的返回值返回一个不可变的响应式 ref 对象
  let nameAge = computed(() => {
    return `${user.name}---${user.age}`
  })
  
  // 接受一个具有 get 和 set 函数的对象，用来创建可写的 ref 对象。
  let numberCom = computed({
    get: () => {
      return number.value + 10
    },
    set: (newValue) => {
      number.value = newValue - 10
    }
  })

</script>
