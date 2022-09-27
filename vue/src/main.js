import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import VueGeolocation from 'vue-browser-geolocation'

import './assets/formulate.css'
import VueFormulate from '@braid/vue-formulate'

Vue.use(VueFormulate)


Vue.config.productionTip = false
Vue.use(VueGeolocation)

import * as VueGoogleMaps from 'vue2-google-maps'


Vue.use(VueGoogleMaps, {
        load: {
            key: 'AIzaSyCali24u_r1ftsr-ASwzsQxtxzVjt_8N_Q',
            libraries: 'places'
        },
    }),


    axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')