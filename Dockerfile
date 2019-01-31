FROM java:8
VOLUME /tmp
ADD test-jms-consumer-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Duser.timezone=GMT", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
