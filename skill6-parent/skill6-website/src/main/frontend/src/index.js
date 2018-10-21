import BlogList from './component/BlogList'
import Vue from 'vue'
import Router from 'vue-router'
import AppBody from './component/AppBody'
import Login from './component/Login'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        /*{
            path: '/',
            //默认跳转到推荐，实现默认页面
            redirect: '/topic',
            name: 'topic',
            component: AppContent
        },*/
        {
            path: '/',
            name: 'APP',
            component: AppBody,
            children: [
                {
                    path: "/",
                    component: BlogList
                },
                {
                    path: "/login",
                    component: Login
                }
            ]
        }/*,
        {
            path: '/blog/editor',
            component:
            EditorMain
        }
        ,
        {
            path: '/!*!/!*!/!*',
            component:
            BlogMain
        }*/
    ]
})
