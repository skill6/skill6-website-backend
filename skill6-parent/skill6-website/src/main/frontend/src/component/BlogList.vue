<template>
  <div>
    <div id="blog-info-top">
      <div class="blog-info-div blog-info-div-border" v-for="info in blog.top" :key="info.id" :id="info.id">
        <div class="row">
          <div class="col-md-10">
            <h4 style="color: #1b809e;margin-top: 0;margin-bottom: 10px;font-size: 18px"
                v-html="info.title"></h4>
          </div>
          <div class="col-md-2">
                <span style="margin-right: 10px">
                  <i :class="[info['thumb-up-d']?'fa-thumbs-up':'fa-thumbs-o-up','fa']"></i>
                  <span v-html="info['thumb-up']"></span>
                </span>
            <span style="margin-right: 10px">
                <i :class="[info['thumb-down-d']?'fa-thumbs-down':'fa-thumbs-o-down','fa']"></i>
                <span v-html="info['thumb-down']"></span>
              </span>
          </div>
        </div>
        <p>
            <span style="padding: 3px;color: red;background-color: #dddffa;margin: 5px"><i
                class="fa fa-lock"></i>顶置</span>
          <span style="background-color: #337ab7;border-radius: 3px;margin: 5px;color: #ffffff;padding: 3px;"
                v-for=" word in info['key-words']" :key="word" v-html="word"></span>
        </p>
        <p v-html="info.summary"></p>
      </div>
    </div>
    <div id="blog-info-common">
      <div class="blog-info-div blog-info-div-border" v-for="info in blog.common" :id="info.id" :key="info.id">
        <div class="row">
          <div class="col-md-10">
            <h4 style="color: #1b809e;margin-top: 0;margin-bottom: 10px;font-size: 18px" v-html="info.title"></h4>
          </div>
          <div class="col-md-2">
                <span style="margin-right: 10px">
                  <i :class="[info['thumb-up-d']?'fa-thumbs-up':'fa-thumbs-o-up','fa']"></i>
                  <span v-html="info['thumb-up']"></span>
                </span>
            <span style="margin-right: 10px">
                <i :class="[info['thumb-down-d']?'fa-thumbs-down':'fa-thumbs-o-down','fa']"></i>
                <span v-html="info['thumb-down']"></span>
              </span>
          </div>
        </div>
        <p>
              <span style="background-color: #337ab7;border-radius: 3px;margin: 5px;color: #ffffff;padding: 3px;"
                    v-for=" word in info['key-words']" :key="word" v-html="word">
              </span>
        </p>
        <p v-html="info.summary"></p>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "BlogList",
    data: function () {
      return {
        blog: {
          top: [
            {
              id: 1,
              title: '学习党的指导思想',
              summary: '始终围绕在以习近平为核心的党中央周围',
              'key-words': ['党', '习近平'],
              'thumb-up': 20,
              'thumb-up-d': false,
              'thumb-down-d': true,
              'thumb-down': 10,
              'update-time': 1534075455
            }
          ],
          common: [
            {
              id: 2,
              title: '如何配置Java环境变量',
              summary: '安装Jdk，配置<code>JAVA_HOME</code>环境变量',
              'key-words': ['Java', '环境变量'],
              'thumb-up': 20,
              'thumn-up-d': false,
              'thumn-down-d': true,
              'thumb-down': 10,
              'update-time': 1534075455
            },
            {
              id: 3,
              title: '如何配置Java环境变量',
              summary: '安装Jdk，配置<code>JAVA_HOME</code>环境变量',
              'key-words': ['Java', '环境变量'],
              'thumb-up': 20,
              'thumn-up-d': false,
              'thumn-down-d': true,
              'thumb-down': 10,
              'update-time': 1534075455
            }
          ]
        }
      }
    }
  }
</script>

<style scoped>
  .blog-info-div {
    padding: 20px 0px 0px 20px;
    margin-top: 20px;
    margin-bottom: 20px;
    border: 1px solid #eee;
    border-left-width: 5px;
    border-bottom-width: 5px;
    border-radius: 3px;
  }

  .blog-info-div-border {
    border-left-color: red;
    border-bottom-color: #1b809e;
  }
</style>