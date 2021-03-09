use backhome;
create table registered_user (id INT(11),username VARCHAR(25),password VARCHAR(100),avatar VARCHAR(250),token VARCHAR(1000),create_time datetime DEFAULT CURRENT_TIMESTAMP);
create table site (id INT(11), 
name VARCHAR(100),
address VARCHAR(100),
fees VARCHAR(100),
hours VARCHAR(25),
appointment VARCHAR(25),
report_to VARCHAR(200),
show_IGG VARCHAR(25),
N_protein_test VARCHAR(25),
wechat_num VARCHAR(100),
phone_num VARCHAR(100),
email VARCHAR(200),
web VARCHAR(200)
)

create table comment (id INT(11), 
content VARCHAR(4000),
user_id INT(11),
site_id INT(11),
create_time datetime DEFAULT CURRENT_TIMESTAMP,
stars INT(11)
)

alter table comment modify column id varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
alter table `registered_user` modify column id varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;

INSERT INTO `registered_user` VALUES ('1349290158897311745', 
'admin',  '$2a$10$8qx711TBg/2hxfL7N.sxf.0ROMhR/iuPhQx33IFqGd7PLgt5nGJTO', 
'https://s3.ax1x.com/2020/12/01/DfHNo4.jpg', 
'', '2021-01-13 17:40:17');

use backhome;
alter table site add column lat DECIMAL(9,6); 

use backhome;
alter table site add column lng DECIMAL(9,6); 

use backhome;
INSERT INTO `site` VALUES (1, 
'Apostle Diagnostics', '160 E Tasman Dr, STE 116，San Jose, CA 95134', 
'N/A', 'N/A','N/A','CHINA Consulate San Francisco','N/A','N/A','N/A',
'(888)-992-7678','support@apostledx.com','https://apostledx.com',
'37.264827','-121.368604');

use backhome;
INSERT INTO `site` VALUES (2, 
'TargetDx Laboratory', '6541-B Via Del Oro, San Jose, CA95119', 
'N/A', 'N/A','N/A','CHINA Consulate San Francisco','N/A','N/A','N/A',
'(219)-510-0120','info@targetdxlab.com','www.targetdxlab.com',
'37.235191','-121.784092');

use backhome;
alter table comment modify column user_id varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;

use backhome;
INSERT INTO `comment` VALUES ('1349290158897311760', 
'This site is great!', '1349290158897311745', 
1, '2021-01-14 17:40:17',5);

use backhome;
update comment set stars=1 where id='1367765516734844929';

-- use backhome;
-- alter table comment drop column avatar; 

use backhome;
update `registered_user` set avatar='user1.jpg' where id='1349290158897311745';


use backhome;
alter table site add column country VARCHAR(20); 
alter table site add column region VARCHAR(50); 


use backhome;
update site set region='SF',country='US' where id='2';
