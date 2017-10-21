FROM java:8

RUN mkdir -p opt

ADD ./vtk-hotel-boot.jar /opt

WORKDIR /opt

RUN chmod +x vtk-hotel-boot.jar

CMD ["java","-jar","vtk-hotel-boot.jar"]

EXPOSE 8080