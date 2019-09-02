CREATE TABLE `question_info` (
`question_id` bigint(19) NOT NULL COMMENT '提问ID',
`categoryId` bigint(19) NOT NULL,
`user_id` bigint(19) NOT NULL COMMENT '提问的用户',
`recommend_answer_id` bigint(19) NULL COMMENT '推荐的回答',
`question_title` varchar(256) NULL COMMENT '提问的标题',
`question_label` varchar(256) NULL COMMENT '提问标签',
`question_visit_count` int(32) NOT NULL COMMENT '提问浏览次数',
`question_create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`question_update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
`question_attach_file` tinyint(1) NOT NULL COMMENT '是否包含附件',
`question_attach_ids` varchar(256) NULL,
`question_valid` tinyint(1) NOT NULL COMMENT '是否被逻辑删除',
`question_solve` tinyint(1) NULL COMMENT '提问是否解决',
`question_html_content` text NULL,
`question_md_content` text NULL,
PRIMARY KEY (`question_id`) 
);

CREATE TABLE `question_answer` (
`answer_id` bigint(19) NOT NULL COMMENT '回答的ID',
`question_id` bigint(19) NOT NULL COMMENT '关联的提问ID',
`answer_content` text NULL COMMENT '回答内容',
`answer_time` timestamp(3) NULL DEFAULT CURRENT_TIMESTAMP(3),
`answer_thumbs_up_count` int(32) NULL COMMENT '同意数量',
`answer_thumbs_down_count` int(32) NULL COMMENT '不同意数量',
PRIMARY KEY (`answer_id`) 
);

