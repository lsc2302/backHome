import request from '@/utils/request'

export function getBillboard() {
  return request({
    url: '/sites',
    method: 'get'
  })
}