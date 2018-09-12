<template>
  <div id="app">
    <header class="navbar navbar-expand-sm navbar-light">
      <nav class="container">
        <a class="navbar-brand" href="/">
          <img src="./images/logo/logo.jpg" style="padding: 3px;width: 90px;margin-top: -8px">
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
              <router-link class="nav-link" to="/qa">问答</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/project">项目</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/blog/editor">写博客</router-link>
            </li>
          </ul>
          <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="./login">登录</a></li>
            <li class="nav-item"><a class="nav-link" href="./signup">注册</a></li>
          </ul>
        </div>
      </nav>
    </header>
    <RedLine w=100% h=2px></RedLine>
    <router-view></router-view>
    <RedHr w="100%" h="2px"></RedHr>
    <AppFooter></AppFooter>
  </div>
</template>
<script>
  import RedLine from "./component/RedLine";
  import AppContent from "./component/AppContent";
  import RedHr from "./component/RedHr";
  import AppFooter from "./component/AppFooter";
  import 'vue-router'

  export default {
    name: 'app',
    components: {AppFooter, RedHr, AppContent, RedLine}
  }
</script>

<style>
  #app {
    background-color: #eeeeee;
  }

  header {
    font-size: 15px;
    background-color: white;
  }

  * {
    font-size: 15px;
  }
</style>
