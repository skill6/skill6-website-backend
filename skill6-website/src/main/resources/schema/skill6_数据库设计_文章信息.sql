CREATE TABLE `article_info` (
`article_id` bigint(19) NOT NULL,
`category_id` bigint(19) NOT NULL COMMENT '目录id',
`article_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标题',
`article_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '作者',
`article_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '摘要',
`article_label` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文章标签，多个用分号分隔（英文单词有空格）',
`article_read_total` int(32) NOT NULL COMMENT '阅读量',
`article_html_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'html格式的内容',
`article_md_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'markdown格式的内容',
`article_create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`article_update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`article_place_top` tinyint(1) NOT NULL,
`article_top_priority` int(5) NULL,
`article_attach_file` tinyint(1) NOT NULL,
`article_attach_ids` varchar(256) NULL COMMENT '附件链接，多个id用逗号分隔',
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
`article_id` bigint(19) NOT NULL,
`user_id` bigint(19) NOT NULL,
`comment_user_id` bigint(19) NOT NULL COMMENT '评论用户的id',
`comment_thumbs_up_count` int(10) NULL COMMENT '评论点赞人数',
`comment_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`comment_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`comment_valid` tinyint(1) NOT NULL,
PRIMARY KEY (`comment_id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 41
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '文章评论'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;

CREATE TABLE `article_read_record` (
`article_id` bigint(19) NOT NULL,
`article_date_daily` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '文章阅读记录当天日期',
`article_read_daily` int(32) NOT NULL COMMENT '文章当天阅读量',
PRIMARY KEY (`article_id`, `article_date_daily`) 
);

CREATE TABLE `article_modify_record` (
`article_modify_id` bigint(19) NOT NULL,
`article_id` bigint(19) NOT NULL,
`category_id` bigint(19) NOT NULL,
`article_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`article_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`article_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '摘要',
`article_label` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文章标签，多个用分号分隔（英文单词有空格）',
`article_read_total` int(32) NOT NULL COMMENT '阅读量',
`article_html_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`article_md_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`article_create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`article_update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`article_place_top` tinyint(1) NOT NULL COMMENT '是否置顶，0为假，1为真',
`article_top_priority` int(5) NULL COMMENT '置顶优先级',
`article_attach_file` tinyint(1) NOT NULL COMMENT '是否有附件，0为假，1为真',
`article_attach_ids` text NULL COMMENT '附件id列表，多个id用逗号分隔',
PRIMARY KEY (`article_modify_id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 73
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '文章修改记录
'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;

CREATE TABLE `article_comment_reply` (
`reply_id` bigint(19) NULL,
`comment_id` bigint(19) NULL COMMENT '评论的id',
`reply_user_id` bigint(19) NULL,
`reply_to_user_id` bigint(19) NULL COMMENT '被回复的用户Id',
`reply_content` text NULL COMMENT '回复内容',
`reply_time` timestamp(3) NULL DEFAULT CURRENT_TIMESTAMP(3),
`reply_valid` tinyint(1) NULL COMMENT '回复是否逻辑删除'
);

