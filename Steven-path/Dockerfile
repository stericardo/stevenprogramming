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

# TO UPLOAD ON THE PUBLIC I USED:
# docker build -t stericardo/steven-spring-rest:1.0 .

# 1.0: digest: sha256:557d67f811ecbf40106874a6d02b02efa43e536a9dd9a0e350e2fa1ba6c804fd size: 1373



# docker buildx build --platform linux/amd64 -t stericardo/steven-spring-rest:2.0 .
# docker push stericardo/steven-spring-rest:2.0


# docker buildx build --platform linux/amd64 -t stericardo/steven-spring-rest:3.0 .
# docker push stericardo/steven-spring-rest:3.0