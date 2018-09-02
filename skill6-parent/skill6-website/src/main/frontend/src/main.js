import Vue from 'vue'
import App from './App.vue'

import index from "./index"

Vue.config.productionTip = false
new Vue({
  router: index,
  render: h => h(App)
}).$mount('#app')
