<template>
  <div class="comments">
    <span class="comments-title">Comments</span>
    <hr />
    <div class="comments-records">
        <comment
        v-for="comment in comments"
        :key="comment.id"
        :comment="comment"
        />
    </div>
  </div>
</template>

<script>
// import { mapGetters } from 'vuex'
// import { fetchCommentsByTopicId } from '@/api/comment'
import Comment from './Comment'
export default {
  name: 'Comments',
  components: {
    Comment
  },
  data() {
    return {
      comments: [
          {
              id:1,
              userLogo:'user1.jpg',
              username:'123',
              createTime:'2020-01-23',
              content:"great!"
          },
          {
              id:2,
              userLogo:'user2.jpg',
              username:'456',
              createTime:'2020-01-24',
              content:"great Too!"
          },
          {
              id:3,
              userLogo:'user3.jpg',
              username:'789',
              createTime:'2020-01-24',
              content:"great Too!"
          },
          {
              id:4,
              userLogo:'user1.jpg',
              username:'012',
              createTime:'2020-01-24',
              content:"great Too!"
          },
          {
              id:5,
              userLogo:'user1.jpg',
              username:'012',
              createTime:'2020-01-24',
              content:"great Too!"
          },
          ]
    }
  },
//   computed: {
//     ...mapGetters([
//       'token'
//     ])
//   },
//   async mounted() {
//     await this.fetchComments(this.slug)
//   },
//   methods: {
//     // 初始化
//     async fetchComments(topic_id) {
//       console.log(topic_id)
//       fetchCommentsByTopicId(topic_id).then(response => {
//         const { data } = response
//         this.comments = data
//       })
//     }
//   }
}
</script>

<style>
.comments-title{
  font-weight:700;
  font-size:0.6rem;
  margin-left:2%;
}

.comments-records{
    height:40vh;
    overflow:scroll;
}
</style>