DROP TABLE IF EXISTS user;
-- ----------------------------
-- Table structure for library_admin_info
-- ----------------------------
DROP TABLE IF EXISTS library_admin_info;
CREATE TABLE library_admin_info (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `job_no` varchar(100) DEFAULT NULL COMMENT '工号',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码·',
  `name` varchar(100) DEFAULT NULL COMMENT '管理员姓名',
  `mobile` varchar(15) DEFAULT NULL COMMENT '管理员联系方式',
  `is_delete` int(2) DEFAULT '0' COMMENT '0：未删除  1、已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for library_book_info
-- ----------------------------
DROP TABLE IF EXISTS library_book_info;
CREATE TABLE library_book_info (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '书籍名称',
  `isbn` varchar(100) DEFAULT NULL COMMENT '书籍编码',
  `bk_case_id` varchar(100) DEFAULT NULL COMMENT '书架编号',
  `price` decimal(10,0) DEFAULT NULL COMMENT '定价',
  `author` varchar(100) DEFAULT NULL COMMENT '作者',
  `type` varchar(100) DEFAULT NULL COMMENT '书籍类型',
  `synopsis` varchar(255) DEFAULT NULL COMMENT '书籍简介',
  `press` varchar(100) DEFAULT NULL COMMENT '出版社',
  `status` int(2) DEFAULT '0' COMMENT '0--借出，1--没有借出',
  `image` varchar(255) DEFAULT NULL COMMENT '封面图片',
  `is_delete` int(2) DEFAULT '0' COMMENT '0：未删除  1、已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for library_borrow_info
-- ----------------------------
DROP TABLE IF EXISTS library_borrow_info;
CREATE TABLE library_borrow_info (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `reader_id` int(10) DEFAULT NULL,
  `book_id` int(10) DEFAULT NULL COMMENT '书籍编号',
  `out_time` datetime DEFAULT NULL COMMENT '借出时间',
  `end_time` datetime DEFAULT NULL COMMENT '到期时间',
  `back_time` datetime DEFAULT NULL COMMENT '归还时间',
  `is_expired` int(2) DEFAULT '0' COMMENT '0：未过期  1、已过期',
  `fine` decimal(10,0) DEFAULT NULL COMMENT '罚款',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_delete` int(2) DEFAULT '0' COMMENT '0：未删除  1、已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for library_reader_info
-- ----------------------------
DROP TABLE IF EXISTS library_reader_info;
CREATE TABLE library_reader_info (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '读者姓名',
  `mobile` varchar(15) DEFAULT NULL COMMENT '读者联系方式',
  `address` varchar(255) DEFAULT NULL COMMENT '读者地址',
  `id_card` varchar(100) DEFAULT NULL COMMENT '读者身份证',
  `email` varchar(100) DEFAULT NULL COMMENT '读者邮箱',
  `is_delete` int(2) DEFAULT '0' COMMENT '0：未删除  1、已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);
