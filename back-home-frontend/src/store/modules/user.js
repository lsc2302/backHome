import { getUserInfo, login, logout } from "@/api/auth/auth";
import { getToken, setToken, removeToken } from "@/utils/auth";

const state = {
  token: getToken(),
  user: "", 
};

const mutations = {
  SET_TOKEN_STATE: (state, token) => {
    state.token = token;
  },
  SET_USER_STATE: (state, user) => {
    state.user = user;
  },
};

const actions = {
  login({ commit }, userInfo) {
    const { name, pass } = userInfo;
    return new Promise((resolve, reject) => {
      login({ username: name.trim(), password: pass })
        .then((response) => {
          const { data } = response;
          commit("SET_TOKEN_STATE", data.token);
          commit("SET_USER_STATE", name.trim());
          setToken(data.token);
          resolve();
        })
        .catch((error) => {
          reject(error);
        });
    });
  },

  // getInfo({ commit, state }) {
  //   return new Promise((resolve, reject) => {
  //     getUserInfo()
  //       .then((response) => {
  //         const { data } = response;
  //         if (!data) {
  //           commit("SET_TOKEN_STATE", "");
  //           commit("SET_USER_STATE", "");
  //           removeToken();
  //           resolve();
  //           reject("Verification failed, please Login again.");
  //         }
  //         commit("SET_USER_STATE", data);
  //         resolve(data);
  //       })
  //       .catch((error) => {
  //         reject(error);
  //       });
  //   });
  // },

  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token)
        .then((response) => {
          console.log(response);
          commit("SET_TOKEN_STATE", "");
          commit("SET_USER_STATE", "");
          removeToken();
          resolve();
        })
        .catch((error) => {
          reject(error);
        });
    });
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
