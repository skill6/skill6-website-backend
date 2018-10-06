FROM java:8
MAINTAINER LIU JICHUN jliu666@hotmail.com
ENV TZ Asia/Shanghai

RUN echo "deb http://mirrors.ustc.edu.cn/debian/ jessie main contrib non-free" > /etc/apt/sources.list \
    && echo "deb-src http://mirrors.ustc.edu.cn/debian/ jessie main contrib non-free" >> /etc/apt/sources.list \

    && echo "deb http://mirrors.ustc.edu.cn/debian/ jessie-updates main contrib non-free" >> /etc/apt/sources.list \
    && echo "deb-src http://mirrors.ustc.edu.cn/debian/ jessie-updates main contrib non-free" >> /etc/apt/sources.list \

    && echo "deb http://mirrors.ustc.edu.cn/debian/ jessie-backports main contrib non-free" >> /etc/apt/sources.list \
    && echo "deb-src http://mirrors.ustc.edu.cn/debian/ jessie-backports main contrib non-free" >> /etc/apt/sources.list \

    && echo "deb http://mirrors.ustc.edu.cn/debian-security/ jessie/updates main contrib non-free" >> /etc/apt/sources.list \
    && echo "deb-src http://mirrors.ustc.edu.cn/debian-security/ jessie/updates main contrib non-free" >> /etc/apt/sources.list \
    && apt-get update \
    && apt-get install -y libxss1 libappindicator1 libindicator7 xvfb unzip fonts-liberation libappindicator3-1 libatk-bridge2.0-0 libgtk-3-0 lsb-release xdg-utils\
    && wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && dpkg -i google-chrome*.deb \
    && apt-get install -f \
    && wget -N https://chromedriver.storage.googleapis.com/2.42/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && chmod +x chromedriver \
    && mv -f chromedriver /usr/local/share/chromedriver \
    && ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver \
    && ln -s /usr/local/share/chromedriver /usr/bin/chromedriver \


