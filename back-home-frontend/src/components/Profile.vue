<template>
    <div class="container">
        <img :src="require('@/userLogos/'+'user1.jpg')" class="Avatar"/>
        <div class="Name">admin</div>
    </div>
</template>

<script>
import getInfoByName from '@/api/user';
export default {

}
</script>

<style>
.container{
    position: relative;
    height:100%;
    width:100%;
    box-sizing: content-box;
}
.Avatar{
    max-height:50%;
    max-width:50%;
    border-radius:50%;
    margin-top:30%;
}

.Name{
    margin-top:20%;
}
</style>