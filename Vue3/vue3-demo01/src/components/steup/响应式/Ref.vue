<template>
  <h2>Ref使用</h2>
  {{n1}}  <button @click="addN1">点击+1</button> <br><br>
  {{n2}}  <button @click="addN2">点击+1</button> <br><br>
</template>

<script lang="ts">
// defineComponent 函数，定义一个组件
import {defineComponent, ref} from 'vue';

export default defineComponent({
  name: 'App',
  setup () {
    // 非响应式数据
    let n1 = 10
    // 数据变化但是页面不进行渲染
    function addN1() {
      console.log('n1++ before：', n1)
      n1++
      console.log('n1++ after：', n1)
    }

    // ref 定义一个响应式数据，返回 Ref 对象，对象中有 value 属性
    //    - 一般是定义基本类型数据
    //    - 操作数据需要调用对象的 value 属性
    //    - 模板中使用数据不需要 .value
    let n2 = ref(10)
    function addN2() {
      console.log('n2++ before：', n2)
      // n2++   Ref 返回的是对象，不能对对象进行++
      n2.value++
      console.log('n2++ after：', n2)
    }
    
    return {
      n1,
      addN1,
      n2,
      addN2
    }
  }
});
</script>