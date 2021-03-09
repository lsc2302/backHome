<template>
  <div class="container">
      <el-tabs v-model="activeName" class="tabs">
        <el-tab-pane label="Sign In" name="first" :key="'first'">
            <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-width="80px" class="login-box">
                <el-form-item label="Account" prop="username" class="form-item">
                <el-input type="text" v-model="form.username"/>
                </el-form-item>
                <el-form-item label="Password" prop="password" class="form-item">
                <el-input type="password" v-model="form.password"/>
                </el-form-item>
                <el-form-item>
                <el-button type="primary" v-on:click="onSubmit('loginForm')">Sign In</el-button>
                </el-form-item>
            </el-form>
        </el-tab-pane>
        <el-tab-pane label="Sign Up" name="second" :key="'second'">
            <el-form ref="registerForm" :model="registerForm" :rules="registerRules" label-width="80px" class="login-box">
                <el-form-item label="Account" prop="username">
                <el-input type="text" v-model="form.username"/>
                </el-form-item>
                <el-form-item label="Password" prop="password">
                <el-input type="password" v-model="form.password"/>
                </el-form-item>
                <el-form-item>
                <el-button type="primary" v-on:click="onSubmit('registerForm')">Sign Up</el-button>
                </el-form-item>
            </el-form>
        </el-tab-pane>
      </el-tabs>
  </div>
</template>

<script>
export default {
 data() {
      return {
        activeName: "first",
        loginForm: {
          username: '',
          password: ''
        },
        loginRules: {
          username: [
            {required: true, message: 'Empty Account Not Allowed!', trigger: 'blur'}
          ],
          password: [
            {required: true, message: 'Empty Password Not Allowed!', trigger: 'blur'}
          ]
        },
        registerForm: {
          username: '',
          password: ''
        },
        registerRules: {
          username: [
            {required: true, message: 'Empty Account Not Allowed!', trigger: 'blur'}
          ],
          password: [
            {required: true, message: 'Empty Password Not Allowed!', trigger: 'blur'}
          ]
        },
        dialogVisible: false
      }
    },
    methods: {
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$router.push("/main/"+this.form.username);
          } else {
            this.dialogVisible = true;
            return false;
          }
        });
      }
    }
}
</script>

<style>
.container{
    height:100%;
    width:100%;
    display: flex;
    flex-direction: row;
    align-items: center;
}

.tabs{
    width:90%;
    margin-left:5%;
    box-sizing: border-box;
}

.login-box {
    width: 90vw;
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