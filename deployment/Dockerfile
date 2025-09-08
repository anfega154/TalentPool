# Build
FROM gradle:8-jdk21 AS builder
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN gradle clean build -x test --no-daemon

# Run
FROM eclipse-temurin:21-jre-alpine
RUN addgroup -S appgroup && adduser -S norootuser -G appgroup

WORKDIR /app
COPY --from=builder /home/gradle/project/applications/app-service/build/libs/*.jar /app/TalentPool.jar

EXPOSE 8080
USER norootuser

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=70", "-Djava.security.egd=file:/dev/./urandom", "-jar", "TalentPool.jar"]
