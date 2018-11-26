CREATE DATABASE mcsj DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'mcsj'@'%' IDENTIFIED BY 'ZCd#GeAO6p';

GRANT SELECT,DELETE,UPDATE,CREATE,DROP ON mcsj.* TO 'mcsj'@'%';

FLUSH PRIVILEGES;

use mcsj;
--执行sql文件
set names utf8;
source ../mcsj.sql