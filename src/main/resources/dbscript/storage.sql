-- ----------------------------
-- Table structure for `storage`
-- ----------------------------
-- DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增长ID',  
    `name` varchar(50)    COMMENT '库位名称',  
    `attribute` varchar    COMMENT '属性 (1本部库位、2二网库位、3临展库位)',  
    `latitude` varchar(10)    COMMENT '经度',  
    `longitude` varchar(10)    COMMENT '纬度',  
    `privince` varchar(20)    COMMENT '省',  
    `city` varchar(20)    COMMENT '市',  
    `address` varchar(100)    COMMENT '详细地址',  
    `contacts_name` varchar（30）    COMMENT '联系人',  
    `contacts_post` varchar(30)    COMMENT '联系人岗位',  
    `contacts_phone` varchar(30)    COMMENT '联系人电话',  
    `internal_remark` varchar（300）    COMMENT '内部备注',  
    `suditor_remark` varchar（300）    COMMENT '审计员备注',  
    `activity_start_time` bigint(20)    COMMENT '活动开始时间 (当属性为临展车位时使用)',  
    `activity_end_time` bigint(20)    COMMENT '活动结束时间 (当属性为临展车位时使用)',  
    `status` varchar(1)    COMMENT '状态 (1正常0禁用)',  
    `create_by` bigint    COMMENT '创建人ID',  
    `update_by` bigint    COMMENT '更新人ID',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





