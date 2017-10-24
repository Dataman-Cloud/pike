import Vue from 'vue'
import Router from 'vue-router'

import Layout from 'views/layout/Layout'
const _import = require('./_import_' + process.env.NODE_ENV)
// in development env not use Lazy Loading,because Lazy Loading large page will cause webpack hot update too slow
// so only in production use Lazy Loading

const Login = _import('Login')
const Graph = _import('graph/Graph')
const ReleaseList = _import('release/List')
const ProjectList = _import('project/List')
const ProjectEdit = _import('project/Edit')

Vue.use(Router)

export const constantRouterMap = [
  {
    path: '/login',
    name: 'Login',
    component: Login,
    hidden: true
  },
  {
    path: '/graph',
    component: Layout,
    name: '首页',
    redirect: {name: '资源概览'},
    iconCls: 'el-icon-picture', // 图标样式class
    children: [
      {
        path: 'index',
        name: '运营大盘',
        component: Graph
      }
    ]
  },
  {
    path: '/release',
    component: Layout,
    name: '发布管理',
    redirect: {name: '发布列表'},
    iconCls: 'el-icon-picture', // 图标样式class
    children: [
      {
        path: 'index',
        name: '发布列表',
        component: ReleaseList
      }
    ]
  },
  {
    path: '/project',
    component: Layout,
    name: '项目管理',
    redirect: {name: '项目列表'},
    iconCls: 'el-icon-picture', // 图标样式class
    children: [
      {
        path: 'index',
        name: '项目列表',
        component: ProjectList
      },
      {
        path: 'addProject',
        name: '创建项目',
        component: ProjectEdit,
        hidden: true
      },
      {
        path: 'editProject',
        name: '编辑项目',
        component: ProjectEdit,
        hidden: true
      }
    ]
  }
]

export default new Router({
  // mode: 'history',
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [
  {
    path: '/',
    redirect: {name: 'Login'},
    hidden: true
  },
  {
    path: '*',
    hidden: true,
    redirect: {name: '运营大盘'}
  }
]
