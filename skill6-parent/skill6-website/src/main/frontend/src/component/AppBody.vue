<template>
    <div class="container" style="margin-top: 10px">
        <div class="row">
            <div class="col-md-9 col-sm-6" style="padding: 5px">
                <div style="background-color: white;padding: 15px;">
                    <router-view></router-view>
                </div>
            </div>
            <div class="col-md-3 col-sm-6" style="padding: 5px">
                <site-statistics></site-statistics>
                <site-statistics></site-statistics>
                <site-statistics></site-statistics>
            </div>
        </div>
    </div>
</template>

<script>
    import SiteStatistics from "./SiteStatistics";

    export default {
        name: "AppBody",
        components: {SiteStatistics}
    }
</script>

<style scoped>

</style>