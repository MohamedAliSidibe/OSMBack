FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /OSM-Voyages
COPY --from=builder /app/target/Voyages-et-Partages*.jar /OSM-Voyages/app.jar
EXPOSE 8080
CMD ["java", "-jar", "/OSM-Voyages/app.jar"]
