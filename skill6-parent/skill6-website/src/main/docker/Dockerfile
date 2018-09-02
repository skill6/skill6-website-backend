FROM java:alpine
MAINTAINER LIU JICHUN jliu666@hotmail.com
ADD skill6-website.jar app.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-jar","/app.jar"]
EXPOSE 8081 5005