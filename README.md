--- 

# x-chat

x-chat 是一个即时通讯(IM)系统，灵感来自微信，旨在提供稳定、高效的通讯服务。

## 项目简介

x-chat 项目旨在创建一个高效、安全的即时通讯系统。系统采用 Java 编写，利用 Spring Boot、Netty 等框架，确保高性能和高扩展性。支持多种部署方式，包括常规
JAR 运行、Docker 容器化部署以及 Kubernetes 集群部署。

## 技术栈

- **后端**
    - Java
    - Spring Boot
    - Spring Security
    - Netty
    - MySQL
    - Redis
    - RabbitMQ
    - Kubernetes
    - Docker

- **前端**
    - Vue.js (待定)
    - React.js (待定)
    - SwiftUI (待定)

## 功能列表

- 用户注册与登录
- 实时聊天
- 群聊
- 消息通知
- 消息存储与检索
- 好友管理
- 群组管理

## 运行项目

### 本地运行

1. 克隆项目到本地
   ```sh
   git clone https://github.com/yourusername/x-chat.git
   cd x-chat
   ```

2. 配置数据库 (MySQL) 和 Redis

3. 在 `application.properties` 文件中配置数据库和Redis连接信息

4. 运行项目
   ```sh
   mvn spring-boot:run
   ```

### Docker 部署

1. 构建 Docker 镜像
   ```sh
   docker build -t x-chat:latest .
   ```

2. 运行 Docker 容器
   ```sh
   docker run -d -p 8080:8080 x-chat:latest
   ```

### Kubernetes 部署

1. 编写 Kubernetes 配置文件 (参见 `k8s` 目录中的示例配置)

2. 部署到 Kubernetes 集群
   ```sh
   kubectl apply -f k8s/
   ```

## 贡献指南

目前项目的贡献者只有我本人。如果你对这个项目感兴趣，欢迎提交 Issue 或 Pull Request，一起完善这个项目。

## 许可信息

本项目采用 MIT 许可证。详细信息请参阅 [LICENSE](LICENSE) 文件。

--- 