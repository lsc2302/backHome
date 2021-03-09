import Vue from 'vue'
import Router from 'vue-router'
import Display from "@/pages/Display";
import Login from "@/pages/Login";
import Landing from "@/pages/Landing";


Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Display',
      component: Display
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/landing',
      name: 'Landing',
      component: Landing
    }
  ]
})
