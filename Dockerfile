FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/roman-numerals-converter-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]