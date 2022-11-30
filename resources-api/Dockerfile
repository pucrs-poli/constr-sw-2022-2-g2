FROM maven:3.3.9-jdk-8-alpine
WORKDIR /app
COPY pom.xml .
RUN mvn clean
COPY . .
RUN mvn package
CMD ["java", "-jar", "target/constr-sw-g2-0.0.1-SNAPSHOT.jar"]