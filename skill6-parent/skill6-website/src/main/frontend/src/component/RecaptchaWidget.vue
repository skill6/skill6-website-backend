<template>
    <div :id="id"></div>
</template>

<script>
    export default {
        name: "RecaptchaWidget",
        data: function () {
            return {
                id: 'recaptcha-div',
                widget: null
            }
        },
        methods: {
            init: function () {
                var that = this;
                // 人机验证模块全局仅初始化一次，需要显示时将起添加至需要显示的位置
                var recaptcha = document.getElementById('recaptcha');
                document.getElementById(that.id).appendChild(recaptcha);
                $(recaptcha).show();
                that.widget = recaptcha;
            }
        },
        mounted: function () {
            this.init();
        },
        beforeDestroy: function () {
            // 无需显示时人机验证模块及时收回
            grecaptcha.reset(0);
            $(this.widget).hide();
            document.body.appendChild(this.widget);
        }
    }
</script>

<style scoped>

</style>