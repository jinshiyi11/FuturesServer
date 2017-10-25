--用户信息
CREATE TABLE IF NOT EXISTS user(
id int(10) NOT NULL AUTO_INCREMENT,
phone varchar(16) NOT NULL UNIQUE,
password varchar(255) NOT NULL,
nickName varchar(16),
headImageUrl varchar(255),
PRIMARY KEY (`id`)
)

--期货信息
CREATE TABLE IF NOT EXISTS futures(
id int(10) NOT NULL AUTO_INCREMENT,
name varchar(64) NOT NULL UNIQUE,
title varchar(64) NOT NULL,
PRIMARY KEY (`id`)
)

--评论
CREATE TABLE IF NOT EXISTS comment(
id int(10) NOT NULL AUTO_INCREMENT,
pid int(10),
ppid int(10),
futuresId int(10),
userId int(10),
content varchar(512) NOT NULL,
likeCount int(10) DEFAULT 0,
date BIGINT,
PRIMARY KEY (`id`)
)