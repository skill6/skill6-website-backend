<template>
    <div>
        <div class="row">
            <div id="google-login-btn" class="col-md-6" v-show="google_login_button">
                <div class="loginAbcRioButton loginAbcRioButtonLightBlue" style="margin-bottom: 10px">
                    <div class="loginAbcRioButtonContentWrapper">
                        <div class="loginAbcRioButtonIcon" style="padding:13px">
                            <div style="width:18px;height:18px;">
                                <svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="18px" height="18px"
                                     viewBox="0 0 48 48" class="abcRioButtonSvg">
                                    <g>
                                        <path fill="#EA4335"
                                              d="M24 9.5c3.54 0 6.71 1.22 9.21 3.6l6.85-6.85C35.9 2.38 30.47 0 24 0 14.62 0 6.51 5.38 2.56 13.22l7.98 6.19C12.43 13.72 17.74 9.5 24 9.5z"></path>
                                        <path fill="#4285F4"
                                              d="M46.98 24.55c0-1.57-.15-3.09-.38-4.55H24v9.02h12.94c-.58 2.96-2.26 5.48-4.78 7.18l7.73 6c4.51-4.18 7.09-10.36 7.09-17.65z"></path>
                                        <path fill="#FBBC05"
                                              d="M10.53 28.59c-.48-1.45-.76-2.99-.76-4.59s.27-3.14.76-4.59l-7.98-6.19C.92 16.46 0 20.12 0 24c0 3.88.92 7.54 2.56 10.78l7.97-6.19z"></path>
                                        <path fill="#34A853"
                                              d="M24 48c6.48 0 11.93-2.13 15.89-5.81l-7.73-6c-2.15 1.45-4.92 2.3-8.16 2.3-6.26 0-11.57-4.22-13.47-9.91l-7.98 6.19C6.51 42.62 14.62 48 24 48z"></path>
                                        <path fill="none" d="M0 0h48v48H0z"></path>
                                    </g>
                                </svg>
                            </div>
                        </div>
                        <span style="font-size:15px;line-height:43px;" class="loginAbcRioButtonContents"><span>Sign in with Google</span><span
                                style="display:none">Signed in with Google</span></span>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="loginAbcRioButton loginAbcRioButtonLightBlue">
                    <div class="loginAbcRioButtonContentWrapper">
                        <div class="loginAbcRioButtonIcon" style="padding:13px">
                            <div style="width:18px;height:18px;">
                                <svg height="18" class="octicon octicon-mark-github" viewBox="0 0 16 16" version="1.1"
                                     width="18" aria-hidden="true">
                                    <path fill-rule="evenodd"
                                          d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.013 8.013 0 0 0 16 8c0-4.42-3.58-8-8-8z"></path>
                                </svg>
                            </div>
                        </div>
                        <span style="font-size:15px;line-height:43px;" class="loginAbcRioButtonContents"><span>Sign in with GitHub</span><span
                                style="display:none">Signed in with GitHub</span></span>
                    </div>
                </div>
            </div>
        </div>
        <red-hr></red-hr>
        <form method="get" action="javascript:exit(0)">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>邮箱/用户名</label>
                        <input type="email" class="form-control" aria-describedby="emailHelp"
                               placeholder="请输入邮箱/用户名">
                        <small id="emailHelp" class="form-text text-muted">十分重要</small>
                    </div>
                    <div class="form-group">
                        <label>密码
                            <small>(忘记密码)</small>
                        </label>
                        <input type="password" class="form-control" placeholder="请输入密码">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>点击认证
                            <small>(<a target="_blank" href="https://en.wikipedia.org/wiki/ReCAPTCHA">这是什么？</a>)</small>
                        </label>
                        <recaptcha-widget></recaptcha-widget>
                    </div>
                </div>
            </div>
            <div style="height: 10px"></div>
            <button type="submit" class="btn btn-primary">登录</button>
        </form>
         <div class="row">
         	 <div class="col-md-6" style="margin-left: 100px;">
         		<a href="/connect/qq"><img src="../images/thirdauth/qq_login.png"></a>
				&emsp;
				<a href="/connect/github"><img src="../images/thirdauth/github_login.png"></a>
			</div>
         </div>
    </div>
</template>

<script>
    import RedHr from "./RedHr";
    import RecaptchaWidget from "./RecaptchaWidget";

    export default {
        name: "Login",
        components: {RecaptchaWidget, RedHr},
        data: function () {
            return {
                google_login_button: false
            }
        },
        methods: {
            initGoogleLoginButton: function () {
                if (typeof gapi != 'undefined') {
                    this.google_login_button = true;
                }
            }
        },
        mounted: function () {
            this.initGoogleLoginButton();
        }
    }
</script>

<style scoped>
    .loginAbcRioButton {
        -webkit-border-radius: 1px;
        border-radius: 1px;
        -webkit-box-shadow: 0 2px 4px 0px rgba(0, 0, 0, .25);
        box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .25);
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        -webkit-transition: background-color .218s, border-color .218s, box-shadow .218s;
        transition: background-color .218s, border-color .218s, box-shadow .218s;
        -webkit-user-select: none;
        -webkit-appearance: none;
        background: #fff none;
        color: #262626;
        cursor: pointer;
        outline: none;
        overflow: hidden;
        position: relative;
        text-align: center;
        vertical-align: middle;
        white-space: nowrap;
        width: auto
    }

    .loginAbcRioButton:hover {
        -webkit-box-shadow: 0 0 3px 3px rgba(66, 133, 244, .3);
        box-shadow: 0 0 3px 3px rgba(66, 133, 244, .3)
    }

    .loginAbcRioButtonLightBlue {
        background-color: #fff;
        color: #757575
    }

    .loginAbcRioButtonLightBlue:active {
        background-color: #eee;
        color: #6d6d6d
    }

    .loginAbcRioButtonIcon {
        float: left
    }

    .loginAbcRioButtonBlue .loginAbcRioButtonIcon {
        background-color: #fff;
        -webkit-border-radius: 1px;
        border-radius: 1px
    }

    .loginAbcRioButtonContents {
        font-family: Roboto, arial, sans-serif;
        font-size: 14px;
        font-weight: 500;
        letter-spacing: .21px;
        margin-left: 6px;
        margin-right: 6px;
        vertical-align: top
    }

    .loginAbcRioButtonContentWrapper {
        height: 100%;
        width: 100%
    }

    .loginAbcRioButtonBlue .loginAbcRioButtonContentWrapper {
        border: 1px solid transparent
    }

</style>