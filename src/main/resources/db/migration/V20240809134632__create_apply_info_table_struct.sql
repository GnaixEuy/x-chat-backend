CREATE TABLE `x-chat`.`user_contract_apply`
(
    `id`              varchar(64)  NOT NULL COMMENT '主键id',
    `created_time`    datetime     NULL COMMENT '创建时间',
    `updated_time`    datetime     NULL COMMENT '更新时间',
    `created_user`    varchar(64)  NULL COMMENT '创建者id',
    `updated_user`    varchar(64)  NULL COMMENT '更新者id',
    `apply_user_id`   varchar(64)  NOT NULL COMMENT '申请人id',
    `receive_user_id` varchar(64)  NOT NULL COMMENT '接收人Id',
    `contact_type`    tinyint(1)   NULL COMMENT '联系人类型（0-好友、1-群组）',
    `contact_id`      varchar(64)  NOT NULL COMMENT '联系人群组id',
    `last_apply_time` datetime     NULL COMMENT '最后申请时间',
    `status`          tinyint(1)   NOT NULL COMMENT '状态（0-待处理、1-已同意、2-已拒绝）',
    `apply_info`      varchar(100) NULL COMMENT '申请信息',
    PRIMARY KEY (`id`, `apply_user_id`, `receive_user_id`, `contact_id`)
) comment '用户联系人申请表';