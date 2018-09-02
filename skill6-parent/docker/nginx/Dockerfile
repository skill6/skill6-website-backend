FROM nginx:alpine
COPY skill6-website.conf /etc/nginx/nginx.conf
COPY cert/www.skill6.cn/Nginx/* /cert/
RUN ls -al /cert/ && rm -f /etc/nginx/conf.d/*

