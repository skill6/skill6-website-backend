<template>
    <div>
        <header class="navbar navbar-expand-sm navbar-light">
            <nav class="container">
                <a class="navbar-brand" href="/">
                    <img src="../images/logo/logo.jpg" style="padding: 3px;width: 90px;margin-top: -8px">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#headerlist"
                        aria-controls="headerlist" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div id="headerlist" class="navbar-collapse collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <router-link class="nav-link" to="/topic">技术专题</router-link>
                        </li>
                        <li class="nav-item">
                            <router-link class="nav-link" to="/blog/editor">写博客</router-link>
                        </li>
                        <li class="nav-item">
                            <router-link class="nav-link" to="/blog/editor">下载</router-link>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <router-link class="nav-link" to="/login">登录</router-link>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>