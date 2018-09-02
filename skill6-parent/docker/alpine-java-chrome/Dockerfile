FROM java:alpine
MAINTAINER LIU JICHUN jliu666@hotmail.com
RUN echo "http://dl-4.alpinelinux.org/alpine/edge/main" >> /etc/apk/repositories && \
    echo "http://dl-4.alpinelinux.org/alpine/edge/community" >> /etc/apk/repositories &&\
    apk update && \
    apk add curl unzip libexif udev chromium chromium-chromedriver xvfb &&\
    ls -al 	/usr/bin/