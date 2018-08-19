<template>
  <div class="col-sm-9 main">
    <nav class="navbar navbar-light bg-light navbar-expand-sm" style="margin: 20px 0px 20px 0px;">
      <ul class="navbar-nav">
        <li class="active nav-item">
          <router-link class="nav-link" to="/topic/java">Java</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/topic/spring">Spring</router-link>
        </li>
      </ul>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
  import BlogList from './BlogList'

  export default {
    name: "AppContentMain",
    components: {BlogList}
  }
</script>

<style scoped>
  .main {
    margin-top: 10px;
    background-color: white;
  }


</style>