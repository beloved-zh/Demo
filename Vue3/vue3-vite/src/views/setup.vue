<template>
  <el-row :gutter="10">
    <el-col :span="12">
      <el-card class="box-card ">
        <template #header>
          <div class="card-header">
            <span>用户信息--query</span>
            <el-button class="button" text @click="router.back()">返回</el-button>
          </div>
        </template>
        <div class="text item">id：{{route.query.id}}</div>
        <div class="text item">用户民：{{route.query.userName}}</div>
        <div class="text item">性别：{{route.query.sex}}</div>
        <div class="text item">年龄：{{route.query.age}}</div>
      </el-card>
    </el-col>
    <el-col :span="12">
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span>用户信息--params</span>
            <el-button class="button" text @click="router.back()">返回</el-button>
          </div>
        </template>
        <div class="text item">id：{{route.params.id}}</div>
        <div class="text item">用户民：{{route.params.userName}}</div>
        <div class="text item">性别：{{route.params.sex}}</div>
        <div class="text item">年龄：{{route.params.age}}</div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script setup lang="ts">

  import { useRoute, useRouter } from 'vue-router'
  
  const route = useRoute()

  const router = useRouter()
  
</script>

<style scoped>
  .card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .text {
    font-size: 14px;
  }
  
  .item {
    margin-bottom: 18px;
  }
  
</style>