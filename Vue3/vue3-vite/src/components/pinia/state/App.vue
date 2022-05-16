<template>
  <h1>App.vue</h1>
  count：{{store.count}} <button @click="countAdd">count++</button><br><br>
  username：{{store.username}} <br><br>
  <hr>
  <h3>storeToRefs解构</h3>
  count：{{count}} <button @click="countAdd2">count++</button><br><br>
  username：{{username}} <br><br><hr>
</template>

<script setup lang="ts">
  import { ref } from 'vue'
  import { useTestStore } from '@store/index'
  import {storeToRefs} from 'pinia'
  
  const store = useTestStore()
  
  // pinia 直接解构失去响应式
  // const { count, username } = store
  
  const { count, username } = storeToRefs(store)
  
  const countAdd = () => {
    // 1：直接修改
    //  store.count++
    
    // 2：通过 $patch 修改，传递一个对象，可以有多个，对象中没有的则不会修改
    // store.$patch({
    //   count: 888,
    //   username: '李四'
    // })
    
    // 3：通过 $patch 修改，传递一个函数，可以在修改时做逻辑处理，参数是 store 的 state
    // store.$patch((state) => {
    //   console.log('state', state)
    //   if (state.count > 0) {
    //     state.count--
    //   } else {
    //     state.count++
    //   }
    // })

    // 4：通过 $state 修改，必须覆盖整个 state 对象
    // store.$state = {
    //   count: 10,
    //   username: '李四'
    // }
    
    // 5：通过 action 
    store.addCount(10)
  }
  
  const countAdd2 = () => {
    count.value++
  }
</script>

<style scoped>

</style>
