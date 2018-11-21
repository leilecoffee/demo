CREATE DATABASE demo DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'mcsj'@'%' IDENTIFIED BY 'ZCd#GeAO6p';

GRANT SELECT,DELETE,UPDATE,CREATE,DROP ON blockchain.* TO 'mcsj'@'%';

FLUSH PRIVILEGES;

use demo;
--执行sql文件
set names utf8;
source d:\Users\admin\Desktop\demo.sql