# IMAGEN MODELO
FROM eclipse-temurin:17.0.14_7-jdk

EXPOSE 8080

WORKDIR /root

COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY ./src /root/src

RUN ./mvnw clean install -DskipTests

RUN mv target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]