<template>
  <div v-if="modelValue">
    <h1 >Child.vue</h1>
    title：{{ title }} <br><br>
    <button @click="close">关闭</button> <br><br>
    <button @click="updateTitle">修改标题</button>
  </div>
</template>

<script setup lang="ts">

  // prop 默认值为 modelValue
  type Props = {
    modelValue: boolean,
    modelModifiers: {
      default: () => {}
    },
    title: string,
    // 自定义修饰符
    titleModifiers: {
      prefix: boolean
    }
  }
  const propsData = defineProps<Props>()

  // 双向绑定默认事件为 update:modelValue  自定义的为 update：xxx
  const emit = defineEmits(['update:modelValue', 'update:title'])

  let close = () => {
    console.log(propsData.modelModifiers)
    emit('update:modelValue', false)
  }

  let updateTitle = () => {
    // 查看有指定名称的属性是否有指定的修饰符。后续可根据实际业务做操作
    console.log(propsData.titleModifiers)
    console.log(propsData.titleModifiers?.prefix)
    emit('update:title', '修改后的标题')
  }
</script>