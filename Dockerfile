FROM maven:latest

ENV WORKDIR .

WORKDIR $WORKDIR

COPY . .

RUN mvn -f ./ch-simple/simple/pom.xml clean install