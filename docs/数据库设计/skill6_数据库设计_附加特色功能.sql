CREATE TABLE `feature_category_info` (
`category_id` bigint(19) NOT NULL,
`category_name` char(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`category_type` varchar(16) NOT NULL COMMENT '分类类型，属于哪种文章。如文章分类、代码分类',
`category_create_time` timestamp(3) NOT NULL,
`category_update_time` timestamp(3) NOT NULL,
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
`user_id` bigint(19) NOT NULL COMMENT '提交用户id',
`discuss_belong_id` bigint(19) NOT NULL COMMENT '所属主题id',
`discuss_parent_id` bigint(19) NOT NULL COMMENT '父讨论id，没有父讨论为-1',
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
`article_id` bigint(19) NOT NULL,
`thumbs_up_type` varchar(3) NOT NULL COMMENT '点赞类型，是顶还是踩',
`thumbs_up_time` timestamp(3) NOT NULL,
PRIMARY KEY (`user_id`, `article_id`, `thumbs_up_type`) 
)
COMMENT = '点赞记录';

