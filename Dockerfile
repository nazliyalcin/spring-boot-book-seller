FROM openjdk:17-oracle
WORKDIR /shop
VOLUME /shopapp
COPY build/libs/*.jar shop-0.0.1-SNAPSHOT.jar
LABEL authors="eyalnaz"
EXPOSE 8080
ENTRYPOINT ["java", "-jar","shop-0.0.1-SNAPSHOT.jar"]
