-- ----------------------------
-- Table structure for `team`
-- ----------------------------
-- DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增长ID',  
    `name` varchar(50)    COMMENT '团队名字',  
    `type` varchar(50)    COMMENT '团队属性(属于厂家还是第三方)',  
    `count` int    COMMENT '团队队员数量',  
    `belong_to_id` bigint    COMMENT '团队所属厂家或第三方id',  
    `belong_to_name` varchar(50)    COMMENT '团队所属厂家或第三方名字',  
    `is_forbidden` bit    COMMENT '团队是否被禁用',  
    `create_by` bigint    COMMENT '创建人ID',  
    `update_by` bigint    COMMENT '更新人ID',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





