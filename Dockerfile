FROM java:8
MAINTAINER lidengyin
ARG JAR_FILE
ADD ${JAR_FILE} hotel-list.jar
ADD ./simsun.ttc /usr/share/fonts
ADD ./haichuang.png /usr/local
EXPOSE 8252
ENTRYPOINT ["java","-jar","hotel-list.jar"]