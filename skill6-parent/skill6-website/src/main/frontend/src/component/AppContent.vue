<template>
    <div class="container" id="app-content">
        <div class="row">
            <AppContentMain></AppContentMain>
            <AppContentRight></AppContentRight>
        </div>
    </div>
</template>

<script>
    import AppContentMain from "./AppContentMain";
    import AppContentRight from "./AppContentRight";
    import RedLine from "./RedLine";

    export default {
        name: "AppContent",
        components: {RedLine, AppContentRight, AppContentMain}
    }
</script>

<style scoped>
    #app-content {
        margin-top: 10px
    }
</style>