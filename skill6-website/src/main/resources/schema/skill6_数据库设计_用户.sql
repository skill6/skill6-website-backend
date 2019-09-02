CREATE TABLE `user_info` (
`user_id` bigint(19) NOT NULL COMMENT '分布式ID，长度19',
`user_name` varchar(18) NOT NULL COMMENT '登录账号',
`user_email` varchar(30) NULL COMMENT '邮箱',
`user_phone` varchar(15) NULL COMMENT '手机号',
`user_login_from` varchar(16) NOT NULL COMMENT '首次登陆方式，是注册还是第三方',
`user_password` varchar(32) NOT NULL COMMENT 'MD5加盐加密密码',
`user_pwd_salt` varchar(32) NOT NULL COMMENT '密码加密盐值',
`user_type` varchar(16) NOT NULL COMMENT '用户类型，普通用户还是管理用户',
`user_state` varchar(16) NOT NULL COMMENT '用户状态：100正常, 200锁定, 300无效',
PRIMARY KEY (`user_id`) 
)
COMMENT = '用户主要信息';

CREATE TABLE `user_addition_info` (
`user_id` bigint(19) NOT NULL COMMENT '分布式ID，长度19',
`user_nick_name` varchar(20) NOT NULL COMMENT '昵称',
`user_register_date` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '注册日期',
`user_head_url` varchar(255) NULL COMMENT '头像链接',
`user_sex` tinyint(1) NULL COMMENT '性别',
`user_birthday` varchar(15) NULL COMMENT '生日',
`user_birthday_type` tinyint(1) NULL COMMENT '生日是阳历还是农历',
`user_desc` varchar(255) NULL COMMENT '描述，类似签名',
`user_last_login_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '上次登录时间',
PRIMARY KEY (`user_id`) 
)
COMMENT = '用户附加信息';

CREATE TABLE `user_login_record` (
`login_id` bigint(19) NOT NULL COMMENT '分布式id',
`user_id` bigint(19) NOT NULL,
`login_ip` varchar(15) NULL COMMENT '登录ip',
`login_type` varchar(16) NULL COMMENT '是注册登录还是第三方登录',
`login_equipment` varchar(30) NULL COMMENT '登录设备',
`login_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '登录时间',
`login_result` tinyint(1) NOT NULL COMMENT '登录结果',
`login_fail_reason` varchar(3) NULL COMMENT '如果登录失败，注明原因',
PRIMARY KEY (`login_id`) 
)
COMMENT = '用户登录记录';

CREATE TABLE `user_modify_record` (
`user_modify_id` bigint(19) NOT NULL,
`user_id` bigint(19) NOT NULL,
`user_modify_type` varchar(3) NOT NULL COMMENT '修改密码、手机、邮箱、头像等等，用枚举',
`user_modify_before` varchar(255) NULL COMMENT '修改之前的值',
`user_modify_after` varchar(255) NULL COMMENT '修改之后的值',
`user_modify_result` tinyint(1) NOT NULL COMMENT '是否修改成功',
`user_modify_time` timestamp(3) NOT NULL COMMENT '用户修改信息的世界',
PRIMARY KEY (`user_modify_id`) 
)
COMMENT = '用户信息修改记录';

