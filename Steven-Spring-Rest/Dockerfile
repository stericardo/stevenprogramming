#Steven Spring Rest
FROM eclipse-temurin:17.0.6_10-jdk-focal
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#to build this image type:
# docker build:
#   docker build -t stevenprogramming/steven-spring-rest .
# docker run:
#    docker run -p 8080:8080 stevenprogramming/steven-spring-rest