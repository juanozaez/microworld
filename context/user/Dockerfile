# TEMPORAL BUILD IMAGE
FROM eclipse-temurin:17-jdk AS build-env

COPY . /app
WORKDIR /app
RUN ["./gradlew", "assemble"]

FROM busybox:uclibc AS builder-wget

# REAL IMAGE
FROM gcr.io/distroless/java17-debian11
COPY --from=builder-wget /bin/wget /usr/bin/wget
COPY --from=build-env /app/build/libs/user-0.0.1-SNAPSHOT.jar /app/user.jar


WORKDIR /app

HEALTHCHECK --interval=10s --timeout=5s --retries=5 --start-period=60s CMD ["/usr/bin/wget", "--no-verbose", "--tries=1", "--spider", "http://localhost:8080/actuator/health"]
CMD ["user.jar"]
