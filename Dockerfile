FROM maven:3.9.0-amazoncorretto-17 AS stage1
WORKDIR /usr/app
COPY . /usr/app


RUN mvn dependency:go-offline -B -s settings.xml

RUN mvn clean package -Dmaven.test.skip=true -s settings.xml

FROM openjdk:17
WORKDIR /usr/app
#COPY
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "barbearia-api.jar"]