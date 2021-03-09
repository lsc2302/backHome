import request from '@/utils/request'

export function userRegister(userDTO) {
  return request({
    url: 'http://localhost:8000/user/register',
    method: 'post',
    data: userDTO
  })
}

export function login(data) {
  return request({
    url: 'http://localhost:8000/user/login',
    method: 'post',
    data:data,
  })
}

export function getUserInfo(username) {
  return request({
    url: 'http://localhost:8000/user/info',
    method: 'get',
    headers: {
      userName: username
    }
  })
}

export function logout() {
  return request({
    url: 'http://localhost:8000/user/logout'
  })
}