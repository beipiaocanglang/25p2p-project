-- 项目启动时会创建对应的5张表 添加下面对用的数据到对应的数据库表中
SELECT * FROM t_users;

INSERT INTO t_users VALUES(1,'123','tom'), (2,'456','fox');
COMMIT;

SELECT * FROM t_roel;
-- tom用户具有admin角色 ， fox用户具有user角色
INSERT INTO t_roel VALUES (1,'admin'),(2,'user');
COMMIT;

SELECT * FROM u_r;
-- 关联用户表和角色表
INSERT INTO u_r VALUES (1,1), (2,2);
COMMIT;

-- 查询关联后的表数据
SELECT * FROM t_users,u_r,t_roel WHERE t_users.id = u_r.u_id AND u_r.r_id = t_roel.id;

SELECT * FROM t_permission;
-- 向权限表中插入数据 权限表中具有四种权限 update, delete, add, find
INSERT INTO t_permission VALUES (1,'update'), (2,'delete'), (3,'add'), (4,'find');
COMMIT;

-- 查询角色和权限的关联表
SELECT * FROM r_p;

-- 想角色和权限的关联表中插入数据 admin角色具有update,delete,add权限、fox角色具有find权限
INSERT INTO r_p VALUES (1,1), (2,1), (3,1), (4,2);
COMMIT;