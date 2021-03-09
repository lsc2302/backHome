<template>
    <baidu-map class="bm-view"
    :center="{lat:0,lng:0}"
    :zoom="8" 
    :scroll-wheel-zoom='true'
    @ready="handleMap"
    >
    <bm-scale anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-scale>
    <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
    <div v-for="(location, idx) in mapLocations" :key="idx">
        <bm-marker 
            :position="{lng: location.lng, lat: location.lat}" 
            :dragging="false" 
            animation="BMAP_ANIMATION_BOUNCE"
            @click="infoWindowOpen(location)"
        >
            <bm-info-window
                :title="location.name"
                :position="{lng: location.lng, lat: location.lat}"
                :show="location.showFlag"
                @close="infoWindowClose(location)"
            ></bm-info-window>
        </bm-marker>
    </div>
    </baidu-map>
</template>
<script>

export default {
    data () {
        return {
                map:null,
                BMap:null,
                mapLocations: [],
            }
    },
    methods:{
        handleMap({ BMap, map }) {
            this.map = map;
            this.BMap = BMap;            
            let center = this.computeCenter(this.mapLocations);
            this.map.centerAndZoom(center,8);
        },
        infoWindowOpen(location){
            location.showFlag = !location.showFlag;
            this.$forceUpdate();
            this.$emit("fillLocation", location);
        },
        infoWindowClose(location){
            location.showFlag = false;
        },
        computeCenter(mapLocations){
            let lat=0,lng=0;
            let num = mapLocations.length;
            if(mapLocations && num>=1){
                for(let loc of mapLocations){
                    lat += parseFloat(loc.lat);
                    lng += parseFloat(loc.lng);
                }
                lat /= num;
                lng /= num;
            }
            return new this.BMap.Point(lng, lat)
        }
    },
    props:['locations'],
    watch:{
        locations() {
            for(let idx in this.locations){
                let loc = this.locations[idx];
                if(idx === "0"){
                    loc.showFlag = true;
                }else{
                    loc.showFlag = false;
                }
                this.mapLocations.push(loc);
            }

        },
        mapLocations(){
            if(this.map){
                let center = this.computeCenter(this.mapLocations);
                this.map.centerAndZoom(center,8);
            }
        }
    }
}
</script>
<style scoped>
.bm-view {
    width: 100%; 
    height: 100%;
}
.BMap_bubble_title {
	font-size:13px;
	font-weight:bold;
	text-align:left;
	padding-left:0;
    border-radius:5px;
}

.BMap_pop div:nth-child(9) {
	border-radius:7px;
}
</style>

