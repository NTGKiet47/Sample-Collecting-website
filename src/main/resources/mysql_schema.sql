create database sampleCollecting;

use sampleCollecting;

create table userAccount (
                              user_id varchar(100) not null primary key
);

create table project(
                        id int not null primary key auto_increment,
                        project_name varchar(200) not null,
                        project_desc TINYTEXT default null,
                        owner_id varchar(100) not null,
                        foreign key (owner_id) references user_account(user_id)
);

create table sample(
                       id int not null primary key auto_increment,
                       image_path varchar(200) not null,
                       project_id int not null,
                       foreign key (project_id) references project(id)
);

create table sampleField(
                             id int not null primary key auto_increment,
                             field_name varchar(100) not null,
                             field_value TINYTEXT not null,
                             sample_id int not null,
                             foreign key (sample_id) references sample(id)
);

insert into user_account value ('bang123');
insert into project value (1, 'testProjectName', 'testProjectDesc', 'bang123');
insert into sample value (1, 'vsdfv/sfdbfdsb/agergerg', 1);
insert into sample_field value (1, 'testFieldName', 'testFieldValue', 1);