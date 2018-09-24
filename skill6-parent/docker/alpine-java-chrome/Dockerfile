FROM java:alpine
MAINTAINER LIU JICHUN jliu666@hotmail.com
ENV TZ Asia/Shanghai

RUN sed -i "s@http://dl-cdn.alpinelinux.org/@https://mirrors.huaweicloud.com/@g" /etc/apk/repositories \
    && apk update \
    && apk add -U --no-cache chromium chromium-chromedriver tzdata \
    && apk add wqy-zenhei --no-cache --repository http://nl.alpinelinux.org/alpine/edge/testing --allow-untrusted \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && rm -rf /var/cache/apk/* \
        /usr/share/man \
        /tmp/*