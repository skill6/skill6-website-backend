<template>
  <div class="col-md-9 main">
    <h4>Java代码</h4>
    <hr>
    <p></p>
  </div>
</template>

<script>
  import $ from 'jquery/dist/jquery.min'

  export default {
    name: "Article",
    data: function () {
      return {
        article: null
      }
    },
    methods: {
      getArticle: function () {
        $.ajax({
          url: "/article",
          method: "get",
          success: function (resp) {

          }
        })
      }
    },
    mounted: function () {
      $('title').text('Java 代码');
    }
  }
</script>

<style scoped>
  .main {
    margin-top: 10px;
    background-color: white;
    padding: 10px;
  }
</style>