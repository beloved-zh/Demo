<template>
  <h1>App.vue</h1>
  age：{{store.age}} <button @click="ageAdd">age++</button><br><br>
  username：{{store.username}} <br><br>
  <hr>
  <h3>storeToRefs解构</h3>
  age：{{age}} <button @click="ageAdd2">age++</button><br><br>
  username：{{username}} <br><br><hr>
</template>

<script setup lang="ts">
  import { useTestStore } from './store/index'
  import {storeToRefs} from 'pinia'
  
  const store = useTestStore()
  
  // pinia 直接解构失去响应式
  // const { age, username } = store
  
  const { age, username } = storeToRefs(store)
  
  const ageAdd = () => {
    // 1：直接修改
    //  store.age++
    
    // 2：通过 $patch 修改，传递一个对象，可以有多个，对象中没有的则不会修改
    // store.$patch({
    //   age: 888,
    //   username: '李四'
    // })
    
    // 3：通过 $patch 修改，传递一个函数，可以在修改时做逻辑处理，参数是 store 的 state
    // store.$patch((state) => {
    //   console.log('state', state)
    //   if (state.age > 0) {
    //     state.age--
    //   } else {
    //     state.age++
    //   }
    // })

    // 4：通过 $state 修改，必须覆盖整个 state 对象
    // store.$state = {
    //   age: 10,
    //   username: '李四'
    // }
    
    // 5：通过 action 
    store.addAge(10)
  }
  
  const ageAdd2 = () => {
    age.value++
  }
</script>

<style scoped>

</style>
