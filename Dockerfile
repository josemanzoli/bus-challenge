FROM java:8

RUN mkdir -p /var/log/bus-challenge

RUN mkdir -p /manzoli/app/bus-challenge

WORKDIR /manzoli/app/bus-challenge

COPY . /manzoli/app/bus-challenge

EXPOSE 8080

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/bus-challenge.jar"]