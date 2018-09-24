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

