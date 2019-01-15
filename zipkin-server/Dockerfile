FROM openjdk:8u171-jdk-slim
VOLUME /tmp
MAINTAINER hujunfeng 419644560@qq.com
#ADD target/account-register-center-0.0.1-SNAPSHOT.jar app.jar
#ADD Reptile_mobile_web-0.0.1-SNAPSHOT.jar app.jar
ENV project spring-cloud-learning
ENV mod zipkin-server
#ENV apppath /root/.jenkins/workspace/${project}/${mod}
#WORKDIR ${apppath}
#ENV apppath /root/.jenkins/workspace/spring-cloud-learning/zipkin-server
#WORKDIR ${apppath}/
COPY target/zipkin-server-0.0.1-SNAPSHOT.jar /zipkin-server-1.0.0-SNAPSHOT.jar
#修改时区
#RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/shanghai" > /etc/timezone;
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom    -jar -Xms512m -Xmx512m -Xmn256m  /zipkin-server-1.0.0-SNAPSHOT.jar