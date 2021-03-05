<template>
    <div class="submit-form">
      <form @submit.prevent="onSubmit">
        <textarea
        v-model.lazy="commentText"
        maxlength="400"
        placeholder="Add a comment..."
        :disabled="isLoading" 
        class="submit-content"
        cols=20
        rows=20
        ></textarea>
        <div class="button-wrapper"><el-button type="primary">Comment</el-button></div>
      </form>
    </div>
</template>

<script>
// import { pushComment } from '@/api/comment'
export default {
  name: 'CommentsForm',
  data() {
    return {
      commentText: '',
    }
  },
  props: {
    // slug: {
    //   type: String,
    //   default: null
    // }
  },
  methods: {
    // async onSubmit() {
    //   try {
    //     let postData = {}
    //     console.log(this.commentText)
    //     postData['content'] = this.commentText
    //     postData['topic_id'] = this.slug
    //     await pushComment(postData)
    //     this.$emit('loadComments', this.slug)
    //     this.$message.success('Success!')
    //   } catch (e) {
        
    //   } finally {
    //   }
    // }
  }
}
</script>

<style scoped>
.submit-content{
    height:50%;
    width:90%;
}
.button-wrapper{
    margin-top:0.5rem;
    text-align:right;
}
</style>