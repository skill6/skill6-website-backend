<template>
  <div class="container main" id="app-content">
    <div class="row">
      <Article></Article>
      <AppContentRight></AppContentRight>
    </div>
  </div>
</template>

<script>
  import AppContentMain from "./AppContentMain";
  import AppContentRight from "./AppContentRight"
  import Article from "./Article";

  export default {
    name: "Blog",
    components: {Article, AppContentMain, AppContentRight}
  }
</script>

<style scoped>
 .main {
   margin-top: 10px;
 }
</style>