FROM java:8

RUN mkdir -p opt

ADD target/hotel.jar /opt

WORKDIR /opt

RUN chmod +x hotel.jar

CMD ["java","-jar","hotel.jar"]

EXPOSE 8080