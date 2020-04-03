// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/index'
import axios from 'axios'
// import VueAxios from 'vue-axios'
// import $ from 'jquery'
 /*引入公共样式*/
// import './styles/style.css'
import './styles/style.css'
import './permission'

// create an axios instance
// const service = axios.create({
//   baseURL: "http://192.168.1.86:8089", // url = base url + request url
//   // withCredentials: true, // send cookies when cross-domain requests
//   timeout: 5000 // request timeout
// })

Vue.prototype.axios = axios;
// Vue.use(VueAxios,axios);

// Vue.prototype.jquery = $;

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
