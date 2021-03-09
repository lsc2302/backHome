import request from '@/utils/request'

export function getCommentsBySiteId(siteid) {
  return request({
    url: 'http://localhost:8000/comments/get_comments',
    method: 'get',
    params: {
      siteid: siteid
    }
  })
}

export function pushComment(data,header) {
  return request({
    url: 'http://localhost:8000/comments/add_comment',
    method: 'post',
    data: data,
    headers: {
      userName: header
    }
  })
}

