<template>
    <baidu-map class="bm-view"
    :center="mapCenter"
    :zoom="zoom" 
    :scroll-wheel-zoom='true'
    >
    <bm-scale anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-scale>
    <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
    <div v-for="(location, idx) in locations" :key="idx">
        <bm-marker 
            :position="{lng: location.lng, lat: location.lat}" 
            :dragging="true" 
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
                zoom: 8,
                locations:[
                    {   
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
                    },{
                        showFlag:false,
                        name:'TargetDx Laboratory',
                        address:'6541-B Via Del Oro, San Jose, CA95119',
                        lng:'-121.784092',
                        lat:'37.235191',
                        fees:'N/A',
                        hours:'N/A',
                        appointment:'N/A',
                        reportTo:'CHINA Consulate San Francisco',
                        showIGG:'N/A',
                        NProteinTest:'N/A',
                        contactWeChat:'N/A',
                        contactPhone:'(219)-510-0120',
                        contactEmail:'info@targetdxlab.com ',
                        contactWeb:'www.targetdxlab.com',
                    }
                ]
            }
    },
    computed:{
        mapCenter:function(){
            let lat=0,lng=0,num=0;
            for(let loc of this.locations){
                lat += parseFloat(loc.lat);
                lng += parseFloat(loc.lng);
                num += 1;
            }
            lat /= num;
            lng /= num;
            return {lat:lat,lng:lng}
        }
    },
    methods:{
        infoWindowOpen(location){
            location.showFlag = !location.showFlag;
            this.$emit("fillLocation", location);
        },
        infoWindowClose(location){
            location.showFlag = false;
        },
    },
}
</script>
<style>
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

