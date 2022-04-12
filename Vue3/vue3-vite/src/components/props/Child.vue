<template>
  <h2>子组件</h2>
  name：{{name}} <br><br>
  age：{{age}} <br><br>
  hobby：{{hobby}} <br><br>
</template>

<script setup lang="ts">

  // 通过 defineProps 函数接收父组件传递的 props 。参数基本与 选项式相同
  // defineProps 只能在 <script setup> 中使用，所以不需要导入
  // 返回的是 Proxy 的代理对象，模板中使用 props 的值可以直接使用，js 中使用需要接收返回值

  // 数组写法
  // let props = defineProps(['name', 'age'])
  // console.log(props)
  // console.log(props.name)

  // 对象写法 可以声明类型、默认值
  // defineProps({
  //   name: String,
  //   age: {
  //     type: Number,
  //     default: 20,
  //   },
  //   hobby: {
  //     type: Array,
  //     default: () => {
  //       return ['抽烟', '喝酒', '烫头']
  //     }
  //   }
  // })

  // TS 写法， 基本写法
  // defineProps<{
  //   name: string,
  //   age: number,
  //   hobby: string[]
  // }>()

  // TS 默认值写法
  // 通过 withDefaults 函数
  //    第一个参数是 props 函数
  //    第二个参数是一个对象设置默认值
  type Props = {
    name?: string,
    age?: number,
    hobby?: string[]
  }
  withDefaults(defineProps<Props>(), {
    age: 20,
    hobby: () => ['抽烟', '喝酒']
  })


</script>