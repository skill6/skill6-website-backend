<template>
  <div id="app">
    <AppHeader></AppHeader>
    <RedLine w=100% h=2px></RedLine>
    <AppContent></AppContent>
    <RedHr w="100%" h="2px"></RedHr>
    <AppFooter></AppFooter>
  </div>
</template>
<script>
  import AppHeader from "./component/AppHeader";
  import RedLine from "./component/RedLine";
  import AppContent from "./component/AppContent";
  import RedHr from "./component/RedHr";
  import AppFooter from "./component/AppFooter";

  export default {
    name: 'app',
    components: {AppFooter, RedHr, AppContent, RedLine, AppHeader}
  }
</script>

<style>
  #app {
    background-color: #eeeeee;
  }
  * {
    font-size: 15px;
  }
</style>
