import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import pdp from '@/views/pdp/index'
import prof from '@/views/pdp/prof'
import question from '@/views/pdp/question'

Vue.use(Router)

export default new Router({
  // mode: 'history',
  // base: '/dist/',
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
      path: '/',
      redirect: '/pdp',
      hidden: true,
    },
    {
      path: '/pdp',
      name: 'pdp',
      component: pdp,
    },
    {
      path: '/prof',
      name: 'prof',
      component: prof,
    },
    {
      path: '/question',
      component: question,
    }
  ]
})
