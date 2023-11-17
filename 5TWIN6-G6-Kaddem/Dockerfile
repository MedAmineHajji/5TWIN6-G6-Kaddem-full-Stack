# Use a lightweight Java image for the final application
FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /5TWIN6-G6-Kaddem

# Copy the built JAR file
COPY ./target/5TWIN6-G6-Kaddem.jar 5TWIN6-G6-Kaddem.jar

# Run the application
CMD ["java", "-jar", "5TWIN6-G6-Kaddem.jar"]
