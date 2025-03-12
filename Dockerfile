FROM eclipse-temurin:21

LABEL authors="kaushalkishore"
WORKDIR /app

COPY target/Banking_App_Rest_Api_V1.jar /app/Banking_App_Rest_Api_V1.jar

ENTRYPOINT ["java","-jar","Banking_App_Rest_Api_V1.jar"]
