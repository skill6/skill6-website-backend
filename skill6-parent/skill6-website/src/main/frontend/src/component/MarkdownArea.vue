<template>
  <div id="markdown">
    <p v-html="html" id="markdown-body"></p>
  </div>
</template>

<script>

  import scriptjs from 'scriptjs'

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
          url: "https://api.github.com/markdown",
          data: JSON.stringify({
            text: that.md_content,
            model: "markdown"
          }),
          method: "post",
          contentType: "application/json;charset=utf-8",
          success: function (t) {
            that.html = t;
            $("#markdown-body table").addClass("table table-striped");
            console.info(t)
          }
        })
      }
    },
    mounted: function () {
      console.info(jQuery)
      var script = document.createElement("script")
      script.src = "/editormd/editormd.min.js";
      script.type = "text/javascript"
      $('body').append(script)
    }
  }

</script>

<style>

</style>