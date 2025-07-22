# Use a minimal Java 17 base image
FROM openjdk:17-jdk-slim

# Add a non-root user for better security
RUN addgroup --system spring && adduser --system --ingroup spring spring

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY target/*.jar app.jar

# Set permissions and change ownership
RUN chown -R spring:spring /app

# Switch to non-root user
USER spring

# Expose port 8080
EXPOSE 8080

# JVM options (can be overridden from Docker Compose)
ENV JAVA_OPTS="-Xmx512m -Xms256m -Djava.security.egd=file:/dev/./urandom"

# Use exec form and proper environment expansion
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
