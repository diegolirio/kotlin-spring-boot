FROM gradle:6.8.3-jre11

EXPOSE 8080
RUN mkdir /app
COPY app/build/libs/app.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]