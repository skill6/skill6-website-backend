<template>
    <footer>
        <div class="container">
            <div style="height: 10px"></div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div id="footer-link">
                        <strong>
                            <a href="/about" target="_blank">关于</a>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <a href="https://github.com/skill6/skill6" target="_blank">GitHub仓库</a>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <a href="https://github.com/skill6/skill6/issues" target="_blank">反馈问题</a>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <a href="https://shang.qq.com/wpa/qunwpa?idkey=0fb612b44f55c807d55813ab1dd1dd469954c438890b628bc4fe26cb3aaa2d9d"
                               target="_blank">加入我们<span
                                    style="font-size: 5px">(QQ群:628612966)</span></a>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        </strong>
                    </div>
                    <div id="footer">©2018 &nbsp;
                        <a href="https://www.skill6.cn" target="_blank">skill6.cn</a>
                        &nbsp;<b>技术流, 技术牛, IT学习社区, IT学习资源共享平台</b>&nbsp;&nbsp;<br>
                        <a href="http://www.miibeian.gov.cn" target="_blank">渝ICP备16013250号-4</a>&nbsp;|&nbsp;<span>Power by
                            skill6(Spring Boot + MySQL)</span>
                    </div>
                </div>
            </div>
        </div>
        <div style="height: 10px"></div>
    </footer>
</template>

<script>
    export default {
        name: "AppFooter"
    };
</script>

<style scoped>

    #footer-link * {
        color: grey;
        font-size: 14px;
    }

    #footer, #footer * {
        color: grey;
        font-size: 12px;
    }

    footer {
        background-color: white;
    }

    footer strong {
        font-size: 15px;
    }

</style>