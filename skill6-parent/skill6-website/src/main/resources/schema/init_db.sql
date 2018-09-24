//用户
CREATE TABLE `user_privacy_info` (

`user_id` bigint(19) NOT NULL COMMENT '分布式ID，长度19',

`user_name` varchar(18) NOT NULL COMMENT '登录账号',

`user_email` varchar(30) NULL COMMENT '邮箱',

`user_phone` varchar(15) NULL COMMENT '手机号',

`user_login_from` varchar(3) NOT NULL COMMENT '首次登陆方式，是注册还是第三方',

`user_password` varchar(32) NOT NULL COMMENT 'MD5加盐加密密码',

`user_pwd_salt` varchar(32) NOT NULL COMMENT '密码加密盐值',

`user_type` varchar(3) NOT NULL COMMENT '用户类型，普通用户还是管理用户',

`user_state` varchar(3) NOT NULL COMMENT '用户状态：100正常, 200锁定, 300无效',

PRIMARY KEY (`user_id`) 

);



CREATE TABLE `user_addition_info` (

`user_id` bigint(19) NOT NULL COMMENT '分布式ID，长度19',

`user_nick_name` varchar(20) NOT NULL COMMENT '昵称',

`user_register_time` timestamp(3) NOT NULL COMMENT '注册日期',

`user_head_url` varchar(255) NULL COMMENT '头像链接',

`user_sex` tinyint(1) NULL COMMENT '性别',

`user_birthday` varchar(15) NULL COMMENT '生日',

`user_birthday_type` tinyint(1) NULL COMMENT '生日是阳历还是农历',

`user_desc` varchar(255) NULL COMMENT '描述，类似签名',

`user_last_login_time` timestamp(3) NOT NULL COMMENT '上次登录时间',

PRIMARY KEY (`user_id`) 

);



CREATE TABLE `user_login_record` (

`login_id` bigint(19) NOT NULL,

`login_ip` varchar(15) NULL,

`login_type` varchar(255) NULL COMMENT '是注册登录还是第三方登录',

`login_equipment` varchar(30) NULL COMMENT '登录设备',

`login_time` timestamp(3) NOT NULL,

`login_user_id` varchar(19) NOT NULL,

`login_success` tinyint(1) NOT NULL COMMENT '是否登录成功',

`login_fail_reason` varchar(3) NULL COMMENT '如果登录失败，注明原因',

PRIMARY KEY (`login_id`) 

);



CREATE TABLE `user_modify_record` (

`user_id` bigint(19) NOT NULL,

`user_modify_type` varchar(3) NOT NULL COMMENT '修改密码、手机、邮箱、头像等等，用枚举',

`user_modify_time` timestamp(3) NOT NULL,

`user_modify_before` varchar(255) NULL COMMENT '修改之前的值',

`user_modify_after` varchar(255) NULL COMMENT '修改之后的值',

`user_modufy_success` tinyint(1) NOT NULL COMMENT '是否修改成功',

PRIMARY KEY (`user_id`) 

)

COMMENT = '用户信息修改记录';



//RBAC权限


CREATE TABLE IF NOT EXISTS `rbac_role_info` (
`role_id` bigint(19) NOT NULL COMMENT '角色分布式ID',
`role_name` varchar(16) NOT NULL COMMENT '角色名称，如管理员、总监',
`role_code` varchar(16) NOT NULL COMMENT '角色代码。用于匹配角色',
`role_desc` varchar(128) NULL COMMENT '角色描述',
`role_create_time` timestamp(3) NOT NULL,
`role_last_modify_time` timestamp(3) NOT NULL,
`role_valid` tinyint(1) NOT NULL COMMENT '是否可用，0为假，1为真',
PRIMARY KEY (`role_id`) 
);
CREATE TABLE IF NOT EXISTS `rbac_user_role_rel` (
`user_id` bigint(19) NOT NULL COMMENT '用户分布式ID',
`role_id` bigint(19) NOT NULL COMMENT '角色分布式ID',
PRIMARY KEY (`user_id`, `role_id`) 
);
CREATE TABLE IF NOT EXISTS `rbac_role_permission_rel` (
`role_id` bigint(19) NOT NULL,
`permission_id` bigint(19) NOT NULL,
PRIMARY KEY (`role_id`, `permission_id`) 
);
CREATE TABLE IF NOT EXISTS `rbac_permission_info` (
`permission_id` bigint(19) NOT NULL,
`permission_name` varchar(32) NOT NULL COMMENT '权限名称，如创建用户',
`permission_code` varchar(32) NOT NULL COMMENT '权限代码，如sys:user:create，用于匹配权限',
`permission_desc` varchar(128) NULL COMMENT '权限描述',
`permission_navi` tinyint(1) NOT NULL COMMENT '是否为菜单栏导航节点，0为假，1为真',
`permission_url` varchar(128) NULL COMMENT '如果为菜单导航节点，对应节点的URL',
`permission_create_time` timestamp(3) NOT NULL,
`permission_last_modify_time` timestamp(3) NOT NULL,
`permission_valid` tinyint(1) NOT NULL,
PRIMARY KEY (`permission_id`) 
);
CREATE TABLE IF NOT EXISTS `rbac_session` (
`session_id` bigint(19) NOT NULL COMMENT '会话ID',
`session_content` text NOT NULL COMMENT 'session序列化后的内容',
`session_create_time` timestamp(3) NOT NULL,
`session_last_modify_time` timestamp(3) NOT NULL,
`session_valid` tinyint(1) NOT NULL,
PRIMARY KEY (`session_id`) 
);

