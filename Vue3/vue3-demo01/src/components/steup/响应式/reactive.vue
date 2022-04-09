<template>
  <h2>reactive使用</h2>
  姓名：{{user.name}} <br><br>
  年龄：{{user.age}} <br><br>
  性别：{{user.gender}} <br><br>
  爱好：{{user.hobby}} <br><br>
  老婆：{{user.wife}} <br><br>
  <button @click="updateUser">修改数据</button>
</template>

<script lang="ts">
import {defineComponent, reactive} from 'vue';

export default defineComponent({
  name: 'App',
  setup () {

    // reactive 一般用于定义响应式对象
    // 返回一个 Proxy 的代理对象，被代理的对象就是传入的对象。响应式是深层的，会影响内部所有嵌套属性
    let user = reactive<any>({
      name: '张三',
      age: 22,
      hobby: ['抽烟', '喝酒', '烫头'],
      wife: {
        name: '小红',
        age: 20,
        hobby: ['口红', '包包']
      }
    })

    // 不能定义基本数据类型
    // let number = reactive(10)

    let updateUser = () => {
      console.log('=========updateDate===========')
      // 修改已定义属性
      user.name += '!'
      user.age += 1
      user.wife.name += '!'

      // 添加一个未定义属性
      user.gender = '男'

      // 删除一个已定义属性
      delete user.wife.hobby

      console.log(user)
    }
    
    return {
      user,
      updateUser
    }
  }
});
</script>