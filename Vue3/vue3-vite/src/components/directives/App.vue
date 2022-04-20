<template>
  <h1>App.vue</h1>
  <div v-if="showInput">
    name：<input type="text" v-model="name" v-focus:beloved.input="{background: 'red'}" v-test="{width: '1000px',height: '100px'}"> <br><br>
  </div>
  <button @click="showInput = !showInput">切换显示</button>
</template>

<script setup lang="ts">
  import {Directive, DirectiveBinding, ref, RendererNode, VNode} from 'vue'

  // 自定义指令必须是 v开头驼峰命名
  const vFocus:Directive = {
    created() {
      console.log('在绑定元素的 attribute 或事件监听器被应用之前调用')
    },
    beforeMount() {
      console.log('当指令第一次绑定到元素并且在挂载父组件之前调用')
    },
    // el：当前绑定的DOM 元素
    // binding：指令相关数据
    // vnode：当前元素的虚拟DOM
    // prevVnode：上一个虚拟节点，仅在 beforeUpdate 和 updated 钩子中可用
    mounted(el:HTMLElement, binding:DirectiveBinding, vnode:RendererNode, prevVnode:any) {
    // mounted(...par) {
      console.log('在绑定元素的父组件被挂载前调用')
      // console.log(par)
      console.log(el)
      console.log(binding)
      console.log(vnode)
      console.log(prevVnode)

      el.style.background = binding.value.background
      if (binding.modifiers.input) {
        el.focus()
      }
    },
    beforeUpdate() {
      console.log('在更新包含组件的 VNode 之前调用')
    },
    updated(el:HTMLElement, binding:DirectiveBinding, vnode:RendererNode, prevVnode:VNode) {
      console.log('在包含组件的 VNode 及其子组件的 VNode 更新后调用')
      console.log(el)
      console.log(binding)
      console.log(vnode)
      console.log(prevVnode)
    },
    beforeUnmount() {
      console.log('在卸载绑定元素的父组件之前调用')
    },
    unmounted() {
      console.log('当指令与元素解除绑定且父组件已卸载时，只调用一次')
    }
  }

  // 函数简写
  // mounted 和 updated 时触发相同行为，不关心其他的钩子函数。
  const vTest:Directive = (el, binding: DirectiveBinding) => {
    el.style.width = binding.value.width
    el.style.height = binding.value.height
  }

  let name = ref()
  let showInput = ref(true)
</script>
