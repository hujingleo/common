-- ----------------------------
-- Table structure for `distributor`
-- ----------------------------
-- DROP TABLE IF EXISTS `distributor`;
CREATE TABLE `distributor` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT '自增长ID',  
    `company_name` varchar(50)    COMMENT '公司名称',  
    `company_short_name` varchar(50)    COMMENT '公司简称',  
    `privince` varchar（30）    COMMENT '省',  
    `city` varchar(30)    COMMENT '市',  
    `contacts_name` varchar（30）    COMMENT '联系人',  
    `contacts_post` varchar(30)    COMMENT '联系人岗位',  
    `contacts_phone` varchar(30)    COMMENT '联系人电话',  
    `internal_remark` varchar（300）    COMMENT '内部备注',  
    `suditor_remark` varchar（300）    COMMENT '审计员备注',  
    `status` varchar(1)    COMMENT '状态 (1正常0禁用)',  
    `create_by` bigint    COMMENT '创建人ID',  
    `update_by` bigint    COMMENT '更新人ID',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





