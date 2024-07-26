FROM ubuntu:latest

LABEL authors="gnaixeuy"
MAINTAINER GnaixEuy<sgghcj@live.com>

# 指定构建过程中的工作目录
WORKDIR /app

# 将src目录下所有文件，拷贝到工作目录中src目录下
COPY src /app/src

# 将pom.xml文件，拷贝到工作目录下
COPY pom.xml /app

# 执行代码编译命令
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true -Dspring.profiles.active=pro

# 选择运行时基础镜像
FROM openjdk:17

ENV APPLICATION_PORT 8080

# 指定运行时的工作目录
WORKDIR /app

# 将构建产物jar包拷贝到运行时目录中
COPY --from=build /app/target/fluorescent-music-0.0.1-SNAPSHOT.jar .

# 暴露端口
EXPOSE 80

# 执行启动命令
CMD ["java", "-jar", "/app/x-chat-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=pro"]