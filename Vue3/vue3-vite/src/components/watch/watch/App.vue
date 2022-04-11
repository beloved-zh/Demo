<template>
  number1：<input type="text" v-model="number1"><br><br>
  number2：<input type="text" v-model="number2"><br><br>
  refObject：<input type="text" v-model="refObject.user.name"><br><br>
  reactiveObject：<input type="text" v-model="reactiveObject.user.name"><br><br>
  reactiveObjectAge：<input type="text" v-model="reactiveObject.user.age"><br><br>
</template>

<script setup lang="ts">
  import { ref, reactive, watch } from 'vue'

  let number1 = ref()
  let number2 = ref()

  // 监听单个值
  //    参数1：需要监听的值
  //    参数2：监听到的回调函数，接收新值和旧值
  //    参数3：配置对象
  //        deep：开启深度监听
  //        immediate：鉴听开始之后被立即调用
  watch(number1, (newValue, oldValue) => {
    console.log('newValue：', newValue)
    console.log('oldValue：', oldValue)
  }, {
    deep: true,
    immediate: true
  })

  // 监听多个值
  //    1：传入数组，数组内的是需要监听的值
  //    2：监听回调的参数也是数组格式，内容为监听数据集合的新旧值 
  watch([number1, number2], (newValue, oldValue) => {
    console.log('newValue：', newValue)
    console.log('oldValue：', oldValue)
  })

  let refObject = ref({
    user: {
      name: '张三'
    }
  })

  // 监听 ref 对象。正常情况 ref 是监听不到的，需要开启深度监听，才可以监听到
  //   注意：对象的监听 newValue 和 oldValue 的值是一样的
  watch(refObject, (newValue, oldValue) => {
    console.log('newValue：', newValue)
    console.log('oldValue：', oldValue)
  }, {
    deep: true
  })

  let reactiveObject = reactive({
    user: {
      name: '李四',
      age: 20
    }
  })

  // 监听 reactive 对象。无论是否开启深度监听，都可以监听到
  //   注意：对象的监听 newValue 和 oldValue 的值是一样的
  watch(reactiveObject, (newValue, oldValue) => {
    console.log('newValue：', newValue)
    console.log('oldValue：', oldValue)
  })

  // 监听对象单一属性
  //    参数1：是一个函数，返回需要监听对象的属性
  watch(() => {
    return reactiveObject.user.age
  }, (newValue, oldValue) => {
    console.log('newValue：', newValue)
    console.log('oldValue：', oldValue)
  })
</script>
