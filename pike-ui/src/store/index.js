import Vuex from 'vuex'
import Vue from 'vue'
import user from './user'
import graph from './graph'
import permission from './permission'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    user,
    graph,
    permission
  },
  getters
})
