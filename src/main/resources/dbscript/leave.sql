-- ----------------------------
-- Table structure for `leave`
-- ----------------------------
-- DROP TABLE IF EXISTS `leave`;
CREATE TABLE `leave` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增长ID',  
    `member_id` bigint    COMMENT '队员id',  
    `member_name` varchar(50)    COMMENT '队员姓名',  
    `member_phone` bigint    COMMENT '队员手机号',  
    `submit_at` bigint    COMMENT '请假申请提交时间',  
    `reason` varchar(500)    COMMENT '请假原因',  
    `start_at` bigint    COMMENT '假期开始时间',  
    `days` int    COMMENT '请假天数',  
    `verify_status` int    COMMENT '申请状态（申请中、通过、拒绝）',  
    `create_by` bigint    COMMENT '创建人ID',  
    `update_by` bigint    COMMENT '更新人ID',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





