<template>
  <div class="container">
      <el-tabs v-model="activeName" class="tabs">
        <el-tab-pane label="Sign In" name="first" :key="'first'">
            <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-width="80px" class="login-box">
                <el-form-item label="Account" prop="username" class="form-item">
                <el-input type="text" v-model="loginForm.name"/>
                </el-form-item>
                <el-form-item label="Password" prop="password" class="form-item">
                <el-input type="password" v-model="loginForm.pass"/>
                </el-form-item>
                <el-form-item>
                <el-button type="primary" v-on:click="onLogin('loginForm')">Sign In</el-button>
                </el-form-item>
            </el-form>
        </el-tab-pane>
        <el-tab-pane label="Sign Up" name="second" :key="'second'">
            <el-form ref="registerForm" :model="registerForm" :rules="registerRules" label-width="80px" class="login-box">
                <el-form-item label="Account" prop="username">
                <el-input type="text" v-model="registerForm.name"/>
                </el-form-item>
                <el-form-item label="Password" prop="password">
                <el-input type="password" v-model="registerForm.pass"/>
                </el-form-item>
                <el-form-item>
                <el-button type="primary" v-on:click="onRegister('registerForm')">Sign Up</el-button>
                </el-form-item>
            </el-form>
        </el-tab-pane>
      </el-tabs>
  </div>
</template>

<script>
import { userRegister } from '@/api/auth/auth'

export default {
 data() {
      return {
        activeName: "first",
        loginForm: {
          name: '',
          pass: ''
        },
        loginRules: {
          name: [
            {required: true, message: 'Empty Account Not Allowed!', trigger: 'blur'}
          ],
          pass: [
            {required: true, message: 'Empty Password Not Allowed!', trigger: 'blur'}
          ]
        },
        registerForm: {
          name: '',
          pass: ''
        },
        registerRules: {
          name: [
            {required: true, message: 'Empty Account Not Allowed!', trigger: 'blur'}
          ],
          pass: [
            {required: true, message: 'Empty Password Not Allowed!', trigger: 'blur'}
          ]
        },
      }
    },
    methods: {
      onRegister(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            userRegister(this.registerForm)
            .then((value) => {
              const { code, message } = value
              if (code === 200) {
                this.$message({
                  message: 'Register Success',
                  type: 'success'
                })
              setTimeout(() => {
                this.loading = false
                this.activeName= "first";
              }, 0.1 * 1000)
              }else{
                this.$message.error('Register Failed' + message);
              }
          })
          }
          else {
            return false;
          } 
        });
      },
      onLogin(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.loginForm);
            this.$store
            .dispatch("user/login", this.loginForm)
            .then(() => {
              this.$message({
                message: "Login Successfully!",
                type: "success",
                duration: 2000,
              });
              setTimeout(() => {
                this.$router.push({ path: "/landing" });
              }, 0.1 * 1000);
            })
            .catch(() => {
               this.$message.error('Login Failed' + message);
            });
          }
          else {
            return false;
          } 
        });
      }
    }
}
</script>

<style scoped>
.container{
    height:100%;
    width:100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    background: url('../assets/bg.jpeg') no-repeat;
    background-size:cover;
}

.tabs{
    width:90%;
    margin-top:-45%;
    box-sizing: border-box;
    background-color: white;
    padding:5%;
    border-radius:5%;
}

.login-box {
    width: 80vw;
}

.form-item {
    text-align: left;
}

.login-title {
    text-align: center;
    margin: 0 auto 40px auto;
    color: #303133;
}
</style>