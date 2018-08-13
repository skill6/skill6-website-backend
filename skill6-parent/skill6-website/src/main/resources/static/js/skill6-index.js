new Vue({
  el: '#skill6-app',
  data: {
    index: {
      notice: {
        show: true,
        data: {
          message: "<span style=\"text-align: center;color: red;font-size: 15px;\">通知：网站将于2018年10月上线</span>",
          id: '001'
        }
      },
      blog: {
        top: [
          {
            id: 001,
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
            id: 002,
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
            id: 002,
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
            id: 002,
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
            id: 002,
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
            id: 002,
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
            id: 002,
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
  },
  methods: {
    closeNotice: function () {
      var that = this;
      $.cookie("notice-" + that.index.notice.data.id + '-show', 'false', {
        expires: 30
      });
      that.index.notice.show = false;
    },
    checkShowNotice: function () {
      var that = this;
      if ($.cookie("notice-" + that.index.notice.data.id + '-show')
          == 'false') {
        that.index.notice.show = false;
      }
    },
    route: function (data, title, url) {
      var that = this;
      window.history.pushState(data, title, url);
    },
    cancelHref: function () {
      var that = this;
      $('.route-btn a').click(function (e) {
        e.preventDefault()
        that.route('xyz', 'abc', $(this).attr('href'));
      });
    }
  },
  mounted: function () {
    this.checkShowNotice();
    this.cancelHref();
  }
})