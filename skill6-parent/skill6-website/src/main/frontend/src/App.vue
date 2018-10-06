<template>
    <div id="app">
        <Header></Header>
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
    import Header from "./component/Header";

    export default {
        name: 'app',
        components: {Header, AppFooter, RedHr, AppContent, RedLine}
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
