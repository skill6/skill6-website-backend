CREATE TABLE `rbac_role_info` (
`role_id` bigint(19) NOT NULL COMMENT '角色分布式ID',
`role_name` varchar(16) NOT NULL COMMENT '角色名称，如管理员、总监',
`role_code` varchar(16) NOT NULL COMMENT '角色代码。用于匹配角色',
`role_desc` varchar(128) NULL COMMENT '角色描述',
`role_create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`role_update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`role_valid` tinyint(1) NOT NULL COMMENT '是否可用，0为假，1为真',
PRIMARY KEY (`role_id`) 
);

CREATE TABLE `rbac_user_role_rel` (
`user_id` bigint(19) NOT NULL COMMENT '用户分布式ID',
`role_id` bigint(19) NOT NULL COMMENT '角色分布式ID',
PRIMARY KEY (`user_id`, `role_id`) 
)
COMMENT = '用户角色关联表';

CREATE TABLE `rbac_role_permission_rel` (
`role_id` bigint(19) NOT NULL,
`permission_id` bigint(19) NOT NULL,
PRIMARY KEY (`role_id`, `permission_id`) 
);

CREATE TABLE `rbac_permission_info` (
`permission_id` bigint(19) NOT NULL,
`permission_name` varchar(32) NOT NULL COMMENT '权限名称，如创建用户',
`permission_code` varchar(32) NOT NULL COMMENT '权限代码，如sys:user:create，用于匹配权限',
`permission_desc` varchar(128) NULL COMMENT '权限描述',
`permission_navi` tinyint(1) NOT NULL COMMENT '是否为菜单栏导航节点，0为假，1为真',
`permission_url` varchar(256) NULL COMMENT '如果为菜单导航节点，对应节点的URL',
`permission_create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`permission_update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`permission_valid` tinyint(1) NOT NULL,
PRIMARY KEY (`permission_id`) 
);

CREATE TABLE `rbac_session` (
`session_id` bigint(19) NOT NULL COMMENT '会话ID',
`session_content` text NOT NULL COMMENT 'session序列化后的内容',
`session_create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`session_update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`session_valid` tinyint(1) NOT NULL,
PRIMARY KEY (`session_id`) 
)
COMMENT = '会话持久化';

