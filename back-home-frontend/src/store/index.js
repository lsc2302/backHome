import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import user from './modules/user'
import createLogger from "vuex/dist/logger"; 

Vue.use(Vuex)

const store = new Vuex.Store({
    modules: {
        user
    },
    getters,
    plugins: [createLogger()]
})

export default store;