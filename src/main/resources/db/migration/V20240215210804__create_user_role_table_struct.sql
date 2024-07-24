CREATE TABLE user
(
    id                 VARCHAR(64)          NOT NULL PRIMARY KEY COMMENT '用户ID',
    created_time       datetime             NULL COMMENT '创建时间',
    updated_time       datetime             NULL COMMENT '更新时间',
    created_user       VARCHAR(64)          NULL COMMENT '创建用户',
    updated_user       VARCHAR(64)          NULL COMMENT '更新用户',
    username           VARCHAR(64)          NULL COMMENT '用户名',
    nickname           VARCHAR(128)         NULL COMMENT '昵称',
    password           VARCHAR(64)          NULL COMMENT '密码',
    email              VARCHAR(32)          NULL COMMENT '电子邮件',
    age                int                  NULL COMMENT '年龄',
    birthday           DATE                 NULL COMMENT '生日',
    phone              VARCHAR(32)          NULL COMMENT '电话号码',
    address            VARCHAR(256)         NULL COMMENT '地址',
    avatar_url         VARCHAR(1024)        NULL COMMENT '头像URL',
    personal_signature VARCHAR(1024)        NULL COMMENT '个性签名',
    website_url        VARCHAR(1024)        NULL COMMENT '个人网站URL',
    gender             VARCHAR(12)          NULL COMMENT '性别',
    `locked`           tinyint(1) DEFAULT 0 NOT NULL COMMENT '是否锁定，1-是，0-否',
    enabled            tinyint(1) DEFAULT 1 NOT NULL COMMENT '是否可用，1-是，0-否',
    last_login_ip      VARCHAR(64)          NULL COMMENT '最后登录IP',
    last_login_time    datetime             NULL COMMENT '最后登录时间'
) COMMENT '用户表';

CREATE TABLE role
(
    id           VARCHAR(64)  NOT NULL PRIMARY KEY COMMENT '角色ID',
    name         VARCHAR(128) NULL COMMENT '角色名称',
    title        VARCHAR(128) NULL COMMENT '角色标识',
    created_time datetime     NOT NULL COMMENT '创建时间',
    updated_time datetime     NOT NULL COMMENT '更新时间',
    created_user VARCHAR(64)  NULL COMMENT '创建用户',
    updated_user VARCHAR(64)  NULL COMMENT '更新用户'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT '角色表';