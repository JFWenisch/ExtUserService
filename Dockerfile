FROM ubuntu


ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update -y
RUN apt-get install -y console-setup sudo wget curl unzip openjdk-21-jdk 
RUN useradd --create-home -s /bin/bash user && \
    adduser user sudo && \
    echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> /etc/sudoers 

USER user
ENV USER=user


COPY --chown=user:user src/target/*.jar /extuserservice.jar
ENV JAVA_HOME /usr/lib/jvm/java-21-openjdk-amd64/
ENTRYPOINT ["java","-jar","extuserservice.jar"]
