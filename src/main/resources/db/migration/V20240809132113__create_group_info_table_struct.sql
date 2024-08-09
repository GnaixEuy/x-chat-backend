CREATE TABLE `x-chat`.`group_info`
(
    `id`             varchar(64) NOT NULL COMMENT '主键id',
    `created_time`   datetime    NULL COMMENT '创建时间',
    `updated_time`   datetime    NULL COMMENT '更新时间',
    `created_user`   varchar(64) NULL COMMENT '创建人id',
    `updated_user`   varchar(64) NULL COMMENT '更新人id',
    `group_name`     varchar(32) NULL COMMENT '群昵称',
    `group_owner_id` varchar(64) NOT NULL COMMENT '群主id',
    `group_notice`   varchar(64) NULL COMMENT '群公告',
    `join_type`      tinyint(1)  NULL COMMENT '加群方式，（0-直接加入、1-管理员同意后加入）',
    `status`         tinyint(1)  NOT NULL DEFAULT 1 COMMENT '状态（1-正常、0-解散）',
    PRIMARY KEY (`id`)
) comment '群信息表';