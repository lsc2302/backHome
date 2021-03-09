import request from '@/utils/request'

export default function getSites(region) {
  return request({
    url: 'http://localhost:8000/sites',
    method: 'get',
    params:{
      region:region
    }
  })
}
