FROM openjdk:8
EXPOSE 8081
COPY target/calculator-processor-1.0.jar calculator-processor-1.0.jar
ENTRYPOINT ["java","-jar","/calculator-processor-1.0-SNAPSHOT.jar"]