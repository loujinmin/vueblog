import Vue from 'vue'
import VueRouter from 'vue-router'
import BlogDetail from '../views/BlogDetail.vue'
import Blogs from '../views/Blogs.vue'
import BlogEdit from '../views/BlogEdit.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    redirect: {name: 'Blogs'}
  },
  {
    path: '/blogs',
    name: 'Blogs',
    component: Blogs,
  },
  {
    path: '/blog/add',
    name: 'BlogAdd',
    component: BlogEdit,
  },
  {
    path: '/blog/:blogId',
    name: 'BlogDetail',
    component: BlogDetail,
  },
  {
    path: '/blog/:blogId/edit',
    name: 'BlogEdit',
    component: BlogEdit,
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
