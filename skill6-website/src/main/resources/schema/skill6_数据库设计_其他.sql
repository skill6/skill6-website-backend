CREATE TABLE `category_info` (
`category_id` bigint(19) NOT NULL,
`category_name` char(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`category_type` varchar(16) NOT NULL COMMENT '分类类型，属于哪种文章。如文章分类、代码分类',
`category_create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`category_update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`category_valid` tinyint(1) NOT NULL,
PRIMARY KEY (`category_id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 101
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '分类信息'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;

CREATE TABLE `version_info` (
`version_id` bigint(19) NOT NULL,
`user_id` bigint(19) NOT NULL COMMENT '版本发布用户id',
`version_number` varchar(10) NOT NULL,
`version_content` text NOT NULL,
`version_release_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '版本发布时间',
PRIMARY KEY (`version_id`) 
);

CREATE TABLE `notice` (
`notice_id` bigint(19) NOT NULL COMMENT '通知的ID',
`notice_content` text NOT NULL COMMENT '通知的内容',
`notice_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '通知发布的时间',
PRIMARY KEY (`notice_id`) 
);

