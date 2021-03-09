// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import BaiduMap from 'vue-baidu-map'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import echarts from 'echarts'

Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(BaiduMap, {
  ak: 'iSuu2ePCQ3KLIcg1Rotf3hcemKscRGGK'
});

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
