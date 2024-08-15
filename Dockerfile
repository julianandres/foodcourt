FROM amazoncorretto:17.0.10-alpine3.19
RUN apk add --update --no-cache openssh
COPY target/foodcourt.jar foodcourt.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","foodcourt.jar"]