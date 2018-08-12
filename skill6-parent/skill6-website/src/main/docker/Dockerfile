FROM java:alpine
ADD processor-web.jar app.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-jar","/app.jar"]
EXPOSE 8081 5005