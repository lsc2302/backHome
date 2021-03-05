<template>
<div class="info">
    <div class="record">
        <span class="title">Agency Name:</span>
        <span class="value">{{curLocation&&curLocation.name}}</span>
    </div>
    <div class="record">
        <span class="title">Address:</span>
        <span class="value">{{curLocation&&curLocation.address}}</span>
    </div>
    <div class="record">
        <span class="title">Testing fees:</span>
        <span class="value">{{curLocation&&(curLocation.fees === 'N/A'?'N/A':'$'+curLocation.fees)}}</span>
    </div>
    <div class="record">
        <span class="title">Available hours:</span>
        <span class="value">{{curLocation&&curLocation.hours}}</span>
    </div>
    <div class="record">
        <span class="title">Appointment:</span>
        <span class="value">{{curLocation&&curLocation.appointment}}</span>
    </div>
    <div class="record">
        <span class="title">Report To:</span>
        <span class="value">{{curLocation&&curLocation.reportTo}}</span>
    </div>
    <div class="record">
        <span class="title">Show IGG:</span>
        <span class="value">{{curLocation&&curLocation.showIGG}}</span>
    </div>
    <div class="record">
        <span class="title">SARS-CoV-2 N protein Test:</span>
        <span class="value">{{curLocation&&curLocation.NProteinTest}}</span>
    </div>
    <div class="record">
        <div class="title">Contact:</div>
        <div class="contact-methods">
            <div class="contact-method">
                <div class="contact-wrapper">
                    <img src="../assets/wechat.png" class="contact-logo"/>
                    <span>WeChat:{{curLocation&&curLocation.contactWeChat}}</span>
                </div>
                <div class="contact-wrapper">
                    <img src="../assets/phone.png" class="contact-logo"/>
                    <span>Phone:{{curLocation&&curLocation.contactPhone}}</span>
                </div>
                <div class="contact-wrapper">
                    <img src="../assets/email.png" class="contact-logo"/>
                    <span>Email:{{curLocation&&curLocation.contactEmail}}</span>
                </div>
                <div class="contact-wrapper">
                    <img src="../assets/web.png" class="contact-logo"/>
                    <span>Web:{{curLocation&&curLocation.contactWeb}}</span>
                </div>
            </div>
        </div>
    </div>
</div>
</template>

<script>

export default {
    name:'Info',
    props: ['cur-location'],
    data(){
        return {
        }
    },
    created:function(){
    }
}
</script>

<style>

.info{
    height:60vh;
    overflow-y:scroll;
}

.record{
    text-align:left;
    margin-bottom: 0.5rem;
    font-size:0.5rem;
}

.title{
    margin:0;
    font-size:0.5rem;
    font-weight:700;
}

.contact-logo{
    width:0.8rem;
    margin-left: 0.5rem;
    margin-right:1rem;
}

.contact-wrapper{
    height:1rem;
    margin: 0.5rem 0;
    display: flex;
    flex-direction: row;
    align-items: center;
}

</style>