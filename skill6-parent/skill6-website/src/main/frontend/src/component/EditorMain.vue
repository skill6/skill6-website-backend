<template>
  <div class="container" style="padding: 0px;margin-top: 20px">
    <!--<div class="col-md-6" style="height: 300px;background-color: red"></div>-->
    <!--<div class="col-md-6"></div>-->
    <div id="blog-header"
         style="background-color: white;border-radius: 5px;min-height: 30px;margin-bottom: 10px;padding: 10px">
      <div id="title">
        <span><router-link to="/topic" style="color: #2268d0;">topic</router-link></span>
        <span> / </span>
        <input id="titleval"
               style="height: 35px;padding: 6px 8px 6px 8px;border-radius: 5px;font-size: 14px;border: 1px solid #d1d5da;min-height: 34px;height: 20px"/>
        <button class="btn btn-sm" type="button" style="margin: 0px 0px 5px 5px;padding: 3px 10px;font-size: 12px;"
                data-clipboard-target="#titleval" id="title-val-clip">
          <svg class="octicon octicon-clippy" viewBox="0 0 14 16" version="1.1" width="14" height="16"
               style="vertical-align: -2px;"
               aria-hidden="true">
            <path fill-rule="evenodd"
                  d="M2 13h4v1H2v-1zm5-6H2v1h5V7zm2 3V8l-3 3 3 3v-2h5v-2H9zM4.5 9H2v1h2.5V9zM2 12h2.5v-1H2v1zm9 1h1v2c-.02.28-.11.52-.3.7-.19.18-.42.28-.7.3H1c-.55 0-1-.45-1-1V4c0-.55.45-1 1-1h3c0-1.11.89-2 2-2 1.11 0 2 .89 2 2h3c.55 0 1 .45 1 1v5h-1V6H1v9h10v-2zM2 5h8c0-.55-.45-1-1-1H8c-.55 0-1-.45-1-1s-.45-1-1-1-1 .45-1 1-.45 1-1 1H3c-.55 0-1 .45-1 1z"></path>
          </svg>
        </button>
        <span> or </span>
        <a href="JavaScript:history.go(-1)">cancel</a>
      </div>
    </div>
    <div id="md-editor" style="background-color: white;margin-top: 10px"></div>
  </div>
</template>

<script>
  export default {
    name: "EditorMain",
    methods: {
      initEditor: function () {

      }
    },
    mounted: function () {
      this.initEditor();
      new ClipboardJS("#title-val-clip");
    }
  }
</script>

<style scoped>
  * {
    box-sizing: border-box;
  }

  #md-editor {
    border-radius: 5px;
    height: 2000px;
  }

  #blog-header #title * {
    font-size: 18px;
  }

  .btn {
    color: #24292e;
    border: 1px solid rgba(27, 31, 35, 0.2);
    background-color: #eff3f6;
    background-image: linear-gradient(-180deg, #fafbfc 0%, #eff3f6 90%);
  }
</style>