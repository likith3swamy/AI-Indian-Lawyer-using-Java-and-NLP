FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/ai-indian-lawyer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -Xms256m -Xmx1g -jar /app/app.jar"]