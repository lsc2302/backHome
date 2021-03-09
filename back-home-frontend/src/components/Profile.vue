<template>
    <div class="container">
        <img :src="require('@/userLogos/'+avatar)" class="Avatar" v-show="!!user" />
        <div class="Name">{{user}}</div>
        <span class="Logout" @click="logout" v-show="!!user">Logout</span>
        <div class="toLogin" @click="toLogin" v-show="!user">Please Login to see your profile</div>
    </div>
</template>

<script>
import {getUserInfo} from '@/api/auth/auth';
import { mapGetters } from 'vuex'
export default {
    data(){
        return {
            avatar:'user.jpg',
        }
    },
    computed: {
        ...mapGetters(['token', 'user'])
    },
    methods:{
        fetchProfile(){
            getUserInfo('admin').then((res)=>{
                console.log(123,res)
                let profile = res.data;
                this.avatar = profile.avatar;
            })
        },
        
        async logout() {
            this.$store.dispatch('user/logout').then(() => {
                this.$message.info('Logout Successfully!')
                setTimeout(() => {
                this.$router.push({ path: '/login' })
                }, 500)
            })
        },
        toLogin(){
            this.$router.push({ path: '/login' });
        }
    },
    async mounted(){
        await this.fetchProfile();
    }
}
</script>

<style scoped>
.container{
    position: relative;
    height:100%;
    width:100%;
    box-sizing: content-box;
    display: block;
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

.Logout{
    position: absolute;
    bottom:10%;
    right:10%;
    color:blue;
    font-size:15px;
}

.toLogin{
    margin-top:70%;
    color:blue;
    font-size:20px;
    width:100%;
}
</style>