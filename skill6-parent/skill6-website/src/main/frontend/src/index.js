import AppContent from './component/AppContent'
import BlogList from './component/BlogList'
import Vue from 'vue'
import Router from 'vue-router'
import BlogMain from './component/BlogMain'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      //默认跳转到推荐，实现默认页面
      redirect: '/topic',
      name: 'topic',
      component: AppContent
    },
    {
      path: '/topic',
      //默认跳转到推荐，实现默认页面
      redirect: '/topic/java',
      name: 'Topic',
      component: AppContent,
      children: [
        {
          path: '/topic/java',
          component: BlogList
        },
        {
          path: '/topic/spring',
          component: BlogList
        }
      ]
    },{
      path: '/*/*/*',
      component: BlogMain
    }]
})
