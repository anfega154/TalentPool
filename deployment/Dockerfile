FROM gradle:8-jdk21 AS builder
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN gradle clean build -x test --no-daemon

# Run
FROM eclipse-temurin:21-jre-alpine
RUN addgroup -S appgroup && adduser -S norootuser -G appgroup

WORKDIR /app

COPY applications/app-service/build/libs/TalentPool.jar /app/TalentPool.jar

USER norootuser

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar TalentPool.jar"]
