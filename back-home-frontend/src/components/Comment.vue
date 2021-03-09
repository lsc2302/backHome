<template>
  <article class="comment">
    <div class="comment-header">
        <img :src="require('@/userLogos/'+comment.avatar)" class="userLogo">
        <div class="comment-title">
            <strong>{{ comment.username }}</strong>
            <span class="comment-time">{{ new Date(comment.createTime).toDateString() }}</span>
            <br />
        </div>
    </div>
    <div>
        {{ comment.content }}
    </div>
  </article>
</template>

<script>
export default {
  name: 'LvCommentsItem',
  props: {
    comment: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
.comment{
    margin-bottom:0.5rem;
    font-size:15px;
}
.comment-header{
    display: flex;
    flex-direction: row;
    height:1rem;
    margin-bottom: 0.2rem;
    align-items: flex-end;
}
.userLogo{
    height:1rem;
    margin-right:0.1rem;
}
.comment-title{
    flex:1;
}
.comment-time{
    color:gray;
    font-size:10px;
}
</style>