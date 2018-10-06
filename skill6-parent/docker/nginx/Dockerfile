FROM nginx:alpine
COPY skill6-website.conf /etc/nginx/nginx.conf
COPY cert/skill6.cn/nginx/* /cert/
RUN ls -al /cert/ && rm -f /etc/nginx/conf.d/*

