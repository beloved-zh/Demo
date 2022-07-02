<template>
    <div class="login">
        <el-card class="box-card">
            <el-form ref="formRef" :model="form" :rules="rules" label-width="80px" label-position="top">
                <el-form-item prop="username" label="用户名：">
                    <el-input v-model="form.username" placeholder="请输入用户名！！！" />
                </el-form-item>
                <el-form-item prop="password" label="密码：">
                    <el-input v-model="form.password" type="password" show-password placeholder="请输入密码！！！" />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">登录</el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<script setup lang="ts">
    import { ref, reactive } from 'vue'
    import { useRouter } from 'vue-router'
    import type { FormInstance, FormRules } from 'element-plus'
    import store from '@store/index'

    const router = useRouter()

    const form = reactive({
        username: '',
        password: '',
    })

    const formRef = ref<FormInstance>()

    const rules = reactive<FormRules>({
        username: [
            {
                required: true,
                message: '请输入用户名！！！',
                trigger: 'blur',
            }
        ],
        password: [
            {
                required: true,
                message: '请输入密码！！！',
                trigger: 'blur',
            }
        ]
    })

    const onSubmit = () => {
        formRef.value?.validate((valid, fields) => {
            if (valid) {
                store.userStore.LoginUser(form)
                initRouter()
                router.push('/userInfo')
            } else {
                console.log('error submit!', fields)
            }
        })
    }

    const initRouter = () => {
        const adminData = [
            {
                path: '/demo01',
                name: 'demo01',
                component: 'demo01.vue'
            },
            {
                path: '/demo02',
                name: 'demo02',
                component: 'demo02.vue'
            },
            {
                path: '/demo03',
                name: 'demo03',
                component: 'demo03.vue'
            }
        ]

        const userData = [
            {
                path: '/demo01',
                name: 'demo01',
                component: 'demo01.vue'
            }
        ]

        if(form.username === 'admin') {
            adminData.forEach(item => {
                router.addRoute({
                    path: item.path,
                    name: item.name,
                    component: () => import(`../views/${item.component}`)
                })
            })  
        } else {
            userData.forEach(item => {
                router.addRoute({
                    path: item.path,
                    name: item.name,
                    component: () => import(`../views/${item.component}`)
                })
            })  
        }

        console.log('---', router.getRoutes());
        
    }
</script>

<style scoped lang="less">
    .login {
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .box-card {
        width: 380px;
    }
</style>