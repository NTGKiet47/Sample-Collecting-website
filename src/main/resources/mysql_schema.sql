create database sampleCollecting;

use sampleCollecting;

create table user_account (
                              userId varchar(100) not null primary key
);

create table project(
                        id int not null primary key auto_increment,
                        projectName varchar(200) not null,
                        projectDesc TINYTEXT default null,
                        ownerId varchar(100) not null,
                        foreign key (ownerId) references user_account(userId)
);

create table sample(
                       id int not null primary key auto_increment,
                       imagePath varchar(200) not null,
                       projectId int not null,
                       foreign key (projectId) references project(id)
);

create table sample_field(
                             id int not null primary key auto_increment,
                             fieldName varchar(100) not null,
                             feildValue TINYTEXT not null,
                             sampleId int not null,
                             foreign key (sampleId) references sample(id)
);

insert into user_account value ('bang123');
insert into project value (1, 'testProjectName', 'testProjectDesc', 'bang123');
insert into sample value (1, 'vsdfv/sfdbfdsb/agergerg', 1);
insert into sample_field value (1, 'testFieldName', 'testFieldValue', 1);