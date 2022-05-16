import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'

const routes: Array<RouteRecordRaw> = [{
    path: '/',
    component: () => import('@views/main.vue')
},{
    path: '/setup',
    component: () => import('@views/setup.vue')
}]


// history  =>  createWebHistory
// hash     =>  createWebHashHistory  
// abstact  =>  createMemoryHistory
const router = createRouter({
    history: createWebHistory(),
    routes
})

//导出router
export default router