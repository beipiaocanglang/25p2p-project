-- 这是ShiroTest3对应的数据库
CREATE DATABASE ssh_shiro;

CREATE TABLE users(
  id int PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20),
	password VARCHAR(20)
);

INSERT INTO users VALUES(null,'tom','123');