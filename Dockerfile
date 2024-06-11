FROM maven:3.8.7 as build

COPY . .

RUN mvn -B clean package -DskipTests

FROM openjdk:17

COPY --from=build target/*.jar Investment.jar

EXPOSE 8080

# COPY target/Investment ../app/
ENTRYPOINT ["java", "-jar", "Investment.jar"]


