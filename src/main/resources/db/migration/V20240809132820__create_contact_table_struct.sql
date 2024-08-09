CREATE TABLE `x-chat`.`user_contract`
(
    `id`           varchar(64) NOT NULL COMMENT '主键id',
    `created_time` datetime    NULL COMMENT '创建时间',
    `updated_time` datetime    NULL COMMENT '更新时间',
    `created_user` varchar(64) NULL COMMENT '创建人',
    `updated_user` varchar(64) NULL COMMENT '更新人',
    `user_id`      varchar(64) NOT NULL COMMENT '用户id',
    `contact_id`   varchar(64) NOT NULL COMMENT '联系人ID或者群组ID',
    `contact_type` tinyint(1)  NULL COMMENT '联系人类型(0-好友、1-群组)',
    `status`       tinyint(1)  NULL COMMENT '状态（0-非好友、1-好友、2-已删除好友、3-被好友删除）',
    PRIMARY KEY (`id`, `contact_id`)
) comment '用户联系人表';