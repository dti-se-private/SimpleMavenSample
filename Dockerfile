FROM maven:latest

ENV WORKDIR .

WORKDIR $WORKDIR

COPY . .

RUN mvn -f ./ch-simple/simple/pom.xml clean install

CMD ["java", "-jar", "./ch-simple/simple/target/simple-0.8-SNAPSHOT.jar"]
