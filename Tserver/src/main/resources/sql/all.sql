create table  users(id int(10) UNSIGNED 
NOT NULL PRIMARY KEY AUTO_INCREMENT,login_id varchar(50),password varchar(100),name varchar(50),xing char,
card varchar(255),drawable varchar(50),lateLogin varchar(50),phone varchar(11),create_tiem varchar(20),
cont varchar(50),province varchar(50),city varchar(50),lateDate varchar(50))AUTO_INCREMENT=10001;


create table  userLevel(id int(10) UNSIGNED 
NOT NULL PRIMARY KEY AUTO_INCREMENT,user_index int(10),level int(2),card varchar(50))AUTO_INCREMENT=10001;