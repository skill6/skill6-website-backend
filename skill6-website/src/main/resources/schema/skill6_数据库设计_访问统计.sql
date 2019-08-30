CREATE TABLE `visit_statistics` (
`statistics_id` bigint(19) NOT NULL,
`statistics_date` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '统计日期',
`statistics_online_max` int(10) NOT NULL COMMENT '当日最大在线人数',
`statistics_current_day` int(16) NOT NULL COMMENT '当日访问总数',
`statistics_total_count` int(16) NOT NULL COMMENT '累计访问总数',
PRIMARY KEY (`statistics_id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 387
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '访问统计，每天一条记录'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;

CREATE TABLE `visit_record` (
`visit_id` bigint(19) NOT NULL,
`user_id` bigint(19) NOT NULL COMMENT '访问用户id',
`visit_content_id` bigint(19) NOT NULL COMMENT '访问内容对应id',
`visit_content_type` varchar(16) NOT NULL COMMENT '访问内容类型',
`visit_start_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '开始时间',
`visit_end_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '结果时间',
PRIMARY KEY (`visit_id`) 
)
COMMENT = '文章、代码、问答等访问记录';

