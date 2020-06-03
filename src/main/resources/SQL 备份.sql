-- 创建测试数据库 mybatis_Test
create database mybatis_Test;


-- 创建测试表
drop table if exists user;
create table user(
id int(11) not null auto_increment,
username VARCHAR(32) not null COMMENT '用户名称',
birthday datetime default null COMMENT '生日',
sex char(1) default null COMMENT'性别',
address varchar(256) default null COMMENT '地址',
primary key (id)
)ENGINE = INNODB default charset = utf8

-- 追加数据

insert into user(username,birthday,sex,address) values('张三','2000-01-03 19:13:12','男','湖北武汉'),('晨晨','1996-01-03 19:13:12','女','湖北武汉')

select * from user

