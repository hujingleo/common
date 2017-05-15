-- ----------------------------
-- Table structure for `late`
-- ----------------------------
-- DROP TABLE IF EXISTS `late`;
CREATE TABLE `late` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增长ID',  
    `member_id` bigint    COMMENT '队员id',  
    `task_id` int    COMMENT '任务id',  
    `task_storage` varchar(50)    COMMENT '任务对应库位',  
    `member_name` varchar(50)    COMMENT '队员名字',  
    `member_phone` bigint    COMMENT '队员手机号',  
    `dealer_id` bigint    COMMENT '经销商id',  
    `submit_at` bigint    COMMENT '迟到申请时间',  
    `task_at` bigint    COMMENT '任务计划开始时间',  
    `arrive_at` bigint    COMMENT '实际到场时间',  
    `img_url` varchar(500)    COMMENT '现场照片url',  
    `reason` varchar(500)    COMMENT '迟到原因',  
    `verify_status` int    COMMENT '申请状态',  
    `create_by` bigint    COMMENT '创建人ID',  
    `update_by` bigint    COMMENT '更新人ID',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





