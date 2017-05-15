-- ----------------------------
-- Table structure for `member`
-- ----------------------------
-- DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增长ID',  
    `name` varchar(50)    COMMENT '队员名字',  
    `phone` bigint    COMMENT '队员手机号',  
    `account` varchar(50)    COMMENT '队员账号',  
    `pwd` varchar(50)    COMMENT '队员密码',  
    `team_id` bigint    COMMENT '所属团队id',  
    `status` int    COMMENT '状态是(正常0，请假1，迟到2)',  
    `create_by` bigint    COMMENT '创建人ID',  
    `update_by` bigint    COMMENT '更新人ID',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





