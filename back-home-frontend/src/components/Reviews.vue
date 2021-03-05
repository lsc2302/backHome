<template>
  <div class="reviews">
    <span class="plot-title">Ratings</span>
    <div id="plot" style="width: 300px;height:100px;"></div>
    <Comments></Comments>
  </div>
</template>

<script>
import Comments from '@/components/Comments'

export default {
  components: { Comments },
  name: 'reviewsChart',
  data:function(){
    return {
      ratingsData:[5, 20, 36, 10, 10]
      };
  },
  components:{
    Comments,
  },
  computed:{
    ratingsPercentData:function(){
      let sum = this.ratingsData.reduce((prev, next, index, array) => prev + next);
      let res = [];
      for(let val of this.ratingsData){
        res.push((val/sum).toFixed(3)*100)
      }
      return res;
    }
  },
  methods:{
	  createReviewsChart(){
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
          data: this.ratingsPercentData,
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
		  }
  },
  mounted() {
    console.log(this.ratingsPercentData)
  	this.createReviewsChart();
  }
}
</script>

<style>
.reviews{
  text-align: left;
}

.plot-title{
  font-weight:700;
  font-size:0.6rem;
  margin-left:2%;
}
</style>
