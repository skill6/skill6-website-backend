CREATE TABLE `store_file` (
`file_id` bigint(19) NOT NULL,
`file_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`file_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`file_upload_time` timestamp(3) NOT NULL,
`file_type` varchar(16) NOT NULL COMMENT '文件类型，doc、zip等',
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
`image_type` varchar(16) NOT NULL COMMENT '图片类型，jpg、png等',
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

