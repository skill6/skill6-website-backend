CREATE TABLE `sys_user_info` (
`user_id` bigint(19) NOT NULL COMMENT '分布式ID，长度19',
`user_name` varchar(18) NOT NULL COMMENT '登录账号',
`user_email` varchar(30) NULL COMMENT '邮箱',
`user_phone` varchar(15) NULL COMMENT '手机号',
`user_login_from` varchar(3) NOT NULL COMMENT '首次登陆方式，是注册还是第三方',
`user_password` varchar(32) NOT NULL COMMENT 'MD5加盐加密密码',
`user_pwd_salt` varchar(32) NOT NULL COMMENT '密码加密盐值',
`user_type` varchar(16) NOT NULL COMMENT '用户类型，普通用户还是管理用户',
`user_state` varchar(16) NOT NULL COMMENT '用户状态：100正常, 200锁定, 300无效',
PRIMARY KEY (`user_id`) 
);

CREATE TABLE `sys_user_role_rel` (
`user_id` bigint(19) NOT NULL COMMENT '用户分布式ID',
`role_id` bigint(19) NOT NULL COMMENT '角色分布式ID',
PRIMARY KEY (`user_id`, `role_id`) 
);

CREATE TABLE `sys_role_permission_rel` (
`role_id` bigint(19) NOT NULL,
`permission_id` bigint(19) NOT NULL,
PRIMARY KEY (`role_id`, `permission_id`) 
);

CREATE TABLE `sys_role_info` (
`role_id` bigint(19) NOT NULL COMMENT '角色分布式ID',
`role_name` varchar(16) NOT NULL COMMENT '角色名称，如管理员、总监',
`role_code` varchar(16) NOT NULL COMMENT '角色代码。用于匹配角色',
`role_desc` varchar(128) NULL COMMENT '角色描述',
`role_create_time` timestamp(3) NOT NULL,
`role_update_time` timestamp(3) NOT NULL,
`role_valid` tinyint(1) NOT NULL COMMENT '是否可用，0为假，1为真',
PRIMARY KEY (`role_id`) 
);

CREATE TABLE `sys_permission_info` (
`permission_id` bigint(19) NOT NULL,
`permission_name` varchar(32) NOT NULL COMMENT '权限名称，如创建用户',
`permission_code` varchar(32) NOT NULL COMMENT '权限代码，如sys:user:create，用于匹配权限',
`permission_desc` varchar(128) NULL COMMENT '权限描述',
`permission_navi` tinyint(1) NOT NULL COMMENT '是否为菜单栏导航节点，0为假，1为真',
`permission_url` varchar(128) NULL COMMENT '如果为菜单导航节点，对应节点的URL',
`permission_create_time` timestamp(3) NOT NULL,
`permission_update_time` timestamp(3) NOT NULL,
`permission_valid` tinyint(1) NOT NULL,
PRIMARY KEY (`permission_id`) 
);

