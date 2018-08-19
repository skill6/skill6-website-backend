<template>
  <div class="col-sm-3 main">
    <SiteStatistics></SiteStatistics>
    <SiteStatistics></SiteStatistics>
    <SiteStatistics></SiteStatistics>
    <SiteStatistics></SiteStatistics>
  </div>
</template>

<script>
  import SiteStatistics from "./SiteStatistics";

  export default {
    name: "AppContentRight",
    components: {SiteStatistics}
  }
</script>

<style scoped>
  .main {
    margin-top: 10px;
  }
</style>