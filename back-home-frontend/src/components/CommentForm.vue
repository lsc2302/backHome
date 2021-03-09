<template>
    <div class="submit-form">
      <el-form @submit.prevent="onSubmit">
        <div class="header">
        <el-form-item label="Please rate this site" class="stars-intro">
          <el-select v-model="ratings" placeholder="please select your ratings" class="stars">
            <el-option label="1" value=1></el-option>
            <el-option label="2" value=2></el-option>
            <el-option label="3" value=3></el-option>
            <el-option label="4" value=4></el-option>
            <el-option label="5" value=5></el-option>
          </el-select>
        </el-form-item>
        </div>
        <textarea
        v-model.lazy="commentText"
        maxlength="400"
        placeholder="Add a comment..."
        class="submit-content"
        cols=20
        rows=15
        ></textarea>
        <div class="button-wrapper">
          <el-button type="primary" @click="onSubmit">Comment</el-button>
        </div>
      </el-form>
    </div>
</template>

<script>
import { pushComment } from '@/api/comment'
export default {
  name: 'CommentsForm',
  data() {
    return {
      commentText: '',
      ratings:'5',
    }
  },
  props: ['cur-location'],
  methods: {
    async onSubmit() {
      try {
        let postData = {}
        console.log(this.commentText,this.ratings,this.curLocation, this.curLocation.id);
        postData['site_id'] = this.curLocation.id;
        postData['content'] = this.commentText;
        postData['stars'] = this.stars;
        await pushComment(postData,"admin")
        this.$message.success('Success!')
      } catch (e) {
        
      } finally {
      }
    }
  },
  watch:{
    curLocation:function(newCurLocation, oldCurLocation){
        this.curLocation = newCurLocation;
    }
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
.header{
  display: flex;
  flex-direction: row;
  align-items: center;
  width:90%;
  margin-left:5%;
}
.stars{
  width:30%;
}
</style>