//文章信息
CREATE TABLE `article_info` (

`article_id` bigint(19) NOT NULL,

`article_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`article_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`article_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '摘要',

`article_label` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文章标签，多个用分号分隔（英文单词有空格）',

`article_read_total` int(32) NOT NULL,

`article_html_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`article_md_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`article_create_time` timestamp(3) NOT NULL,

`article_last_modify_time` timestamp(3) NOT NULL,

`article_category_id` varchar(19) NOT NULL,

`artilce_place_top` tinyint(1) NOT NULL,

`article_top_priority` int(5) NULL,

`article_attach_file` tinyint(1) NOT NULL,

`article_attach_url` text NULL COMMENT '附件链接，多个url用空格分隔',

`article_valid` tinyint(1) NOT NULL,

PRIMARY KEY (`article_id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 73

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_bin

COMMENT = '文章和代码

'

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;



CREATE TABLE `article_comment` (

`comment_id` bigint(19) NOT NULL,

`comment_article_id` varchar(19) NOT NULL,

`comment_user_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`comment_parent_id` bigint(19) NOT NULL COMMENT '评论的父评论id',

`comment_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`comment_date` timestamp(3) NOT NULL,

`comment_valid` tinyint(1) NOT NULL,

PRIMARY KEY (`comment_id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 41

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_bin

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;



CREATE TABLE `article_read_record` (

`article_id` bigint(19) NOT NULL,

`article_date_daily` timestamp(3) NOT NULL COMMENT '文章当天日期',

`article_read_daily` int(32) NOT NULL COMMENT '文章当天阅读量',

PRIMARY KEY (`article_id`, `article_date_daily`) 

);



CREATE TABLE `article_modify_record` (

`article_id` bigint(19) NOT NULL,

`article_last_modify_time` timestamp(3) NOT NULL,

`article_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`article_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`article_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '摘要',

`article_label` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文章标签，多个用分号分隔（英文单词有空格）',

`article_read_total` int(32) NOT NULL,

`article_html_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`article_md_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`article_create_time` timestamp(3) NOT NULL,

`article_category_id` varchar(19) NOT NULL,

`artilce_place_top` tinyint(1) NOT NULL,

`article_top_priority` int(5) NULL,

`article_attach_file` tinyint(1) NOT NULL,

`article_attach_url` text NULL COMMENT '附件链接，多个url用空格分隔',

PRIMARY KEY (`article_id`, `article_last_modify_time`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 73

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_bin

COMMENT = '文章和代码

'

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;



//附加特色功能
CREATE TABLE `feature_category_info` (

`category_id` bigint(19) NOT NULL,

`category_name` char(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`category_type` varchar(3) NOT NULL COMMENT '分类类型，属于哪种文章。如文章分类、代码分类',

`category_create_time` timestamp(3) NOT NULL,

`category_modify_time` timestamp(3) NOT NULL,

`category_valid` tinyint(1) NOT NULL,

PRIMARY KEY (`category_id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 101

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_bin

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;



CREATE TABLE `feature_discuss_area` (

`discuss_id` bigint(19) NOT NULL,

`discuss_belong_id` bigint(19) NOT NULL,

`discuss_parent_id` bigint(19) NOT NULL,

`discuss_comitter_id` varchar(19) NOT NULL,

`discuss_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`discuss_create_time` timestamp(3) NOT NULL,

`discuss_valid` tinyint(1) NOT NULL,

PRIMARY KEY (`discuss_id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 41

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_bin

COMMENT = '讨论区'

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;



CREATE TABLE `feature_thumbs_up_record` (

`user_id` bigint(19) NOT NULL,

`article_id` varchar(19) NOT NULL,

`thumbs_up_type` varchar(3) NOT NULL,

`thumbs_up_time` timestamp(3) NOT NULL,

PRIMARY KEY (`user_id`, `article_id`, `thumbs_up_type`) 

)

COMMENT = '点赞记录';




//文件存储
CREATE TABLE `store_file` (

`file_id` bigint(19) NOT NULL,

`file_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`file_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`file_upload_time` timestamp(3) NOT NULL,

`file_type` varchar(3) NOT NULL,

`file_hash_code` varchar(64) NOT NULL COMMENT '哈希值，用作校验',

`file_download_count` int(32) NOT NULL,

PRIMARY KEY (`file_id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 13

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_bin

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;



CREATE TABLE `store_image` (

`image_id` bigint(19) NOT NULL,

`image_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,

`image_upload_time` timestamp(3) NOT NULL,

`image_type` varchar(3) NOT NULL,

`image_hash_code` varchar(64) NOT NULL,

`image_download_count` int(32) NOT NULL,

PRIMARY KEY (`image_id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 254

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_bin

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;




//访问统计
CREATE TABLE `visit_statistics` (

`visit_id` bigint(19) NOT NULL,

`visit_date` timestamp(3) NOT NULL,

`visit_online_max` int(32) NOT NULL,

`visit_current_day` int(32) NOT NULL,

`visit_total_count` int(32) NOT NULL,

PRIMARY KEY (`visit_id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 387

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_bin

COMMENT = '访问统计'

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;



CREATE TABLE `visit_record` (

`visit_id` bigint(19) NOT NULL,

`visit_start_time` timestamp(3) NOT NULL,

`visit_end_time` timestamp(3) NOT NULL,

`visit_content_type` varchar(3) NOT NULL,

`visit_content_id` bigint(19) NOT NULL,

`visit_user_id` bigint(19) NOT NULL,

PRIMARY KEY (`visit_id`) 

)

COMMENT = '文章、代码、问答等访问记录';





//其他
CREATE TABLE `version_info` (

`version_id` bigint(19) NOT NULL,

`version_user_id` varchar(19) NOT NULL,

`version_number` varchar(10) NOT NULL,

`version_content` text NOT NULL,

`version_release_time` timestamp(3) NOT NULL COMMENT '版本发布时间',

PRIMARY KEY (`version_id`) 

);