import Vue from 'vue'
import App from './App.vue'

import BootstrapVue from 'bootstrap-vue'

Vue.use(BootstrapVue);
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.min'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap-vue/dist/bootstrap-vue.min'
import 'font-awesome/css/font-awesome.min.css'
import index from "./index"
Vue.config.productionTip = false
new Vue({
  router: index,
  render: h => h(App)
}).$mount('#app')
