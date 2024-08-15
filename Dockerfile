FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
RUN apk add --update --no-cache openssh
COPY target/foodcourt.jar foodcourt.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","foodcourt.jar"]