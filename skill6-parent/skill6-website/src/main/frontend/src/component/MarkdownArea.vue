<template>
  <div id="markdown">
    <p v-html="html" id="markdown-body"></p>
  </div>
</template>

<script>

  export default {
    name: "MarkdownArea",
    props: {
      "md_content": [String]
    },
    data: function () {
      return {
        html: null
      }
    },
    methods: {
      toHtml: function () {
        var that = this;
        $.ajax({
          url: "/md",
          data: JSON.stringify({
            text: that.md_content
          }),
          method: "post",
          contentType: "application/json;charset=utf-8",
          success: function (t) {
            that.html = t;
            that.$nextTick(function () {
              $("#markdown-body table").addClass("table table-striped");
              $("#markdown-body img").css("max-width", "100%");
              console.info($("#markdown-body table"))
            })
          }
        })
      }
    },
    mounted: function () {
      this.toHtml()
    }
  }

</script>

<style scoped>
  #markdown-body img {
    max-width: 100%;
  }

  #markdown-body hr {
    background-color: red;
  }
</style>