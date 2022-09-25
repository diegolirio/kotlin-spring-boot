FROM gradle:6.8.3-jre11

EXPOSE 8080
RUN mkdir /app
COPY build/libs/*.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]