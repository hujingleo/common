-- ----------------------------
-- Table structure for `vender`
-- ----------------------------
-- DROP TABLE IF EXISTS `vender`;
CREATE TABLE `vender` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增长ID',  
    `name` varchar(50)    COMMENT '厂家名称',  
    `status` varchar(1)    COMMENT '状态 (禁用0 正常1)',  
    `manager_id` bigint    COMMENT '登录账号ID',  
    `create_by` bigint    COMMENT '创建时间',  
    `update_by` bigint    COMMENT '更新时间',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





