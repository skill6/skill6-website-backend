CREATE TABLE `thirdparty_auth` (
`thirdparty_id` bigint(19) NOT NULL COMMENT '主键分布式id',
`user_id` bigint(19) NOT NULL COMMENT '用户id',
`thirdparty_primary_key` varchar(36) NOT NULL COMMENT '第三方返回的数据中选择选择一个作为主键',
`thirdparty_data` text NULL COMMENT '第三方返回的所有数据',
`thirdparty_valid` tinyint(1) NOT NULL COMMENT '该条记录是否有效，用户每使用第三方登录一次，就获取一次信息。获取到的数据和当前有效数据进行对比，若不同则插入一条新的数据，并设置当前有效记录为无效',
`thirdparty_create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
PRIMARY KEY (`thirdparty_id`) 
);

