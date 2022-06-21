import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
import store from '../store/index'

declare module 'vue-router' {
    interface RouteMeta {
        title: string
    }
}

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        component: () => import('@views/Login.vue'),
        meta: {
            title: '登录'
        }
    },
    {
        path: '/userInfo',
        component: () => import('@views/UserInfo.vue'),
        meta: {
            title: '个人信息'
        }
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

/**
 * 路由前置守卫
 *  to：目标路由
 *  from：当前路由
 *  next()：放行路由跳转
 *  next(false)：阻止路由跳转
 *  next('/')
 */
router.beforeEach((to, from, next) => {
    document.title = to.meta.title
    if(to.path === '/' || store.userStore.loginUser.username) {
        next()
    } else {
        next('/')
    }
})

router.afterEach((to, from) => {
    console.log('路由后置守卫');
    console.log(to);
    console.log(from);
})

//导出router
export default router