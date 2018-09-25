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

