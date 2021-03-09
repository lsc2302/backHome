<template>
  <div class="reviews">
    <span class="plot-title">Ratings</span>
    <div id="plot" style="width: 300px;height:100px;"></div>
    <Comments :comments=comments></Comments>
  </div>
</template>

<script>
import Comments from '@/components/Comments'
import {getCommentsBySiteId} from '@/api/comment'

export default {
  components: { Comments },
  name: 'reviewsChart',
  data(){
        return {
            comments:[]
        }
    },
  props: ['cur-location'],
  components:{
    Comments,
  },
  methods:{
	  createReviewsChart(ratingsPercentData){
		  var reviewsChart = this.$echarts.init(document.getElementById('plot'));
		  var option = {
			  yAxis: {
          data: [1,2,3,4,5],
          axisLabel:{
            interval:0
          },
          axisLine:{
            show:false
          },
          axisTick:{
            show:false
          },
          barCateGoryGap:10,
        },
        grid: {
          left: '0%',
          top:'15%',
          containLabel: true,
          height:70
        },
			  xAxis: {
          show:false,
          axisLabel:{
            show:false,
            interval:0
          },
        },
			  series: [{
				  name: 'ratings',
				  type: 'bar',
          data: ratingsPercentData,
          barWidth:'10',
          label:{
            show: true,
            position:'right',
            color:'#000',
            formatter: '{c}%'
          }
        }],
        color:"#FFD700"
		  };
		  reviewsChart.setOption(option);
      },
      fetchComments(siteid){
            getCommentsBySiteId(siteid).then((res)=>{
                let comments = res.data;
                this.comments = comments;
                let stars = [0,0,0,0,0];
                for(let comment of comments){
                  stars[comment.stars-1] += 1;
                }
                let sum = stars.reduce((prev, next, index, array) => prev + next);
                let per = [];
                for(let val of stars){
                  per.push((val/sum).toFixed(2)*100)
                }
                this.createReviewsChart(per);
            })
        }
  },
  watch:{
    curLocation:async function(newCurLocation, oldCurLocation){
       if(newCurLocation){
         await this.fetchComments(newCurLocation.id);
      }
    }
  },
}
</script>

<style scoped>
.reviews{
  text-align: left;
}

.plot-title{
  font-weight:700;
  font-size:0.6rem;
  margin-left:2%;
}
</style>
