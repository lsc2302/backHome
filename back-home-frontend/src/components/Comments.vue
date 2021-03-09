<template>
  <div class="comments">
    <span class="comments-title">Comments</span>
    <hr />
    <div class="comments-records">
        <comment
        v-for="comment in commentsList"
        :key="comment.id"
        :comment="comment"
        />
    </div>
  </div>
</template>

<script>
import Comment from '@/components/Comment'
export default {
  name: 'Comments',
  components: {
    Comment
  },
  props:['comments'],
  data() {
    return {
      commentsList:[],
    }
  },
  watch:{
    comments:function(newComments,oldComments){
      if(newComments && newComments.length>=1){
        this.commentsList = newComments;
      }
      console.log(this.commentsList)
    }
  }
}
</script>

<style scoped>
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