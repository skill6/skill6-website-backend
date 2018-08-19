<template>
  <header class="navbar navbar-expand-sm navbar-light">
    <nav class="container">
      <a class="navbar-brand" href="./">
        <img src="../images/logo/logo.jpg" style="padding: 3px;width: 90px;margin-top: -8px">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#headerlist"
              aria-controls="headerlist" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div id="headerlist" class="navbar-collapse collapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active"><a class="nav-link" href="/topic">技术专题</a></li>
          <li class="nav-item"><a class="nav-link" href="/qa">问答</a></li>
          <li class="nav-item"><a class="nav-link" href="/project">项目</a></li>
          <li class="nav-item"><a class="nav-link" href="/code">代码库</a></li>
          <li class="nav-item"><a class="nav-link" href="/source">资源</a></li>
          <li class="nav-item"><a class="nav-link" href="/talk">灌水区</a></li>
          <li class="nav-item"><a class="nav-link" href="/developing">开发中</a></li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item"><a class="nav-link" href="./login">登录</a></li>
          <li class="nav-item"><a class="nav-link" href="./signup">注册</a></li>
        </ul>
      </div>
    </nav>
  </header>
</template>
<script>
  export default {
    name: "AppHeader"
  }
</script>

<style scoped>
  header {
    font-size: 15px;
    background-color: white;
  }
</style>