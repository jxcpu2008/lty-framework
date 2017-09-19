# Host: 127.0.0.1  (Version 5.7.15)
# Date: 2016-10-10 11:45:18
# Generator: MySQL-Front 5.4  (Build 1.19)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "t_auth_menu"
#

DROP TABLE IF EXISTS `t_auth_menu`;
CREATE TABLE `t_auth_menu` (
  `id` varchar(36) NOT NULL,
  `text` varchar(100) NOT NULL COMMENT '菜单名字',
  `seq` int(11) NOT NULL COMMENT '菜单序号',
  `icon_cls` varchar(20) DEFAULT NULL COMMENT '图标',
  `url` varchar(200) NOT NULL COMMENT '菜单地址',
  `pid` varchar(36) DEFAULT NULL COMMENT '上级菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

#
# Data for table "t_auth_menu"
#

INSERT INTO `t_auth_menu` VALUES ('0','首页',1,'icon-tip','',NULL),('cdgl','菜单管理',3,'icon-sum','/admin/cdgl.jsp','xtgl'),('jsgl','角色管理',0,'icon-reload','/admin/jsgl.jsp','xtgl'),('xtgl','系统管理',1,'icon-sum','','0'),('yhgl','用户管理',1,'icon-back','/admin/yhgl.jsp','xtgl'),('zygl','资源管理',1,'icon-tip','/admin/zygl.jsp','xtgl');

#
# Structure for table "t_auth_resource"
#

DROP TABLE IF EXISTS `t_auth_resource`;
CREATE TABLE `t_auth_resource` (
  `id` varchar(36) NOT NULL,
  `text` varchar(100) NOT NULL COMMENT '资源描述',
  `url` varchar(200) NOT NULL COMMENT '资源url',
  `seq` int(11) NOT NULL COMMENT '排序',
  `pid` varchar(36) DEFAULT NULL COMMENT '上级资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

#
# Data for table "t_auth_resource"
#

INSERT INTO `t_auth_resource` VALUES ('2294b01b-9606-4fa2-b3a9-15cf10ec3f36','删除','1',10,'6932a247-89da-40d8-aeb4-b68d7187801b'),('23e89fa4-9f35-40e1-a9b4-2d56d2dd7178','添加','33',10,''),('6932a247-89da-40d8-aeb4-b68d7187801b','用户','',10,'23e89fa4-9f35-40e1-a9b4-2d56d2dd7178'),('bf4da9db-619e-4f57-89c3-5b773d4a5a8c','查询','',10,'');

#
# Structure for table "t_auth_role"
#

DROP TABLE IF EXISTS `t_auth_role`;
CREATE TABLE `t_auth_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '角色名字',
  PRIMARY KEY (`id`),
  UNIQUE KEY `weiyi_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

#
# Data for table "t_auth_role"
#

INSERT INTO `t_auth_role` VALUES ('0a9a58ec-d178-4c11-bf07-76ada8e847f6','小龙'),('1','1'),('admin','管理员');

#
# Structure for table "t_auth_role_menu"
#

DROP TABLE IF EXISTS `t_auth_role_menu`;
CREATE TABLE `t_auth_role_menu` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  `menu_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单中间表';

#
# Data for table "t_auth_role_menu"
#

INSERT INTO `t_auth_role_menu` VALUES ('2201f817-0972-4e9f-b2f9-88aa701ff207','0a9a58ec-d178-4c11-bf07-76ada8e847f6','yhgl'),('745b5441-4e61-4e6e-8e60-265a7421673d','0a9a58ec-d178-4c11-bf07-76ada8e847f6','cdgl'),('765088c2-9601-47a0-afb1-1cc6c334b5d6','0a9a58ec-d178-4c11-bf07-76ada8e847f6','zygl'),('933462fb-1211-45fa-b1eb-556b15f65446','admin','cdgl'),('b6f5002a-01ff-44c2-9f81-bdf5a2298c5f','0a9a58ec-d178-4c11-bf07-76ada8e847f6','xtgl'),('b94c98dd-d522-4bd1-8a1c-e0bef2395403','0a9a58ec-d178-4c11-bf07-76ada8e847f6','0'),('c54f8cae-2e8e-4893-8c0a-2979a35b31f5','0a9a58ec-d178-4c11-bf07-76ada8e847f6','jsgl'),('fe749904-616e-481d-889c-1d979f588578','admin','zygl');

#
# Structure for table "t_auth_role_resource"
#

DROP TABLE IF EXISTS `t_auth_role_resource`;
CREATE TABLE `t_auth_role_resource` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  `resource_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源中间表';

#
# Data for table "t_auth_role_resource"
#

INSERT INTO `t_auth_role_resource` VALUES ('0205e525-62ba-4ad0-9c7e-73a98571c177','72425d55-701d-4f08-bd81-d05eb5895de4','2294b01b-9606-4fa2-b3a9-15cf10ec3f36'),('30a892f6-c2cc-43df-9eaf-c51b4696121e','fe90303a-644b-451b-a20f-021d2a69a74a','2294b01b-9606-4fa2-b3a9-15cf10ec3f36'),('5d23ba33-7864-4190-a1aa-22f3870ec9a5','72425d55-701d-4f08-bd81-d05eb5895de4','23e89fa4-9f35-40e1-a9b4-2d56d2dd7178'),('75181133-bf01-4097-9811-926846feb141','1','23e89fa4-9f35-40e1-a9b4-2d56d2dd7178'),('937ed552-9870-443e-b66b-824783075bd5','72425d55-701d-4f08-bd81-d05eb5895de4','bf4da9db-619e-4f57-89c3-5b773d4a5a8c'),('943c0613-f817-4679-8398-5e4a4599aec1','72425d55-701d-4f08-bd81-d05eb5895de4','6932a247-89da-40d8-aeb4-b68d7187801b'),('d3abae64-219d-4f29-82de-fe76aa9f224c','1','2294b01b-9606-4fa2-b3a9-15cf10ec3f36'),('f6a2f877-ff5f-41b3-8389-acc04ebe68a9','fe90303a-644b-451b-a20f-021d2a69a74a','23e89fa4-9f35-40e1-a9b4-2d56d2dd7178'),('f78de9bd-5d0b-46b8-9f7a-04ff18a34124','fe90303a-644b-451b-a20f-021d2a69a74a','6932a247-89da-40d8-aeb4-b68d7187801b');

#
# Structure for table "t_auth_user"
#

DROP TABLE IF EXISTS `t_auth_user`;
CREATE TABLE `t_auth_user` (
  `id` varchar(36) NOT NULL COMMENT '用户id',
  `login_name` varchar(100) NOT NULL COMMENT '用户 登录名',
  `password` varchar(100) NOT NULL COMMENT '用户登录密码',
  `status` varchar(100) NOT NULL COMMENT '用户状态',
  `type` varchar(100) DEFAULT NULL COMMENT '用户类型',
  `payment_code` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_no` bigint(20) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限-用户表';

#
# Data for table "t_auth_user"
#

INSERT INTO `t_auth_user` VALUES ('0','liuwei','liuwei','0','0','0','2016-05-31 16:06:53',0),('068d5d76-b5a8-4f0d-9a0b-a9030b7f9b2d','kevin.xie','Icx6ZENJOCCqdQOCq/+s87dhl2ulL3m97m0b61iZAQE=','1','1',NULL,'2016-10-10 11:14:10',NULL),('983b59ae-01a2-4f51-9209-a5ecd6d86eb9','段彩云','Kqm6/2AdBcvcoi/IGSwMU8mbVMDSgXSi9f6iHjaMM2w=','1','1',NULL,'2016-07-09 21:31:10',NULL),('admin','admin','Icx6ZENJOCCqdQOCq/+s87dhl2ulL3m97m0b61iZAQE=','1','1',NULL,'2016-07-07 22:34:48',NULL),('admin1','admin1','','1','1',NULL,NULL,NULL),('d73726e6-f975-4fc8-8156-1da859c87810','刘伟','b45iXWdr/VPRLXUkjHTYl28quQFbHCF0/tkiv6MzcSY=','1','1',NULL,'2016-07-09 21:23:28',NULL),('df28815b-2924-43fd-b27a-60e7bee90d49','test','7Qrz9gJj8k2uTUfyTXROBnQdNaGpRKAh4aBM2w2Q3ss=','1','1',NULL,'2016-10-10 11:13:59',NULL);

#
# Structure for table "t_auth_user_role"
#

DROP TABLE IF EXISTS `t_auth_user_role`;
CREATE TABLE `t_auth_user_role` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

#
# Data for table "t_auth_user_role"
#

INSERT INTO `t_auth_user_role` VALUES ('1a7bef76-95de-447e-83db-79586157b985','admin','admin'),('31edbcaf-0ff0-4114-aa0f-85ac5d7fba76','30ceea63-bcf9-411f-a499-dc2c60040c82','0a9a58ec-d178-4c11-bf07-76ada8e847f6'),('3715eba8-5fbf-4a22-8f27-0def3b75096b','30ceea63-bcf9-411f-a499-dc2c60040c82','1'),('4c75b1c6-1196-4209-8e7d-f6ec35a0d3b0','admin1','admin'),('63c33c8a-2166-4fbb-8f6a-6c5e3484e2b0','068d5d76-b5a8-4f0d-9a0b-a9030b7f9b2d','admin'),('91ef0734-16c1-47f3-aa32-8fae1eb9aac3','admin','0a9a58ec-d178-4c11-bf07-76ada8e847f6'),('9c107d68-eeee-4346-b4e6-888e1f5cd046','1','admin'),('a42d69fa-7d57-4758-ac5a-6a544e9bfc20','d73726e6-f975-4fc8-8156-1da859c87810','admin'),('e531da75-b9d2-4aba-b3b7-e1e3879d80d7','admin1','0a9a58ec-d178-4c11-bf07-76ada8e847f6');
