import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'

const routes: Array<RouteRecordRaw> = [{
    path: '/',
    alias: ['/mian', '/mian1', '/main2'],
    component: () => import('@views/main.vue'),
    // 字符串
    // redirect: '/childrenA',
    // 对象形式
    // redirect: {
    //   // path: '/childrenA'
    //   // name: 'childrenA'
    // },
    // 函数形式
    redirect: (to) => {
        console.log('to', to)
        
        // 返回字符串
        // return '/childrenA'
        // 返回对象
        return {
            path: '/childrenA',
            query: to.query
        }
    },
    children: [
        {
            path: '/childrenA',
            name: 'childrenA',
            component: () => import('@views/childrenA.vue')
        },
        {
            path: '/childrenB',
            name: 'childrenB',
            component: () => import('@views/childrenB.vue')
        }
    ]
},{
    path: '/setup-query',
    name: 'SetupQuery',
    component: () => import('@views/setup.vue')
},{
    path: '/setup/:id/:userName/:sex/:age',
    name: 'Setup',
    component: () => import('@views/setup.vue')
},{
    path: '/root',
    component: () => import('@views/root.vue'),
    children: [
        {
            path: '',
            components: {
                default: () => import('@views/main.vue'),
                header: () => import('@views/header.vue'),
                bottom: () => import('@views/bottom.vue')
            }
        }
    ]
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