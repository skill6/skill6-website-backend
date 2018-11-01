CREATE TABLE `version_info` (
`version_id` bigint(19) NOT NULL,
`user_id` bigint(19) NOT NULL COMMENT '版本发布用户id',
`version_number` varchar(10) NOT NULL,
`version_content` text NOT NULL,
`version_release_time` timestamp(3) NOT NULL COMMENT '版本发布时间',
PRIMARY KEY (`version_id`) 
);

