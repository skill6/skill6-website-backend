<template>
    <div>
        <form method="get" action="javascript:exit(0)">
            <div class="form-group">
                <label for="exampleInputEmail1">邮箱/用户名</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                       placeholder="请输入邮箱/用户名">
                <small id="emailHelp" class="form-text text-muted">十分重要
                </small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
            </div>
            <div class="g-recaptcha" data-sitekey="6LcQzHMUAAAAAJ_v7fN7cnvhnPqypGPGZ_XA6AQ7"></div>
            <div style="height: 10px"></div>
            <button type="submit" class="btn btn-primary" @click="login">登录</button>
        </form>
    </div>
</template>

<script>
    export default {
        name: "Login",
        methods: {
            login: function () {
            }
        },
        mounted: function () {
        }
    }
</script>

<style scoped>

</style>