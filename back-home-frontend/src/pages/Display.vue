<template>
    <div class="container">
        <div class="home" v-show="active==='home'">
            <Map class="full-map" @fillLocation="fillLocationFunc" :locations="Locations"></Map>
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
                        <Reviews :cur-location="curLocation"></Reviews>
                    </el-tab-pane>
                    <el-tab-pane label="comment" name="third" :key="'third'">
                        <CommentForm :cur-location="curLocation"></CommentForm>
                    </el-tab-pane>
                </el-tabs>
            </div>
        </div>
        <div class="profile" v-show="active==='profile'">
            <Profile></Profile>
        </div>
        <div class="bottom">
            <div @click="switchFunc('home')">
                <img src="../assets/home_black.jpeg" class="nav-icon" v-if="active==='home'" />
                <img src="../assets/home_white.jpeg" class="nav-icon" v-else/>
            </div>
            <div @click="switchFunc('profile')">
                <img src="../assets/profile_black.jpeg" class="nav-icon" v-if="active==='profile'"/>
                <img src="../assets/profile_white.jpeg" class="nav-icon" v-else/>
            </div>
        </div>
    </div>
</template>

<script>
import Map from '@/components/Map'
import Info from '@/components/Info'
import Reviews from '@/components/Reviews'
import CommentForm from '@/components/CommentForm'
import getSites from '@/api/sites'
import Profile from '@/components/Profile'

export default {
    name:'Display',
    data(){
        return {
            activeName: "first",
            showInfo:false,
            curLocation:null,
            Locations:[],
            active:'home'
        }
    },
    components:{
        Map,
        Info,
        Reviews,
        CommentForm,
        Profile
    },
    methods:{
        showInfoFunc:function(location){
            this.showInfo = true;
        },
        hideInfoFunc:function(){
            this.showInfo = false;
        },
        fillLocationFunc(location){
            this.curLocation = location;
        },
        fetchSites(){
            let region = sessionStorage.getItem('region');
            getSites(region).then((res)=>{
                let locations = res.data;
                this.Locations = locations;
                this.curLocation = locations[0];
            })
        },
        switchFunc(name){
            this.active = name;
        }
    },
    async mounted() {
        await this.fetchSites();
    },

}
</script>

<style scoped>
.container{
    position: relative;
    height:100%;
    width:100%;
    box-sizing: content-box;
}

.home{
    position: absolute;
    bottom:10%;
    height:90%;
    width:100%;
}

.profile{
    position: absolute;
    bottom:10%;
    height:90%;
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
    box-shadow: -2px -2px 4px  -2px #000000,2px -2px 4px -2px  #000000;
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
    box-shadow: -2px -2px 4px  -2px #000000,2px -2px 4px -2px  #000000;
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

.bottom{
    position:absolute;
    bottom:0;
    height:10%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    border-top: 1px solid rgba(0,0,0,0.1);
}

.nav-icon{
    width:10%;
}

</style>