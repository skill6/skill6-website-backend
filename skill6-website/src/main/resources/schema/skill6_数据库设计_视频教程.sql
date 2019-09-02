CREATE TABLE `video_info` (
`video_id` bigint(19) NOT NULL,
`video_poster_id` bigint(19) NOT NULL COMMENT '封面url对应id',
`video_name` varchar(256) NULL,
`video_desc` text NULL COMMENT '视频描述',
`video_create_time` timestamp(3) NULL DEFAULT CURRENT_TIMESTAMP(3),
`video_update_time` timestamp(3) NULL DEFAULT CURRENT_TIMESTAMP(3),
PRIMARY KEY (`video_id`) 
);

