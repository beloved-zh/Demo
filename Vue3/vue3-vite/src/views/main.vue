<template>
  <el-table :data="data" style="width: 100%">
    <el-table-column prop="userName" label="姓名" />
    <el-table-column prop="sex" label="性别" />
    <el-table-column prop="age" label="年龄" />
    <el-table-column label="操作" >
      <template #default="scope">
        <el-button type="primary" @click="toQuery(scope.row)">Query传参</el-button>
        <el-button type="primary" @click="toParams(scope.row)">Params传参</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-card class="box-card ">
    <template #header>
      <div>
        <span>子路由</span>
        <router-link style="margin-left:10px;" to="/">childrenA</router-link>
        <router-link style="margin-left:10px;" to="/childrenB">childrenB</router-link>
      </div>
    </template>
    <router-view></router-view>
  </el-card>
</template>

<script setup lang="ts">

import { data } from '@data/userList.json'
import { useRouter } from 'vue-router'

type User = {
  id: string;
  userName: string;
  sex: string;
  age: number;
}

const router = useRouter()

// query 传参正常get 地址栏显示参数
const toQuery = (user: User) => {
  
  router.push({
    path: "/setup-query",
    query: user
  })
  
}

// params 传参地址栏不显示，接收页面刷新会丢失数据
// 如果使用动态路由参数，参数使用 restful 风格路径参数在地址后，刷新不会消失
const toParams = (user: User) => {
  
  router.push({
    name: 'Setup',
    params: user
  })
  
}
</script>

<style scoped>

</style>
