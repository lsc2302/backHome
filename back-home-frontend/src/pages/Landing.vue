<template>
    <div class="container">
        <div class="intro">
            <label>Please select the country you are living</label>
            <el-select v-model="curCountry" class="stars">
            <el-option label="United States" value='US'></el-option>
            <el-option label="Canada" value='CA'></el-option>
        </el-select>
        </div>
        <div class="intro">
            <label>Please select the region you are living</label>
            <el-select v-model="curRegion" class="stars">
            <el-option  
                v-for="region in regionsDict[curCountry]"
                :key="region"
                :label="region" 
                :value="abbr[region]">
            </el-option>
        </el-select>
        </div>
        <div class="nextWrapper">
            <img :src="require('@/assets/next.jpeg')" 
            @click="nextHandler"
            class="next" />
            <span class="nextText">Next</span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Landing',
    data() {
        return {
            curCountry:'US',
            curRegion:'San Francisco',
            regionsDict:{
                'US':['San Francisco','Los Angles','Seattle','New York','Huston','Chicago'],
                'CA':['Ottawa','Toronto','Vancouver','Calgary','Montreal']
            },
            abbr:{
                'San Francisco':'SF',
                'Los Angles':'LA',
                'Seattle':'SEA',
                'New York':'NY',
                'Huston':'HOU',
                'Chicago':'CHI',
                'Ottawa':'OTT',
                'Toronto':'GTA',
                'Vancouver':'VAN',
                'Calgary':'CAL',
                'Montreal':'MON'
            }
        }
    },
    watch:{
        curCountry:function(newVal,oldVal){
            this.curRegion = this.regionsDict[newVal][0];
            sessionStorage.setItem('country',newVal);
            sessionStorage.setItem('region',this.curRegion);
        },
        curRegion:function(newVal,oldVal){
            sessionStorage.setItem('region',newVal);
        }
    },
    mounted(){
        sessionStorage.setItem('country','US');
        sessionStorage.setItem('region','SF');
    },
    methods:{
        nextHandler(){
            this.$router.push({ path: '/display' })
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
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
.intro{
    font-size:15px;
    margin-bottom:20%;
}

.nextWrapper{
    height:8%;
    width:100%;
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top:10%;
}

.next{
    height:60%;
    margin-right:2%;
}
</style>