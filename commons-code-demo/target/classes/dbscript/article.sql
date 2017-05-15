-- ----------------------------
-- Table structure for `article`
-- ----------------------------
-- DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '文章id',  
    `type` bigint NOT NULL   COMMENT '类型',  
    `title` varchar NOT NULL   COMMENT '标题',  
    `img` varchar NOT NULL   COMMENT '图片',  
    `url` varchar    COMMENT '链接',  
    `industry` varchar    COMMENT '行业',  
    `status` varchar NOT NULL   COMMENT '状态',  
    `create_by` bigint NOT NULL   COMMENT '创建人id',  
    `update_by` bigint NOT NULL   COMMENT '更新人id',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





