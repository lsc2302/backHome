<template>
    <div class="container">
        <Map class="full-map" @fillLocation="fillLocationFunc"></Map>
        <div :class="{showInfoPopup:showInfo,hideInfoPopup:!showInfo}">
            <div class="arrow-wrapper">
                <img v-if="showInfo" src="../assets/arrow_down.png" class="arrow" @click="hideInfoFunc"/>
                <img v-else src="../assets/arrow_up.png" class="arrow" @click="showInfoFunc"/>
            </div>
            <el-tabs v-model="activeName" >
                <el-tab-pane label="information" name="first" :key="'first'">
                    <Info :cur-location="curLocation"></Info>
                </el-tab-pane>
                <el-tab-pane label="reviews" name="second" :key="'second'">
                    <Reviews></Reviews>
                </el-tab-pane>
                <el-tab-pane label="comment" name="third" :key="'third'">
                    <CommentForm></CommentForm>
                    <!-- <lv-comments-form :slug="slug" v-if="token" @loadComments="fetchComments"/> -->
                </el-tab-pane>
            </el-tabs>
            
        </div>
    </div>
</template>

<script>
import Map from '@/components/Map'
import Info from '@/components/Info'
import Reviews from '@/components/Reviews'
import CommentForm from '@/components/CommentForm'

export default {
    name:'Landing',
    data(){
        return {
            activeName: "first",
            showInfo:false,
            curLocation:{   
                        showFlag:true,
                        name:'Apostle Diagnostics',
                        address:'160 E Tasman Dr, STE 116，San Jose, CA 95134',
                        lng:'-121.368604',
                        lat:'37.264827',
                        fees:'N/A',
                        hours:'N/A',
                        appointment:'N/A',
                        reportTo:'CHINA Consulate San Francisco',
                        showIGG:'N/A',
                        NProteinTest:'N/A',
                        contactWeChat:'N/A',
                        contactPhone:'(888)-992-7678',
                        contactEmail:'support@apostledx.com',
                        contactWeb:'https://apostledx.com',
                    }
        }
    },
    components:{
        Map,
        Info,
        Reviews,
        CommentForm
    },
    methods:{
        showInfoFunc:function(location){
            this.showInfo = true;
        },
        hideInfoFunc:function(){
            this.showInfo = false;
        },
        fillLocationFunc(location){
            console.log("received"+location);
            this.curLocation = location;
            console.log(this.curLocation)
        }
    }
}
</script>

<style>
.container{
    position: relative;
    height:100%;
    width:100%;
    box-sizing: content-box;
}

.full-map{
    height:100%;
    width:100%;
}

.showInfoPopup{
    position:absolute; 
    bottom:0;
    /* top:30%; */
    left:5%;
    height:80%;
    width:90%;
    padding:0 5%;
    z-index: 2; 
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-color:black;
    background-color: white;
    box-shadow: 0 2px 2px 2px rgba(0,0,0,0.1);
    box-sizing: border-box;
}

.hideInfoPopup{
    position:absolute; 
    bottom:0;
    left:5%;
    height:2rem;
    width:90%;
    padding:0 5%;
    z-index: 2; 
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-color:black;
    background-color: white;
    box-shadow: 0 2px 2px 2px rgba(0,0,0,0.1);
    box-sizing: border-box;
    overflow-y:hidden;
}

.arrow-wrapper{
    width:100%;
}

.arrow{
    width:30%;
    height:1.5rem;
}

</style>